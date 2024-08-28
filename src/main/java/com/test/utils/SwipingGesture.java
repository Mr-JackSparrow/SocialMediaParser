package com.test.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SwipingGesture {

    public static void swipeLeft(){}

    public static void swipeRight(AppiumDriver driver){}

    public static void swipeDown(AppiumDriver driver){
    }

    public static void swipeUp(AppiumDriver driver){

        Dimension dimension = driver.manage().window().getSize();

        int x = dimension.getWidth() / 2;
        int startY = (int) (dimension.getHeight() * 0.8);
        int endY = (int) (dimension.getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), new Point(x, startY)))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), new Point(x, endY)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }
}
