package tests;

import java.io.IOException;


import org.testng.annotations.Test;

import com.ui.EbayPage;
import com.ui.ProjectSpecifics;

public class UiTestCase001 extends ProjectSpecifics {
	

	@Test
	public void testRun() throws IOException {

		EbayPage ep= new EbayPage(driver);
		ep.searchBook().selectFirstBook().switchToNewWindow().clickAddToCart();
	}

}
