package day07_JsAllerts_IFrame;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C04_BasicAuthentication extends TestBaseEach {

    @Test
    public void basicAuthenticationTesti() {
    /*
            Bir url'e ulasirken
            kullanici adi ve sifreyi de url'e ekleyip
            ulasmak istedigimiz server'a giris yapabilmek icin
            Basic Authentication Kullanilabilir

            Buradaki en onemli kural :
            gidecegimiz url
            kullanici adi ve sifre
            kullanici adi ve sifreyi URL'e ekleme yontemi
            bizim bulabilecegimiz veya tahmin edebilecegimiz bir bilgi degildir
            BU bilgilerin otomasyon oncesi bize verilmis olmasi gerekir
         */

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin
        // driver.get("https://testotomasyonu.com/basicauth");

        // sadece url ile gidersek otomasyon ile kullanici adi ve sifreyi GIREMEYIZ

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        ReusableMethods.bekle(3);
    }
}
