package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.List;

public class C06_DropdownMenu extends TestBaseEach {

    /*
    ● https://testotomasyonu.com/form adresine gidin.
      1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
      2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
      3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
      4. Secilen değerleri konsolda yazdirin
      5. Ay dropdown menüdeki tum değerleri(value) yazdırın
      6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
     */

    @Test
    public void dropdownTesti() {

        //https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        WebElement gunElementi = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        WebElement ayElementi = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        WebElement yilElementi = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

        Select selectGun = new Select(gunElementi);
        Select selectAy = new Select(ayElementi);
        Select selectYil = new Select(yilElementi);

        //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        selectGun.selectByIndex(18);

        //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        selectAy.selectByValue("mart");

        //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        selectYil.selectByVisibleText("2008");

        //4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        //5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayDdmTumSecenekler =  selectAy.getOptions();
        System.out.println(ReusableMethods.getStringList(ayDdmTumSecenekler));

        //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedListSize = 13;
        int actualListSize = ayDdmTumSecenekler.size();

        Assertions.assertEquals(expectedListSize,actualListSize);
        ReusableMethods.bekle(3);

    }

}
