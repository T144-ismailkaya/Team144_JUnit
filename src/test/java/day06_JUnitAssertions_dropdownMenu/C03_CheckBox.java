package day06_JUnitAssertions_dropdownMenu;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_CheckBox {
    /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    a. Verilen web sayfasına gidin. https://testotomasyonu.com/form
    b. Sirt Agrisi ve Carpinti checkbox’larini secin
    c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
     */

    static WebDriver driver;

    @BeforeEach
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testotomasyonu.com/form");
    }

    @AfterEach
    public void teardown(){driver.quit();}

    @Test
    public void checkboxTesti (){
        //b. Sirt Agrisi ve Carpinti checkbox’larini secin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement carpintiCheckbox =driver.findElement(By.xpath("//input[@id='gridCheck4']"));
        WebElement sirtagrisiCheckbox = driver.findElement(By.xpath("//input[@id='gridCheck5']"));

        carpintiCheckbox.click();
        sirtagrisiCheckbox.click();

        //c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assertions.assertTrue(sirtagrisiCheckbox.isSelected());
        Assertions.assertTrue(carpintiCheckbox.isSelected());

        //d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerChechbox = driver.findElement(By.xpath("//input[@id='hastalikCheck2']"));
        WebElement epilepsiChechbox = driver.findElement(By.xpath("//input[@id='hastalikCheck7']"));

        Assertions.assertFalse(sekerChechbox.isSelected());
        Assertions.assertFalse(epilepsiChechbox.isSelected());

    }

}
