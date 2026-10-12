# Algo d'optimisation dans les graphes

## Plan :

- Arbre couvrant de poid min

- Plus court chemin pondere

- Flots maximum

- Coloration

- Connexite

# Arbre couvrant de poids minimum :

Soit $G=(V,E,W)$ un graphe ponderé ou $w$ fonction de poids $w : E \to \R^+$

Si on a $H(W,F)$ un sous graphe de $G$ le poid de $H$ note $W(H) = \sum_{f\in F}W(f)$.

On veut trouver l'arbre couvrant de poid minimum



**Notion de coupe :** $X \subseteq V(G); \space \delta(X)=$l'ensemble des arrete qui on un sommet dans $X$ et l'autre dans $V\backslash X$ 

2 regle :

- Soit $\delta(X)$ une coupe sans arete bleue , on selectionne $e$ l'arete sans couleur de poid min de $\delta(X) \to$ on al colorie en bleu.

- On selectione un cycle $C$ sans arret rouge , on selectione l'arete $e$ de $C$ qui n'est pas colorie et de poid maximum. 



Un meta algorithme :

apliquer une des deux regles tant que c'est possible.

L'invariant de couleur , chaque arete qui est colorie en bleu est dans la solution , chque arete de colorie en rouge est exclu de la solution



**Lemme du meta-algo :**

Le meta-algo termine toujours en ayant colorie toute  les aretes.



Par recurence sur le nombre d'arrete colorie.  
Base trivial : Soit on prent un sommet  $x$ et on considere $\delta(x)$.  
Soit $G$ contient un cycle $C$(on appliquie la regle rouge).

Recurence: par l'absurde on suppose il existe une arrete pas colorie a la fin.

2 cas à considere :

- e a ses deux extremite dans deux composante bleues differente

on considere spdg $\delta(C_1)$ a au moins une arete non colorie , pas d'arete bleu, donc on peu appliquer la regle bleu


