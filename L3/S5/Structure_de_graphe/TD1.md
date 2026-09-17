# Q4



Reccurence:



Soit $T=(V,E)$ un arbre , on definit un arbre $G=(v_1,v_2,v_3,...,v_n)$ sur les sommets de $T$.

$\forall i$ on veux $G[v_1,v_2,...v_n]$ est un Arbre.



Preuve :

Base : racine de l'arbre OK n=0

Induction : $G[v_1,v_2,...v_{i-1}]$ est un arbre donc $m_i=i-2$

quand on rajoute $v_i$ à  $G[v_1,v_2,...v_{i-1}]$ , on ajoute 1 seule arrete car 0 arrete il est pas connexe et si >2 cree un cycle

donc on a $m_i = m_{i-1} +1 = i-2+1=i-1$

A chaque veape $i$ on ajoute exactement 1 arrete , il y a $n-1$etapes $m=n-1$
