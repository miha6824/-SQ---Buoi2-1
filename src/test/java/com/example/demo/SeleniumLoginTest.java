package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SeleniumLoginTest {

    public static void main(String[] args) {
        // Thiết lập đường dẫn ChromeDriver (cập nhật theo đường dẫn của bạn)
        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

       
        // Cấu hình ChromeOptions để sử dụng chế độ headless
        ChromeOptions options = new ChromeOptions();
      

        // Chỉ định đường dẫn đến Chrome binary (cài đặt chrome của bạn)
        options.setBinary("D:\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");

        // Khởi tạo WebDriver với ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            // Mở trang web
            driver.get("http://localhost:8080/login"); // Thay bằng URL trang đăng nhập của bạn

            // Đặt thời gian chờ
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Kiểm thử thành công
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            // Nhập thông tin đúng
            usernameField.sendKeys("admin");
            passwordField.sendKeys("admin123");
            loginButton.click();

            // Kiểm tra chuyển hướng sau khi đăng nhập
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("Dashboard")) {
                System.out.println("Kiểm thử thành công: Đăng nhập đúng hoạt động.");
            } else {
                System.out.println("Kiểm thử thất bại: Không chuyển hướng đến Dashboard.");
            }

            // Kiểm thử thất bại
            driver.get("http://localhost:8080/login");
            usernameField = driver.findElement(By.id("username"));
            passwordField = driver.findElement(By.id("password"));
            loginButton = driver.findElement(By.id("loginButton"));

            // Nhập thông tin sai
            usernameField.sendKeys("wrong_user");
            passwordField.sendKeys("wrong_password");
            loginButton.click();

            // Kiểm tra thông báo lỗi
            WebElement errorMessage = driver.findElement(By.id("errorMessage"));
            if (errorMessage.getText().equals("Tên đăng nhập hoặc mật khẩu không đúng")) {
                System.out.println("Kiểm thử thất bại: Hiển thị thông báo lỗi đúng.");
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

    @Override
    public String toString() {
        return "SeleniumLoginTest []";
    }
}
