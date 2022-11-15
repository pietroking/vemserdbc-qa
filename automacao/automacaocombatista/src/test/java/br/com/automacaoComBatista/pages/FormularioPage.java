package br.com.automacaoComBatista.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormularioPage extends BasePage{

    //MAPEAMENTO NOVO USUARIO

    private static final By btnFormulario =
            By.cssSelector("body > div.row > div.col.s3 > ul > li:nth-child(1) > a");
    private static final By btnCriarUsuario =
            By.cssSelector("body > div.row > div.col.s3 > ul > li.bold.active > div > ul > li:nth-child(1) > a");

    private static final By campoName =
            By.cssSelector("[name=\"user[name]\"]");
    private static final By campoLastname =
            By.cssSelector("[name=\"user[lastname]\"]");
    private static final By campoEmail =
            By.cssSelector("[name=\"user[email]\"]");
    private static final By btnCriar =
            By.cssSelector("[value=\"Criar\"]");

    public void escreverNoCompoNome(){
        sendKeys(campoName, "AAAAAAaaaaateste1");
    }

    public void escreverNoCompoUltimoNome(){
        sendKeys(campoLastname, "teste1");
    }

    public void escreverNoCompoEmail(){
        sendKeys(campoEmail, "teste@teste.com");
    }

    public void clicarNoBotaoCriar(){
        click(btnCriar);
    }
    public void clicarNoBotaoFormulario(){
        click(btnFormulario);
    }
    public void clicarNoBotaoCriarUsuario(){
        click(btnCriarUsuario);
    }


    //MAPEAMENTO LISTA USUARIOS

    private static final By btnListaUsuarios =
            By.cssSelector("body > div.row > div.col.s3 > ul > li.bold.active > div > ul > li:nth-child(2) > a");
    private static final By btnDelete =
            By.cssSelector("body > div.row > div > table > tbody > tr:nth-child(1) > td:nth-child(11) > a");
    private static final By btnEdit =
            By.cssSelector("body > div.row > div > table > tbody > tr:nth-child(1) > td:nth-child(10) > a");
    private static final By btnVoltar =
            By.cssSelector("body > div.row > div.col.s9 > div:nth-child(3) > div > a.btn.waves-light.red");

    public void clicarAlert(){
        Alert alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clicarNoBotaoListaUsuarios(){
        click(btnListaUsuarios);
    }

    public void clicarNoBotaoDelete(){
        click(btnDelete);
    }

    public void clicarNoBotaoVoltar(){
        click(btnVoltar);
    }
}
