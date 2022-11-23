import BasePage from "./BasePage";
const basePage = new BasePage();

let username = "#Username"
let password = "#Password"
let loginBtn = "body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input.btn.btn-primary"
let msgmLogin = ".alert-danger"

export default class LoginPage extends BasePage {

    loginNoSistema(){
        basePage.preencherInput(username, "teste123")
        basePage.preencherInput(password, "12345")
        basePage.click(loginBtn)

    }

    loginNoSistemaComSenhaErrada(){
        basePage.preencherInput(username, "teste123")
        basePage.preencherInput(password, "123456789")
        basePage.click(loginBtn)
        basePage.validarText(msgmLogin, "Wrong username or password")
    }

    preencherUsername(){
        basePage.preencherInput(username, "teste123")
    }

    preencherSenha(){
        basePage.preencherInput(password, "12345")
    }

    clicarNoBtnLogin(){
        basePage.click(loginBtn)
    }

    preencherUsernameErro(){
        basePage.preencherInput(username, "teste")
    }

    preencherSenhaErro(){
        basePage.preencherInput(password, "123456789")
    }

    validarMsgErro(){
        basePage.validarText(msgmLogin, "Wrong username or password")
    }
}
