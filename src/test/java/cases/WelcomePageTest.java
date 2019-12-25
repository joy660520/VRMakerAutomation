package cases;

import org.testng.annotations.Test;

import tasks.CreateNewLiveTour;
import tasks.DeleteLiveTour;
import tasks.WelcomePage;

public class WelcomePageTest extends AccountLoginTest{
	@Test
	public void runTest() throws Exception {
		
		WelcomePage wp = new WelcomePage(driver);
		wp.welcomePage(userModel);

	}
}
