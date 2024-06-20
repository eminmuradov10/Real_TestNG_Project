package Real_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class First_Real_Program {

	WebDriver driver;

	// For each test(there are 2 tests in total), it will call BeforeMethod and
	// AfterMethod
	// BeforeMethod->test1-AfterMethod,BeforeMethod->test2-AfterMethod

	// Since test are under Class, BeforeClass and AfterClass will run only once and
	// 2 tests will run during the process

	@Parameters({ "url", "key" })
	@BeforeClass
	public void setUp(String myurl, String mykey)

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\eminm\\Desktop\\My_Files\\Programming_Exercises\\Selenium_Example_Projects\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(myurl);

		System.out.println(mykey);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

	}

	@Test
	public void verifyTitle()

	{

		String actualTitle = driver.getTitle();

		String expectedTitle = "Amazon.com. Spend less. Smile more.";

		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void verifyLogo()

	{

		boolean flag = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();

		// Assert.assertTrue(flag);

		// Deliberately failing the test

		Assert.assertTrue(false);

	}

	@Test
	public void AdmissionBrokenlinks()

	{

		System.out.println("Admission Broken links"); // Deliberately causing skip

		throw new SkipException("msg");

	}

	int var = 1;
	
	
	// This test case will be called twice, but only 1 will succeed
	@Test(successPercentage = 50, invocationCount = 2)
	public void Counter()

	{

		System.out.println("Counter");// code for testcase

		if (var == 1)

		{

			var++;

			Assert.assertTrue(false);

		}

		else

		{

			Assert.assertTrue(true);

		}

	}

	@AfterClass
	public void tearDown()

	{
		try {
			Thread.sleep(5000); // Adding a 1-second buffer time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();

	}

	@DataProvider(name = "mydata1")
	public Object[][] getData()

	{

		Object[][] data = new Object[3][2];

		data[0][0] = "user1";

		data[0][1] = "password1";

		data[1][0] = "user2";

		data[1][1] = "password2";

		data[2][0] = "user3";

		data[2][1] = "password3";

		return data;

	}

	@Test(dataProvider = "mydata1", dataProviderClass = Program_2.class) // It will look for mydata1 inside Program_2
																			// java class
	public void AdmissionLogin(int user, int password)

	{

		System.out.println("Admission Login");// code for testcase

		System.out.println(user);

		System.out.println(password);

	}

	@Test(dataProvider = "mydata1") // It will look for mydata1 inside this java class
	public void AdmissionLogin(String user, String password)

	{

		System.out.println("Admission Login");// code for testcase

		System.out.println(user);

		System.out.println(password);

	}

}
