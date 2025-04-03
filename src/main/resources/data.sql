INSERT INTO roles ( name, description) VALUES
   ('ROLE_STUDENT', 'US-01'),
   ('ROLE_ADVISOR', 'US-02'),
   ( 'ROLE_ADMIN', 'US-03'),
   ( 'ROLE_SUPERADMIN', 'US-04');


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
    ( '2022800001', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin1@gmail.com', '0341234001', 'Trần', 'Văn A', '1970-01-01', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'USER', NOW(), NOW()),
    ( '2022800002', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin2@gmail.com', '0341234002', 'Lê', 'Thị B', '1972-02-02', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'USER', NOW(), NOW()),
    ('2022800003', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin3@gmail.com', '0341234003', 'Phạm', 'Văn C', '1974-03-03', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'USER', NOW(), NOW()),
    ( '2022800004', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin4@gmail.com', '0341234004', 'Nguyễn', 'Thị D', '1976-04-04', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'USER', NOW(), NOW()),
    ( '2022800005', '$2a$10$9hWPtTSDFsBhJB5fblv9tOuuVDUuw9e3c4BBHoJSwtP5', 'admin5@gmail.com', '0341234005', 'Hoàng', 'Văn E', '1978-05-05', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'USER', NOW(), NOW());

INSERT INTO users (username,password,email,phone,first_name,last_name,birth_date,avatar,gender,enabled,user_type,created_at,updated_at)
VALUES
    ( 'bangyugi', '$2a$10$FiqGELBJ1ByXPHQz9CY5LuZAdwChfuEWsyHaphWmKBYaRFbXNcHZK', 'bangyugi@gmail.com', '0334236824', 'Trần', 'Văn Bằng', '2004-08-22', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'USER', NOW(), NOW()),
    ( '2022900002', '$2a$10$FiqGELBJ1ByXPHQz9CY5LuZAdwChfuEWsyHaphWmKBYaRFbXNcHZK', 'superadmin2@gmail.com', '0352324678', 'Nguyễn', 'Thị Lan', '1968-11-22', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'FEMALE', TRUE, 'USER', NOW(), NOW()),
    ( '2022900003', '$2a$10$FiqGELBJ1ByXPHQz9CY5LuZAdwChfuEWsyHaphWmKBYaRFbXNcHZK', 'superadmin3@gmail.com', '0359874896', 'Trần', 'Văn Minh', '1970-03-30', 'https://cdn-icons-png.flaticon.com/512/3607/3607444.png', 'MALE', TRUE, 'USER', NOW(), NOW());


INSERT INTO user_role(user_id,role_id) VALUES
    (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),
    (11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),
    (21,3),(22,3),(23,3),(24,3),(25,3),
    (26,4),(27,4),(28,4);

INSERT INTO categories ( name, description, created_at, updated_at)
VALUES
    ('E-Commerce', 'Category for E-Commerce projects', '2025-04-02', '2025-04-02'),
    ('Game Development', 'Category for Game Development projects', '2025-04-02', '2025-04-02'),
    ('Artificial Intelligence', 'Category for Artificial Intelligence projects', '2025-04-02', '2025-04-02');

INSERT INTO tags (name, description, created_at, updated_at)
VALUES
    ('e-commerce', 'Tag: e-commerce', '2025-04-02', '2025-04-02'),
    ('microservices', 'Tag: microservices', '2025-04-02', '2025-04-02'),
    ('cloud', 'Tag: cloud', '2025-04-02', '2025-04-02'),
    ('AI', 'Tag: AI', '2025-04-02', '2025-04-02'),
    ('analytics', 'Tag: analytics', '2025-04-02', '2025-04-02'),
    ('big data', 'Tag: big data', '2025-04-02', '2025-04-02'),
    ('retail', 'Tag: retail', '2025-04-02', '2025-04-02'),
    ('MMORPG', 'Tag: MMORPG', '2025-04-02', '2025-04-02'),
    ('multiplayer', 'Tag: multiplayer', '2025-04-02', '2025-04-02'),
    ('fantasy', 'Tag: fantasy', '2025-04-02', '2025-04-02'),
    ('arcade', 'Tag: arcade', '2025-04-02', '2025-04-02'),
    ('retro', 'Tag: retro', '2025-04-02', '2025-04-02'),
    ('deep learning', 'Tag: deep learning', '2025-04-02', '2025-04-02'),
    ('image recognition', 'Tag: image recognition', '2025-04-02', '2025-04-02');

INSERT INTO technologies (name, description, created_at, updated_at)
VALUES
    ('Node.js', 'Technology: Node.js', '2025-04-02', '2025-04-02'),
    ('React', 'Technology: React', '2025-04-02', '2025-04-02'),
    ('AWS', 'Technology: AWS', '2025-04-02', '2025-04-02'),
    ('Docker', 'Technology: Docker', '2025-04-02', '2025-04-02'),
    ('Kubernetes', 'Technology: Kubernetes', '2025-04-02', '2025-04-02'),
    ('Python', 'Technology: Python', '2025-04-02', '2025-04-02'),
    ('Apache Spark', 'Technology: Apache Spark', '2025-04-02', '2025-04-02'),
    ('Tableau', 'Technology: Tableau', '2025-04-02', '2025-04-02'),
    ('Unity', 'Technology: Unity', '2025-04-02', '2025-04-02'),
    ('C#', 'Technology: C#', '2025-04-02', '2025-04-02'),
    ('Photon Engine', 'Technology: Photon Engine', '2025-04-02', '2025-04-02'),
    ('C++', 'Technology: C++', '2025-04-02', '2025-04-02'),
    ('SDL', 'Technology: SDL', '2025-04-02', '2025-04-02'),
    ('TensorFlow', 'Technology: TensorFlow', '2025-04-02', '2025-04-02'),
    ('Keras', 'Technology: Keras', '2025-04-02', '2025-04-02'),
    ('OpenCV', 'Technology: OpenCV', '2025-04-02', '2025-04-02');

INSERT INTO projects (title, abstractive, thumbnail, status, summission_date, upvote, downvote, project_information, repository_url, post, author_name, advisor_name, author_id, advisor_id, category_id, created_at, updated_at)
VALUES
    ('NextGen E-Commerce Platform', 'Một nền tảng thương mại điện tử cloud-native, có khả năng mở rộng cao dành cho thị trường bán lẻ hiện đại.', 'https://example.com/images/nextgen-ecommerce.png', 'ACTIVE', '2025-04-02', 50, 2, 'Dự án này nhằm cách mạng hóa trải nghiệm mua sắm trực tuyến bằng cách tích hợp cá nhân hóa dựa trên AI cùng kiến trúc microservices.', 'https://github.com/example/nextgen-ecommerce', 'Tài liệu chi tiết về thiết kế, triển khai và vận hành nền tảng NextGen E-Commerce.', 'Đinh Huy Hoàng', 'Phạm Thị Hoa', 1, 18, 1, '2025-04-02', '2025-04-02'),

    ('Smart Retail Analytics', 'Công cụ phân tích thông minh dựa trên big data giúp tối ưu hóa chiến lược bán lẻ.', 'https://example.com/images/smart-retail.png', 'ACTIVE', '2025-04-02', 40, 1, 'Smart Retail Analytics thu thập và phân tích dữ liệu hành vi khách hàng, hỗ trợ các nhà bán lẻ nâng cao doanh số và hiệu quả vận hành.', 'https://github.com/example/smart-retail-analytics', 'Bài viết chi tiết về quy trình phân tích dữ liệu khách hàng và những kết quả thu được từ dự án.', 'Lê Minh Khánh', 'Lê Thị Lan', 5, NULL, 1, '2025-04-02', '2025-04-02'),

    ('Infinite Adventure', 'Trò chơi MMORPG nhập vai với thế giới mở đầy sáng tạo và tương tác trực tuyến cao.', 'https://example.com/images/infinite-adventure.png', 'ACTIVE', '2025-04-02', 80, 3, 'Infinite Adventure đưa người chơi vào một thế giới giả tưởng sống động, nơi họ có thể khám phá, tạo liên minh và tham gia vào các trận chiến hoành tráng.', 'https://github.com/example/infinite-adventure', 'Bài viết chi tiết về cơ chế trò chơi, cốt truyện và cơ sở hạ tầng mạng hỗ trợ hàng nghìn người chơi trực tuyến cùng lúc.', 'Phạm Duy Khanh', 'Nguyễn Quang Vũ', NULL, NULL, 2, '2025-04-02', '2025-04-02'),

    ('Retro Arcade Revival', 'Phiên bản hiện đại của những trò chơi arcade cổ điển với đồ họa nâng cấp và chế độ chơi đa người.', 'https://example.com/images/retro-arcade.png', 'ACTIVE', '2025-04-02', 65, 4, 'Retro Arcade Revival tái hiện lại vẻ đẹp của các trò chơi arcade xưa cũ, đồng thời bổ sung các tính năng mới và chế độ chơi đa người để tăng tính cạnh tranh.', 'https://github.com/example/retro-arcade-revival', 'Bài viết trình bày quá trình chuyển thể các trò chơi cổ điển sử dụng công cụ phát triển hiện đại.', 'Nguyễn Huy Hoàng', 'Lê Minh Hiển', NULL, NULL, 2, '2025-04-02', '2025-04-02'),

    ('DeepVision AI', 'Nền tảng deep learning tiên tiến cho các tác vụ nhận dạng hình ảnh.', 'https://example.com/images/deepvision-ai.png', 'ACTIVE', '2025-04-02', 100, 5, 'DeepVision AI sử dụng các mô hình mạng nơ-ron tích chập (CNN) để nhận diện và phân loại đối tượng trong hình ảnh, ứng dụng rộng rãi trong lĩnh vực an ninh và y tế.', 'https://github.com/example/deepvision-ai', 'Bài viết tổng hợp nghiên cứu về các kiến trúc mạng nơ-ron và quá trình huấn luyện mô hình với dữ liệu lớn.', 'Nguyễn Thanh Bình', 'Đặng Minh Thuận', NULL, 15, 3, '2025-04-02', '2025-04-02');

INSERT INTO project_tag (project_id, tag_id)
VALUES
    (1, 1), (1, 2), (1, 3), (1, 4),
    (2, 5), (2, 6), (2, 7),
    (3, 8), (3, 9), (3, 10),
    (4, 11), (4, 12), (4, 9),
    (5, 13), (5, 14), (5, 4);

INSERT INTO project_technology (project_id, technology_id)
VALUES
    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
    (2, 6), (2, 7), (2, 8),
    (3, 9), (3, 10), (3, 11),
    (4, 9), (4, 12), (4, 13),
    (5, 6), (5, 14), (5, 15), (5, 16);

