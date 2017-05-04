package com.Cat.Appium_Cat.tests;

import org.junit.Assert;
import org.testng.annotations.Test;



public class TestSample extends TestBase{
	@Test
	public void sampletest(){
		driver.findElementById("enter_name").sendKeys("RAM");
		driver.hideKeyboard();
		driver.findElementById("button").click();
		String actual_message =driver.findElementById("greeting").getText();
		String expected_message ="Meow, RAM";
		Assert.assertEquals(actual_message, expected_message);
		
	}
	
//	@Test
//	public void sampleFailTest(){
//		driver.findElementById("enter_name").sendKeys("RAM");
//		driver.hideKeyboard();
//		driver.findElementById("button").click();
//		String actual_message =driver.findElementById("greeting").getText();
//		String expected_message ="Meow, ST";
//		Assert.assertEquals(actual_message, expected_message);
//		
//	}

}
