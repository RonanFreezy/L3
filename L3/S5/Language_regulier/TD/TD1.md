# Exercie 2

$$
L \text{ est regulier }\implies L \text{ verifie la condition du lemme de pompage}
$$

## Q1 :

Posons $N=3$,soit $w \in L$ tq $|w|>N=3$

Si $i=j=0 \space w=c^k,k>3$ 

on pose $x = \epsilon,y=c,z=c^{k-1}. \space \forall m \in \N$, on a $xy^mz=c^{m+k-1} \in L$

Si $i=0, j>0, w=b^jc^k$ avec $j>0$

on pose $x=\epsilon,y=b,c=b^{j-1}c^k. \space \forall m,w_m=y^mz=b^{m+j-1}c^k \in L$

Si $i>0, w=a^ib^jc^k \space i>0,j \neq k$

on pose $ x=\epsilon, y=a, z=a^{i-1}b^jc^k;\space j \neq k$

$\forall m,\space w_m=xy^mz\in L$

Donc $L$satisfait ma condition du lemme de pompage



## Q3 :

ba; aa; cb; ca



## Q4 :

Trouver $L'$ tq $L$ regulier $\implies L'$régulier et $L'$ ne satisfait pas la condition du lemme de pompage



$L=\{a^ib^jc^k\mid i>0 \implies j\neq k\}$ 

## Q5 :

Soit $L=\{a^{3^{n}}\mid n \in \N \}$

Montrer que $L$ n'est pas régulier.

Soit $N$ un entier positif . Posons $w=a^{3^N}$

On a bien $|w|>N$ et $ w \in L$

Soient $xyz$ tq $w=xyz; |xy|<N et |y|>0$

Posons $m=2$

on a $3^{N}<3^{N}+1 <= |xy^mz| < 3^{N} +N<3^{N+1}$

d'ou $xy^mz\notin L.$ Parcontrapose du lemme de pompage regulier nous en deduisons que L n'est pas regulier.
