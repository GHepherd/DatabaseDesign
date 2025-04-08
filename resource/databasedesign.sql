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
                       emial VARCHAR(50) NOT NULL  COMMENT '邮箱',
                       pass_word VARCHAR(50) NOT NULL  COMMENT '密码',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 体征记录表
CREATE TABLE vital_signs (
                             record_id INT AUTO_INCREMENT PRIMARY KEY,
                             user_id INT NOT NULL,
                             weight DECIMAL(5,1) COMMENT '体重(kg)',
                             height DECIMAL(5,2) COMMENT '身高(cm)',
                             blood_pressure SMALLINT COMMENT '血压(mmHg)',
                             blood_glucose DECIMAL(4,1) COMMENT '血糖(mmol/L)',
                             blood_lipids DECIMAL(4,1) COMMENT '血脂(mmol/L)',
                             FOREIGN KEY (user_id) REFERENCES users(user_id),
                             INDEX idx_user_date (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 运动记录表
CREATE TABLE exercise_records (
                                  exercise_id INT AUTO_INCREMENT PRIMARY KEY,
                                  user_id INT NOT NULL,
                                  exercise_type ENUM('running','cycling','swimming','yoga','other') NOT NULL,
                                  duration_minutes SMALLINT UNSIGNED COMMENT '运动时长(分钟)',
                                  distance_km DECIMAL(5,2) COMMENT '距离(千米)',
                                  calories DECIMAL(6,1) COMMENT '消耗卡路里',
                                  heartRate INT NOT NULL,
                                  FOREIGN KEY (user_id) REFERENCES users(user_id),
                                  INDEX idx_user_exercise (user_id, exercise_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 饮食记录表
CREATE TABLE diet_records (
                              diet_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              food_name VARCHAR(100) NOT NULL COMMENT '食物名称',
                              amount DECIMAL(6,2) COMMENT '数量(克/毫升)',
                              calories DECIMAL(6,1) COMMENT '热量(kcal)',

                              FOREIGN KEY (user_id) REFERENCES users(user_id),
                              INDEX idx_user_meal (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 睡眠记录表
CREATE TABLE sleep_records (
                               sleep_id INT AUTO_INCREMENT PRIMARY KEY,
                               user_id INT NOT NULL,
                               sleep_start DATETIME NOT NULL,
                               sleep_end DATETIME NOT NULL,
                               deep_sleep_minutes SMALLINT UNSIGNED COMMENT '深睡时长(分钟)',
                               FOREIGN KEY (user_id) REFERENCES users(user_id),
                               INDEX idx_user_sleep (user_id, sleep_start)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 健康目标表
CREATE TABLE health_goals (
                              goal_id INT AUTO_INCREMENT PRIMARY KEY,
                              user_id INT NOT NULL,
                              goal_type VARCHAR(50) NOT NULL ,
                              target_value DECIMAL(8,2) COMMENT '目标数值',
                              start_date DATE NOT NULL,
                              end_date DATE NOT NULL,
                              current_progress DECIMAL(8,2) DEFAULT 0.00,
                              status VARCHAR(50) NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(user_id),
                              INDEX idx_user_goals (user_id, goal_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 健康提醒表
CREATE TABLE health_reminders (
                                  reminder_id INT AUTO_INCREMENT PRIMARY KEY,
                                  user_id INT NOT NULL,
                                  reminder_type VARCHAR(50) NOT NULL,
                                  reminder_title VARCHAR(255) NOT NULL,
                                  datetime DATETIME NOT NULL,
                                  is_completed BOOLEAN DEFAULT FALSE,
                                  FOREIGN KEY (user_id) REFERENCES users(user_id),
                                  INDEX idx_user_reminders (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





