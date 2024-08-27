package com.test.instagram;

import com.test.utils.DriverProvider;
import com.test.utils.TapGesture;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutoFollowing {

    private AppiumDriver driver;

    public AutoFollowing() {
        try {
            AppiumDriver driver = DriverProvider.getDriver();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openFollowingOption() {

        WebElement tabAvatar = driver.findElement(By.id("com.instagram.android:id/tab_avatar"));
        TapGesture.singleTap(tabAvatar, driver);

        // com.instagram.android:id/row_profile_header_following_container

        WebElement profileContainer = driver.findElement(By.id("com.instagram.android:id/row_profile_header_following_container"));
        TapGesture.singleTap(profileContainer, driver);

        // (//android.widget.LinearLayout[@resource-id="com.instagram.android:id/follow_list_content_container"])[2]
        WebElement followListButton = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.instagram.android:id/follow_list_content_container\"])[2]"));
        TapGesture.singleTap(followListButton, driver);

        // com.instagram.android:id/row_profile_header_followers_container
        WebElement followersListOfCR7 = driver.findElement(By.id("com.instagram.android:id/row_profile_header_followers_container"));
        TapGesture.singleTap(followersListOfCR7, driver);

        driver.quit();
    }



}
