# Plan

- [def de base](#def)
- graphe bipartie
- decomposition en cycle
- tour euclidien
- Parcour de graphe
  - generique
  - en largeur
  - en profondeur
- couplage

# C'est quoi un graphe {#def}

Graphe :
: G=(V,E) avec V l'ensemble des sommet et E l'ensemble des arrete ,E inclus dans V x V

> Ex: G ~1~ = ({1,2,3,4},{{1,2},{2,3},{3,4},{1,4}}

dessin graph
'''
1->2
2->3
3->4
1->4
'''
arete :
: {1,2} 1->2 et 2->1

arc :
: (a,b) a->b != (b->a)

boulce:
: il existe x dans V tq {x,x} ou (x,x)

Graphe simple :
: Graphe sans arrte parrallele

## motivation

- Outils pour modeliser des pb de la vie reel
- outils theorique puissant
- Minimisation de Camera (pour une galerie d'art)

## Approche 

- vision algebrique
- Mathematique discrete<br> Trouver des condition nessecaire et suffisante pour l'existance dun objet

## Algotrithme de resolution

Representation d'un graphe:

- matrice d'adjacence
- Liste d'ajacence

### matrice d'adjacence

dans un graphe a n sommet l'espace meemoire utilise et en O(n^2^)
 le nombre max d'arrete est de $\frac{n(n-1)}{2}$ il s'aggit d'un graphe complet

### Liste d'ajacence
 
Liste de liste des voision

1->2
2->3,1,4
3->4,2
4->3,2

$$d_G(x) = \left|\{w \mid \{w, x\} \in E(G)\}\right|$$
d~G~(2)=3,d~G~(1)=1,d~G~(3)=2

$$n + \sum_{x \in V} d_G(x)$$

$$\sum_{x \in V} d_G(x) = 2 * m$$ (2)

$$(1) et (2) -> n+2m \in O(n+m)$$

dans un graphe oriente on distigue les voison entrant et sortant
on note:
- d^+^~G~ le nombre de voision sortant 
- d^-^~G~ le nombre de voision entrant

$$S(G) = \min \left\{ d_G(x)\mid x \in V(G) \right\} $$
$$\Delta(G) = \max \left\{ d_G(x)\mid x \in V(G) \right\} $$
$$N_G(v) =  \left\{w| \left\{v,w\right\} \in V(G)\right\}$$

on dit qu'un graphe est  k-regulier si tous les somment ont des degres identiques 

## chemin et cycles

chemin : 
: $P = (v~1~,v~2~,v~3~,...,v~k~) , pour tout i dans [1,k-1] v~i~ != v~i+1~ et {v~i~,v~i+1~} appartient a E(G)$

graphe non oriente
```
1->2
2->3,6
3->6,4
4->6,5
5->6,7
6->2,3,4,5
7->5
```

Ex: P~1~ = (1,2,6,3,4,6,5,7) n'est pas un chemin elem car il y a 2 fois le sommet 6
P~2~ = (1,2,3,4,5,7) est un chemin
P~3~ = (1,2,6,7) n'est  pas un chemin car l'arrete {6,7} n'existe pas dans le graphe

cycles:
: Un cycle est un chemin et {V~1~,v~k~} appartient a E(G)
