package cases;

import org.testng.annotations.Test;

import tasks.CreateNewLiveTour;
import tasks.DeleteLiveTour;

public class DeleteLiveTourTest extends AccountLoginTest{
	@Test
	public void runTest() throws Exception {
		
		DeleteLiveTour dt = new DeleteLiveTour(driver);
		dt.deleteLiveTour(userModel);

	}
}
