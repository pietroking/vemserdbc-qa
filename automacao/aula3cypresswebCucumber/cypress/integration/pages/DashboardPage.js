import BasePage from "./BasePage";
const basePage = new BasePage();

import {faker} from "@faker-js/faker"

let username = "#Username"
let password = "#Password"
let createUserBtn = "body > div > div > p:nth-child(4) > a"
let searchBtn = "body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0"
let searchBar = "#searching"
let editBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary"
let detailsBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-info"
let deleteBtn = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger"
let createBtn = "body > div > form > div > div:nth-child(9) > div > input"
let msgmLogin = ".alert-danger"
let name = "#Name"
let company = "#Company"
let address = "#Address"
let city = "#City"
let phone = "#Phone"
let email = "#Email"
let saveBtn = "body > div > form > div > div:nth-child(10) > div > input"
let confirmDeleteBtn = "body > div > div > form > div > input"
let nomeUser = "body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1)"
let voltarBtn = "body > div > p > a.btn.btn-link"


const nameFake = "Jaci Golpista"
const companyFake = "DBC"
const addressFake = "Rua do Golpe"
const cityFake = "Golpistinha"
const phoneFake = "99999999"
const emailFake = "jaci.golpista@dbccompany.com.br"

export default class DashboardPage extends BasePage {

    criarUser(){
        basePage.click(createUserBtn)
        basePage.preencherInput(name, nameFake)
        basePage.preencherInput(company, companyFake)
        basePage.preencherInput(address, addressFake)
        basePage.preencherInput(city, cityFake)
        basePage.preencherInput(phone, phoneFake)
        basePage.preencherInput(email, emailFake)
        basePage.click(createBtn)
    }

    clicarNoBtnCreateUser(){
        basePage.click(createUserBtn)
    }

    preencherCampos(){
        basePage.preencherInput(name, nameFake)
        basePage.preencherInput(company, companyFake)
        basePage.preencherInput(address, addressFake)
        basePage.preencherInput(city, cityFake)
        basePage.preencherInput(phone, phoneFake)
        basePage.preencherInput(email, emailFake)
    }

    clicarNoBtnCreate(){
        basePage.click(createBtn)
    }

    buscarUser(){
        basePage.preencherInput(searchBar, emailFake)
        basePage.click(searchBtn)
    }

    editarUser(){
        basePage.click(editBtn)
        basePage.limparCampo(company)
        basePage.preencherInput(company, "DBC COMPANY")
        basePage.click(saveBtn)
    }

    clicarNoBtnEditUser(){
        basePage.click(editBtn)
    }

    modificarCampos(){
        basePage.limparCampo(company)
        basePage.preencherInput(company, "DBC COMPANY")
    }

    clicarNoBtnSalvar(){
        basePage.click(saveBtn)
    }

    detailsUser(){
        basePage.click(detailsBtn)
    }

    clicarNoBtnDelete(){
        basePage.click(deleteBtn)
    }

    clicarNoBtnVoltar(){
        basePage.click(voltarBtn)
    }

    deleteUser(){
        basePage.click(confirmDeleteBtn)
    }

    pegarUrl(){
        cy.url()
        .should('be.equal', 'https://itera-qa.azurewebsites.net/Dashboard');
    }
}