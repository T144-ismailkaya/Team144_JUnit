package day09_action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C08_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        /*
            Bir projede kod yazdigimizda
            kod'un bulundugu her bilgisayarda calismasi gerekir

            Bunun icin dosya yolunu kisisel bilgilerden arindirmak gerekir

            Java bu tur ortak projelerde
            dosya yolunun saglikli calismasi icin
            standart 2 dosya yolu baslangici belirlemis

            1- System.getProperty("user.home") ==> bilgisayarin ana dosya yolunu verir
                                                   yani herkeste farkli olan kismi verir

            2- System.getProperty("user.dir") ==> uzerinde calistigimiz projenin ana klasorunu verir
               /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team144_JUnit
         */

        // Downloads klasorunde sample.png dosyasi bulundugunu test edin

        // String dosyaYolu = "/Users/ahmetbulutluoz/Downloads/sample.png";
        //       C:\Users\ismai\            Downloads\sample.png"
        //       C:\\Users\\User\\          Downloads\\image.png
        //       /Users/ahmetbulutluoz      /Downloads/sample.png
        //         herkeste farkli      + herkeste ayni

        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\sample.png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Projemizde day09 package'inda sample.png dosyasi bulundugunu test edin

        // String dosyaYolu2 = "src/test/java/day09_actions/sample.png";
        //String dosyaYolu2 = System.getProperty("user.dir") + "/src/test/java/day09_actions/sample.png";
        String baseDir = System.getProperty("user.dir");
        Path filePath = Paths.get(baseDir, "src", "test", "java", "day09_actions", "sample.png");

        String dosyaYolu2 = ("File Path: " + filePath.toString());
        //Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
        File file = new File(dosyaYolu2);
        if (file.exists()) {
            System.out.println("File exists: " + dosyaYolu2);
        } else {
            System.out.println("File does not exist: " + dosyaYolu2);
        }
        //  /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team144_JUnit  /src/test/java/day09_actions/sample.png
        //  C:\Users\Administrator\IdeaProjects\Team144_JUnit                       \src\test\java\day09_actions\sample.png
        //  C:\Users\User\IdeaProjects\Team144_JUnit                                \src\test\java\day09_actions\image (1).png

        System.out.println(System.getProperty("user.dir")); //C:\Users\ismai\IdeaProjects\Team144_JUnit


    }

}
