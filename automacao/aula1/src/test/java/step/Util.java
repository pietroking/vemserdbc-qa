package step;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

public class Util extends BaseTest{
    public static void login(){
        driver.findElement(By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("[id=\"Username\"]")).sendKeys("teste123");
        driver.findElement(By.cssSelector("[id=\"Password\"]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }

    public static void botaoCreateNew(){
        driver.findElement(By.cssSelector("body > div > div > p:nth-child(4) > a")).click();
    }

    public static void botaoEdit(){
        driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary")).click();
    }

    public static void botaoDetails(){
        driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-info")).click();
    }

    public static void botaoDelete(){
        driver.findElement(By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger")).click();
    }

    public static void search(String key) throws InterruptedException {
        driver.findElement(By.cssSelector("[name=\"searching\"]")).sendKeys(key);
        driver.findElement(By.cssSelector("[value=\"Search\"]")).click();
        Thread.sleep(1000);
    }

    public static void create(String nome,String company,String address,String city,String phone,String email){
        driver.findElement(By.cssSelector("[id=\"Name\"]")).sendKeys(nome);
        driver.findElement(By.cssSelector("[id=\"Company\"]")).sendKeys(company);
        driver.findElement(By.cssSelector("[id=\"Address\"]")).sendKeys(address);
        driver.findElement(By.cssSelector("[id=\"City\"]")).sendKeys(city);
        driver.findElement(By.cssSelector("[id=\"Phone\"]")).sendKeys(phone);
        driver.findElement(By.cssSelector("[id=\"Email\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("[value=\"Create\"]")).click();
    }


    public static void delete(){
        botaoDelete();
        driver.findElement(By.cssSelector("[value=\"Delete\"]")).click();
    }

}
