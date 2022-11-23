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
}
