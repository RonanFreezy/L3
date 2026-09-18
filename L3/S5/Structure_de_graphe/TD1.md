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



$1 \implies 2$ : par contrapose
