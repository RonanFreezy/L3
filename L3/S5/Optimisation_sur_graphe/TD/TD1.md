# Ex 0 :

Parcours pour trouver le plus  petit chemin par rapport a s

# Ex 1 :

# Ex 2 :

Comme ln est positive et croissante sur $[1,+inf[$ et $ln(a\times b)=\ln(a)+\ln(b)$.

Au lieu d'ajouter leur poid, on ajoute leur $\ln$ et pour revenir dans le cas de base on prend l'exponentielle. Comme dijkstra est correct par + et qu'il existe une bijection alors c'est correct pour $\times$

# Ex 3 :



# Ex 4 :

Si on trouve un chemin de longeur $-k$ dans $G'$ ca correspond à un chemin de longeur $k$ dans  $G$. Si pn a un chemin de longeur $-k'$ ou $-k'<-k$ dans $G'$. dans on a un chemin de longeur $k'>k$.

# Ex 5 :

L'algo de dikstra sur se graphe ,trie le poid des arrete.

**Theoreme :** dans le modele comparatif, on ne  peut pas trier en $o(n \log n)$

donc il n'existe pas d'implementation de dijkstra en $o(m+n\log n)$.


