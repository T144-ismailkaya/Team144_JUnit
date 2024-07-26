package day07_JsAllerts_IFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_Iframe extends TestBaseEach {

    @Test
    public void test01(){

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement baslikTesti = driver.findElement(By.tagName("h3"));
        Assertions.assertTrue(baslikTesti.isEnabled());
        System.out.println(baslikTesti.getText());
         /*
            iframe tag'i bir HTML sayfa icinde inner baska bir HTML sayfasi olusturulmasina izin verir

            bir sayfada birden fazla iframe olabilecegi gibi
            ic ice katmanli iframe'ler olusturmak da mumkundur

            Sunu bilmemiz ve dikkat etmemiz gerekir
            URL ile gittigimiz sayfa ve icindeki iframe'ler birbirinden bagimsizdir
            ve aralarinda gecis yapmak icin driver.switchTo() kullanilmalidir

         */

        //	- Text Box’a “Merhaba Dunya!” yazin.
        // TextBox iframe icinde oldugundan
        // once iframe'i locate etmeli
        WebElement iframeElementi = driver.findElement(By.id("mce_0_ifr"));

        // gittigimiz url'in oldugu sayfadan
        // locate ettigimiz iframe'in oldugu sayfaya gecis yapmali
        driver.switchTo().frame(iframeElementi);

        // sonra textBox'a yazi gondermeliyiz
        WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya");

        //	- TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
        /*
            Giris yaptigimiz bir iframe'den disari cikmak icin 2 alternatifimiz var
            1- driver.switchTo().parentFrame();
            eger ic ice birden fazla katman varsa bir ust katmana cikarir
            2- driver.switchTo().defaultContent();
            kac katmanli olursa olsun, en ustteki ansayfaya gecis yapar
         */
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();


        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[@*='large-4 large-centered columns']"));
        Assertions.assertTrue(elementalSeleniumElementi.isDisplayed());
        //  	ve  yazisini konsolda yazdirin.
        System.out.println(elementalSeleniumElementi.getText());

        ReusableMethods.bekle(3);

    }

}
