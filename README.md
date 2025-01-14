# Bài Tập Kiểm Thử Tự Động với Selenium
1. Đề bài
- Mô Tả Bài Tập : Bạn được yêu cầu kiểm thử tự động một trang web đơn giản sử dụng Selenium. Trang web là một trang đăng nhập có các thành phần sau:
          Một ô nhập liệu cho tên người dùng (username).
          Một ô nhập liệu cho mật khẩu (password).
          Một nút "Đăng nhập" (Login).
          Một thông báo lỗi xuất hiện khi đăng nhập thất bại.
- Yêu cầu: 1) Thiết lập môi trường:
+ Cài đặt Selenium WebDriver.
+ Sử dụng trình duyệt Chrome hoặc Firefox.
+ Sử dụng ngôn ngữ lập trình Python hoặc Java.
-  Viết kịch bản kiểm thử:
+ Kiểm thử thành công:
Nhập đúng thông tin tài khoản (ví dụ: username: admin, password: admin123).
Kiểm tra xem trang chuyển hướng đến màn hình chính sau khi đăng nhập.
+) Kiểm thử thất bại:
Nhập sai tên người dùng hoặc mật khẩu.
Xác minh rằng thông báo lỗi hiển thị đúng nội dung, ví dụ: "Tên đăng nhập hoặc mật khẩu không đúng."
+) Kiểm tra trường hợp bỏ trống:
Bỏ trống cả hai trường nhập liệu.
Kiểm tra rằng hệ thống hiện thông báo yêu cầu nhập thông tin.
- Viết báo cáo kết quả kiểm thử:
Báo cáo kết quả của từng kịch bản.
Đánh giá xem chức năng có hoạt động đúng như mong đợi không.
- Đầu Ra Mong Đợi:
Mã nguồn kiểm thử tự động.
Kết quả kiểm thử (bảng hoặc báo cáo mô tả).
Nếu phát hiện lỗi, ghi rõ lỗi và đưa ra đề xuất cải tiến.
2. Mã code 
![Mô tả ảnh](https://github.com/miha6824/image/blob/main/Screenshot%202025-01-14%20192810.png)
![Mô tả ảnh](https://github.com/miha6824/image/blob/main/Screenshot%202025-01-14%20192827.png)
3. Kịch bản kiếm thử
--) Kịch bản 1: Đăng nhập đúng
Hành động:
+ Mở trang đăng nhập (http://localhost:8080/login).
+ Nhập tên đăng nhập là admin.
+ Nhập mật khẩu là admin123.
+ Nhấn nút loginButton.
Kiểm tra:
+ Nếu sau khi đăng nhập tiêu đề trang chứa chữ "Dashboard", thì in ra: "Kiểm thử thành công: Đăng nhập đúng hoạt động."
+ Nếu không, in ra: "Kiểm thử thất bại: Không chuyển hướng đến Dashboard"
--) Kịch bản 2: Đăng nhập sai
Hành động:
+ Quay lại trang đăng nhập (http://localhost:8080/login).
+ Nhập tên đăng nhập sai (wrong_user).
+ Nhập mật khẩu sai (wrong_password).
+ Nhấn nút loginButton.
Kiểm tra:
+Nếu tìm thấy phần tử errorMessage và nội dung của nó là "Tên đăng nhập hoặc mật khẩu không đúng", thì in ra: "Kiểm thử thất bại: Hiển thị thông báo lỗi đúng."
Nếu không, in ra: "Kiểm thử thất bại: Thông báo lỗi không đúng."
