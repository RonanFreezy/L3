**T2,T1 :**

| T1  | T2         | A   | B   |
| --- | ---------- | --- | --- |
|     | read(B,s)  | a    | b    |
|     | s=s*2      |     |     |
|     | Write(B,s) |     |   2b  |
|     | read(A,s)  |     |     |
|     |   s=s+3         |     |     |
|     |        write(A,s)    | a+3    |     |
|     |commit            |     |     |
| read(A,t)    |            |     |     |
|   t=t+2  |            |     |     |
|   write(A,t)  |            |  a+5   |     |
|  read(B,t)   |            |     |     |
|  t=t*3   |            |     |     |
|  write(A,t)   |            |     |  6b   |
|    commit t |            |     |     |
|     |            |     |     |
|     |            |     |     |
|     |            |     |     |
|     |            |     |     |

**T1,T2 :**

| T1  | T2         | A   | B   |
| --- | ---------- | --- | --- |
| read(A,t) |  |  |  |
| t=t+2 |  |  |  |
| write |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |

3) lecture impropre

| T1  | T2         | A   | B   |
| --- | ---------- | --- | --- |
| | read(B,s) |  |  |
| | s=2s |  |  |
| | write(B,s) |  |  |
|read(A,t) |...  |  |  |
| t=t+2| ... |  |  |
|Write(A,t) | ... |  |  |
|read(B,t) (lecture impropre) | ... |  |  |
|... | ... |  |  |
|commit |...  |  |  |
| | commit |  |  |

4) perte de mise a jour

| T1  | T2         | A   | B   |
| --- | ---------- | --- | --- |
| | read(B,s) |  |  |
| | s=2*s |  |  |
| | write(B,s) |  |  |
|read(A,t) |...  |  |  |
|t=t+2 |...  |  |  |
|write(A,t) | ... |  |  |
|read(B,t) (lecture impropre)| ... |  |  |
|t=3*t | ... |  |  |
|write(B,t) () | ... |  |  |
|commit |... |  |  |
| | commit |  |  |


# Ex2:

Q1)

$E_1= (T_1,T_2) = r_1(A)w_1(A)w_1(B)r_1(B) \ \  r_2(B)w_2(B)w_2(A)r_2(A)C_1C_2$  
$E_2= r_1(A)w_1(A)w_1(B)r_2(B) \ \  r_1(B)w_2(B)w_2(A)r_2(A)C_1C_2$  
$E_3= (T_2,T_1) =  r_2(B)w_2(B)w_2(A)r_2(A) \ \ r_1(A)w_1(A)w_1(B)r_1(B) C_2C_1$
