package com.mbio.mbio_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsPage {
	private final WebDriver driver;

    private final By HERO_HEADING = By.xpath("//h1[contains(text(),'Why MultiBank Group')]");
    private final By HERO_STATS = By.cssSelector(".stats-section div");
    private final By LEADERSHIP_HEADING = By.xpath("//h3[contains(text(),'A tradition of global leadership')]");
    private final By LEADERSHIP_TEXT = By.xpath("//p[contains(text(),'Founded in 2005')]");
    private final By INNOVATION_HEADING = By.xpath("//h3[contains(text(),'Innovation with purpose')]");
    private final By INNOVATION_IMAGE = By.cssSelector("img[src*='smartphone']");
    private final By INTEGRITY_HEADING = By.xpath("//h3[contains(text(),'Integrity built into every decision')]");
    private final By INTEGRITY_IMAGE = By.cssSelector("img[src*='dashboard']");
    private final By STRENGTH_HEADING = By.xpath("//h3[contains(text(),'The strength behind MultiBank Group')]");
    private final By STRENGTH_CARDS = By.cssSelector(".strength-section .card");
    private final By COMMUNITY_HEADING = By.xpath("//h3[contains(text(),'Community & Media')]");
    private final By MEDIA_CARDS = By.cssSelector(".community-section .card");
    
    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHeroSectionVisible() {
        return driver.findElement(HERO_HEADING).isDisplayed();
    }

    public boolean areStatsVisible() {
        return driver.findElements(HERO_STATS).size() >= 3;
    }

    public boolean isLeadershipSectionVisible() {
        return driver.findElement(LEADERSHIP_HEADING).isDisplayed();
    }

    public boolean isInnovationSectionVisible() {
        return driver.findElement(INNOVATION_HEADING).isDisplayed();
    }

    public boolean isIntegritySectionVisible() {
        return driver.findElement(INTEGRITY_HEADING).isDisplayed();
    }

    public boolean areStrengthCardsVisible() {
        return driver.findElements(STRENGTH_CARDS).size() == 3;
    }

    public boolean areCommunityCardsVisible() {
        return driver.findElements(MEDIA_CARDS).size() >= 4;
    }

}
