package com.letzAutomate.qa.util;

import com.aventstack.extentreports.ExtentTest;

// Singleton class for ExtentTest object
	public class ExtentManager {
	    private static ExtentTest extentTest;

	    public static ExtentTest getExtentTest() {
	        return extentTest;
	    }

	    public static void setExtentTest(ExtentTest test) {
	        extentTest = test;
	    }
	}

