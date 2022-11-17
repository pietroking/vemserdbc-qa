import UserService from "../service/service";
const userService = new UserService();

const userPayload = require('../../fixtures/addUser.payload.json')
const produtoPayload = require('../../fixtures/addProduto.payload.json')

context('User', () => {
    it('POST - Adicionae um novo usuario', () => {
        userService.usuarioRequest(userPayload).should((response) => {
            expect(response.status).to.equal(200);
        })        
    });  
})

// context('Produto', () => {
//     it('POST - Adicionar um novo produto', () => {
//       userService.usuarioRequest(produtoPayload).should((response) =>{
//             expect(response.status).to.eq(200)
//         })
//     });
// });