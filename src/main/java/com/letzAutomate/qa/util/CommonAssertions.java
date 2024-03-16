package com.letzAutomate.qa.util;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonAssertions {

    public static void assertTextEquals(WebElement element, String expectedText) {
        Assert.assertEquals(element.getText(), expectedText);
    }

    public static void assertElementPresent(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element is not present");
    }

}

