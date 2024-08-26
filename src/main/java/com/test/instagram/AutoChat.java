package com.test.instagram;

import com.test.utils.DriverProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.WaitOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class AutoChat {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public AutoChat() {
       try {
           driver = DriverProvider.getDriver();
           wait = new WebDriverWait(driver, Duration.ofSeconds(3));
           Thread.sleep(2000);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void startAutoChat(){

        //com.instagram.android:id/action_bar_inbox_button
        WebElement messenger = wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(
                                By.id("com.instagram.android:id/action_bar_inbox_button")
                        )
                )
        );
        messenger.click();

        //android.widget.TextView[@content-desc="S usrr"]
        WebElement chat = wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(
                                By.xpath("//android.widget.TextView[@content-desc=\"jacksparrow.py\"]")
                        )
                )
        );
        chat.click();

        WebElement editText = wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(
                                By.xpath("//android.widget.EditText[@resource-id=\"com.instagram.android:id/row_thread_composer_edittext\"]")
                        )
                )
        );

//        for(int i = 0; i < 10; i++){
//
//            editText.sendKeys("hiiii");
//
//            WebElement send = wait.until(
//                    ExpectedConditions.elementToBeClickable(
//                            driver.findElement(
//                                    By.xpath("//android.widget.Button[@resource-id=\"com.instagram.android:id/row_thread_composer_button_send\"]")
//                            )
//                    )
//            );
//            send.click();
//        }

        // com.instagram.android:id/message_list
        WebElement recyclerView = wait.until(
                ExpectedConditions.elementToBeClickable(
                        driver.findElement(
                                By.id("com.instagram.android:id/message_list")
                        )
                )
        );

        List<WebElement> rows = recyclerView.findElements(By.id("com.instagram.android:id/message_content"));

        int i = 0;
        for(WebElement row : rows){
            WebElement message = row.findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.TextView"));

            System.out.println(message.getText().toString());
            i++;
        }

        driver.quit();
    }
}
