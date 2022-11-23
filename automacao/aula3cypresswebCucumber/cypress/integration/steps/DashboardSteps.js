/// <reference types="cypress" />

import DashboardPage from "../pages/DashboardPage"
const dashboardPage = new DashboardPage;

import LoginPage from "../pages/LoginBase"
const loginPage = new LoginPage;

Given("que estou logado no sistema", ()=>{
    loginPage.loginNoSistema();
});

And("clico no botao criar novo usuarios", ()=>{
    dashboardPage.clicarNoBtnCreateUser();
});

And("preencho os campos", ()=>{
    dashboardPage.preencherCampos();
});

When("clico em criar", ()=>{
    dashboardPage.clicarNoBtnCreate();
});
  
Then("devo ser redirecionado para o dashboard", ()=>{
    dashboardPage.pegarUrl();
});
  
And("consigo pesquisar o usuario criado", ()=>{
    dashboardPage.buscarUser();
});

And("clico no botao editar usuario", ()=>{
    dashboardPage.clicarNoBtnEditUser();
});

And("modifico os campos", ()=>{
    dashboardPage.modificarCampos();
});

When("clico em salvar", ()=>{
    dashboardPage.clicarNoBtnSalvar();
});

And("clico no botao delete usuario", ()=>{
    dashboardPage.clicarNoBtnDelete();
});

When("clico em delete", ()=>{
    dashboardPage.deleteUser();
});

And("clico no botao voltar para dashboard", ()=>{
    dashboardPage.clicarNoBtnVoltar();
});

When("clico em detalhes", ()=>{
    dashboardPage.detailsUser();
});
