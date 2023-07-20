Create database Feedback_QnA;

use Feedback_QnA;
go
CREATE TABLE course (
  course_id INT PRIMARY KEY,
  name NVARCHAR(255) NOT NULL
);
GO

CREATE TABLE student (
  student_id INT IDENTITY (1,1),
  student_email VARCHAR(255) NOT NULL,
  student_password VARCHAR(255) NOT NULL,
  primary key(student_id, student_email),
  name NVARCHAR(255) NOT NULL,
  course_id INT NOT NULL,
  FOREIGN KEY (course_id) REFERENCES course(course_id)
);
GO

CREATE TABLE lecture (
  lecture_id INT IDENTITY (1,1),
  lecture_email VARCHAR(255) NOT NULL,
  lecture_password VARCHAR(255) NOT NULL,
  primary key(lecture_id, lecture_email),
  name NVARCHAR(255) NOT NULL,
  course_id INT NOT NULL,
  FOREIGN KEY (course_id) REFERENCES course(course_id)
);
GO

CREATE TABLE feedback (
  id INT PRIMARY KEY IDENTITY (1,1),
  content NTEXT NOT NULL,
  date DATE NOT NULL,
  student_id INT NOT NULL,
  student_email VARCHAR(255),
  lecture_id INT NOT NULL,
  lecture_email VARCHAR(255),
  course_id INT NOT NULL,
  FOREIGN KEY (student_id,student_email) REFERENCES student(student_id,student_email),
  FOREIGN KEY (lecture_id,lecture_email) REFERENCES lecture(lecture_id,lecture_email),
  FOREIGN KEY (course_id) REFERENCES course(course_id)
);
GO

CREATE TABLE qna (
  id INT PRIMARY KEY IDENTITY (1,1),
  question NTEXT NOT NULL,
  answer NTEXT,
  date DATE NOT NULL,
  student_id INT NOT NULL,
  student_email VARCHAR(255),
  lecture_id INT NOT NULL,
  lecture_email VARCHAR(255),
  course_id INT NOT NULL,
  FOREIGN KEY (student_id,student_email) REFERENCES student(student_id,student_email),
  FOREIGN KEY (lecture_id,lecture_email) REFERENCES lecture(lecture_id,lecture_email),
  FOREIGN KEY (course_id) REFERENCES course(course_id)
);
GO
INSERT INTO Course (course_id,name) VALUES
(1,N'Toán rời rạc'),
(2,N'Cấu trúc dữ liệu và giải thuật'),
(3,N'Công nghệ phần mềm'),
(4,N'Mạng máy tính'),
(5,N'Trí tuệ nhân tạo');

GO
INSERT INTO student (student_email,student_password,name, course_id) VALUES 
  ('thuydung11@gmail.com','123',N'Nguyễn Thùy Dung', 1),
  ('phanvan22@gmail.com','123',N'Phan Văn', 1),
  ('anhtuc33@gmail.com','123',N'Hoa Anh Túc', 2),
  ('dangtu44@gmail.com','123',N'Định Đăng Tú', 2),
  ('tiendat55@gmail.com','123',N'Nguyễn Tiến Đạt', 3),
  ('trankim66@gmail.com','123',N'Trần Kim', 3),
  ('dangluan77@gmail.com','123',N'Đặng Luân', 4),
  ('lehieu88@gmail.com','123',N'Lê Hiếu', 4),
  ('tamanh99@gmail.com','123',N'Minh Tâm Anh', 5),
  ('nguyendu90@gmail.com','123',N'Nguyễn Vinh Dự', 5);
  GO
 INSERT INTO lecture ( lecture_email,lecture_password, name, course_id) VALUES
    ( 'nguyenvanx@gmail.com','123', N'Nguyễn Văn X', 1),
    ( 'tranthiy@gmail.com','123', N'Trần Thị Y', 2),
    ( 'levanc@gmail.com','123', N'Lê Văn C', 3),
    ( 'phamthid@gmail.com','123', N'Phạm Thị D', 3),
    ( 'nguyenvane@gmail.com','123', N'Nguyễn Văn E', 2),
    ( 'dothif@gmail.com','123', N'Đỗ Thị F', 1),
    ( 'hoangvang@gmail.com','123', N'Hoàng Văn G', 4),
    ( 'nguyenthih@gmail.com','123', N'Nguyễn Thị H', 5),
	( 'nguyenvanve@gmail.com','123', N'Nguyễn Văn Vẻ', 5);

GO
   INSERT INTO feedback ( content, date, student_id, lecture_id, course_id) VALUES
    ( N'Bài giảng rất dễ hiểu và hữu ích', '2023-01-01', 1, 1, 1),
    (N'Cảm ơn thầy đã giải đáp thắc mắc của em', '2023-01-02', 2, 1, 2),
    ( N'Em rất hài lòng với bài giảng này', '2023-01-03', 3, 1, 3),
    ( N'Nhờ có bài giảng này mà em đã hiểu rõ hơn về chủ đề này', '2022-01-04', 4, 7, 4),
    ( N'Thầy giảng bài rất truyền cảm hứng', '2023-01-05', 5, 5, 2),
    ( N'Em đang gặp khó khăn với chủ đề này và rất cảm ơn thầy đã giải thích rõ ràng', '2023-01-06', 6, 6, 5),
    ( N'Bài giảng này quá tuyệt vời', '2023-01-07', 7, 3, 1),
    ( N'Em rất thích phần trình bày của thầy', '2023-01-08', 8, 5, 2),
    (N'Các ví dụ của thầy rất hay và đầy đủ', '2023-01-09', 9, 1, 5),
    ( N'Em sẽ tiếp tục theo đuổi chủ đề này nhờ sự giúp đỡ của thầy', '2023-01-10', 9, 2, 1);
GO
INSERT INTO qna ( question, answer, date, student_id, lecture_id, course_id) VALUES
( N'Học cải thiện điểm cần làm gì?', N'Làm thêm bài tập thầy giao.', '2023-02-01', 1, 1, 1),
( N'Môn học nào sẽ được dạy trong khóa học này?', N'Khóa học này sẽ tập trung vào các môn lập trình cơ bản như Java và Python.', '2023-02-05', 3, 2, 2),
( N'Lịch học phụ đạo của khóa học này như thế nào?', N'Khóa học này sẽ có lịch học vào các buổi tối trong tuần từ 19h đến 21h.', '2023-02-08', 5, 4, 3),
( N'Điểm chấm bài tập được tính như thế nào?', N'Điểm chấm bài tập sẽ được tính dựa trên các yêu cầu của bài tập và cách thức hoàn thành của sinh viên.', '2023-02-12', 6, 3, 3),
( N'Có cần phải có kiến thức trước khi tham gia khóa học này không?', N'Không, khóa học này sẽ bắt đầu từ cơ bản và không yêu cầu kiến thức trước.', '2023-02-15', 4, 5, 2),
(N'Có cần phải đăng ký trước để tham gia khóa học này không?', N'Có, sinh viên cần đăng ký trước để tham gia khóa học.', '2022-02-02', 1, 6, 1),
( N'Khóa học này sẽ kéo dài trong bao lâu?', N'Khóa học này sẽ kéo dài trong 2 tháng.', '2022-02-09', 7, 7, 4),
( N'Sinh viên sẽ được học những kỹ năng gì trong khóa học này?', N'Sinh viên sẽ được học các kỹ năng lập trình cơ bản và phát triển phần mềm.', '2023-02-14', 8, 7, 4),
( N'Có cần thiết phải có laptop để tham gia khóa học này không?', N'Có, sinh viên cần có laptop để có thể thực hành các bài tập lập trình.', '2023-02-18', 9, 8, 5),
( N'Khóa học này có phù hợp với những người mới bắt đầu học lập trình không?', N'Có, khóa học này sẽ phù hợp với những người mới bắt đầu học','2023-02-18',4,2, 2);
