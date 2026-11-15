# Exemple 10/36

## Q1)

$\Omega=\{victoire,nul,defaite\}$

## Q2)

$P(victoire)=3/5;P(nul)=1/5;P(defaite)=1/10$

## Q3)

$P(victoire)+P(nul)+P(defaite)=3/5+1/5+1/10=9/10 \neq 1$

# Exemple 14/36

## Q1)

$P(A)=1-P(\bar{A})=1-1/2^n$

## Q2)

$A=\{roi\};B=\{pique\}$

$P(A\cup B)=P(A)+P(B)-P(A\cap B)=4/52 +13/52-1/52=4/13$

## Q3)

Point carre ordre 3. 65/96

# Exemple 16/36

Suite ordonnée de longeur 3 avec remise de la population {1,2,3,4,5,6}

$6³$

# Exemple 18

$A=\{1,...,20\},n=|A|=20$

$A^3_{20} = 6840$

# Exemple 19

$(_5^{52}) = 2\ 598\ 960$

# Exemple 20

Anagrame de PROBA : $\frac{5!}{1!1!1!1!1!}$

Anaframe de STAT : $\frac{4!}{1!2!1!}= 12$

# Exemple 21

$n=7$ boite numerote de 0 à 6

$r=2$

$(^{7+2-1}_2)$

# Exemple 22

## Q1)

$\Omega=\{1,...6\}^n, |\Omega|=6^n$

$A=\{(i_1,..,i_n):2\leq i_j <6, 1\leq j \leq n\},|A|=5^n$

$P(A)= \frac{|A|}{|\Omega|}=\frac{5^n}{6^n}$

## Q2)

$\Omega=\{P,F\}^{2n},|\Omega|=2^{2^n}$

$A=\{n \ F\}, |A|=(^{2n}_2)$

## Q3)

$\Omega=\{ \text{5 cartes d'un jeux de 52 cartes} \},|\Omega|=(^{52}_5)= 2\ 598\ 960$

$A=\{\text{quite flush royale}\},|A|=4$

# Exemple 23

5 parmi 100

3 parmi 5 $|A|=(^{10}_3)(^{90}_2)=120*4\ 005=480\ 600$

# Exemple 27

$\Omega=\{R,B\}^2$

$A_1=\{\text{premiere boule rouge}\};A_2=\{\text{deuxieme boule rouge}\}$

$P(A_1 \cap A_2)=P(A_1) \times P_{A_1}(A_2)$

$P(A_1)=10/20=1/2$

$P_{A_1}(A_2)=9/20$

$P(A_1 \cap A_2)=P(A_1) \times P_{A_1}(A_2)=1/2*9/20=9/40$

# Exemple 28

$P(R_i\cap B_j)=P((i,j))= 1/36=P(R_i)P(B_j)$ 

# Exemple 31

$A= \{(i,j)|i\in [1,3],j\in [1,6]\};\ P(A)=1/2$

$B= \{(i,j)|i\in [3,5],j\in [1,6]\};\ P(B)=1/2$

$A \cap B= \{(3,j)|j\in [1,6]\};\ P(A\cap B)=1/6 \neq P(A)P(B)$

$C= \{(i,j),i+j=9|i,j\in [1,6]\},\ P(C)=1/9$

$A\cap B \cap C= \{(3,6)\},\ P(A\cap B \cap C)=1/36=P(A)P(B)P(C)$

---

a= de 1 = 1à 3

b= de2 de 4à6

c= somme=7

$B= \{(i,j)|i\in [1,6],j\in [4,6]\}$

$A \cap B= \{(i,j)|i\in [1,3],j\in [4,6]\}$

$C= \{(i,j), i+j=7|i,j\in [1,6]\}$

$A\cap C= \{(1,6),(2,5),(3,4)\},\ P(A\cap C)=1/12$

$B\cap C= \{(i,j)|i\in [1,3],j\in [1,6]\}$

# Exemple 33

$\Omega=\{\text{choisir 3 pommes dans le meme panier}\}$

$A=\{\text{avoir choisi 2pomme amere}\}$

$U_i=\{\text{choisir 3 pommes dans le panier i}\}$

$U_1,U_2,U_3:$ est un systeme d'evenement

$P(A)=\Sigma_{i=1}^3P(U_i)P_{U_i}(A)=\frac{1}{3}\Sigma_{i=1}^3\frac{a_i\binom{b_i}{2}}{\binom{a_i+b_i}{3}}$

# Exemple 35

$\Omega=\{\text{un tableau parmi les 300}\}$

$T_1=\{\text{tableau saisi par }O_1\},\ P(T_1)=1/3$

$T_2=\{\text{tableau saisi par }O_2\},\ P(T_2)=2/3$

$T_1,T_2$ sont un systeme comple d'evenement

$F=\{\text{tableau comportent des fautes }\}\}$

$P_{T_1}(F)=52/1000,P_{T_2}(F)=67/1000$

formule de baye

# Exemple 5

$\Omega=\{(i,j): 1 \leq i,j\leq 6\}$

$X:\Omega \to \{2,3,...,12\} avec \ X((i+j))=i+j$

$(X=2)=\{(1,1)\}, (X=3)=\{(1,2),(2,1)\}$

# Exemple 6

fonction de repartition

# Exemple 11

$\Omega=\{\text{sous ensemble de 3 boules}\};\ |\Omega|=\binom{15}{3}=455$

$E[X]$ avec $X$ ne nombre de boules blanches tirées

$X(\Omega)=\{0,1,2,3\}$ est fini $\implies E[X]$ existe

$E[X]=0.P(X=0)+1.P(X=1)+2.P(X=2)+3.P(X=3)=2$

$E[X^2]$ on fait le theorem du transfert avec $X$ et $g(X)=x^2$

$E[X^2]=0.P(X=0)+1^2.P(X=1)+2^2.P(X=2)+3^2.P(X=3)$

# Exemple 14

$X(\Omega)=\{1,2,3,4,5,6\}; \ Y(\Omega)=\{1,2,3,4,5,6\}$

$P(X=x,Y=y)=\{0 \ si\  x<y;\ 1/36 \ si \ x=y;\ 1/18 \ si \ x>y$

loi marginale 

| X/Y    | 1    | 2    | 3    | 4    | 5    | 6     | P(Y=y) |
| ------ | ---- | ---- | ---- | ---- | ---- | ----- | ------ |
| 1      | 1/36 | 1/18 | 1/18 | 1/18 | 1/18 | 1/18  | 11/36  |
| 2      | 0    | 1/36 | 1/18 | 1/18 | 1/18 | 1/18  | 9/36   |
| 3      | 0    | 0    | 1/36 | 1/18 | 1/18 | 1/18  | 7/36   |
| 4      | 0    | 0    | 0    | 1/36 | 1/18 | 1/18  | 5/36   |
| 5      | 0    | 0    | 0    | 0    | 1/36 | 1/18  | 3/36   |
| 6      | 0    | 0    | 0    | 0    | 0    | 1/36  | 1/36   |
| P(X=x) | 1/36 | 3/36 | 5/36 | 7/36 | 9/36 | 11/36 |        |

# Exemple 15

$X(\Omega)=\N^*$ et $Y(\Omega)=\N^*$

$P(X=x)=(3/4)^x * 1/4 + (1/4)^x*3/4=$

Loi marginale de $Y$ : plus simple de passer par la loi conjointe

$P(X=x,Y=y)=(3/4)^x * (1/4)^y * 3/4 + (1/4)^x * (3/4)^y * 1/4$

$P(Y=y)=\Sigma_1^+inf P(X=x,Y=y)$

---

$X= N(m,\sigma_X)$

Soit $X'=X-m$

$E[X']=E[X-m]=E[X]-E[m]=n-m=0$

Soit $Y=\frac{X'}{\sigma_X}$

$var(Y)=var(\frac{X'}{\sigma_X})=\frac{1}{\sigma_X^2}*var(X')=var(X-m)....$

# 15/40

$X=B(100,1/2)=25$

$P((X\leq 40) \cup (X \geq 60))=P((X-50\leq -10)\cup(X-50\geq10))=P(|X-50|\geq 10)$

inegalite de bienaymé-tchebychev $P(|X-50|\geq 10)\leq \frac{var(X)}{10^2}=0.25$
