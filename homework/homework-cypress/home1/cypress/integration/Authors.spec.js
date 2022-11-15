//Suite
context('Authors', () => {

    //Cenario 1
    it('GET - Buscar todos autores', () => {
        cy.request({
            method: 'GET',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body[18].id).to.eq(19);
            expect(response.body[18].firstName).to.eq('First Name 19');
            expect(response.body[18].lastName).to.eq('Last Name 19');
            // expect(response.body[18].idBook).to.eq(7); -- idBook modifica automaticamente
        })
    });

    //Cenario 2
    it('GET - Buscar autor por ID', () => {
        cy.request({
            method: 'GET',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Authors/19',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(19);
            expect(response.body.firstName).to.eq('First Name 19');
            expect(response.body.lastName).to.eq('Last Name 19');
            // expect(response.body.idBook).to.eq(7);
        })
    });

    //Cenario 3
    it('GET - Buscar por idBook', () => {
        cy.request({
            method: 'GET',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/7',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body[length].idBook).to.eq(7);
            expect(response.body[response.body.length - 1].idBook).to.eq(7);
        })
    });

    //Cenario 4
    it('POST - Criar autor', () => {
        cy.request({
            method: 'POST',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false,
            body: {
                "id": 100,
                "idBook": 100,
                "firstName": "Autor POST test",
                "lastName": "string"
                }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(100);
            expect(response.body.firstName).to.eq('Autor POST test');
            expect(response.body.lastName).to.eq('string');
            expect(response.body.idBook).to.eq(100);
        })
    });

    //Cenario 5
    it('PUT - Atualizar autor por ID', () => {
        cy.request({
            method: 'PUT',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Authors/13',
            failOnStatusCode: false,
            body: {
                "id": 100,
                "idBook": 100,
                "firstName": "Autor POST test",
                "lastName": "string"
                }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(100);
            expect(response.body.firstName).to.eq('Autor POST test');
            expect(response.body.lastName).to.eq('string');
            expect(response.body.idBook).to.eq(100);
        })
    });

    //Cenario 6
    it('DELETE - DELETAR autor por ID', () => {
        cy.request({
            method: 'DELETE',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Authors/30',
            failOnStatusCode: false,
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })
    });
})