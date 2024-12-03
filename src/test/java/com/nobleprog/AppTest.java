package com.nobleprog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {

    @Test(enabled = false)
    public void tc1(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.uptut.com");

        String title = driver.getTitle();

        System.out.println(title);

        driver.close();


    }
    
}
