package br.com.aula.pages;

import br.com.aula.utils.Elements;
import org.openqa.selenium.By;

public class BasePage extends Elements {

    public static void click(By by){
        waitElement(by);
        element(by).click();
    }

    public static void sendKeys(By by, String texto){
        waitElement(by);
        element(by).sendKeys(texto);
    }

    public static String getText(By by){
        waitElement(by);
        return element(by).getText();
    }
}
