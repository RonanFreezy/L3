### Lemme de pompage régulier

Si $L$ est regulier alors $L$ satisfait la condition de pompage regulier  

c'est a dire :

- $\exist N>0 \space \forall w \in L \space |w|>N$

- $\exist x,y,z \space w=xyz, \space y\neq \epsilon$

- $\forall i \in \N \text{ on a } xy^iz \in L$

**Average Proof:**

$$
Soit N>0 \text{ Posons } w=... \text{ On a bien } w \in L \space et |w| >N\\
Soient \space x,y,z \space tq \space w=xyz,\space y\neq \epsilon \space et \space  |xy|<N\\
\text{Posons }i=...\\
.\\
.\\
\text{On a } xy^iz \notin L
$$

**Ex :**

Montrer que $L=\left\{ a^nb^mc^k \mid n\neq{m} \text{ ou } m\neq k\right\}$ n'est pas regulier.

**Preuve :**#monter mes etape de L a L'

$$
\text{Prouvons que }L'=\{a^nb^nc^n\mid n >= 0\}\\
Soit N>0 \text{ Posons } w=a^Nb^Nc^N \text{ On a bien } w \in L' \space et |w| >N\\
Soient \space x,y,z \space tq \space w=xyz,\space y\neq \epsilon \space et \space  |xy|<N\\
|xy|<N,\space y\in a^* et\space  y\neq \epsilon\\
\text{Posons }i=2\\
|xy^2z|_a = |x|_a + |y|_a + |y|_a + |z|_a = (|x|_a + |y|_a + |z|_a) + |y|_a\\
= |xyz|_a + |y|_a = N + |y|_a = N + |y|>N\\
|xy^2z|_b = N + |y|_b=N\\
\text{On a } xy^iz \notin L
$$

**Exo :**

Transformer ce Language en grammaire $L=\{a^ib^ic^i \mid i=j \text{ ou }j=k\}$

$L= \{a^ib^ic^i \mid i=j\}\cup \{a^ib^ic^i \mid j=k\}$

$L=\{a^ib^i \mid i=j\}. \{c^k \mid k>=0\} \cup ...$

$X \to aXb \mid \epsilon ,\space C \to cC\mid \epsilon\\S \to AC$

#finir

**Prop :**

Soient $G_1$ et $G_2$ deux grammaires. 

$\exist$ les grammaires :

- $G_\cup$ tq $L(G_\cup) = L(G_1) \cup L(G_2)$

- $G_.$ tq $L(G_.) = L(G_1) . L(G_2)$

- $G_*$ tq $L(G_*) = (L(G_1))^*$

**Preuve :**

On fixe $G_1=(V_1,\Sigma,R_1,S_1) \space et \space G_2=(V_2,\Sigma,R_2,S_2) \space avec \space V_1 \cap V_2 =\empty$

Soit $S \notin V_1 \cup V_2 $

On definit :

- $G_{\cup} =(V_1 \cup V_2 \cup \{ S\},\Sigma,R_1 \cup R_2 \cup \{S \to S_1,S-SS_2\},S)$
- $G_. =(V_1 \cup V_2 \cup \{ S\},\Sigma,R_1 \cup R_2 \cup \{S \to S_1S_2\},S)$
- $G_* =(V_1 \cup \{ S\},\Sigma,R_1 \cup \{S \to SS \mid \epsilon \},S)$

**Corollaire :**

Tout language regulier est génere par une grammaire 

**Preuve :**

base :

si $L=\empty $ alors $ G_\empty = S \to S$
si $L=\{a\} $ pour $a\in \Sigma$ alors $ G_a = S \to a$

heredite:

Si $L=L_1 \cup L_2 \text{ ou } L=L_1 . L_2 \text{ ou } L=L_1^*$ consequece dde la prop precedente.

**Remarque :**

La reciproque est fausse : $S \to aSb \mid \epsilon$

---

**Prop :** 

$$
L \space regulier \iff \exist G \text{ est regulier a droite tq }L=\mathcal{L}(G)
$$

**Preuve :**



$ \implies :$

init : $S\to S \space et \space S\to a$

heredite: Soient $G_1(V_1,\Sigma,R_1,S_1)$ et $G_2(V_2,\Sigma,R_2,S_2)$ linéaires a droites.

il suffit de montrer $\exist$ :

- $G_\cup$ linéaire à droite tq $\mathcal{L}(G_\cup) = \mathcal{L}(G_1) \cup \mathcal{L}(G_2)$ 

- $G_.$ linéaire à droite  tq $\mathcal{L}(G_.) = \mathcal{L}(G_1) . \mathcal{L}(G_2)$

- $G_*$ linéaire à droite  tq $\mathcal{L}(G_*) = (\mathcal{L}(G_1))^*$

$G_\cup$ : $(S->S_1\mid S_2)$

$G_.$ :

$S_1\to bX_1 \mid aS_1 ,X_1 \to bS_1\mid \epsilon$

$S_2 \to ccS_2\mid c$

donc $G_. = (\{ (vS_2) \mid v \in V_1\} \cup V_2,\Sigma,R_1^{()} \cup R_2,(S_1S_2)$

avec $R^{()}= \{ (vS_2) \to ...$



$\impliedby :$

Si $G$ est lineaire a droite alors$\mathcal{L}(G)$ est regulier

soit $G=(V,\Sigma,R,S)$

il faut montre quil existe ue relation entre une regle de la grammaire et la construction de ca dans un automate
