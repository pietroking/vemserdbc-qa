import Activities from '../../service/fakeRestApi.service'
const activities = new Activities

context('Contrato Pessoas', () => {
    it('Contrato - Validar contrato GET pessoas', () => {
        activities.GETPessoacontratoRequest("activities.contratos")
    });

    it('Contrato - Validar contrato GET relatorio', () => {
        activities.GETRelatoriocontratoRequest("relatorio.contrato")
    });

    it('Contrato - Validar contrato GET by name', () => {
        activities.GETByNamecontratoRequest("byName.contrato")
    });

    it('Contrato - Validar contrato GET pessoa contato', () => {
        activities.GETListaContatocontratoRequest("pessoaContato.contrato")
    });

    it('Contrato - Validar contrato GET pessoa endereco', () => {
        activities.GETListaEnderecocontratoRequest("pessoaEndereco.contrato")
    });

    it('Contrato - Validar contrato GET pessoa completa', () => {
        activities.GETListaCompletacontratoRequest("pessoaCompleta.contrato")
    });
})

context('Contrato Contrato', () => {
    it('Contrato - Validar contrato GET contato', () => {
        activities.GETContatocontratoRequest("contato.contrato")
    });

    it('Contrato - Validar contrato GET contato por id', () => {
        activities.GETContatoIdcontratoRequest("contato.contrato")
    });
})

context('Contrato Endereco', () => {
    it('Contrato - Validar contrato GET endereco', () => {
        activities.GETEnderecocontratoRequest("endereco.contrato")
    });

    it('Contrato - Validar contrato GET endereco por idEndereco', () => {
        activities.GETEnderecoIdEnderecocontratoRequest("enderecoIdEndereco.contrato")
    });

    it('Contrato - Validar contrato GET endereco por idPessoa', () => {
        activities.GETEnderecoIdPessoacontratoRequest("enderecoPorId.contrato")
    });

    it('Contrato - Validar contrato GET endereco por pais', () => {
        activities.GETEnderecoPaiscontratoRequest("enderecoPorPais.contrato")
    });
})