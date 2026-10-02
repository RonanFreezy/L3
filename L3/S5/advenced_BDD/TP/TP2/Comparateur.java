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
            int res = t1[indice].compareTo(t2[indice]);
            if(res !=0) return res/Math.abs(res);
        }
        return 0;
    }
}
