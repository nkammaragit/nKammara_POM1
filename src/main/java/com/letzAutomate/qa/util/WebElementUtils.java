package com.letzAutomate.qa.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebElementUtils {
    public static void safeSendKeys(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            // Handle NoSuchElementException
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    public static void safeClick(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            // Handle NoSuchElementException
            System.out.println("Element not found: " + e.getMessage());
        }
    }
}

