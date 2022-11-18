import PessoaService from "./service";
const pessoaService = new PessoaService();

const baseUrl = Cypress.env('API_BASE');
const TOKEN = Cypress.env('ACCESS_TOKEN')
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
import Ajv from "ajv";
const ajv = new Ajv({allErrors:true, Verbose:true});

export default class Contrato{

    // contratoRequest(contrato){
    //     cy.request({
    //         method: 'GET',
    //         url:`${baseUrl}/pessoa`,
    //         headers:{
    //             authorization: token
    //         },
    //         failOnStatusCode: false
    //     }).then((response) => {
    //         //pegar o arquivo (schema) pasta fixtures e passar como paramentro
    //         cy.fixture(contrato).then((contrato) => {
    //             //compilar esse arquivo, (jsonSchema)
    //             const validate = ajv.compile(contrato)

    //             //response da api(validacao)
    //             const responseApi = validate(response.body)

    //             //Validacao (Error)
    //             if(!responseApi) cy.log(validate.errors).then(() => {
    //                 throw new Error('Falha no contrato')
    //             })
    //         })
    //     })
    // }
//PESSOA
    GETPessoacontratoRequest(contrato){
        pessoaService.GETpessoaRequest(0, 20).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETRelatoriocontratoRequest(contrato){
        pessoaService.GETpessoaRelatorioRequest(4799).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETByNamecontratoRequest(contrato){
        pessoaService.GETpessoaByNameRequest("Jaci").then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETListaContatocontratoRequest(contrato){
        pessoaService.GETpessoaListaContato(4799).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETListaEnderecocontratoRequest(contrato){
        pessoaService.GETpessoaListaEndereco(4799).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETListaCompletacontratoRequest(contrato){
        pessoaService.GETpessoaListaCompletaRequest(4799).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }
//CONTATO
    GETContatocontratoRequest(contrato){
        pessoaService.GETcontatoRequest().then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETContatoIdcontratoRequest(contrato){
        pessoaService.GETcontatoIdRequest(4799).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }
//ENDERECO
    GETEnderecocontratoRequest(contrato){
        pessoaService.GETenderecoRequest().then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETEnderecoIdEnderecocontratoRequest(contrato){
        pessoaService.GETenderecoIdRequest(854).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETEnderecoIdPessoacontratoRequest(contrato){
        pessoaService.GETenderecoIdPessoaRequest(4799).then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }

    GETEnderecoPaiscontratoRequest(contrato){
        pessoaService.GETenderecoPorPaisRequest('Brasil').then((response) => {
            //pegar o arquivo (schema) pasta fixtures e passar como paramentro
            cy.fixture(contrato).then((contrato) => {
                //compilar esse arquivo, (jsonSchema)
                const validate = ajv.compile(contrato)

                //response da api(validacao)
                const responseApi = validate(response.body)

                //Validacao (Error)
                if(!responseApi) cy.log(validate.errors).then(() => {
                    throw new Error('Falha no contrato')
                })
            })
        })
    }
}