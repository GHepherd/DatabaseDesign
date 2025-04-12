package com.scau.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SparkApiClient {
    private final String apiPassword;
    private static final String API_URL = "https://spark-api-open.xf-yun.com/v1/chat/completions";

    public SparkApiClient(String apiPassword) {
        this.apiPassword = apiPassword;
    }

    /**
     *
     * 发送对话请求
     * @param userMessage 用户输入内容
     * @return API响应结果（JSON字符串）
     */
    public String sendChatRequest(String userMessage) throws Exception {
        // 1. 构造请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + apiPassword);
        headers.put("Content-Type", "application/json");

        // 2. 构造请求体
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "4.0Ultra");

        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", userMessage);
        requestBody.put("messages", new JSONObject[]{message});

        // 3. 添加工具函数（示例中的天气查询功能）
        JSONObject tool = new JSONObject();
        tool.put("type", "function");

        JSONObject function = new JSONObject();
        function.put("name", "get_current_weather");
        function.put("description", "返回实时天气");

        JSONObject parameters = new JSONObject();
        parameters.put("type", "object");

        Map<String, Object> properties = new HashMap<>();
        properties.put("location", new JSONObject()
                .fluentPut("type", "string")
                .fluentPut("description", "河北省承德市双桥区"));
        properties.put("format", new JSONObject()
                .fluentPut("type", "string")
                .fluentPut("enum", new String[]{"celsius", "fahrenheit"})
                .fluentPut("description", "使用本地区常用的温度单位计量"));

        parameters.put("properties", properties);
        parameters.put("required", new String[]{"location", "format"});
        function.put("parameters", parameters);
        tool.put("function", function);

        requestBody.put("tools", new JSONObject[]{tool});

        // 4. 发送请求并获取响应
        return sendPostRequest(API_URL, headers, requestBody.toJSONString());
    }

    private String sendPostRequest(String url, Map<String, String> headers, String body) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        // 设置请求头
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        // 写入请求体
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = body.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // 读取响应
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }


    public String getChatContent(String userMessage) throws Exception {
        String fullResponse = sendChatRequest(userMessage);
        return extractContent(fullResponse);
    }


    private String extractContent(String jsonResponse) {
        try {
            JSONObject responseObj = JSON.parseObject(jsonResponse);
            JSONArray choices = responseObj.getJSONArray("choices");
            if (choices != null && !choices.isEmpty()) {
                JSONObject firstChoice = choices.getJSONObject(0);
                JSONObject message = firstChoice.getJSONObject("message");
                return message.getString("content");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 使用示例
    public static void main(String[] args) {
        SparkApiClient client = new SparkApiClient("ZTXXqvqjOAQXOFjPXJbw:hBHYSGEpgScDBeyMheBN");
        try {
            String content = client.getChatContent("广州是哪个省份的");
            System.out.println("提取的content内容: " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}