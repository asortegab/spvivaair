Feature: Escoger vuelo
  Como un tester de accenture
  Yo quiero escoger un vuelo
  utilizando screen play

  Scenario: Escoger vuelo en la pagina de vivaair
    Given Andres quiere escoger un vuelo
    When origen medellin destino bogota
    Then obtener el vuelo mas barato