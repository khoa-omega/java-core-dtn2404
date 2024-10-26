DROP DATABASE IF EXISTS lesson_10;
CREATE DATABASE lesson_10;
USE lesson_10;

-- Tạo bảng department
DROP TABLE IF EXISTS department;
CREATE TABLE department (
	department_id INT PRIMARY KEY AUTO_INCREMENT,
	department_name VARCHAR(50)
);

-- Thêm dữ liệu cho bảng department
INSERT INTO department  (department_name)
VALUES                  ("Marketing"    ),
                        ("Sale"         ),
                        ("Bảo vệ"       ),
                        ("Nhân sự"      ),
                        ("Kỹ thuật"     ),
                        ("Tài chính"    ),
                        ("Phó giám đốc" ),
                        ("Giám đốc"     ),
                        ("Thư kí"       ),
                        ("Bán hàng"     );

DELIMITER $$
CREATE PROCEDURE find_by_id(IN in_department_id INT)
BEGIN
    SELECT *
    FROM department
    WHERE department_id = in_department_id;
END $$
DELIMITER ;
