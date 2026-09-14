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

$X->aXb \mid \epsilon ,\space C->cC\mid \epsilon\\S->AC$

#finir
