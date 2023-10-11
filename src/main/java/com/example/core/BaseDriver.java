package com.example.core;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BaseDriver {
    WebDriver driver;

    public BaseDriver(){
        driver = new FirefoxDriver();
    }

    public WebDriver get_driver(){
        log.info("Driver successfully created");
        return driver;
    }

}
