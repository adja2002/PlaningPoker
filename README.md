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

## Utilisation
1. Ouvrir http://localhost:8080
2. Saisir le nombre de joueurs, puis leurs pseudos
3. Charger un backlog JSON : le projet et la première fonctionnalité à estimer s'affichent

## Format du backlog (JSON)

Le backlog à estimer est un fichier JSON de cette forme (exemple : `exemples/backlog.json`) :

```json
{
  "projet": "Bibliothèque en ligne",
  "fonctionnalites": [
    { "id": "F1", "titre": "Rechercher un livre par titre" },
    { "id": "F2", "titre": "Emprunter un livre disponible" }
  ]
}
```

- `projet` : nom du projet estimé
- `fonctionnalites` : liste des fonctionnalités, chacune avec un `id` et un `titre`
- Un fichier invalide ou un backlog sans fonctionnalité est refusé avec un message d'erreur.

## Organisation du code
- `src/main/java/.../jeu` : logique du jeu (joueurs, partie, backlog), testable sans interface
- `src/main/java/.../web` : interface web (contrôleur)
- `src/main/resources/templates` : pages HTML
- `rendus/` : rendus du projet (R0, R1…)