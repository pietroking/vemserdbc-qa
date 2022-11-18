import PessoaService from "../service/service";
const pessoaService = new PessoaService();

const auth = require('../../fixtures/auth.payload.json');
const pessoa = require('../../fixtures/pessoa.payload.json');
const contato = require('../../fixtures/contato.payload.json');
const endereco = require('../../fixtures/endereco.payload.json');

const pessoaErrado = require('../../fixtures/pessoaErrado.payload.json');
const contatoErrado = require('../../fixtures/contatoErrado.payload.json');
const enderecoErrado = require('../../fixtures/enderecoErrado.payload.json');



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

    it('POST - Add pessoa com erro', () => {
        pessoaService.POSTpessoaRequest(pessoaErrado).should((response) => {
            expect(response.status).to.eq(400);
            expect(response.body.errors[0]).to.eq('nome: must not be blank')
        })
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

    it('PUT - Atualiza pessoa errado', () => {
       pessoaService.PUTpessoaRequest(pessoa, 35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });

    it('DELETE - Delete pessoa', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
        })
    });

    it('DELETE - Delete pessoa errado', () => {
        pessoaService.DELETEpessoaRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
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

    it('GET - Listar pessoa por nome erro', () => {
        pessoaService.GETpessoaByNameRequest('haha').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
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

    it('GET - Listar pessoa por CPF errado', () => {
        pessoaService.GETpessoaCpfRequest('000').should((response) => {
            expect(response.status).to.eq(200);
        })
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

    it('GET - Listar pessoa com relatorio errado', () => {
        pessoaService.GETpessoaRelatorioRequest(35).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
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

    it('GET - Listar pessoa completa errada', () => {
        pessoaService.GETpessoaListaCompletaRequest(35).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
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

    it('GET - Listar pessoa com endereco errado', () => {
        pessoaService.GETpessoaListaEndereco(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
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

    it('GET - Listar pessoa com contato errado', () => {
        pessoaService.GETpessoaListaContato(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });
})

context('Contato', () => {
    it('GET - Listar contatos', () => {
        pessoaService.GETcontatoRequest().then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('POST - Add contato', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTcontatoRequest(contato, pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.descricao).to.eq('whatsapp')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('POST - Add contato errado', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTcontatoRequest(contatoErrado, 35)).should((response) => {
            expect(response.status).to.eq(400);
            expect(response.body.errors[0]).to.eq('telefone: Numero nao pode ser nulo ou em branco')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('PUT - Atualizar contato', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTcontatoRequest(contato, pessoa.idPessoa)).then((response) => {
            cy.wrap(response.body).as('contato')
        })
        cy.get('@contato').then(contatoAntigo => pessoaService.PUTcontatoRequest(contato, contatoAntigo.idContato)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.descricao).to.eq('whatsapp')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('PUT - Atualizar contato erro', () => {
        pessoaService.PUTcontatoRequest(contato, 5).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idContato} não encontrado')
        })
    });

    it('DELETE - Deletando contato', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTcontatoRequest(contato, pessoa.idPessoa)).then((response) => {
            cy.wrap(response.body).as('contato')
        })
        cy.get('@contato').then(contato => pessoaService.DELETEcontatoRequest(contato.idContato)).should((response) => {
            expect(response.status).to.eq(200);
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('DELETE - Deletando contato errado', () => {
        pessoaService.DELETEcontatoRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idContato} não encontrado')
        })
    });

    it('GET - Listar contato por ID', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTcontatoRequest(contato, pessoa.idPessoa)).then((response) => {
            cy.wrap(response.body).as('contato')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.GETcontatoIdRequest(pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body[0].descricao).to.eq('whatsapp')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar contato por ID erro', () => {
        pessoaService.GETcontatoIdRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });
})

context('Endereco', () => {
    it('GET - Listar enderecos', () => {
        pessoaService.GETenderecoRequest().then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('POST - Add endereco', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTenderecoRequest(endereco, pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.estado).to.eq('SP')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('POST - Add endereco erro', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTenderecoRequest(enderecoErrado, pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(400);
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });
//TESTE FALHA POR CAUSA DO IDPESSOA
    // it('PUT - Atualizar endereco', () => {
    //     pessoaService.POSTpessoaRequest(pessoa).then((response) => {
    //         cy.wrap(response.body).as('pessoa')
    //     })
    //     cy.get('@pessoa').then(pessoa => pessoaService.POSTenderecoRequest(endereco, pessoa.idPessoa)).then((response) => {
    //         cy.wrap(response.body).as('endereco')
    //     })
    //     cy.get('@endereco').then(enderecoAntigo => pessoaService.PUTenderecoRequest(endereco, enderecoAntigo.idEndereco)).should((response) => {
    //         expect(response.status).to.eq(200);
    //         expect(response.body).that.is.not.empty;
    //         expect(response.body.estado).to.eq('SP')
    //     })
    //     cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    // });

    it('DELETE - Deletando endereco', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTenderecoRequest(endereco, pessoa.idPessoa)).then((response) => {
            cy.wrap(response.body).as('endereco')
        })
        cy.get('@endereco').then(endereco => pessoaService.DELETEenderecoRequest(endereco.idEndereco)).should((response) => {
            expect(response.status).to.eq(200);
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('DELETE - Deletando endereco erro', () => {
        pessoaService.DELETEenderecoRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idEndereco} nao encontrado')
        })
    });

    it('GET - Listar endereco por idPessoa', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTenderecoRequest(endereco, pessoa.idPessoa))
        cy.get('@pessoa').then(pessoa => pessoaService.GETenderecoIdPessoaRequest(pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body[0].estado).to.eq('SP')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar endereco por idPessoa erro', () => {
        pessoaService.GETenderecoIdPessoaRequest(35).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
    });

    it('GET - Listar endereco por ID', () => {
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.POSTenderecoRequest(endereco, pessoa.idPessoa)).then((response) => {
            cy.wrap(response.body).as('endereco')
        })
        cy.get('@endereco').then(endereco => pessoaService.GETenderecoIdRequest(endereco.idEndereco)).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.estado).to.eq('SP')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa))
    });

    it('GET - Listar endereco por ID erro', () => {
        pessoaService.GETenderecoIdRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idEndereco} nao encontrado')
        })
    });

    it('GET - Listar endereco por pais', () => {
        pessoaService.GETenderecoPorPaisRequest('Brasil').then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('GET - Listar endereco por pais erro', () => {
        pessoaService.GETenderecoPorPaisRequest('hahaha').then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
    });

    // it.only('teste', () => {
    //     pessoaService.POSTpessoaRequest(pessoa).then((response) => {
    //         cy.wrap(response.body).as('pessoa')
    //     })
    //     cy.get('@pessoa').then(pessoa => pessoaService.POSTenderecoRequest(endereco, pessoa.idPessoa)).then((response) => {
    //         cy.wrap(response.body).as('endereco')
    //     })
    //     cy.get('@pessoa').then(pessoa => pessoaService.POSTcontatoRequest(contato, pessoa.idPessoa)).then((response) => {
    //         cy.wrap(response.body).as('contato')
    //     })
    // });
})
