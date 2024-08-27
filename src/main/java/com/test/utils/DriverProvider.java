package com.test.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverProvider {

    private static AppiumDriver driver;

    private DriverProvider(){}

    public static AppiumDriver getDriver() throws MalformedURLException {
        if(driver == null){
            var options = new BaseOptions()
                    .amend("platformName", "Android")
                    .amend("appium:platformVersion", "12")
                    .amend("appium:deviceName", "moto e32")
                    .amend("appium:automationName", "UiAutomator2")
                    .amend("appium:appPackage", "com.instagram.android")
                    .amend("appium:appActivity", "com.instagram.android.activity.MainTabActivity")
                    .amend("appium:udid", "ZD222BBYPS")
                    .amend("appium:noReset", true)
                    .amend("appium:setFullReset", false)
                    .amend("appium:newCommandTimeout", 300)
                    .amend("appium:ensureWebviewsHavePages", true)
                    .amend("appium:nativeWebScreenshot", true)
                    .amend("appium:connectHardwareKeyboard", true);

            System.out.println("Driver provided first time");
            return new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } else {

            System.out.println("Driver provided repeated time");
            return driver;
        }
    }

}
