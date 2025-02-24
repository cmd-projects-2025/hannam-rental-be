CREATE TABLE IF NOT EXISTS users (
    student_id CHAR(20) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone_number CHAR(20) NOT NULL UNIQUE
);


INSERT INTO users (student_id, password, name, phone_number) VALUES
('20221234', 'l12345678', '김안녕', '01012345678'),
('20201234', 'l12345678', '이바보', '01087654321')
ON DUPLICATE KEY UPDATE student_id=student_id;

