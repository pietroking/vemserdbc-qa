package step;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class SubscribeTest extends Util{
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();

    String emailErrado = "963258741@a";

    @Test
    public void testSubscribeComEmailCerto(){
        driver.findElement(By.cssSelector("[name=\"EMAIL\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("[value=\"Subscribe\"]")).click();

        String result = driver.findElement(By.cssSelector("#mc4wp-form-1 > div.mc4wp-response > div > p")).getText();

        Assert.assertEquals(result, "Thank you, your sign-up request was successful! Please check your email inbox to confirm.");
    }

    @Test
    public void testSubscribeComEmailErrado(){
        driver.findElement(By.cssSelector("[name=\"EMAIL\"]")).sendKeys(emailErrado);
        driver.findElement(By.cssSelector("[value=\"Subscribe\"]")).click();

        String result = driver.findElement(By.cssSelector("#mc4wp-form-1 > div.mc4wp-response > div > p")).getText();

        Assert.assertEquals(result, "Please provide a valid email address.");
    }
}
