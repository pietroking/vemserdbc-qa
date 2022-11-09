package step;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

public class Util extends BaseTest{
    public static void botaoMyAccount(){
        driver.findElement(By.cssSelector("#menu-item-50 > a")).click();
    }
}
