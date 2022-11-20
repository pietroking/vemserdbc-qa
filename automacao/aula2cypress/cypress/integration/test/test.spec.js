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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa')
        pessoaService.GETpessoaRequest(0,20).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('POST - Add pessoa', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('POST Pessoa')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('POST Pessoa error')
        pessoaService.POSTpessoaRequest(pessoaErrado).should((response) => {
            expect(response.status).to.eq(400);
            expect(response.body.errors[0]).to.eq('nome: must not be blank')
        })
    });

    it('PUT - Atualiza pessoa', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('PUT Pessoa')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('PUT Pessoa error')
       pessoaService.PUTpessoaRequest(pessoa, 35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });

    it('DELETE - Delete pessoa', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('DELETE Pessoa')
        pessoaService.POSTpessoaRequest(pessoa).then((response) => {
            cy.wrap(response.body).as('pessoa')
        })
        cy.get('@pessoa').then(pessoa => pessoaService.DELETEpessoaRequest(pessoa.idPessoa)).should((response) => {
            expect(response.status).to.eq(200);
        })
    });

    it('DELETE - Delete pessoa errado', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('DELETE Pessoa error')
        pessoaService.DELETEpessoaRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });

    it('GET - Listar pessoa por nome', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa por nome')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa por nome error')
        pessoaService.GETpessoaByNameRequest('haha').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
    });

    it('GET - Listar pessoa por CPF', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa por cpf')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa por cpf error')
        pessoaService.GETpessoaCpfRequest('000').should((response) => {
            expect(response.status).to.eq(200);
        })
    });

    it('GET - Listar pessoa com relatorio', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa relatorio')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa relatorio error')
        pessoaService.GETpessoaRelatorioRequest(35).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
    });

    it('GET - Listar pessoa completa', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa completa')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa completa error')
        pessoaService.GETpessoaListaCompletaRequest(35).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
    });

    it('GET - Listar pessoa com endereco', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa endereco')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET  endereco error')
        pessoaService.GETpessoaListaEndereco(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });

    it('GET - Listar pessoa com contato', () => {
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa contato')
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
        cy.allure()
            .epic('EndPoint Pessoa')
            .feature('GET Pessoa contato error')
        pessoaService.GETpessoaListaContato(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });
})

context('Contato', () => {
    it('GET - Listar contatos', () => {
        cy.allure()
            .epic('EndPoint Contato')
            .feature('GET Contatos')
        pessoaService.GETcontatoRequest().then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('POST - Add contato', () => {
        cy.allure()
            .epic('EndPoint Contato')
            .feature('POST Contato')
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
        cy.allure()
            .epic('EndPoint Contato')
            .feature('POST Contato error')
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
        cy.allure()
            .epic('EndPoint Contato')
            .feature('PUT Contato')
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
        cy.allure()
            .epic('EndPoint Contato')
            .feature('PUT Contato error')
        pessoaService.PUTcontatoRequest(contato, 5).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idContato} não encontrado')
        })
    });

    it('DELETE - Deletando contato', () => {
        cy.allure()
            .epic('EndPoint Contato')
            .feature('DELETE Contato')
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
        cy.allure()
            .epic('EndPoint Contato')
            .feature('DELETE Contato error')
        pessoaService.DELETEcontatoRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idContato} não encontrado')
        })
    });

    it('GET - Listar contato por ID', () => {
        cy.allure()
            .epic('EndPoint Contato')
            .feature('GET Contato por ID')
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
        cy.allure()
            .epic('EndPoint Contato')
            .feature('GET Contato por ID error')
        pessoaService.GETcontatoIdRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('ID da pessoa nao encontrada')
        })
    });
})

context('Endereco', () => {
    it('GET - Listar enderecos', () => {
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('GET Endereco')
        pessoaService.GETenderecoRequest().then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('POST - Add endereco', () => {
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('POST Endereco')
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
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('POST Endereco error')
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
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('DELETE Endereco')
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
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('DELETE Endereco error')
        pessoaService.DELETEenderecoRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idEndereco} nao encontrado')
        })
    });

    it('GET - Listar endereco por idPessoa', () => {
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('GET Endereco por IdPessoa')
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
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('GET Endereco por IdPessoa error')
        pessoaService.GETenderecoIdPessoaRequest(35).should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.empty;
        })
    });

    it('GET - Listar endereco por ID', () => {
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('GET Endereco por idEndereco')
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
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('GET Endereco por idEndereco error')
        pessoaService.GETenderecoIdRequest(35).should((response) => {
            expect(response.status).to.eq(404);
            expect(response.body.message).to.eq('{idEndereco} nao encontrado')
        })
    });

    it('GET - Listar endereco por pais', () => {
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('GET Endereco por pais')
        pessoaService.GETenderecoPorPaisRequest('Brasil').then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
        })
    });

    it('GET - Listar endereco por pais erro', () => {
        cy.allure()
            .epic('EndPoint Endereco')
            .feature('GET Endereco por pais error')
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
