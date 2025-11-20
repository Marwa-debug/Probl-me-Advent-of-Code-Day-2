# Advent of Code 2024 - Day 2

Solution du problème "Red-Nosed Reports" pour le test technique Orange.

## Le problème

On doit analyser des rapports de niveaux du réacteur. Un rapport est "safe" si :
- Les niveaux montent ou descendent tout le temps (pas de zigzag)
- La différence entre deux niveaux est entre 1 et 3

### Exemple
```
7 6 4 2 1   -> Safe (descend de 1 ou 2 à chaque fois)
1 2 7 8 9   -> Unsafe (2 -> 7 ça monte de 5, trop grand)
9 7 6 2 1   -> Unsafe (6 -> 2 ça descend de 4, trop grand)
1 3 2 4 5   -> Unsafe (ça monte puis descend puis remonte)
8 6 4 4 1   -> Unsafe (4 -> 4 ça change pas)
1 3 6 7 9   -> Safe (monte de 2, 3, 1, 2)
```

Dans cet exemple, 2 rapports sont safe.

## Ma solution

J'ai fait deux classes :
- **ReportAnalyzer** : contient la logique pour vérifier si un rapport est safe
- **RedNosedReports** : lit le fichier et affiche le résultat

### Comment ça marche

1. Je lis le fichier ligne par ligne
2. Pour chaque ligne, je la découpe en nombres
3. Je vérifie si c'est croissant ou décroissant dès le début
4. Je parcours tous les niveaux et je vérifie les règles
5. Je compte combien sont safe


## Lancer le programme

Il faut Java 11 minimum et Maven.

### Compiler
```bash
mvn clean compile
```

### Lancer les tests
```bash
mvn test
```

### Exécuter
```bash
mvn package
java -jar target/red-nosed-reports-1.0.0.jar input.txt
```

## Résultat

Avec mon input personnel : **236 rapports safe**

## Pourquoi Java ?

J'ai choisi Java plutôt que TypeScript parce que :
- C'est la techno backend du stage (Java + Quarkus)
- Je l'ai appliqué dans plein de petits projets dans le cadre de mes cours, en plus je viens de faire du C# pendant mon stage chez HGH donc c'est proche
- Ça montre que je sais faire du code backend comme ce qui est mentionné dans l'offre du stage

## Notes

J'ai essayé de coder d'une manière assez simple et claire. J'ai fait des tests pour être sûre que ça marche bien avec tous les exemples donnés dans le problème.

---

Marwa HMAOUI
marwa.hmaoui@etu.isima.fr
