# Q1:
```
╭─ Seq Scan ──────────────────────╮
│ Table: imdb.main.titles         │
│ Type: Sequential Scan           │
│ Projections: title_id, type,    │
│              primary_title,     │
│              original_title,    │
│              is_adult,          │
│              premiered, ended … │
│ Filters: title_id = 'tt0024216' │
│ ~2 rows                         │
╰─────────────────────────────────╯
```
Un indexe aurait etet preferable a utiliser

# Question 2
La requête renvoie le même résultat, mais l'exécuteur utilise cette fois-ci un Index Scan au lieu d'un Sequential Scan.

# Question 3
L'optimisation réalisée réside dans le pushdown de filtre : DuckDB pousse la condition de filtrage directement au niveau du seq scan, au lieu de lire toutes les données pour les filtrer ensuite en mémoire.

# Question 5
- Recherche des films dans lesquels Robert De Niro et Al Pacino ont joué tous les deux.

- L'ordre exécuté suit strictement l'ordre défini dans la requête SQL.

- Cet ordre n'est pas optimal. Il serait préférable d'identifier d'abord les rôles joués par Robert De Niro et ceux joués par Al Pacino, puis de croiser ces deux ensembles pour obtenir la liste des films communs.

# Question 6
Le temps d'exécution passe de 0,0498s à 0,00197s .

# Question 7
Le nombre de lignes à renvoyer est trop élevé. L'utilisation d'un index nécessiterait des accès aléatoires qui reliraient plusieurs fois les mêmes blocs de mémoire/disque. Un sequential scan est plus efficace car chaque bloc n'est lu qu'une seule fois.

# Question 8
La requête renvoie 43 427 lignes. L'index n'est pas utilisé car le seuil maximal de lignes autorisant un Index Scan est dépassé :
$$\text{Seuil} = \max(\text{index\_scan\_max\_count},\, \text{index\_scan\_percentage} \times \text{total\_row\_count})$$
$$\text{Seuil} = \max(2048,\, 0{,}001 \times 11\,940\,000) = 11\,940 \text{ lignes}$$

Comme $43\,427 > 11\,940$, le DuckDB choisit un Sequential Scan.

# Question 9
- Temps avec index_scan_max_count = 100 000 : 0,6909 s (index forcé)
- Temps par défaut (2048) : 0,0372 s (seq scan)

L'exécution est nettement plus lente lorsque l'on force l'utilisation de l'index.

# Question 10

| Motif recherché | Nombre de résultats | Type de scan | Temps d'exécution |
| :--- | :--- | :--- | :--- |
| `tt000001` | - | Index Scan | 0,3 ms |
| `00001` | - | Index Scan | 1,16 ms |
| `0001` | - | Index Scan | 15,37 ms |
| `001` | 9 859 | Index Scan | 457 ms |
| `01` | 97 745 | Sequential Scan | 44 ms |

On remarque qu'entre 001 et 01 il renvoie plus de résultat mais le temps d'éxecution diminue, le temps d'éxecution n'est pas croissant.

# Question 11
En définissant SET index_scan_percentage = 0.01, la requête avec `01` bascule à nouveau sur un Index Scan. Son temps d'exécution passe alors à 1,59 s, ce qui confirme la continuité de la hausse du temps d'exécution observée précédemment lorsque l'index est surutilisé.



# Question 13
La stratégie consiste à appliquer les filtres au préalable sur les deux tables concernées pour réduire la taille des données, réaliser leur jointure, puis effectuer la jointure finale avec la table people. Cela permet de conserver une table de hachage la plus petite possible en mémoire.

# Q14:

```Sql
FROM titles as t,people AS p, crew AS c
```

```
╭─ Summary ──────────╮
│ Total Time: 49.13s │
╰────────────────────╯
╭─ Projection ───────────────────────╮
│ 32 rows                        0µs │
╰──────────────────┬─────────────────╯
╭─ Hash Join ──────┴─────────────────╮
│ Join Type: INNER                   │
│ Conditions: title_id = title_id,   │
│             person_id = person_id  │
│ 32 rows                     50.30s │
╰──────────────────┰┰────────────────╯
                   ┃┠─────────────────────────────────────────────────────────────────╮
╭─ Cross Product ──┚┖────────────────╮                               ╭─ Table Scan ───┴───────────────╮
│ 471,772,800 rows            13.45s │                               │ Table: imdb.main.crew          │
╰──────────────────┬─────────────────╯                               │ Type: Sequential Scan          │
                   ├─────────────────────────────────╮               │ Projections: title_id,         │
╭─ Table Scan ─────┴─────────────────╮  ╭─ Table Scan ────────────╮  │              person_id         │
│ Table: imdb.main.titles            │  │ Table: imdb.main.people │  │ Filters: category = 'director' │
│ 32 rows                        0µs │  │ 14,742,900 rows   2.47s │  │ Row Groups Scanned: 942 / 942  │
╰────────────────────────────────────╯  ╰─────────────────────────╯  │ 8,158,454 rows           5.06s │
                                                                     ╰────────────────────────────────╯
```


# Q15 : 

Il fait des produit cartesien plutot que des jointure

```Sql
SELECT p.person_id, p.name
FROM (titles AS t JOIN crew AS c ON t.title_id = c.title_id)
JOIN people AS p ON c.person_id = p.person_id
WHERE c.category = 'director' 
AND t.premiered < 1880;
```

# Q16:

```Sql
SELECT p.person_id, p.name 
FROM people AS p
WHERE p.person_id IN (
    SELECT c.person_id 
    FROM crew AS c
    WHERE c.category = 'director'
    AND c.title_id IN (
        SELECT t.title_id 
        FROM titles AS t
        WHERE t.premiered < 1880
      )
);

```
# Q17:

```Sql
SELECT p.person_id, p.name 
FROM people AS p
WHERE p.person_id IN (
    SELECT c.person_id 
    FROM crew AS c
    WHERE c.category = 'director'
    AND c.title_id IN (
        SELECT t.title_id 
        FROM titles AS t
        WHERE t.premiered < 1880
        LIMIT 50
      )
    LIMIT 50
);

```
