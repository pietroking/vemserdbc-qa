/// <reference types="cypress" />

import LoginPage from "../pages/LoginBase"
const loginPage = new LoginPage;

Given("que preencho o username valido", ()=>{
    loginPage.preencherUsername();
  });
  
And("que preencho a senha valida", ()=>{
    loginPage.preencherSenha();
  });
  
When("clico em login", ()=>{
    loginPage.clicarNoBtnLogin();
  });
  
Given("que preencho o username invalido", ()=>{
    loginPage.preencherUsernameErro();
  });
  
And("que preencho a senha invalida", ()=>{
    loginPage.preencherSenhaErro();
  });
  
Then("devo visualizar uma mensagem de erro", ()=>{
    loginPage.validarMsgErro();
})

