package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumLoginTest {

    public static void main(String[] args) {
        // Thiết lập đường dẫn ChromeDriver (cập nhật theo đường dẫn của bạn)
        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver-win64\\chromedriver.exe");


        // Cấu hình ChromeOptions để hỗ trợ cờ tùy chọn
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--disable-gpu");
options.addArguments("--headless=new"); // Nếu muốn chạy chế độ headless


        // Nếu sử dụng Chrome Portable, chỉ định đường dẫn binary
        options.setBinary("D:\\Downloads\\chrome-win64\\chrome.exe");


        // Khởi tạo WebDriver với ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            // Mở trang web
            driver.get("http://localhost:8080/login");

            // Đặt thời gian chờ
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Kiểm thử đăng nhập thành công
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            usernameField.sendKeys("admin");
            passwordField.sendKeys("admin123");
            loginButton.click();

            // Kiểm tra tiêu đề trang
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("Dashboard")) {
                System.out.println("Kiểm thử thành công: Đăng nhập đúng hoạt động.");
            } else {
                System.out.println("Kiểm thử thất bại: Không chuyển hướng đến Dashboard.");
            }

            // Kiểm thử đăng nhập thất bại
            driver.get("http://localhost:8080/login");
            usernameField = driver.findElement(By.id("username"));
            passwordField = driver.findElement(By.id("password"));
            loginButton = driver.findElement(By.id("loginButton"));

            usernameField.sendKeys("wrong_user");
            passwordField.sendKeys("wrong_password");
            loginButton.click();

            // Kiểm tra thông báo lỗi
            WebElement errorMessage = driver.findElement(By.id("errorMessage"));
            if ("Tên đăng nhập hoặc mật khẩu không đúng".equals(errorMessage.getText())) {
                System.out.println("Kiểm thử thành công: Thông báo lỗi đúng.");
            } else {
                System.out.println("Kiểm thử thất bại: Thông báo lỗi không đúng.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
