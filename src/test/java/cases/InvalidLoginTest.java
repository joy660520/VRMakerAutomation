package cases;

import org.testng.annotations.Test;

import tasks.CreateNewLiveTour;
import tasks.InvalidLogin;

public class InvalidLoginTest extends AccountLoginTest{
	@Test
	public void runTest() throws Exception {
		
		InvalidLogin il = new InvalidLogin(driver);
		il.invalidLogin(userModel);

	}
}
