TDD = Test Driven Development
du coté "Development" : JUnit + ...

du coté "acceptation fonctionnelle" : JBehave ou easyb ou cucumber ou ....

ATDD = Acceptance Test Driven Development
BDD = Behavior Driven Development  (à voir comme un synonyme de ATDD)

BDD (ou ATDD) :
===============

users_stories (fichiers ".story" idéalement accrochés aux Uses Cases)
= liste de scénarios rédigés de la façon suivante:

scénario xyz:

Given (contexte)
When (événement ou condition)
Then (comportement attendu)

===============
Certaines technologies (ex: JBehave en java , ... en ruby , ...)
sont prévues pour ré-exploiter les fichiers ".story" et déclencher tous les 
"acceptance test" ou "behavior test" (+ affichage d'un rapport)

==============
dans le cas particulier de la technologie JBehave ,
un développeur java code une classe en arrière plan de chaque scénario 
avec des annotations @Given , @When , @Then de façon
à associer le scénario à un véritable test exécutable (que l'on peut facilement ré-déclencher
plusieurs fois).