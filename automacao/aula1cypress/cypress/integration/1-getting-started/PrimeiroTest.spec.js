//Suite
context('User', () => {

    //Cenario
    it('GET - Buscar todos os Usuarios', () => {

        cy.request({
            method: 'GET',
            url: 'https://jsonplaceholder.typicode.com/todos/1',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.userId).to.eq(1);
            expect(response.body.id).to.eq(1);
            expect(response.body.title).to.eq("delectus aut autem");
        })
    })

    it('POST - Adicionar um novo usuarios', () => {
        
        cy.request({
            method: 'POST',
            url: 'https://jsonplaceholder.typicode.com/posts',
            failOnStatusCode: false,
            body: {
                "userId": 1,
                "id": 1,
                "title": "teste",
                "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
              }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(201);
            expect(response.body.userId).to.eq(1);
            expect(response.body.id).to.eq(101);
            expect(response.body.title).to.eq("teste");
        })
    });
})