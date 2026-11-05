# PlaningPoker
projet académique : Une application qui permet à une équipe de jouer une partie de planning poker

## Technoogies
-- java 21, Spring Boot, Maven
-- Tests : JUnit 5

## Prérequis 
-- Java 21 (JDK) instalée

## Lancer les test et l'application

```
./mvnw test spring-boot:run
```
sous windows (invite de commandes) : `mvnw.cmd test spring-boot:run`
Le résultat des tests s'affiche, puis << Hello world >> dans la console.
L'application reste ouverte sur http://localhost:8080 ; l'arrêter avec Ctrl + C.

## Lancer seulement les tests

``
./mvn test
``
sous Windows (invite de commande) : `mvnw.cmd test`
