package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import property.PropertyReaders;

import java.lang.reflect.Type;
import java.util.List;

public class Bewerbung extends BaseSteps{
    @When("geht zum HomePage")
    public void gehtZumHomePage() {
    driver.get(PropertyReaders.read().get("url"));
    sleep(1000);
    }

    @Given("nach unten zur Schaltfläche Offene Stellen")
    public void nachUntenZurSchaltflächeOffeneStellen() {
        WebElement cookies = driver.findElement(By.xpath(PropertyReaders.read().get("cookies")));
        wait.until(ExpectedConditions.visibilityOf(cookies));
        click(cookies);
       scrollBy(300);
       sleep(1000);

    }

    @And("klick auf der Link")
    public void klickAufDerLink() {
        sleep(1000);
        scrollBy(200);
        WebElement offeneStelle = driver.findElement(By.xpath(PropertyReaders.read().get("offeneStellen")));
        click(offeneStelle);
        sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(PropertyReaders.read().get("suchtfeld")))));
    }
    List<WebElement> suchtErgebnissList = driver.findElements(By.id(PropertyReaders.read().get("suchtErgebnissList")));
    @Then("schreibt auf der Suchfeld {string}")
    public void schreibtAufDerSuchfeld(String text) {
        int sizeVor = suchtErgebnissList.size();
        driver.findElement(By.id(PropertyReaders.read().get("suchtfeld"))).sendKeys(text,Keys.ENTER);
        suchtErgebnissList = driver.findElements(By.id(PropertyReaders.read().get("suchtErgebnissList")));
        int sizeNach = suchtErgebnissList.size();
        Assert.assertNotEquals(sizeVor,sizeNach);
    }

    @And("klick auf die Stelle Software Tester")
    public void klickAufDieStelleSoftwareTester() {
        click(suchtErgebnissList.get(0));
        WebElement stelleAngebot = driver.findElement(By.xpath(PropertyReaders.read().get("StelleAngebot")));
        wait.until(ExpectedConditions.visibilityOf(stelleAngebot));
    }

    @And("geht nach unten zu den Links für die Bewerbung")
    public void gehtNachUntenZuDenLinksFürDieBewerbung() {
        WebElement bewerbunglinks = driver.findElement(By.xpath(PropertyReaders.read().get("Bewerbunglinks")));
        scrollBy(400);
        wait.until(ExpectedConditions.visibilityOf(bewerbunglinks));

    }

    @Then("klick auf die Links zur Bewerbung")
    public void klickAufDieLinksZurBewerbung() {
        WebElement bewerbunglinks = driver.findElement(By.xpath(PropertyReaders.read().get("Bewerbunglinks")));
        click(bewerbunglinks);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(PropertyReaders.read().get("lebenslauf_hochladen")))));
    }

    @And("alle Daten werden ausgefüllt")
    public void alleDatenWerdenAusgefüllt() {
        scrollBy(600);
        click(By.xpath(PropertyReaders.read().get("senden_links")));
        sleep(1000);
        WebElement anrede = driver.findElement(By.id(PropertyReaders.read().get("anrede")));
        Select select = new Select(anrede);
        select.selectByValue("GENDER_MALE");
        sendKeys(By.id(PropertyReaders.read().get("vorname")),"Engin");
        sendKeys(By.id(PropertyReaders.read().get("nachname")),"Hereser");
        sendKeys(By.id(PropertyReaders.read().get("strasse")),"Gerhart Hauptmann Str");
        sendKeys(By.id(PropertyReaders.read().get("plz")),"65549");
        sendKeys(By.id(PropertyReaders.read().get("geburtsdatum")),"17.12.1985");
        sendKeys(By.id(PropertyReaders.read().get("telefon")),"01795124419");
        sendKeys(By.id(PropertyReaders.read().get("mail")),"enginhereser@gmail");
        anrede = driver.findElement(By.id(PropertyReaders.read().get("wie_gefunden")));
        select = new Select(anrede);
        select.selectByVisibleText("XING");
        sleep(1000);

    }
}
