#Language : en

Feature: Connexion
  Login test in saucelab

  Scenario Outline: Cas passant de connexion
    Given je vais sur la page d'accueil "https://www.saucedemo.com/"
    And j'entre un unsename "<username>"
    And j'entre un mot de passe "<mot de passe>"
    When je clique sur le bouton login
    Then la page des articles est affichée "<titre>"
    Examples:
      | username      | mot de passe | titre     |
      | standard_user | secret_sauce | Swag Labs |