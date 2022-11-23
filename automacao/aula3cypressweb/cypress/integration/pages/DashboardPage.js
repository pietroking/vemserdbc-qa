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
let voltarBtn = "body > div > p > a.btn.btn-link"
let erroSearch = "body > div > div > table > tbody > tr:nth-child(2) > td"


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

    buscarUser(){
        basePage.preencherInput(searchBar, emailFake)
        basePage.click(searchBtn)
    }

    buscarUserError(){
        basePage.preencherInput(searchBar, emailFake)
        basePage.click(searchBtn)
        basePage.validarText(erroSearch, "No Match")
    }

    editarUser(){
        basePage.click(editBtn)
        basePage.limparCampo(company)
        basePage.preencherInput(company, "DBC COMPANY")
        basePage.click(saveBtn)
    }

    detailsUser(){
        basePage.click(detailsBtn)
        basePage.click(voltarBtn)
    }

    deleteUser(){
        basePage.click(deleteBtn)
        basePage.click(confirmDeleteBtn)
    }
}