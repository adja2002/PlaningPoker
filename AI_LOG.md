# AI_LOG.md : journal d'usage de l'IA

> À placer à la racine du dépôt. À remplir **au fil de l'eau**, pas en fin de projet. Une entrée par tâche (pas par message), en 5 lignes.
> Rappel : l'IA est autorisée pour le **code de production** et la **configuration d'outils** uniquement. Qui a fait la demande, les fichiers touchés et les commits se retrouvent dans l'historique Git : ne les recopiez pas.

## Outils utilisés (à remplir une fois)

| Outil | Modèle (si connu) | Mode (autocomplétion, chat, agent) |
|---|---|---|
| Claude (claude.ai) | Claude Opus 5.5 | Chat |

Fichier d'instructions pour agent versionné (`CLAUDE.md`, `AGENTS.md`...) : non

## Entrées

### 2026-11-05 : configuration du projet Spring Boot, hello world et premier test (configuration)

- **Demande (résumé fidèle)** : comment configurer le projet sur Spring Initializr (dépendances), écrire un hello world et un test JUnit 5, et les lancer avec Maven.
- **Résultat** : modifié.
- **Ce que nous avons vérifié** : `./mvnw test` (2 tests passés, BUILD SUCCESS) et `./mvnw spring-boot:run` (« Hello world » affiché).
- **Ce que nous avons changé ou rejeté, et pourquoi** : dépendances limitées à Spring Web et Thymeleaf (JPA et Security écartées : inutiles et bloquantes) ; hello world placé dans une méthode `message()` pour pouvoir la tester ; Java 21 retenu pour être compatible avec les deux machines.

### 2026-11-08 : saisie du nombre de joueurs et des pseudos (US-01)

- **Demande (résumé fidèle)** : code Spring Boot pour saisir le nombre de joueurs et leurs pseudos, en séparant la logique (package `jeu`) de l'interface (package `web`), avec un test JUnit.
- **Résultat** : modifié.
- **Ce que nous avons vérifié** : `./mvnw test` (tests passés) et essai manuel dans le navigateur avec 3 joueurs.
- **Ce que nous avons changé ou rejeté, et pourquoi** : `record` remplacé par une classe avec `getPseudo()` (lisibilité et compatibilité Thymeleaf) ; nom des paramètres ajouté dans `@RequestParam` et pages déplacées dans `templates/` (corrections d'une erreur 500).

### 2026-11-08 : chargement du backlog JSON et affichage de la première fonctionnalité (US-07)

- **Demande (résumé fidèle)** : code pour lire un backlog JSON (Jackson), le valider, et afficher la première fonctionnalité, avec la logique dans le package `jeu` et des tests JUnit.
- **Résultat** : modifié.
- **Ce que nous avons vérifié** : `./mvnw test` (tous les tests passés, dont JSON invalide et backlog vide) ; essai manuel avec `exemples/backlog.json` et avec un fichier vide (message d'erreur, pas de plantage).
- **Ce que nous avons changé ou rejeté, et pourquoi** : méthode de chargement déplacée de `CapiApplication` vers `PartieController` (mauvais fichier, erreurs de compilation).

## Bilan (à compléter en séance 4, 3 lignes)

- Nombre d'entrées et de propositions rejetées ou corrigées :
- Tâches où l'IA a fait gagner du temps :
- Tâches où l'IA a fait perdre du temps :