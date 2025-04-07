#建库语句
CREATE DATABASE databasedesigndb
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

use databasedesigndb;

#建表语句

-- 用户信息表
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
                       username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
                       gender ENUM('M','F','O') COMMENT '性别',
                       birthdate DATE COMMENT '出生日期',
                       height DECIMAL(5,2) COMMENT '身高(cm)',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 体征记录表
CREATE TABLE vital_signs (
                             record_id INT AUTO_INCREMENT PRIMARY KEY,
                             user_id INT NOT NULL,
                             record_date DATE NOT NULL,
                             weight DECIMAL(5,1) COMMENT '体重(kg)',
                             blood_pressure_systolic SMALLINT COMMENT '收缩压(mmHg)',
                             blood_pressure_diastolic SMALLINT COMMENT '舒张压(mmHg)',
                             blood_glucose DECIMAL(4,1) COMMENT '血糖(mmol/L)',
                             cholesterol DECIMAL(4,1) COMMENT '总胆固醇(mmol/L)',
                             recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (user_id) REFERENCES users(user_id),
                             INDEX idx_user_date (user_id, record_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 运动记录表
CREATE TABLE exercise_records (
                                  exercise_id INT AUTO_INCREMENT PRIMARY KEY,
                                  user_id INT NOT NULL,
                                  exercise_type ENUM('running','cycling','swimming','yoga','other') NOT NULL,
                                  start_time DATETIME NOT NULL,
                                  duration_minutes SMALLINT UNSIGNED COMMENT '运动时长(分钟)',
                                  distance_km DECIMAL(5,2) COMMENT '距离(千米)',
                                  calories DECIMAL(6,1) COMMENT '消耗卡路里',
                                  FOREIGN KEY (user_id) REFERENCES users(user_id),
                                  INDEX idx_user_exercise (user_id, exercise_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 饮食记录表
CREATE TABLE diet_records (
                              diet_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              food_name VARCHAR(100) NOT NULL COMMENT '食物名称',
                              meal_type ENUM('breakfast','lunch','dinner','snack') NOT NULL,
                              quantity DECIMAL(6,2) COMMENT '数量(克/毫升)',
                              calories DECIMAL(6,1) COMMENT '热量(kcal)',
                              record_date DATE NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(user_id),
                              INDEX idx_user_meal (user_id, meal_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 睡眠记录表
CREATE TABLE sleep_records (
                               sleep_id INT AUTO_INCREMENT PRIMARY KEY,
                               user_id INT NOT NULL,
                               sleep_start DATETIME NOT NULL,
                               sleep_end DATETIME NOT NULL,
                               quality_rating TINYINT CHECK (quality_rating BETWEEN 1 AND 5) COMMENT '质量评分(1-5)',
                               deep_sleep_minutes SMALLINT UNSIGNED COMMENT '深睡时长(分钟)',
                               FOREIGN KEY (user_id) REFERENCES users(user_id),
                               INDEX idx_user_sleep (user_id, sleep_start)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 健康目标表
CREATE TABLE health_goals (
                              goal_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              goal_type ENUM('weight_loss','muscle_gain','blood_pressure','other') NOT NULL,
                              target_value DECIMAL(8,2) COMMENT '目标数值',
                              start_date DATE NOT NULL,
                              end_date DATE NOT NULL,
                              current_progress DECIMAL(8,2) DEFAULT 0.00,
                              status ENUM('active','achieved','canceled') DEFAULT 'active',
                              FOREIGN KEY (user_id) REFERENCES users(user_id),
                              INDEX idx_user_goals (user_id, goal_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 健康提醒表
CREATE TABLE health_reminders (
                                  reminder_id INT AUTO_INCREMENT PRIMARY KEY,
                                  user_id INT NOT NULL,
                                  reminder_type ENUM('medical_checkup','medication','water_intake','other') NOT NULL,
                                  reminder_content VARCHAR(255) NOT NULL,
                                  trigger_time DATETIME NOT NULL,
                                  is_completed BOOLEAN DEFAULT FALSE,
                                  FOREIGN KEY (user_id) REFERENCES users(user_id),
                                  INDEX idx_user_reminders (user_id, trigger_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE users
    ADD COLUMN password VARCHAR(255) NOT NULL COMMENT '加密后的密码哈希值'
        AFTER username;


