package com.test.instagram;

import com.test.utils.DriverProvider;
import com.test.utils.TapGesture;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AutoChat {

    private AppiumDriver driver;

    public AutoChat() {
       try {
           driver = DriverProvider.getDriver();
       }catch (Exception e){
           e.getCause();
       }
    }


    public String getChatName(){
        openChat();

        WebElement chatName = driver.findElement(By.id("com.instagram.android:id/thread_title"));
        return chatName.getText();
    }


    public void openChat(){

        //com.instagram.android:id/action_bar_inbox_button

        try{
            Thread.sleep(2000);

            WebElement messenger = driver.findElement(By.id("com.instagram.android:id/action_bar_inbox_button"));
            TapGesture.singleTap(messenger, driver);

            //android.widget.TextView[@content-desc="S usrr"]
            WebElement chat = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"jacksparrow.py\"]"));
            TapGesture.singleTap(chat, driver);

            System.out.println("Chat opened");
        }catch (InterruptedException e) {
            e.getCause();
        }catch (NoSuchElementException e) {
            e.getCause();

            openChat();
        }
    }


    public void startAutoChat(){

        openChat();

        WebElement editText = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.instagram.android:id/row_thread_composer_edittext\"]"));

        System.out.println("Starting auto chat");

        for(int i = 0; i < 10; i++){

            editText.sendKeys("hiiii");

            WebElement send = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.instagram.android:id/row_thread_composer_button_send\"]"));
            TapGesture.singleTap(send, driver);
        }

        driver.quit();
    }

    public void retrieveChats(){

        openChat();

        System.out.println("Retrieving chats");

        // com.instagram.android:id/message_list
        WebElement recyclerView = driver.findElement(By.id("com.instagram.android:id/message_list"));

        List<WebElement> items = recyclerView.findElements(By.id("com.instagram.android:id/message_content"));

        int i = 0;
        for(WebElement item : items){
            WebElement message = item.findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.LinearLayout"))
                    .findElement(By.className("android.widget.TextView"));


            System.out.println(message.getText());

//            if(x > 200){
//                chatters = "Sender";
//                chats.put(chatters, chats.get(chatters).add(message.getText()));
//            }else{
//                chatters = "Receiver";
//                chats.put(chatters, chats.get(chatters).add(message.getText()));
//            }

            i++;
        }

        driver.quit();

    }
}
