package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

	public void doThis() {
		System.out.println("This is from parent class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This wil run Before method***");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This wil run After method***");
	}
}
