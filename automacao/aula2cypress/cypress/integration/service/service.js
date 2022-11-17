const baseUrl = Cypress.env('API_BASE');
let token;

before(() => {
    cy.login().should((response) => {
        expect(response.status).to.eq(200);
        token = response.body;
    });
})
Cypress.Commands.add("login", () => {
    return cy.request({
        method: 'POST',
        url:`${baseUrl}/auth`,
        failOnStatusCode: false,
        body: {
            "login": "admin",
            "senha": "123"
        },
    }).as('response').get('@response')
})

export default class PessoaService{

    GETpessoaRequest(pag, tamPag){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/pessoa`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "pagina":`${pag}`,
                "tamanhoDasPaginas":`${tamPag}`
            }
        }).as('response').get('@response')
    }

    POSTpessoaRequest(payload){
        return cy.request({
            method: 'POST',
            url:`${baseUrl}/pessoa`,
            headers:{
                authorization: token
            },
            body: payload,
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    PUTpessoaRequest(payload, idPessoa){
        return cy.request({
            method: 'PUT',
            url:`${baseUrl}/pessoa/${idPessoa}`,
            headers:{
                authorization: token
            },
            body: payload,
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    DELETEpessoaRequest(idPessoa){
        return cy.request({
            method: 'DELETE',
            url:`${baseUrl}/pessoa/${idPessoa}`,
            headers:{
                authorization: token
            },
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    GETpessoaByNameRequest(name){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/pessoa/byname`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "nome":`${name}`
            }
        }).as('response').get('@response')
    }

    GETpessoaCpfRequest(cpf){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/pessoa/${cpf}/cpf`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            }
        }).as('response').get('@response')
    }

    GETpessoaRelatorioRequest(idPessoa){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/pessoa/relatorio`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "idPessoa":`${idPessoa}`
            }
        }).as('response').get('@response')
    }

    GETpessoaListaCompletaRequest(idPessoa){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/pessoa/lista-completa`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "idPessoa":`${idPessoa}`
            }
        }).as('response').get('@response')
    }

    GETpessoaListaEndereco(idPessoa){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/pessoa/lista-com-enderecos`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "idPessoa":`${idPessoa}`
            }
        }).as('response').get('@response')
    }

    GETpessoaListaContato(idPessoa){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/pessoa/lista-com-contatos`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "idPessoa":`${idPessoa}`
            }
        }).as('response').get('@response')
    }
}