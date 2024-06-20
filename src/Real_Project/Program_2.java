package Real_Project;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Program_2 {

	@DataProvider(name = "mydata1")
	public Object[][] getData1()

	{

		Object[][] data = new Object[3][2];

		data[0][0] = 1;

		data[0][1] = 2;

		data[1][0] = 3;

		data[1][1] = 4;

		data[2][0] = 5;

		data[2][1] = 6;

		return data;
	}

	@Test

	public void AdmissionLogin()

	{
		// Soft Assertion will ensure the run of all statements regardless of the outcomes from assert
		SoftAssert a = new SoftAssert();

		System.out.println("Admission Login1");

		// Assert.assertTrue(false);

		a.assertTrue(false);

		System.out.println("Admission Login2");

		// Assert.assertTrue(false);

		a.assertTrue(false);

		System.out.println("Admission Login3");

		// Assert.assertTrue(false);

		a.assertTrue(false);

		System.out.println("Admission Login4");

		a.assertAll();

	}

}
