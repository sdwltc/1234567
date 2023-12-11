-- 创建用户表
CREATE TABLE IF NOT EXISTS users (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(50) NOT NULL,
                                    password VARCHAR(255) NOT NULL,
                                    email VARCHAR(100),
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建新闻表
CREATE TABLE IF NOT EXISTS news (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    title VARCHAR(255) NOT NULL,
                                    content TEXT NOT NULL,
                                    author_id INT,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                    FOREIGN KEY (author_id) REFERENCES users(id)
);

-- 创建评论表
CREATE TABLE IF NOT EXISTS comment (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       news_id INT,
                                       user_id INT,
                                       content TEXT NOT NULL,
                                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       FOREIGN KEY (news_id) REFERENCES news(id),
                                       FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 创建广告表
CREATE TABLE IF NOT EXISTS advertisement (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        type VARCHAR(50) NOT NULL,
                                        content TEXT NOT NULL,
                                        click_count INT DEFAULT 0,
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
