import Activities from '../../service/fakeRestApi.service'
const activities = new Activities

// const allure = Cypress.Allure.reporter.getInterface();
// allure.epic('Validar contratos');

// allure.feature("Contrato Pessoa");
context('Contrato Pessoas', () => {

    it('Contrato - Validar contrato GET pessoas', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Pessoas')
        activities.GETPessoacontratoRequest("activities.contratos")
    });


    it('Contrato - Validar contrato GET relatorio', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Pessoa Relatorio')
        activities.GETRelatoriocontratoRequest("relatorio.contrato")
    });


    it('Contrato - Validar contrato GET by name', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Pessoa By Name')
        activities.GETByNamecontratoRequest("byName.contrato")
    });


    it('Contrato - Validar contrato GET pessoa contato', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Pessoa Contato')
        activities.GETListaContatocontratoRequest("pessoaContato.contrato")
    });


    it('Contrato - Validar contrato GET pessoa endereco', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Pessoa Enderece')
        activities.GETListaEnderecocontratoRequest("pessoaEndereco.contrato")
    });


    it('Contrato - Validar contrato GET pessoa completa', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Pessoa Completa')
        activities.GETListaCompletacontratoRequest("pessoaCompleta.contrato")
    });
})

context('Contrato Contato', () => {

    it('Contrato - Validar contrato GET contato', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Contatos')
        activities.GETContatocontratoRequest("contato.contrato")
    });


    it('Contrato - Validar contrato GET contato por id', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Contato por IdPessoa')
        activities.GETContatoIdcontratoRequest("contato.contrato")
    });
})


context('Contrato Endereco', () => {

    it('Contrato - Validar contrato GET endereco', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Enderecos')
        activities.GETEnderecocontratoRequest("endereco.contrato")
    });


    it('Contrato - Validar contrato GET endereco por idEndereco', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Endereco por IdEnderesso')
        activities.GETEnderecoIdEnderecocontratoRequest("enderecoIdEndereco.contrato")
    });


    it('Contrato - Validar contrato GET endereco por idPessoa', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Endereco por IdPessoa')
        activities.GETEnderecoIdPessoacontratoRequest("enderecoPorId.contrato")
    });


    it('Contrato - Validar contrato GET endereco por pais', () => {
        cy.allure()
            .epic('Contratos')
            .feature('GET Endereco por pais')
        activities.GETEnderecoPaiscontratoRequest("enderecoPorPais.contrato")
    });
})