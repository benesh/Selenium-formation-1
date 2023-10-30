#Language : en

Feature: Ajouter un article

  @aLancer
  Scenario Outline: Ajouter au panier
    Given je vais sur la page d'accueil "https://www.saucedemo.com/"
    And j'entre un unsename "<username>"
    And j'entre un mot de passe "<mot de passe>"
    And je clique sur le bouton login
    And la page des articles est affichée "<titre>"
    When j'ajoute un backpack dans le panier
    And j'ouvre le panier
    Then je verifie si le titre du panier est "<titrePanier>"
    Examples:
      | username      | mot de passe | titre     | titrePanier |
      | standard_user | secret_sauce | Swag Labs | Your Cart   |