//Suite
context('Activities', () => {

    //Cenario 1
    it('GET - Buscar todas atividades', () => {
        cy.request({
            method: 'GET',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Activities',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body[9].id).to.eq(10);
            expect(response.body[9].title).to.eq('Activity 10');
            expect(response.body[9].completed).to.eq(true);
        })
    });

    //Cenario 2
    it('GET - Buscar atividade por ID', () => {
        cy.request({
            method: 'GET',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Activities/10',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(10);
            expect(response.body.title).to.eq('Activity 10');
            expect(response.body.completed).to.eq(true);
        })
    });

    //Cenario 3
    it('POST - Criar atividade', () => {
        cy.request({
            method: 'POST',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Activities',
            failOnStatusCode: false,
            body: {
                    "id": 100,
                    "title": "Atividade POST Test",
                    "dueDate": "2022-11-15T17:51:37.803Z",
                    "completed": true
                }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(100);
            expect(response.body.title).to.eq('Atividade POST Test');
            expect(response.body.completed).to.eq(true);
        })
    });

    //Cenario 4
    it('PUT - Atualizar atividade por ID', () => {
        cy.request({
            method: 'PUT',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Activities/100',
            failOnStatusCode: false,
            body: {
                    "id": 100,
                    "title": "Atividade PUT Test",
                    "dueDate": "2022-11-15T17:51:37.803Z",
                    "completed": false
                }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(100);
            expect(response.body.title).to.eq('Atividade PUT Test');
            expect(response.body.completed).to.eq(false);
        })
    });
    
    //Cenario 5
    it('DELETE - DELETAR atividade por ID', () => {
        cy.request({
            method: 'DELETE',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Activities/0',
            failOnStatusCode: false,
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })
    });
})