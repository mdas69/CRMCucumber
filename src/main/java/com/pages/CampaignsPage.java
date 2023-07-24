package com.pages;

import org.openqa.selenium.By;

import com.factory.CRMApp;

public class CampaignsPage {

	public CRMApp CRM;
	
	public CampaignsPage(CRMApp crmapp) {
		this.CRM = crmapp;
	}
	
	private By campaignsLocator = By.cssSelector("a[href*=campaign]");
	private By newSMSCampaignLocator = By.cssSelector("input[value *= SMS]");
	private By logoutLocator = By.cssSelector("a[href *=logout]");
	private By frameLocator = By.cssSelector("frame[name=mainpanel]");
	
	public void doClickOnCampaignsMenu() {
		CRM.eleUtil.frameSwitch(frameLocator);
		CRM.eleUtil.doClickButton(campaignsLocator);
		
	}
	
	public boolean doCheckNewSMSCampaign() {
		return CRM.eleUtil.elementIsDisplayed(newSMSCampaignLocator);
		
	}
	
	public void doLogoutFromApplication() {
		CRM.eleUtil.doClickButton(logoutLocator);
	}
	
	
}
