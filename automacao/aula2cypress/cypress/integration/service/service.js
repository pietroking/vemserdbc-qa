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
//PESSOA
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

//CONTATO
    GETcontatoRequest(){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/contato`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            }
        }).as('response').get('@response')
    }

    GETcontatoIdRequest(idPessoa){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/contato/${idPessoa}`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            }
        }).as('response').get('@response')
    }

    POSTcontatoRequest(payload, idPessoa){
        return cy.request({
            method: 'POST',
            url:`${baseUrl}/contato/${idPessoa}`,
            headers:{
                authorization: token
            },
            body: payload,
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    PUTcontatoRequest(payload, idContato){
        return cy.request({
            method: 'PUT',
            url:`${baseUrl}/contato/${idContato}`,
            headers:{
                authorization: token
            },
            body: payload,
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    DELETEcontatoRequest(idContato){
        return cy.request({
            method: 'DELETE',
            url:`${baseUrl}/contato/${idContato}`,
            headers:{
                authorization: token
            },
            failOnStatusCode: false
        }).as('response').get('@response')
    }

//ENDERECO
    GETenderecoRequest(){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/endereco`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            }
        }).as('response').get('@response')
    }

    POSTenderecoRequest(payload, idPessoa){
        return cy.request({
            method: 'POST',
            url:`${baseUrl}/endereco/${idPessoa}`,
            headers:{
                authorization: token
            },
            qs: {
                "idPessoa":`${idPessoa}`
            },
            body: payload,
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    PUTenderecoRequest(payload, idEndereco){
        return cy.request({
            method: 'PUT',
            url:`${baseUrl}/endereco/${idEndereco}`,
            headers:{
                authorization: token
            },
            body: payload,
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    DELETEenderecoRequest(idEndereco){
        return cy.request({
            method: 'DELETE',
            url:`${baseUrl}/endereco/${idEndereco}`,
            headers:{
                authorization: token
            },
            failOnStatusCode: false
        }).as('response').get('@response')
    }

    GETenderecoIdRequest(idEndereco){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/endereco/${idEndereco}`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            }
        }).as('response').get('@response')
    }

    GETenderecoIdPessoaRequest(idPessoa){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/endereco/retorna-por-id-pessoa`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "idPessoa":`${idPessoa}`
            }
        }).as('response').get('@response')
    }

    GETenderecoPorPaisRequest(pais){
        return cy.request({
            method: 'GET',
            url:`${baseUrl}/endereco/retorna-por-pais`,
            failOnStatusCode: false,
            headers:{
                authorization: token
            },
            qs: {
                "País":`${pais}`
            }
        }).as('response').get('@response')
    }
}

