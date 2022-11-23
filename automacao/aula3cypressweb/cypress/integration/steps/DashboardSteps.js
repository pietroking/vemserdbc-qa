/// <reference types="cypress" />

import DashboardPage from "../pages/DashboardPage"
const dashboardPage = new DashboardPage;

import LoginPage from "../pages/LoginBase"
const loginPage = new LoginPage;

beforeEach(() => {
    loginPage.loginNoSistema();
})

context('CRUD', () => {
    it('Validar criar user com sucesso', () => {
        dashboardPage.criarUser();
    });

    it('Validar buscar user', () => {
        dashboardPage.buscarUser();
    });

    it('Validar editar user', () => {
        dashboardPage.buscarUser();
        dashboardPage.editarUser();
    });

    it('Validar detalhes user', () => {
        dashboardPage.buscarUser();
        dashboardPage.detailsUser();
    });

    it('Validar delete user', () => {
        dashboardPage.buscarUser();
        dashboardPage.deleteUser();
        dashboardPage.buscarUser();
    });

    it('Validar buscar user inexistente', () => {
        dashboardPage.buscarUserError();
    });
})