package day07_JsAllerts_IFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_DropdownMenu extends TestBaseEach {

    @Test
    public void zeroWebTesti(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button"))
                .click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login"))
                .sendKeys("username");
        //4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password"))
                .sendKeys("password");
        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//*[@*='Sign in']"))
                .click();
        driver.navigate().back();
        //6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu"))
                .click();
        driver.findElement(By.id("pay_bills_link"))
                .click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']"))
                .click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.id("pc_currency"));
        Select select = new Select(ddm);
        select.selectByValue("EUR");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount"))
                .sendKeys("100");
        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollarsCheckbox = driver.findElement(By.id("pc_inDollars_true"));
        Assertions.assertFalse(usDollarsCheckbox.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false"))
                .click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs"))
                .click();
        driver.findElement(By.id("purchase_cash"))
                .click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement yaziElementi = driver.findElement(By.id("alert_content"));

        String expectedYazi = "Foreign currency cash was successfully purchased.";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);
        ReusableMethods.bekle(2);
    }
}
