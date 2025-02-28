-- 데이터베이스 생성 및 선택
CREATE DATABASE IF NOT EXISTS hannam_rental;
USE hannam_rental;

-- 기존 테이블 삭제 (있으면)
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS rental;

-- users 테이블 생성
CREATE TABLE IF NOT EXISTS users (
    student_id CHAR(20) NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone_number CHAR(20) NOT NULL UNIQUE
);

-- product 테이블 생성
CREATE TABLE IF NOT EXISTS product (
    product_number INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    college ENUM('ENGINEERING', 'SMART_CONVERGENCE') NOT NULL
);

-- rental 테이블 생성
CREATE TABLE IF NOT EXISTS rental (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rental_date DATE NOT NULL,
    return_date DATE NULL,
    retrieve BOOLEAN NOT NULL DEFAULT FALSE,
    student_id CHAR(20) NOT NULL,
    product_number INT NOT NULL,
    college ENUM('ENGINEERING', 'SMART_CONVERGENCE') NOT NULL,
    FOREIGN KEY (student_id) REFERENCES users(student_id) ON DELETE CASCADE,
    FOREIGN KEY (product_number) REFERENCES product(product_number) ON DELETE CASCADE
);

-- users 테이블에 데이터 삽입
INSERT INTO users (student_id, password, name, phone_number) VALUES
('20221234', 'l12345678', '김안녕', '01012345678'),
('20201234', 'l12345678', '이바보', '01087654321')
ON DUPLICATE KEY UPDATE
password = VALUES(password),
name = VALUES(name),
phone_number = VALUES(phone_number);

-- product 테이블에 데이터 삽입 (공과대학 우산 6개, 스마트융합대학 우산 4개)
INSERT INTO product (product_name, college) VALUES
('우산', 'ENGINEERING'),
('우산', 'ENGINEERING'),
('우산', 'ENGINEERING'),
('우산', 'ENGINEERING'),
('우산', 'ENGINEERING'),
('우산', 'ENGINEERING'),
('우산', 'SMART_CONVERGENCE'),
('우산', 'SMART_CONVERGENCE'),
('우산', 'SMART_CONVERGENCE'),
('우산', 'SMART_CONVERGENCE');

-- 데이터 확인
SELECT * FROM users;
SELECT * FROM product;
SELECT * FROM rental;

-- 특정 조건으로 데이터 조회
SELECT * FROM product WHERE college = 'ENGINEERING';
SELECT * FROM product WHERE college = 'SMART_CONVERGENCE';
