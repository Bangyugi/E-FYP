INSERT INTO roles ( name, description) VALUES
                                                   ('ROLE_STUDENT', 'US-01'),
                                                   ('ROLE_ADVISOR', 'US-02'),
                                                   ( 'ROLE_SUPERADMIN', 'US-03'),
                                                   ( 'ROLE_ADMIN', 'US-04');


INSERT INTO faculties ( name, description)
VALUES
    ('Khoa Công nghệ thông tin', 'Chuyên đào tạo các ngành liên quan đến CNTT, phần mềm và hệ thống thông tin.'),
    ('Khoa Kinh tế', 'Chuyên đào tạo các ngành về kinh tế, quản trị và tài chính.'),
    ( 'Khoa Cơ khí', 'Chuyên đào tạo các ngành về cơ khí, chế tạo máy móc và công nghệ sản xuất.'),
    ( 'Khoa Điện - Điện tử', 'Chuyên đào tạo các ngành về điện, điện tử và tự động hóa.'),
    ( 'Khoa Quản trị', 'Chuyên đào tạo các ngành về quản trị kinh doanh và điều hành doanh nghiệp.');



INSERT INTO majors ( name, description)
VALUES
    ( 'Computer Science', 'Study of computers, programming, and computational systems.'),
    ( 'Information Technology', 'Focuses on the use of computer technology to manage and process information.'),
    ( 'Software Engineering', 'Application of engineering principles to design, develop, and maintain software systems.'),
    ('Accounting', 'Involves the study of financial recording, reporting, and analysis.'),
    ( 'Business Administration', 'Covers management practices, business operations, and decision making.'),
    ( 'Marketing', 'Focuses on strategies for promoting and selling products or services.'),
    ( 'Mechanical Engineering', 'Involves the design and analysis of mechanical systems and devices.'),
    ( 'Civil Engineering', 'Deals with the planning, design, and construction of infrastructure.'),
    ( 'Environmental Engineering', 'Focuses on developing solutions to environmental problems and sustainability.'),
    ( 'Architecture', 'Covers the art and science of designing buildings and structures.');


INSERT INTO users (username,password,email,phone,first_name,last_name,birth_date,avatar,gender,enabled,user_type,major_id,graduation_time,created_at,updated_at)
VALUES
    ( '202260001', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'dinhhuyhoang@gmail.com', '0343675987', 'Đinh', 'Huy Hoàng', '2002-09-11', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE,  'STUDENT', 1, '2026-10-09', NOW(), NOW()),
    ( '202260002', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'phamminhthuy@gmail.com', '0351234567', 'Phạm', 'Minh Thủy', '2001-05-20', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'STUDENT', 1,
     '2026-10-09', NOW(), NOW()),
    ( '202260003', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'tranvananh@gmail.com', '0369876543', 'Trần', 'Văn Anh', '2002-01-15', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE,  'STUDENT', 2,
     '2026-10-09', NOW(), NOW()),
    ( '202260004', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'nguyenthanhthuy@gmail.com', '0376543210', 'Nguyễn', 'Thanh Thùy', '2001-12-01', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'STUDENT', 2, '2026-10-09', NOW(), NOW()),
    ( '202260005', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'leminhkhanh@gmail.com', '0381122334', 'Lê', 'Minh Khánh', '2002-03-10', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'STUDENT', 4, '2026-10-09', NOW(), NOW()),
    ( '202260006', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'voan@gmail.com', '0392233445', 'Võ', 'Thị An', '2001-11-30', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'STUDENT', 5, '2026-10-09', NOW(), NOW()),
    ( '202260007', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'hoangtuan@gmail.com', '0345566778', 'Hoàng', 'Tuấn Kiệt', '2002-07-07', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE,  'STUDENT',2, '2026-10-09', NOW(), NOW()),
    ( '202260008', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'danglinh@gmail.com', '0356677889', 'Đặng', 'Thị Linh', '2002-04-14', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'STUDENT',3, '2026-10-09', NOW(), NOW()),
    ( '202260009', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'truongnhut@gmail.com', '0367788990', 'Trương', 'Nhật Nhut', '2002-08-18', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'STUDENT', 3, '2026-10-09', NOW(), NOW()),
    ( '202260010', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'nguyenhuuyen@gmail.com', '0378899001', 'Nguyễn', 'Thị Uyên', '2001-09-09', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'STUDENT', 4, '2026-10-09', NOW(), NOW());

INSERT INTO users (username,password,email,phone,first_name,last_name,birth_date,avatar,gender,enabled,user_type,faculty_id,academic_degree,created_at,updated_at)
VALUES
    ( '2022700001', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'lehoangduy@haui.edu.vn', '0341234567', 'Lê', 'Hoàng Duy', '1978-03-15', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADVISOR', 1, 'Tiến sĩ', NOW(), NOW()),
    ( '2022700002', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'nguyenthanhlam@haui.edu.vn', '0352345678', 'Nguyễn', 'Thanh Lâm', '1980-07-22', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADVISOR', 2, 'Thạc sĩ', NOW(), NOW()),
    ('2022700003', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'phamthihoa@haui.edu.vn', '0363456789', 'Phạm', 'Thị Hoa', '1982-11-05', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'ADVISOR', 2, 'Tiến sĩ', NOW(), NOW()),
    ( '2022700004', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'tranthithuy@haui.edu.vn', '0374567890', 'Trần', 'Thị Thủy', '1985-02-28', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'ADVISOR', 4, 'Thạc sĩ', NOW(), NOW()),
    ( '2022700005', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'dangminhthuan@haui.edu.vn', '0385678901', 'Đặng', 'Minh Thuận', '1979-09-09', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADVISOR', 3, 'Tiến sĩ', NOW(), NOW()),
    ( '2022700006', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'voquocanh@haui.edu.vn', '0396789012', 'Võ', 'Quốc Anh', '1983-04-17', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADVISOR', 3, 'Thạc sĩ', NOW(), NOW()),
    ( '2022700007', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'tranthilan@haui.edu.vn', '0347890123', 'Trần', 'Thị Lan', '1986-08-30', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'ADVISOR', 5, 'Thạc sĩ', NOW(), NOW()),
    ( '2022700008', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'nguyenthihoa@haui.edu.vn', '0358901234', 'Nguyễn', 'Thị Hoa', '1981-12-12', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'ADVISOR',2, 'Thạc sĩ', NOW(), NOW()),
    ( '2022700009', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'lethihoang@haui.edu.vn', '0369012345', 'Lê', 'Thị Hoàng', '1984-03-03', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'ADVISOR', 3, 'Tiến sĩ', NOW(), NOW()),
    ('2022700010', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5/Q0eQ/Qw2', 'dangvanquang@haui.edu.vn', '0370123456', 'Đặng', 'Văn Quang', '1977-06-21', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADVISOR', 1, 'Tiến sĩ', NOW(), NOW());

INSERT INTO users (username,password,email,phone,first_name,last_name,birth_date,avatar,gender,enabled,user_type,created_at,updated_at)
VALUES
    ( '2022800001', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin1@gmail.com', '0341234001', 'Trần', 'Văn A', '1970-01-01', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADMIN', NOW(), NOW()),
    ( '2022800002', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin2@gmail.com', '0341234002', 'Lê', 'Thị B', '1972-02-02', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'ADMIN', NOW(), NOW()),
    ('2022800003', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin3@gmail.com', '0341234003', 'Phạm', 'Văn C', '1974-03-03', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADMIN', NOW(), NOW()),
    ( '2022800004', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin4@gmail.com', '0341234004', 'Nguyễn', 'Thị D', '1976-04-04', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'ADMIN', NOW(), NOW()),
    ( '2022800005', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin5@gmail.com', '0341234005', 'Hoàng', 'Văn E', '1978-05-05', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'ADMIN', NOW(), NOW());

INSERT INTO users (username,password,email,phone,first_name,last_name,birth_date,avatar,gender,enabled,user_type,created_at,updated_at)
VALUES
    ( '2022900001', '$2a$10$FiqGELBJ1ByXPHQz9CY5LuZAdwChfuEWsyHaphWmKBYaRFbXNcHZK', 'bangyugi@gmail.com', '0334236824', 'Trần', 'Văn Bằng', '2004-08-22', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'SUPERADMIN', NOW(), NOW()),
    ( '2022900002', '$2a$10$FiqGELBJ1ByXPHQz9CY5LuZAdwChfuEWsyHaphWmKBYaRFbXNcHZK', 'superadmin2@gmail.com', '0352324678', 'Nguyễn', 'Thị Lan', '1968-11-22', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'SUPERADMIN', NOW(), NOW()),
    ( '2022900003', '$2a$10$FiqGELBJ1ByXPHQz9CY5LuZAdwChfuEWsyHaphWmKBYaRFbXNcHZK', 'superadmin3@gmail.com', '0359874896', 'Trần', 'Văn Minh', '1970-03-30', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'SUPERADMIN', NOW(), NOW());
