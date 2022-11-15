package br.com.aula.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    //MAPEAMENTO
    private static final By campoUsername =
            By.cssSelector("[id=\"Username\"]");
    private static final By campoSenha =
            By.cssSelector("[id=\"Password\"]");
    private static final By btnLogin =
            By.cssSelector("[name=\"login\"]");

    @Step
    public void escreverNoCompoLogin(){
        sendKeys(campoUsername, "teste123");
    }

    @Step
    public void escreverNoCompoSenha(){
        sendKeys(campoSenha, "12345");
    }

    @Step("clicando no botao")
    public void clicarNoBotaoLogin(){
        click(btnLogin);
    }


}
