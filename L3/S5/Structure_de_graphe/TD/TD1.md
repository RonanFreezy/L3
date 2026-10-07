# Ex 4 :

**Reccurence:**

Soit $T=(V,E)$ un arbre , on definit un arbre $G=(v_1,v_2,v_3,...,v_n)$ sur les sommets de $T$.

$\forall i$ on veux $G[v_1,v_2,...v_n]$ est un Arbre.

**Preuve :**

Base : racine de l'arbre OK n=0

Induction : $G[v_1,v_2,...v_{i-1}]$ est un arbre donc $m_i=i-2$

quand on rajoute $v_i$ à  $G[v_1,v_2,...v_{i-1}]$ , on ajoute 1 seule arrete car 0 arrete il est pas connexe et si >2 cree un cycle

donc on a $m_i = m_{i-1} +1 = i-2+1=i-1$

A chaque etape $i$ on ajoute exactement 1 arrete , il y a $n-1$etapes $m=n-1$

# Ex 10 :

1)

$|E|=<|X| \times |Y|$

Chaque sommet de $x$ a au plus $|Y|$ voisins
Chaque sommet de $y$ a au plus $|X|$ voisins

$$
\sum_{v\in X \cup Y} \delta_G(v) = \sum_{x\in X} \delta_G(x) + \sum_{y\in Y} \delta_G(y)
$$

2)

chauqe arrete $ e=\{x,y\}$ est comptée exactement une fois $\delta_G(x)$ et exactement une fois dans $\delta_G(y)$ donc $\sum_{x\in X} \delta_G(x) = \sum_{y\in Y} \delta_G(y)$

3)

$$
|E(G)| =< \frac{n^2}{4} \\
|E(K_{n/2,n/2})| = \frac{n}{2}*\frac{n}{2}* = \frac{n^2}{4} \\
$$

Si la partition $X,Y$ des sommet est fixee , le nombre d'arrete maximum est $|X|\times|Y|$

Par l'absurde

Supposons qu'il existe une bipartie complet sur $n$ sommet tq $|X|\neq |Y|\space et \space |X|\neq |Y|>\frac{n^2}{4}$

$$
|X|>|Y|
|X|=\frac{n}{2} + k
|Y|=\frac{n}{2} - k
$$

> faire par etude de fonction.

# Ex 7:

$1 \implies 2$ (Par contrapose) :

On suppose qu'il n y a pas de chemin ou plusieur chemin :

- Si il n'existe pas de chemin alors le graphe n'est pas connexe.

- Si il existe plusieur chemins alors $G$ posséde un cycle.

Donc $T$ n'est pas un arbre.

$2 \implies 3$ (Par l'absurde):

On suppose qu' il existe un unique chemin de $x$ à $y$ et que $T$ n'est pas connexe minimal.

Donc $T$ est connexe, Deplus si on enleve une arrete $z$ sur le chemin de $x$ à $y$, alors il n'existe pas de de chemin de $x$ à $y$. Donc $T-e$ n'est plus connexe.

Donc $T$ est connexe minimal.

$3 \implies 4$ (Par contrapose) :

($T$ cyclique ou $T+e$ est acyclique) $\implies$ ($T$ aconnexe ou $T-e$ connexe)

- Supposons $T$ à un cycle, alors il y a plusieur chemin poiur allez de $x$ à $y$. Si on enleve une arrete alors il existe toujours un chemin entre $x$ et $y$.  
  Donc $T-e$ est connexe. 

- Supposons $T+e$ acyclique . il exisite un unique chemin de $x$ à $y$. Donc dans $T$ il n'existe pas de chemin.  
  Donc $T$ aconnexe.

$4 \implies 1$ :

On suppose 4 alors $T+e$ est connexe cyclique. Deplus $T$ est acyclique , c'est adire que si on enleve une arrete de $T+e$ on coupe un cycle mais pas la connexite.  
Donc $T$ connexe acylique = arbre. 

# Ex 8:

$s$ un sommet 
BFS,trouve la valeur $k=\max G[v]$

Si: $k==n \to G$ connexe et si $|E|==n-1$ alors $G$ est un arbre.  
Sinon contient un cycle ou n'est pas connexe.

# EX 12:

On suppose $\delta(G)>\frac{n-2}{2}$ et $G$ n'est pas connexe (Absurde).

Si $G$ n'est pas connexe alors il admet au moins 2 composante connexe $C_1$ et $C_2$.

comme $\delta_G(v) > \frac{n-2}{2}$

$\delta_G(v) \geq \frac{n}{2}$
v a au moins $\frac{n}{2}$ voisin.

$|C_1| \geq \frac{n}{2} +1$
$|C_2| \geq \frac{n}{2} +1$
$G$ a $n$ sommets au total .

les Composante connexe forme une partition.

$|C_1|+|C_2| \geq (\frac{n}{2} +1) + (\frac{n}{2} +1) \geq n+2$

il existe au moins un sommet à al fois dans $C_1$ et dans $C_2$

# EX 13:

$\forall x \in C_i; \space \forall y \in C_j$ dans $G, \space i\neq j$

alors dans $\bar{G}, \space x$ et $y$ sont relié par une arrete car dans $G$ , il y a aucune arrete entre $C_i$ et $C_j$

Dans $\bar{G} \space \forall x,y \in C_i, \exist j; j\neq i$ tq

- $x$ est connecte a $z \in C_j$
- $y$ est connecte a $z \in C_j$

Donc il existe un chemin $x,...,z,...,y$ 
Donc $\bar{G}$ est connexe

La reciproue est fausse !