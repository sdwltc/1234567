-- 忽略报错，因为脚本没创建表呢，其实插入成功了
-- 插入用户数据
INSERT INTO USERS (username, password, email) VALUES ('user1', 'password1', 'user1@example.com');
INSERT INTO USERS (username, password, email) VALUES ('user2', 'password2', 'user2@example.com');

-- 插入新闻数据
INSERT INTO news (title, content, author_id) VALUES ('First News', 'This is the content of the first news.', 1);
INSERT INTO news (title, content, author_id) VALUES ('Second News', 'This is the content of the second news.', 2);

-- 插入评论数据
INSERT INTO comment (news_id, user_id, content) VALUES (1, 1, 'This is a comment on the first news.');
INSERT INTO comment (news_id, user_id, content) VALUES (1, 2, 'This is another comment on the first news.');

-- 插入广告数据
INSERT INTO advertisement (type, content) VALUES ('Banner', 'This is a banner ad.');
INSERT INTO advertisement (type, content) VALUES ('Interstitial', 'This is an interstitial ad.');
