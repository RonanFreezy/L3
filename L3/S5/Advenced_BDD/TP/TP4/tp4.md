# Exercice 1

## Q1

|Session 1|Session 2|
|---|---|
|SELECT ctid, * FROM produit FOR SHARE||
||SELECT ctid, * FROM produit WHERE nom = 'bananes' FOR SHARE|
|COMMIT||
||COMMIT|

Comme il s'agit d'un verrou partagé, plusieurs transactions peuvent lire les données simultanément.

## Q2

|Session 1|Session 2|
|---|---|
|SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR SHARE;||
||SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR UPDATE;|
||UPDATE produit SET prix = 6 WHERE nom = 'pommes';|
|SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR SHARE;||
||ROLLBACK;|
|ROLLBACK;||

La session 2 est en attente du relâchement du verrou par la session 1. Les transactions s'exécutent donc de manière sérielle.

## Q3

|Session 1|Session 2|
|---|---|
|SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR UPDATE;||
|UPDATE produit SET prix = 6 WHERE nom = 'pommes';||
||SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR SHARE;|
|ROLLBACK;||
||ROLLBACK;|

La session 2 est bloquée car elle tente d'acquérir un verrou partagé sur une ligne déjà verrouillée en mode exclusif. Les deux transactions sont exécutées en série pour régler le problème.

## Q4

|Session 1|Session 2|
|---|---|
|SELECT ctid, * FROM produit WHERE nom = 'carottes' FOR UPDATE;||
|UPDATE produit SET prix = 1 WHERE nom = 'carottes';||
||SELECT ctid, * FROM produit WHERE nom = 'carottes' FOR UPDATE;|
||UPDATE produit SET prix = 3 WHERE nom = 'carottes';|
|ROLLBACK;||
||ROLLBACK;|

Blocage de la session 2 car elle tente de modifier une ligne dont la transaction de modification est déjà en cours.

## Q5

|Session 1|Session 2|
|---|---|
|SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR UPDATE;||
|UPDATE produit SET prix = 4 WHERE nom = 'pommes';||
||SELECT ctid, * FROM produit WHERE nom = 'carottes' FOR UPDATE;|
||UPDATE produit SET prix = 3 WHERE nom = 'carottes';|
|SELECT ctid, * FROM produit WHERE nom = 'carottes' FOR UPDATE;||
|UPDATE produit SET prix = 1 WHERE nom = 'carottes';||
||SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR UPDATE;|
||UPDATE produit SET prix = 6 WHERE nom = 'pommes';|
|ROLLBACK;||
||ROLLBACK;|

Le SGBD détecte un interblocage (deadlock) et annule la transaction de la session 2 suite au conflit sur les pommes et les carottes.

## Q6

|Session 1|Session 2|
|---|---|
|SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR SHARE;||
||SELECT ctid, * FROM produit WHERE nom = 'carottes' FOR SHARE;|
|SELECT ctid, * FROM produit WHERE nom = 'carottes' FOR UPDATE;||
|UPDATE produit SET prix = 1 WHERE nom = 'carottes';||
||SELECT ctid, * FROM produit WHERE nom = 'pommes' FOR UPDATE;|
||UPDATE produit SET prix = 6 WHERE nom = 'pommes';|
|ROLLBACK;||
||ROLLBACK;|

Ce scénario provoque également un interblocage.

# Exercice 2

## Q7

|Session 1|Session 2|
|---|---|
|select ctid,* from produit where prix >=5;||
||insert into produit (id,nom,prix)|
||values (7,'kaki',6);|
||COMMIT;|
|select ctid,* from produit where prix >=5;||
|COMMIT;||

Lors du deuxième affichage, on obtient la ligne avec « kaki » en plus. Les deux sessions ne sont pas totalement isolées.

## Q8

Ce comportement n'est pas sérialisable car la propriété d'isolation n'est pas respectée.

## Q9

|Session 1|Session 2|
|---|---|
|select ctid,* from produit where prix >=5;||
||UPDATE produit SET prix = 4 WHERE nom = 'kaki';|
||COMMIT;|
|select ctid,* from produit where prix >=5;||
|COMMIT;||

## Q10

|Session 1|Session 2|
|---|---|
|SELECT * FROM panier WHERE client = 0 FOR SHARE;||
||SELECT * FROM panier WHERE client = 0 FOR SHARE;|
|INSERT INTO panier (client, produit) VALUES (0, 4);||
|COMMIT;||
||INSERT INTO panier (client, produit) VALUES (0, 0);|
||COMMIT;|

Ce n'est pas sérialisable car le résultat n'est pas équivalent à une exécution sérielle (S1 puis S2 ou S2 puis S1). 
Poser un verrou partagé ne suffit pas ici, car la lecture partagée n'empêche pas les insertions concurrentes.

## Q11

### Q7 bis

|Session 1|Session 2|
|---|---|
|LOCK TABLE produit IN SHARE MODE;||
|select * from produit where prix >=5;||
||insert into produit (id,nom,prix)|
||values (7,'kaki',6);|
||COMMIT;|
|select * from produit where prix >=5;||
|COMMIT;||

### Q9 bis

|Session 1|Session 2|
|---|---|
|LOCK TABLE produit IN SHARE MODE;||
|select ctid,* from produit where prix >=5;||
||UPDATE produit SET prix = 4 WHERE nom = 'kaki';|
||COMMIT;|
|select ctid,* from produit where prix >=5;||
|COMMIT;||

### Q10 bis

|Session 1|Session 2|
|---|---|
|LOCK TABLE panier IN EXCLUSIVE MODE;||
|SELECT * FROM panier WHERE client = 0 FOR SHARE;||
||SELECT * FROM panier WHERE client = 0 FOR SHARE;|
|INSERT INTO panier (client, produit) VALUES (0, 4);||
|COMMIT;||
||INSERT INTO panier (client, produit) VALUES (0, 0);|
||COMMIT;|

# Exercice 3

## Q12

En niveau d'isolation `READ COMMITTED`, on lit les variables seulement dans leur dernier état validé (commit). Les deux transactions se déroulent en parallèle.

|Session 1|Session 2|prix 1|prix 2|
|---|---|---|---|
|||5|5|
|UPDATE produit SET prix = 6 WHERE nom = 'pommes';||6|5|
||select * from produit where nom = 'pommes';|6|5|
|COMMIT;||6|5|
||COMMIT;|6|6|

## Q13

Ici, l'écriture sale est impossible : l'opération est bloquante, il faut donc attendre que S1 valide (`COMMIT`) pour débloquer S2.

|Session 1|Session 2|
|---|---|
|UPDATE produit SET prix = 6 WHERE nom = 'pommes';||
||UPDATE produit SET prix = 3 WHERE nom = 'pommes';|
|Commit;||
||Commit;|

## Q14 

Le niveau `READ COMMITTED` ne protège pas contre la lecture non répétable (repeatable read anomaly).

|Session 1|Session 2|prix 1|prix 2|
|---|---|---|---|
|||5|5|
|UPDATE produit SET prix = 6 WHERE nom = 'pommes';||6|5|
||select * from produit where nom = 'pommes';|6|5|
|COMMIT;||6|5|
||select * from produit where nom = 'pommes';|6|6|
||COMMIT;|6|6|

## Q15

Des tuples fantômes peuvent apparaître en niveau `READ COMMITTED`.

|Session 1|Session 2|
|---|---|
|select * from produit where prix >=5;||
||insert into produit (id,nom,prix)|
||values (7,'kaki',6);|
||COMMIT;|
|select * from produit where prix >=5;||
|COMMIT;||

## Q16

|Session 1|Session 2|
|---|---|
|UPDATE produit SET prix = 4 WHERE nom = 'pommes';||
||UPDATE produit SET prix = 3 WHERE nom = 'carottes';|
|UPDATE produit SET prix = 1 WHERE nom = 'carottes';||
||UPDATE produit SET prix = 6 WHERE nom = 'pommes';|
|ROLLBACK;||
||ROLLBACK;|

## Q17

On augmente tous les prix de 1 dans S1, qui pose des verrous sur toutes les lignes modifiées. S2 est donc bloqué car il attend que les verrous soient libérés par S1. Une fois S1 validée, S2 s'applique sur les nouvelles données.

# Exercice 4

## Q18

En `REPEATABLE READ`, le SGBD isole les lectures par rapport au début de la transaction, rendant certaines anomalies de lecture impossible.

## Q20

|Session 1|Session 2|
|---|---|
|select * from panier where client =0;||
||select * from panier where client =0;|
|delete from panier where client =0 and produit = 1;||
||delete from panier where client =0 and produit = 0;|
|COMMIT;||
||COMMIT;|

À la fin, il n'y a plus rien dans le panier du client 0. Cette exécution n'est pas sérialisable, car le résultat combiné diffère d'une exécution sérielle.

## Q21

Dans le cas `SERIALIZABLE`, le SGBD détecte une anomalie de sérialisation et renvoie une erreur pour empêcher la transaction concurrente de corrompre la cohérence globale.

# Exercice 5

## Q22

Le SGBD pose un verrou de type `UPDATE` sur `panier` et aucun sur `produit`, car modifier le prix d'un produit ne compromet pas la cohérence du panier.

## Q23

Oui, le SGBD pose un verrou de type `No Key Update` sur `produit` et rien sur `panier`.

## Q24

Oui, le SGBD pose un verrou de type `UPDATE` sur `produit` et rien sur `panier`.

## Q25

Ça fonctionne, mais le comportement peut paraître surprenant selon le cas d'usage.