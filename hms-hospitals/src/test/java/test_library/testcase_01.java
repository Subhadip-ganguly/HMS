package test_library;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_library.Excel;
import generic_library.launch;
import pom_library.Login_pom;

public class testcase_01 extends launch
{
	@DataProvider(name="xyz")
	String[][] fdata() throws Exception
	{
		String un=Excel.fetch(1, 0);
		String pass=Excel.fetch(1, 1);
		String[][] arr = {{un,pass}};
		return arr;
	}
	
	@Test(dataProvider = "xyz")
	void tc(String un,String pwd) throws Exception
	{
		
		String exp=Excel.fetch(1, 2);
		Login_pom p=new Login_pom(driver);
		p.setEmail(un);
		p.setPass(pwd);
		p.clickLogin();
		Thread.sleep(2000);
		String act=driver.getTitle();
		
		assertEquals(act, exp);
	}
	
}
