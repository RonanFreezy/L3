from sage.all import *




def initialisation_dijsktra(G : Graph,sdeb):
    d={}
    V=G.vertices()
    P={}
    P[sdeb]=sdeb
    for i in V:
        d[i]= math.inf
    d[sdeb]=0

    return d,V,P

def min_dist(V,d):
    min = math.inf
    v_min= None
    for v in V:
        if d[v]<min :
            min = d[v]
            v_min = v
    return v_min


def maj_dist(v,w,G,d,P):
    if d[v] + G.edge_label(v,w)< d[w]:
        d[w]= d[v] + G.edge_label(v,w)
        P[w]=v

def extrac_path(P,sfin):
    path=[]
    v=sfin
    while P[v]!=v:
        path.append(v)
        v=P[v]
    path.append(v)
    path.reverse()
    return path


def Dijsktra(G : Graph,sdeb,sfin):
    d,V,P=initialisation_dijsktra(G,sdeb)
    while V!=[]:
        v_min=min_dist(V,d)
        V.remove(v_min)
        for w in G.neighbors_out(v_min):
            maj_dist(v_min,w,G,d,P)

    return extrac_path(P,sfin)

def test_dijsktra():
    mat=[
        [0,0,18,0,3],
        [8,0,4,0,0],
        [0,0,0,0,0],
        [0,1,0,0,0],
        [0,10,0,2,0]
    ]
    g=DiGraph(matrix(mat), weighted=True)
    print(Dijsktra(g,0,2))
test_dijsktra()