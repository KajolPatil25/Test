package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;



import Base.BrowserAction;
import POM.Verify;


public class VerifyTest extends BrowserAction  {
	
	@Test (priority=1)
	public void browserIniImdb()
	{
		intializeBrowserIMDB();
		Reporter.log("IMDB Website open successfully");
	}

	
	@Test (priority=2)
	public void IMDB() throws EncryptedDocumentException, IOException
	{
		Verify v = new Verify(driver);
		v.SearchMovieImdb();
		v.ImdbReleaseDateAndCountry();	
		Reporter.log("IMDB Website searched movie read data from excel successfully done");
		Reporter.log("ReleaseDate and Country Text Obtained successfully from website ");
	}
	
	@Test (priority=3)
	public void browserIniWiki()
	{
		intializeBrowserWikipedia();
		Reporter.log("Wkipedia Website Open Successfully");
	}
	
	@Test (priority=4)
	public void Wiki() throws EncryptedDocumentException, IOException
	{
		Verify v = new Verify(driver);
		v.WikiSearch();
		v.WikiReleaseDateAndCountry();
		Reporter.log("Wkipedia Searched Movie read data from excel Successfully done");
		Reporter.log("Wkipedia Text for Movie release date and Country Obtained Successfully from website");
		
	}
	
	@Test (priority=5)
	public void verifyReleaseDate()

	{
		Verify v = new Verify(driver);
		v.validateReleaseDate() ;
		Reporter.log("IMDB Movie Release Date and Wikipedia Movie Date Matched");
		
	}
	
	@Test 
	public void verifyMovieCountry()
	{	Verify v = new Verify(driver);
		v.validateCountry();
		Reporter.log("MDB country and Wikipedia country name Matched");
	}
	
	@Test(priority=7)
	public void browserClose()
	{
		driver.quit();
		Reporter.log("browser close successfully");
	}
	

}
