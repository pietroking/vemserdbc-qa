package step;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterTest extends Util{
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String senha = faker.internet().password(13,20,true,true,true);
    String senhaVeryWeak = "12";
    String senhaWeak = "1234567891";
    String senhaMedium = "123456789!a@s#d";

    @Test
    public void deveRegistrarContaCorretamente() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("[id=\"reg_password\"]")).sendKeys(senha);
        driver.findElement(By.cssSelector("[value=\"Register\"]")).click();
        String[] user = email.split("@", 2);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"woocommerce-MyAccount-content\"]")));
        String result = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > div > p:nth-child(1)")).getText();

        Assert.assertTrue(result.contains(user[0]));
    }

    @Test
    public void deveRegistrarContaSemPreencher(){
        botaoMyAccount();
        driver.findElement(By.cssSelector("[value=\"Register\"]")).click();
        String result = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText();

        Assert.assertEquals(result, "Error: Please provide a valid email address.");
    }

    @Test
    public void deveRegistrarContaSenhaMuitoFraca() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"reg_password\"]")).sendKeys(senhaVeryWeak);
        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys(email);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"woocommerce-password-strength short\"]")));
        String result = driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > div")).getText();
        Assert.assertEquals(result, "Very weak - Please enter a stronger password.");
    }

    @Test
    public void deveRegistrarContaSenhaFraca() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"reg_password\"]")).sendKeys(senhaWeak);
        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys(email);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"woocommerce-password-strength bad\"]")));
        String result = driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > div")).getText();
        Assert.assertEquals(result, "Weak - Please enter a stronger password.");
    }

    @Test
    public void deveRegistrarContaSenhaMedia() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"reg_password\"]")).sendKeys(senhaMedium);
        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys(email);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"woocommerce-password-strength good\"]")));
        String result = driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > div")).getText();
        Assert.assertEquals(result, "Medium");
    }
    @Test
    public void deveRegistrarContaSenhaForte() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"reg_password\"]")).sendKeys(senha);
        driver.findElement(By.cssSelector("[id=\"reg_email\"]")).sendKeys(email);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"woocommerce-password-strength strong\"]")));
        String result = driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > div")).getText();
        Assert.assertEquals(result, "Strong");
    }
}
