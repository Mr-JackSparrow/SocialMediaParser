package com.test.instagram;

import com.test.utils.DriverProvider;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoFollowers {
    public static void main(String[] args)  {

        try {
            AppiumDriver driver = DriverProvider.getDriver();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));




            WebElement tabAvatar = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/tab_avatar")));
            tabAvatar.click();

            // com.instagram.android:id/row_profile_header_following_container

            WebElement profileContainer = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/row_profile_header_following_container")));
            profileContainer.click();

            // (//android.widget.LinearLayout[@resource-id="com.instagram.android:id/follow_list_content_container"])[2]
            WebElement followListButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.instagram.android:id/follow_list_content_container\"])[2]")));
            followListButton.click();

            // com.instagram.android:id/row_profile_header_followers_container
            WebElement followersListOfCR7 = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/row_profile_header_followers_container")));
            followersListOfCR7.click();

            // //androidx.recyclerview.widget.RecyclerView

            // androidx.recyclerview.widget.RecyclerView
            scrollAndClickAllButtonsInRecyclerView(driver);


            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollAndClickAllButtonsInRecyclerView(AppiumDriver driver) {
        WebElement recyclerView = driver.findElement(By.className("androidx.recyclerview.widget.RecyclerView"));

        List<WebElement> items = recyclerView.findElements(By.className("android.widget.LinearLayout"));

        System.out.println(items.size());

        scrollDown(driver);

    }

    public static boolean scrollDown(AppiumDriver driver) {
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.8);
        int endY = (int) (driver.manage().window().getSize().height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));

        List<WebElement> newListItems = driver.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
        return !newListItems.isEmpty();
    }

}
