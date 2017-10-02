# JSF-PRIMEFACES-JPA-MAVEN
 ## Adres Defteri Uygulaması

 Projenin kodlanmasında  JSF, JPA, MAVEN ve PRIMEFACES kullandım.Primefaces kullanmamdaki sebeb ise hazır arayüz şablonları ile hız kazanmaktı.
 IDE olarak Netbeans kullandım.
 Uygulama sunucusu olarak Glassfish kullandım. Yaptığım araştırmalar sonucunda JEE7 ile uygulama geliştirirken en mantıklı sunucunun Glassfish olduğunu gördüm.
 Veritabanı konusunda Mysql kullandım. Netbeans'te Services kısmında bulunan DATABASE kısmından yeni database oluşturdum ve ardından tablolarımı yazdığım query ile oluşturdum.
 

## Kurulum
Uygulamayı kurmak için yapılması gerekenler şöyle;

1-Netbeans yüklenmelidir.

2-Glassfish kurulumu yapılmalı.

3-Mysql bilgisayarınızda kurulu olmalıdır.

4-Aşağıdaki kodlarla bir database oluşturun.

CREATE DATABASE adresdefteri;
use adresdefteri;

CREATE TABLE kisi (
    kisi_id int(11) NOT NULL AUTO_INCREMENT,
    ad varchar(15) NOT NULL,
    soyad varchar(15) NOT NULL,
    adres varchar(50) NOT NULL,
    email varchar(40) NOT NULL,
    PRIMARY KEY (kisi_id)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=UTF8;

CREATE TABLE telefon(
    tel_id int(11) NOT NULL AUTO_INCREMENT,
    kisi_id int(11) NOT NULL,
    telno varchar(15) NOT NULL,
    PRIMARY KEY (tel_id),
    CONSTRAINT tel_fk_1 FOREIGN KEY (kisi_id) REFERENCES kisi (kisi_id)
)ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=UTF8;
 
 
5-Projeyi IDE'den açtıktan sonra "Other Source" nin altındaki "persitent.xml" klasörüni silin ve projenin üstüne tıklayıp NEW->Persistence Unit kısmından yeniden oluşturun clean and build edin.

6-Glassfish sunucusunu başlatın ve ardından projeyi çalıştırın.

 


 
