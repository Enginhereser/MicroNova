Feature: Home Page

  Scenario: Funktionalität der Bewerbung der Offene Stelle

    When  geht zum HomePage
    Given nach unten zur Schaltfläche Offene Stellen
    And   klick auf der Link
    Then  schreibt auf der Suchfeld "software Tester"
    And   klick auf die Stelle Software Tester
    And   geht nach unten zu den Links für die Bewerbung
    Then  klick auf die Links zur Bewerbung
    And   alle Daten werden ausgefüllt


    








