/// <reference types="cypress" />

import LoginPage from "../pages/LoginBase"
const loginPage = new LoginPage;

context('Login', () => {
    it('Validar login com sucesso', () => {
        loginPage.loginNoSistema();
    });

    it('Validar login com erro', () => {
        loginPage.loginNoSistemaComSenhaErrada();
    });
})