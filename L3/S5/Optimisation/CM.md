---

s: La position actuelle du cavalier et l'etat de chaque case(visite ou non-visite)

s0: Le cavalier est place dans n'importe quelle case de la grille. Toute les cases sont marques comme 'non-visite'

A:8 action possible correspondant au 8 facon de deplacer le cavalier (certain action seront interdites selon l'etat actuelle)

A(s): Les action qui deplace le cavalier vers une case non-visite à l'interieur de la grille. La case d'arrivée

---

s: aeroport ou on est + date d'arrive

s0: aeroport d'ou part le client, la date de depart souhaitée

A: Tous les vols d'un aeroport à un autre

A(s): ce sont les vols qui partent de l'aeroport actuel, a une date ulterieur a la date actuelle( en fait, on pourrait aussi exiger une certaine durée entre l'arrive dans l'aeroport et le prochain vol,sinon le client rique de rater sa correspondance)

succ(s,a)les etat resultant de la prise du vol a partir de l'etat s

T: arrive au la destination finale

c(s,s'): 0, pour la possibilite, le cout, ne nombre de changement ect ...

---


