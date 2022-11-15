//Suite
context('Books', () => {

    //Cenario 1
    it('GET - Buscar todos livros', () => {
        cy.request({
            method: 'GET',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Books',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body[9].id).to.eq(10);
            expect(response.body[9].title).to.eq('Book 10');
            expect(response.body[9].description).to.eq('Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n');
            expect(response.body[9].pageCount).to.eq(1000);
            expect(response.body[9].excerpt).to.eq('Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n');
        })
    });

    //Cenario 2
    it('GET - Buscar livro por ID', () => {
        cy.request({
            method: 'GET',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Books/10',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(10);
            expect(response.body.title).to.eq('Book 10');
            expect(response.body.excerpt).to.eq('Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n');
            expect(response.body.description).to.eq('Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n');
            expect(response.body.pageCount).to.eq(1000);
        })
    });

    //Cenario 3
    it('POST - Criar livro', () => {
        cy.request({
            method: 'POST',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Books',
            failOnStatusCode: false,
            body: {
                "id": 100,
                "title": "Book POST Test",
                "description": "string",
                "pageCount": 0,
                "excerpt": "string",
                "publishDate": "2022-11-15T19:46:00.031Z"
                }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(100);
            expect(response.body.title).to.eq('Book POST Test');
            expect(response.body.excerpt).to.eq('string');
            expect(response.body.description).to.eq('string');
            expect(response.body.pageCount).to.eq(0);
        })
    });

    //Cenario 4
    it('PUT - Atualizar livro por ID', () => {
        cy.request({
            method: 'PUT',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Books/30',
            failOnStatusCode: false,
            body: {
                "id": 100,
                "title": "Book PUT Test",
                "description": "string",
                "pageCount": 0,
                "excerpt": "string",
                "publishDate": "2022-11-15T19:48:13.911Z"
                }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).that.is.not.empty;
            expect(response.body.id).to.eq(100);
            expect(response.body.title).to.eq('Book PUT Test');
            expect(response.body.excerpt).to.eq('string');
            expect(response.body.description).to.eq('string');
            expect(response.body.pageCount).to.eq(0);
        })
    });
    
    //Cenario 5
    it('DELETE - DELETAR livro por ID', () => {
        cy.request({
            method: 'DELETE',
            url:'https://fakerestapi.azurewebsites.net/api/v1/Books/30',
            failOnStatusCode: false,
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })
    });
})