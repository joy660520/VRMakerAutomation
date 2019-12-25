package cases;

import org.testng.annotations.Test;

import tasks.CreateNewLiveTour;
import tasks.ImportPhotosFromGallery;

public class ImportPhotosFromGalleryTest extends AccountLoginTest {
	@Test
	public void runTest() throws Exception {

		ImportPhotosFromGallery ip = new ImportPhotosFromGallery(driver);
		ip.importPhotosFromGallery(userModel);

	}
}
