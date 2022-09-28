package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import Base.BrowserAction;
import Utility.UtilityClass ;


public class Verify extends BrowserAction{
	
	public String MovieDate;
	public String ImdbCountryname;
	public String wMovieCountry;
	public String wMovieDate;
	
	
	//=================================================IMDB Object Repository=================================================================
		@FindBy(xpath="//input[@type='text']") private WebElement SearchIMDB;
		@FindBy(xpath="//ul[@role='listbox']/li[1]/a[1]") private WebElement ClickSearchIMDB;
		//@FindBy(xpath="//table[@class=\"findList\"]/tbody/tr[1]/td[2]/a[1]") private WebElement ClickOnMovie;
		@FindBy(xpath="//li[@data-testid='title-details-releasedate'] //div//ul//li//a")private  WebElement releaseDate;
		@FindBy(xpath="//li[@data-testid='title-details-origin'] //div//ul/li/a") private WebElement ImdbCountry;
		
		
		
		//=======================================Wikipedia Object Repository=============================================================
		@FindBy (xpath="//input[@type=\"search\"]") private WebElement wikiSearch;
		@FindBy (xpath="//input[@value=\"Go\"]") private WebElement ClickwikiSearch;
		@FindBy(xpath="//Table[@class=\"infobox vevent\"]//tr[12]//td//div//ul//li") private WebElement wikiReleaseDate;
		@FindBy(xpath="//Table[@class=\"infobox vevent\"]//tr[14]//td") private WebElement wikiMovieCity;
		
//========================================IMDB Method====================================================================================		
		
		public Verify(WebDriver driver)

		{
			PageFactory.initElements(driver, this);
			
		}
		
		public void SearchMovieImdb() throws EncryptedDocumentException, IOException
		{
			
			SearchIMDB.sendKeys(UtilityClass.getStringTestData(0, 0));
			ClickSearchIMDB.click();
			//ClickOnMovie.click();
		}
		
		
		public  void ImdbReleaseDateAndCountry() throws IOException
		{	
			
			MovieDate =releaseDate.getText();
			System.out.println(MovieDate);
			ImdbCountryname=ImdbCountry.getText();
			System.out.println(ImdbCountryname);
			
		}
		
//======================================================Wikipedia Method======================================================================
		public void WikiSearch() throws EncryptedDocumentException, IOException
		{
			wikiSearch.sendKeys(UtilityClass.getStringTestData(0, 0));
			ClickwikiSearch.click();
		
		}
		public  void WikiReleaseDateAndCountry() throws IOException
		{	
			wMovieDate=wikiReleaseDate.getText();
			System.out.println(wMovieDate);
			wMovieCountry=wikiMovieCity.getText();
			System.out.println(wMovieCountry);
		}

		
//============================================Compare Method=====================================================================================
		
		public void validateReleaseDate() 
		{
			
			Assert.assertEquals(MovieDate, wMovieDate);
			System.out.println("IMDB Move Release Date and Wikipedia MovieDate Matched");
			
			
		}		
		public void validateCountry() 
		{
			
			Assert.assertEquals(ImdbCountryname, wMovieCountry);;
			System.out.println("IMDB country and Wikipedia country Matched");
			
			
		}
		
		
		
	}



