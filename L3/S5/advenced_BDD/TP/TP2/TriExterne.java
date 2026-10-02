import java.io.*;
import java.util.*;

public class TriExterne {
    // size of the cache in number of n-uplet
    // M >= 3
    public static int M = 10;
    public final String[][] cache;
    public final String path;
    public final String[] entete;
    public final Comparateur comparateur;
    public final BufferedReader fichierInit; // on utilise BufferedReader pour charger en ram  des bloc de donnée plutot que de lire un apres l'autre sur le disque

    public TriExterne (String path, String[] colonnes) throws FileNotFoundException, IOException {
        this.path = path;
        this.fichierInit = new BufferedReader(new FileReader(path));
        // liste des noms de colonnes du fichier CSV
        this.entete = fichierInit.readLine().split(";");

        int[] indices = new int[colonnes.length]; // indice dit a quel position dans entete se trouve la valuer de tri dans colone . ex Triexterne([id,nom,prenom],[prenom,nom]) : indice = [2,1]
        for(int i = 0; i < colonnes.length; i++) {
            indices[i] = -1;
            for (int indice = 0; indice < entete.length; indice++)
                if (entete[indice].equals(colonnes[i]))
                    indices[i] = indice;

            if (indices[i] == -1)
                throw new RuntimeException(String.format("La colonne \"%s\" n'existe pas dans l'entête du fichier CSV", colonnes[i]));
        }

        this.comparateur = new Comparateur(indices);
        this.cache = new String[M][entete.length];
    }

    public void trier() throws FileNotFoundException, IOException {
    }

    // tri le cache entre les indices 0 et taille - 1 inclus
    private void trierCache(int taille) {
        Arrays.sort(this.cache, comparateur);
    }

    // écrit une ligne dans un fichier CSV pour les stocker les valeurs
    private static void ecrireLigneCSV(FileWriter fw, String[] valeurs) throws IOException {
    }

    // écrit dans un fichier CSV le contenu du cache de l'indice 0 à taille - 1 (avec taille <= M)
    private void sauvegardeCache(String path, String[] entete, int taille) throws IOException {
    }

    // lit le fichier CSV inital et le diviser en fichiers triée de taille M à l'exception du dernier
    // retourne le nombre de nuplets lus
    private int creerFragmentsInitiaux() throws IOException {
        return 0;
    }

    private int fusion(int niveau, int nombre) throws FileNotFoundException, IOException {
        return 0;
    }

    public String toString() {
        return Arrays.toString(this.cache);
    }

    private static String nomDeFragment(int niveau, int numero) {
        return String.format("fragment_%s_%s.csv", niveau, numero);
    }
        
    public static String[] nupletDepuis(String ligne) {
        return ligne.split(";");
    }

    /*public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.out.println("Le premier argument est un fichier CSV");
            System.out.println("Le deuxième argument est les colonnes pour le tri");
            return;
        }

        long t1 = System.currentTimeMillis();
            
        TriExterne algo = new TriExterne(args[0], args[1].split(";"));

        algo.trier();

        System.out.println("Temps d'éxécution : " + (System.currentTimeMillis() - t1) + "ms");
    }*/

    public static void main() {
        testcompare();
    }

    private static void testcompare(){

        String[] l1 = new String[4];
        String[] l2 = new String[4];
        
        l1[0]="Ronan";
        l1[1]="dormir";
        l1[2]="fruit";
        l1[3]="porteable";

        l2[0]="Ronan";
        l2[1]="lire";
        l2[2]="fruit";
        l2[3]="porte";


        int[] indices={0,3};
        Comparateur com = new Comparateur(indices);

        int res1= com.compare(l1, l2);
        System.out.printf("l1 > l2  par la colone %d : %d", indices[0],res1);

    }
}
