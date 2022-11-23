Feature: Dashboard

 Scenario: Validar create com sucesso
    Given que estou logado no sistema
    And clico no botao criar novo usuarios
    And preencho os campos
    When clico em criar
    Then devo ser redirecionado para o dashboard
    And consigo pesquisar o usuario criado

 Scenario: Validar edit com sucesso
    Given que estou logado no sistema
    And consigo pesquisar o usuario criado
    And clico no botao editar usuario
    And modifico os campos
    When clico em salvar
    Then devo ser redirecionado para o dashboard
    And consigo pesquisar o usuario criado

 Scenario: Validar detalhes com sucesso
    Given que estou logado no sistema
    And consigo pesquisar o usuario criado
    When clico em detalhes
    And clico no botao voltar para dashboard
    Then devo ser redirecionado para o dashboard
    And consigo pesquisar o usuario criado

 Scenario: Validar delete com sucesso
    Given que estou logado no sistema
    And consigo pesquisar o usuario criado
    And clico no botao delete usuario
    When clico em delete
    Then devo ser redirecionado para o dashboard
    And consigo pesquisar o usuario criado