#language:pt

  @test
  Funcionalidade: Login

    Contexto: O usuário deve logar sistema apos preencher o login e senha validos

      @wip
      Cenario: Validar login com sucesso preenchendo email e senha validos
        Dado que acesso a tela de login
        E que preencho o username valido
        E que preencho a senha valida
        Quando clico em Login
        Entao devo vizualizar uma mensagem de boas vindas