package com.letzAutomate.qa.util;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class CommonAssertions {
    private static final SoftAssert softAssert = new SoftAssert();

    public static void assertTextEquals(WebElement element, String expectedText) {
        softAssert.assertEquals(element.getText(), expectedText);
    }

    public static void assertElementPresent(WebElement element) {
        softAssert.assertTrue(element.isDisplayed(), "Element is not present");
    }

    public static void softAssertTextEquals(WebElement element, String expectedText) {
        assertTextEquals(element, expectedText);
    }

    public static void softAssertElementPresent(WebElement element, String expectedText) {
        assertElementPresent(element);
    }

    public static void softAssertAll() {
        softAssert.assertAll();
    }
}
