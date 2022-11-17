import PessoaService from "../service/service";
const pessoaService = new PessoaService();

const auth = require('../../fixtures/auth.payload.json');
const pessoa = require('../../fixtures/pessoa.payload.json');

context('Pessoa', () => {
    it('GET - Listar pessoas', () => {
        pessoaService.GETpessoaRequest(0,20).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('POST - Add pessoa', () => {
        pessoaService.POSTpessoaRequest(pessoa).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.nome).to.eq('Jaci Golpista')
        }).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('PUT - Atualiza pessoa', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoaCriada => pessoaService.PUTpessoaRequest(pessoa, pessoaCriada.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.nome).to.eq('Jaci Golpista')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('DELETE - Delete pessoa', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
        })
    });

    it('GET - Listar pessoa por nome', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoaCriada => pessoaService.GETpessoaByNameRequest(pessoaCriada.nome)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar pessoa por CPF', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoaCriada => pessoaService.GETpessoaCpfRequest(pessoaCriada.cpf)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar pessoa com relatorio', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoaCriada => pessoaService.GETpessoaRelatorioRequest(pessoaCriada.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar pessoa completa', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoaCriada => pessoaService.GETpessoaListaCompletaRequest(pessoaCriada.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar pessoa com endereco', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoaCriada => pessoaService.GETpessoaListaEndereco(pessoaCriada.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar pessoa com contato', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoaCriada => pessoaService.GETpessoaListaContato(pessoaCriada.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });
})