package test;		
	
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyCommonListener.class)
public class TestCases {
	
	@Test
	public void FailedTest()
	{
		System.out.println("Test Logic is Preformed Here");
		Assert.assertTrue(false);
	} 

}		
