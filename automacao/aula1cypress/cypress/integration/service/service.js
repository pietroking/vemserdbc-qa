
const API_BASE = Cypress.env('API_BASE')
const TOKEN = Cypress.env('ACCESS_TOKEN')

export default class UserService{

    usuarioRequest(payload){
        return cy.request({
            method: 'POST',
            url:`${API_BASE}/qa/user`,
            failOnStatusCode: false,
            body: payload
        }).as('response').get('@response')
    }

    // produtoRequest(payload){
    //     return cy.request({
    //       method: 'POST',
    //       url: `${API_BASE}/qa/produto`,
    //       failOnStatusCode: false,
    //       body: payload,
    //       headers: {
    //         authorization: TOKEN
    //       }
    //     }).as('response').get('@response')
    //   }
}