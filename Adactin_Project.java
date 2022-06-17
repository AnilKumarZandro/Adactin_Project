package com.Adactin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Baseclass.Base_Class;
import com.pageobjectmanager.PageObjectManager;
import com.reader.FileReaderManager;

public class Adactin_Project extends Base_Class {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		driver = BrowserLaunch("Firefox");
		
		getURL(FileReaderManager.getInstanceFR().getInstanceCR().LaunchUrl());
		
//		getURL("https://adactinhotelapp.com/");

		PageObjectManager pom = new PageObjectManager(driver);

		sendKeys(pom.getLogin().getUsername(), "ZandroAnil");
		sendKeys(pom.getLogin().getPassword(), "T9WC50");
		ClickonElement(pom.getLogin().getLoginBtn());
		
		dropdown(pom.getSearchhotel().getLocation(), "ByIndex", "1");
		dropdown(pom.getSearchhotel().getHotels(), "ByValue", "Hotel Hervey");
		dropdown(pom.getSearchhotel().getRoom_type(), "ByVisibleText", "Super Deluxe");
		dropdown(pom.getSearchhotel().getRoom_nos(), "Byindex", "2");
		sendKeys(pom.getSearchhotel().getDatepick_in(), "18/05/2022");
		sendKeys(pom.getSearchhotel().getDatepick_out(), "19/05/2022");
		dropdown(pom.getSearchhotel().getAdult_room(), "ByValue", "2");
		dropdown(pom.getSearchhotel().getChild_room(), "ByValue", "2");
		ClickonElement(pom.getSearchhotel().getSubmit());

		ClickonElement(pom.getSelecthotel().getRadiobutton_0());
		ClickonElement(pom.getSelecthotel().getContinueBtn());

		sendKeys(pom.getBookhotel().getFirst_name(), "Anil");
		sendKeys(pom.getBookhotel().getLast_name(), "Kumar");
		sendKeys(pom.getBookhotel().getAddress(), "123 Main St");
		sendKeys(pom.getBookhotel().getCc_num(), "1111111111111111");
		dropdown(pom.getBookhotel().getCc_type(), "byIndex", "2");
		dropdown(pom.getBookhotel().getCc_exp_month(), "byValue", "12");
		dropdown(pom.getBookhotel().getCc_exp_year(), "ByVisibleText", "2022");
		sendKeys(pom.getBookhotel().getCc_cvv(), "1234");
		ClickonElement(pom.getBookhotel().getBook_now());

		ImplicitWait(30);

		ClickonElement(pom.getConfirmBook().getMy_itinerary());

		ClickonElement(pom.getLastscreen().getCheck_all());
		ClickonElement(pom.getLastscreen().getCancelall());

		Alert("alert", "accept");
		
		close();

	}

}
