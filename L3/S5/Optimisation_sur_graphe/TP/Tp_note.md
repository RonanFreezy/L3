# Q1 :

avec n variable on a $2n$ litereaux car $\forall x_i , i\in [1,n]; x_i ,\bar{x_i} \in C$

Chaque literaux est dans au plus $n$ clause et comme $(x_1 \lor x_2) \equiv (x_2 \lor x_1)$ donc on reduit de moitier le nombre de clause totale.

On a donc $|C|=\frac{(2n)^2}{2}=2n^2$.



# Q2 :

$(x_1 \lor x_2) \land (x_1 \lor \bar{x_2}) \land (\bar{x_1} \lor x_2) \land (\bar{x_1} \lor \bar{x_2})$ n'est pas satisfiable.



    
