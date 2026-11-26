from sage.all import *


def fnc2sat(l:list[bool,bool]) -> bool: 
    for i in range(len(l)):
        if not(l[i][0] or l[i][1]):
            return False
    return True

def fnc2sattodigraph(F:list[int,int])-> DiGraph:# on note une formule F tq xi est note i et \bar{x_i} est note -i avec des i succin ex:[[-1,2],[2,-2]]
    g=DiGraph()
    for i in range(len(F)):
        for j in range(2):
            g.add_vertex(inttostring(F[i][j]))

        for j in range(2):
            g.add_edge((inttostring(-F[i][1-j]),inttostring(F[i][j])))

    return g


def sign(x:int) -> str:
    if x>=0 :
        return ""
    else : 
        return "-"

def inttostring(i:int)-> str:
    return f"{sign(i)}x{abs(i)}"


def test_ex4():
    F=[
        [1,-2],
        [3,4],
        [-2,-3],
        [4,-5],
        [2,-5]
        ]

    
    d=fnc2sattodigraph(F).plot()
    d.save("tp_note_test.png")

#test_ex4()