package br.com.automacaoComBatista.pages;

import org.openqa.selenium.By;

public class UserPage extends BasePage{

    private static final By textValidateUser =
            By.cssSelector("#notice");

    public String validarTextLogadoNaTela(){
        return getText(textValidateUser);
    }

    public String idUser(){
        return driver.getCurrentUrl().substring(48);
    }

}
