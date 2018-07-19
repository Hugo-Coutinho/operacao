describe('primeiro teste',function(){

    Cypress.on('uncaught:exception', (err, runnable) => {
        // returning false here prevents Cypress from
        // failing the test
        return false
      })

    it('editando cadastro',function(){

        cy.visit('http://localhost:8080/operacao/login.jsp')

        cy.get('[type="text"]').type('hugo')
        cy.get('[type="password"]').type('567')
        cy.get('.btn-primary').click()

        cy.url().should('include', '/operacao/logar.htm')
        cy.get(':nth-child(2) > :nth-child(1) > a > span').click()
        cy.pause
        cy.get('#nome').type('rogerinho')
        cy.get('#email').type('roger@gmail.com')
        cy.get('#senha').type('123')
        cy.get('#cep').type('20745270')
        cy.get('#rua').type('Bernardo')
        cy.get('#bairro').type('Engenho de Dentro')
        cy.get('#cidade').type('Rio de Janeiro')
        cy.get('#uf').type('RJ')
        cy.get('[value="m"]').click()
        cy.get('form > .btn').click()

        cy.contains('sucesso')
    })


});
