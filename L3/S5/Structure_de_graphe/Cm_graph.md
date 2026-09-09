# Plan

- [def de base](#def)
- [graphe bipartie](#graphe-bipartie)
- decomposition en cycle
- tour euclidien
- Parcours de graphe
  - générique
  - en largeur
  - en profondeur
- couplage

# C'est quoi un graphe {#def}

Graphe :
: $G=(V,E)$ avec $V$ l'ensemble des sommets et $E$ l'ensemble des arêtes ,$E \subseteq  V \times V$

**Ex:** 

$G_1 = \left( \big\{1,2,3,4 \big\},\big\{\{1,2\},\{2,3\},\{3,4\},\{1,4\} \big\} \right)$
```mermaid
graph LR
1---2
1---4
2---3
3---4
```

Arête :
: {1,2} 1->2 et 2->1

Arc :
: (a,b) a->b != (b->a)

Boucle:
: $\exist x \in V , \{x,x\} \text{ ou } (x,x) \in E$

Graphe simple :
: Graphe sans arête parallèle

## Motivation

- Outils pour modéliser des problèmes de la vie réelle
- Outils théoriques puissants
- Minimisation de caméras (pour une galerie d'art)

## Approche 

- Vision algébrique
- Mathématique discrète<br>Trouver des condition nessecaire et suffisante pour l'existence d'un objet

## Algorithme de résolution

Représentation d'un graphe:

- Matrice d'adjacence
- Liste d'adjacence

### Matrice d'adjacence

Dans un graphe à $n$ sommet l'espace mémoire utilisé est en $O(n^2)$
Le nombre max d'arêtes est de $\frac{n(n-1)}{2}$ il s'agit d'un graphe complet

### Liste d'adjacence
 
Liste de listes des voisins

1->[2]
2->[3,1,4]
3->[4,2]
4->[3,2]

$$d_G(x) = \left|\{w \mid \{w, x\} \in E(G)\}\right|$$
**Ex:** 

$d_G(2)=3,d_G(1)=1,d_G(3)=2$

$$n + \sum_{x \in V} d_G(x)$$
$$et$$
$$\sum_{x \in V} d_G(x) = 2m$$

$$\implies n+2m \in O(n+m)$$

Dans un graphe orienté on distingue les voisins entrants et sortants
on note:
- $d_G^+$ le nombre de voisins sortants 
- $d_G^-$ le nombre de voisins entrants

$$S(G) = \min \left\{ d_G(x)\mid x \in V(G) \right\} $$
$$\Delta(G) = \max \left\{ d_G(x)\mid x \in V(G) \right\} $$
$$N_G(v) =  \left\{w \mid \left\{v,w\right\} \in V(G)\right\}$$

On dit qu'un graphe est  $k-$régulier si tous les sommets ont des degrés identiques 

## Chemins et Cycles

Chemins : 
: $P = (v_1,v_2,v_3,...,v_k), \forall{i} \in{[1,k-1]},v_i \neq v_{i+1} \text{ et } {v_i,v_{i+1}}\in{E(G)}$

**Ex:** 

```mermaid
graph LR
    1 --- 2
    2 --- 6
    6 --- 5
    5 --- 7
    2 --- 3
    3 --- 6
    3 --- 4
    4 --- 5
    4 --- 6
```

- $P_1 = (1,2,\bold{6},3,4,\bold{6},5,7)$ n'est pas un chemin élémentaire car il y a 2 $\times$ le sommet 6
- $P_2 = (1,2,3,4,5,7)$ est un chemin
- $P_3 = (1,2,6,7)$ n'est pas un chemin élémentaire car l'arête {6,7} n'existe pas dans le graphe

Cycles:
: Un cycle est un chemin et $\{v_1,v_k\} \in{E(G)}$

## Famille de graphe particuliere

### Graphe en etoiles

$K_{1,n}$ un sommet dominant $n$ sommets

### Foret et Arbre

Foret:
: Graphe sans cycle

Arbre :
: Graphe connexe acyclique

Connexe:
: $G=(V,E)$ est connexe si $\forall$ paire de sommet $\exist$ un chemin qui les relies.  

Si le graphe n'est pas connexe on peut partitioner l'ensemble des sommets de $G$ en composantes connexe

$C \subseteq V(G)$ est une composante connexe si le sous graphe Induit epar $C$ est connexe et est un ensemble maximal.

La partition en composant connexe est unique.

Pour n'importe quel graphe à $n$ sommets , le nombre de composante connexe esst au plus $n$.
nombre min = 1 $\implies$ le graphe est connexe 

> Etoile $\subseteq$ Arbre $\subsetneq$ Foret $\subsetneq$ Bipartie

### Graphe Bipartie

$G=(V,E)$ est un graphe bipartie $ssi$ on peut partitioner $V$ en deux parties $A$ et $B$ de telle facon que chaque arête $e$ ait une extremité dans $A$ et l'autre dans $B$.

**Ex:**

- Graphe bipartie
```mermaid
graph LR
1---2
1---6
2---3
2---5
3---4
4---5
5---6
```
- Graphe non-bipartie
  
```mermaid 
graph LR
A---B
A---C
B---C
```

#### Stables/Ensemble independants

Noté $I_n$ graphe à $n$ sommets sans aucune arrete.

Un graphe est bipartie $ssi$ il peut être partitioné en deux stables.

### Sous graphe/Graphe partiel

$H=(W,F),W\subseteq V \text{ et } F \subseteq E$
Pour obtenir $H$ on peut supprimer de $V$ des sommets et des arêtes.

### Sous graphe induit

$H=(W,F), W\subseteq V \space F= E \cap (W,W)$  
On garde toutes les arete de E qui ont leur 2 extremite dans W.

**Notation :** $H=G[W]$ H est le sous graphe induit par $W$ et $G$ 

$G$ est Bipartie $ssi$ $G[A]$ et $G[B]$ induisent des stables

### Sous graphe couvrant

Soit $G(V,E)$ un graphe et $H(W,F)$ un sous graphe de $G$.  
$H$ est couvrant (pour $G$) $si$:
- $W=V$
- $H$ est connexe

### Graphe complementaire 

$G=(V,E)\space \bar{G} = (v_1 \binom{V}{2}\backslash E)$

```mermaid
graph LR
1---2
2---3
3---4
4---1
```
```mermaid
graph LR
1---3
2---4
```
---

$G(V,E) \space H(W,F)$
$G$ et $H$ sont isomorphe $ssi \space \exist$ une bijection #finir_la_def


# Graphe Bipartie

**Remarque:** 
- Tous les cylces impair $(C_{2k+1})$ ne sont pas bipartie.
- Si $G$ contient un cycle impair comme sous graphe alors il n'est pas biparti.

**Theoreme:** Un graphe $G$ est bipartie $ssi$ $G$ ne contient pas de cycle Impaire.

**Preuve:**
$\implies$ obvious
$\impliedby$ SI $G$ ne contient pas de cycle impair alors tous les cylces sont de longeur paires