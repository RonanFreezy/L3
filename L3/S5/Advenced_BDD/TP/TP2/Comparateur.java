import java.util.*;

// compare deux nuplets par rapport à l'ordre lexicographique d'un sous-ensemble de ces indices
// attention, l'ordre des indices compte et il n'est pas forcément croissant
class Comparateur implements Comparator<String[]> {

    public final int[] indices;
    
    public Comparateur(int[] indices) {
        this.indices = indices;
    }

    @Override 
    public int compare(String[] t1, String[] t2) {
        for (int indice : indices) {
            try {// implementation un peu moche pour des entier
                int i1 =Integer.parseInt(t1[indice]);
                int i2 =Integer.parseInt(t2[indice]);

                if(i1 > i2) return 1;
                else if (i1<i2) return -1;
                
            } catch (NumberFormatException e) {
                int res = t1[indice].compareTo(t2[indice]);
                if(res!=0) return res;
            }
        }
        return 0;
    }
}
