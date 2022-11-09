package step;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends Util{
    String email = "pietroteste@teste.com";
    String senha = "pietro123456789!";
    String senhaErrada = "123456789";

    @Test
    public void deveLogarCorretamente() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys(senha);
        driver.findElement(By.cssSelector("[value=\"Login\"]")).click();

        String[] user = email.split("@", 2);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"woocommerce-MyAccount-content\"]")));
        String result = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > div > p:nth-child(1)")).getText();

        Assert.assertTrue(result.contains(user[0]));
    }

    @Test
    public void deveLogarComSenhaIncorreta() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("[id=\"password\"]")).sendKeys(senhaErrada);
        driver.findElement(By.cssSelector("[value=\"Login\"]")).click();

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")));
        String result = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText();

        Assert.assertEquals(result, "Error: the password you entered for the username pietroteste@teste.com is incorrect. Lost your password?");
    }

    @Test
    public void deveLogarComSenhaNaoPreenchida() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[id=\"username\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("[value=\"Login\"]")).click();

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")));
        String result = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText();

        Assert.assertEquals(result, "Error: Password is required.");
    }

    @Test
    public void deveLogarComUserNaoPreenchido() throws InterruptedException {
        botaoMyAccount();
        driver.findElement(By.cssSelector("[value=\"Login\"]")).click();

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")));
        String result = driver.findElement(By.cssSelector("#page-36 > div > div.woocommerce > ul > li")).getText();

        Assert.assertEquals(result, "Error: Username is required.");
    }
}
