# Exercice 1 :

## Q1 :

En supposant un Debit de 100 Mo/s on pourra lire la BDD en 30 000 s $\approx$ 8h20

## Q2 :

$$
100 \times (10^{-2}+10/10^7) \\= 10 \times (10^{-2} + 10^{-6}) \\= 10^{-1} + 10^{-5}\\= 0.1 +0.00001 \\= 0.10001s
$$

## Q3 :

Avec une bonne RAM en DDR4 de Debit 6Go/s

$$
100\times (10^{-8} +  \frac{10}{6*10^9})\\
=100 \times \frac{1}{3}*10^{-8}\\
=\frac{1}{3}*10^{-6}\\
=0.00000003s
$$

## Q4 :

$$
3*10^{12} /3*10^{3} = 10^{9}\\
10^{9}\times (10^{-2}+10^{3}/10^7)\\
=10^{9}\times (10^{-2}+10^{-4})\\
=10^{7}+10^{5}\\
=10^{7}s
$$



# Exercice 2 :

## Q1 :

| Type     | capacite                       |
| -------- | ------------------------------ |
| piste    | 40k*512=20 480k                |
| cylindre | 10*20 480k=204 800k            |
| surface  | 5 335 031 400/10 = 533 503 140 |
| disque   | 533 503 140*2=1 067 006 280    |

## Q2 :

7 400 rpm =  7400/60 = 123t/s

en moyenne 1/2 tour soit (1/123)/2=0.004

donc $10^{-2} + 4*10^{-3} = 14ms$



## Q3 :

datapiste/debit=20/100=0.2

123*0.2=24.6ms



# Exercice 3 :

## Q1 :



## Q2 :

10% hit ratio car 10% de chance de lire le block en memoire :
(100 -90)/100



## Q3 :

on a un cache de 100 mo

fichier A : 200mo avc 80 % de chance de lecture 

fichier B : 800mo avec 20% de chance de lecture



donc 80% du cache pour pour A soit 80 mo de A qui represente 40% du fichier A en cache

donc 20% du cache pour pour B soit 20 mo de B  qui represente 2.5% du fichier B en cache .



$0.8*0.4 + 0.025*0.2 = 0.325$

on a 32.5% de chance de prendre un fichier dans le cache . le hit ratio est donc de 100-(100-32.5)/100 


