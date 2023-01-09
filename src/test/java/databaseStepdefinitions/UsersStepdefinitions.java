package databaseStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;

public class UsersStepdefinitions {

    /*
    Bir database'e baglanmak ve o database'deki tablolarda islem yapabilmek icin
    oncelikle sistem yonetici ile gorusup gerekli bilgileri almalisiniz
    Domain ve IP : sql748.main-hosting.eu ya da 82.180.174.52
    Port : 3306
    Veritabanı : u480337000_jdbc_data
    Kullanıcı Adı : u480337000_jdbc_user
    Parola : 4Ob8Y]DJU/f
    Tablo : users
    Users Tablosu Alanlar : id,first_name,last_name,email,gender,birth_date,ip_address,
                       is_customer,customer_number,status
    database turu : mySql
    1- İlk adim olarak database turune uygun JDBC dependency'sini pom'a eklemelisiniz
    2- database turune uygun olarak Url, username ve password hazirlayin
    3- database baglantisi, query calistirma ve donen sonucu kaydetmek icin variable'lar olusturun
    4- Artik test adimlarina uygun ilerleyebilirsiniz

     */

    String url="jdbc:mysql://sql748.main-hosting.eu:3306/u480337000_jdbc_data";
    String username="u480337000_jdbc_user";
    String password="4Ob8Y]DJU/f";

    Connection connection; //database'e baglantimizi saglayacak
    Statement statement; // database'de istedigimiz query'leri calistirmamizi saglar
    ResultSet resultSet; // Statement ile yapilan sorgu sonucunu store etmek icin kullanilir

    @Given("Kullanici JDBC ile database'e baglanir")
    public void kullanici_jdbc_ile_database_e_baglanir() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Then("users tablosundaki isim verilerini alir")
    public void users_tablosundaki_isim_verilerini_alir() throws SQLException {
        // connection ilk adimda kuruldu
        // query'leri caşistiracagımız statement objesi de ilk adimda olusturulur
        // simdi once String olarak sorguyu hazırlayip
        // sonra statement objesini kullanarak query'i calistiracagız
        // ve donen sonucu resultSet objesine store edecegiz

        String query="SELECT isim FROM users";
        resultSet=statement.executeQuery(query);

    }
    @Then("isim verilerini test eder")
    public void isim_verilerini_test_eder() throws SQLException {
        // Ilk iki adimda gerekli java sql objelerini olusturduk
        // connectiın ile baglantiyi sagladik
        // statement'a connection uzerinden sorgu yapma ozelliklerini yukledik
        // statement objesini kullanarak istedigimiz databse sorgusunu calistirip
        // sonuclari resultSet objesine store ettik
        // yani su anda elimizde 1000 adet isim barindiran bir resultSet objesi var
        // bu objeyi kullanarak istadigimiz isim bilgilerine ulasilabilir
        // ve istenen testleri yapabiliriz


        // ilk ismi yazdiralim
        // resultSet iterator ile calisir

        resultSet.first();
        System.out.println(resultSet.getString("first_name"));// Laraine

        // ikinci ve 3. isimleri yazdiralim
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        // 11. satirdaki ismin trever oldugunu test edelim
        resultSet.absolute(11);
        String actual11nciIsim=resultSet.getString("first_name");
        String expected11nciIsim="Trever";

        Assert.assertEquals(expected11nciIsim,actual11nciIsim);

        // son ismin Jaine oldugunu test edin
        resultSet.last();
        String actualsoniIsim=resultSet.getString("first_name");
        String expectedsoniIsim="Jaine";

        Assert.assertEquals(expectedsoniIsim,actualsoniIsim);

        // tum isim listesini yazdirin
        System.out.println("--------");

        resultSet.absolute(0);
        int siraNo=1;
        while (resultSet.next()){
            System.out.println(siraNo +"-" + resultSet.getString("first_name"));

            siraNo++;

        }


    }


    @Then("id si {int} olan kisinin {string} degerinin {string} oldugunu test eder")
    public void idSiOlanKisininDegerininOldugunuTestEder(int id, String last_name, String verilenDeger) throws SQLException {
        // id'si 14 olan user'ın "last_name" degerini getir
        //SELECT last_name FROM Users WHERE id=14 bu dinamik değil
        //String query="SELECT last_name FROM users";

        String query="SELECT "+last_name+" FROM users WHERE id="+id;

        resultSet=statement.executeQuery(query);
        resultSet.first();

        String actualSoyisim= resultSet.getString("last_name");

        Assert.assertEquals(actualSoyisim,verilenDeger);

    }

    @Then("id degeri {int} olan kisinin {string} degerini {string} yapar")
    public void idDegeriOlanKisininDegeriniYapar(int id, String fieldName, String istenenDeger) {

        String query="UPDATE users SET "+fieldName+"='"+istenenDeger+"' WHERE id="+id;

        try {
            statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("yapılan sorgu ResultSet döndürmüyor");
        }

    }
}
