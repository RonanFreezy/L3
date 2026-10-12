import java.io.*;
import java.util.*;

public class TriExterne {
    // size of the cache in number of n-uplet
    // M >= 3
    public static int M = 5;
    public final String[][] cache;
    public final String path;
    public final String[] entete;
    public final Comparateur comparateur;
    public final BufferedReader fichierInit; // on utilise BufferedReader pour charger en ram  des bloc de donnée plutot que de lire un apres l'autre sur le disque

    public TriExterne (String path, String[] colonnes) throws FileNotFoundException, IOException {
        this.path = path;
        this.fichierInit = new BufferedReader(new FileReader(path));// liste des noms de colonnes du fichier CSV
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
        int nb=creerFragmentsInitiaux();
        fusion(0, nb/M +1);
    }

    // tri le cache entre les indices 0 et taille - 1 inclus
    private void trierCache(int taille) {
        Arrays.sort(this.cache,0,taille,comparateur);
    }

    // écrit une ligne dans un fichier CSV pour stocker les valeurs
    private static void ecrireLigneCSV(FileWriter fw, String[] valeurs) throws IOException {
        for (int i = 0; i < valeurs.length; i++) {
            fw.write(valeurs[i]);
            if (i==valeurs.length-1) fw.write('\n');
            else fw.write(';'); 
        }
    }

    // écrit dans un fichier CSV le contenu du cache de l'indice 0 à taille - 1 (avec taille <= M)
    private void sauvegardeCache(String path, String[] entete, int taille) throws IOException {
        FileWriter fw= new FileWriter(path);
        ecrireLigneCSV(fw, entete);
        for (int i = 0; i < taille; i++) {
            ecrireLigneCSV(fw, cache[i]);
        }
        fw.close();

    }

    // lit le fichier CSV inital et le diviser en fichiers triée de taille M à l'exception du dernier
    // retourne le nombre de nuplets lus
    private int creerFragmentsInitiaux() throws IOException {
        String ligne;
        int nb_nuplet=0;
        while ((ligne = this.fichierInit.readLine()) != null){
            String[] nuplet = nupletDepuis(ligne);
            cache[nb_nuplet%M]=nuplet;
            nb_nuplet++;
            if(nb_nuplet%M==0){
                trierCache(M);
                sauvegardeCache(nomDeFragment(0, (nb_nuplet/M)-1), entete, M);
            }
        }
        int nb_restant = nb_nuplet%M;
        if(nb_restant!=0){
                trierCache(nb_restant);
                sauvegardeCache(nomDeFragment(0, nb_nuplet/M), entete, nb_restant);
            }
        return nb_nuplet;
    }

    private int fusion(int niveau, int nombre) throws FileNotFoundException, IOException {

        if(nombre==1)return 1;

        clearCache();
        
        //initialiser tout les fragment de se niveau
        BufferedReader[] files = new BufferedReader[nombre];
        for (int i = 0; i < nombre; i++) {
            files[i] = new BufferedReader(new FileReader(nomDeFragment(niveau, i)));
        }
        int nbMaxFusion = (nombre%(M-1)==0) ? nombre/(M-1): nombre/(M-1)+1; // arrondie a l'entier superieur

        for (int numFusion = 0; numFusion < nbMaxFusion; numFusion++) {

            int nbFragment= (numFusion==nbMaxFusion-1 && nombre%(M-1)!=0) ? nombre%(M-1): M-1;
            initCache(files, numFusion, nbFragment);

            FileWriter fw= new FileWriter(nomDeFragment(niveau+1, numFusion));
            ecrireLigneCSV(fw, entete);

            int iMin; String tempLine;
            while ((iMin=min())<M) {
                ecrireLigneCSV(fw,cache[M-1]);

                cache[M-1]=null;

                tempLine = getLineFromFileAtIndex(files, numFusion, iMin);
                cache[iMin] = (tempLine != null) ? tempLine.split(";") : null;// si null ca veux dire que l'on a fini de s'occuper de se fragment
            }
            fw.close();
        }
        return fusion(niveau+1, nbMaxFusion);
    }

    private void initCache(BufferedReader[] files, int numFusion,int nbFragment) throws IOException{
        for (int numFragment = 0; numFragment < nbFragment; numFragment++) {
                getLineFromFileAtIndex(files, numFusion, numFragment);// enleve les entete des fichier
                cache[numFragment]=getLineFromFileAtIndex(files, numFusion, numFragment).split(";"); // remplie le cache avec le premier n_uplet du fichier
            }
    }

    private String getLineFromFileAtIndex(BufferedReader[] files,int numFusion,int numFragment) throws IOException{// une simple fonction pour gere les indice afin de faire le moins d'erreur d'inattention
        return files[numFusion*(M-1)+numFragment].readLine();
    }

    private int min(){// ecrit a ladresse M-1 le minimun de cache et renvoie l'indice du min
        int index=initFirstNotNull();
        for (int i = index + 1; i < M-1; i++) {
            if (cache[i]!=null){
                if(comparateur.compare(cache[i],cache[M-1])<0){
                    cache[M-1] = cache[i];
                    index=i;
                }
            }
        }
        return index;
    }

    private void clearCache(){
        for (int i = 0; i < M; i++) cache[i]=null;
    }

    private int initFirstNotNull(){//renvoie l'index que premier n-uplet non null et M si tout null
        int i=0;
        while(i<M && cache[i]==null){
            i++;
        }
        if(i<M)cache[M-1] = cache[i];
        return i;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.cache);
    }

    private static String nomDeFragment(int niveau, int numero) {
        return String.format("./temp/fragment_%s_%s.csv", niveau, numero);
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

    public static void main() throws Exception{
        //testcompare();
        testcomune();
    }

    private static void testcomune() throws Exception{
        String[] colones = new String[1];
        colones[0]= "PTOT";
        TriExterne test = new TriExterne("./communes_test.csv", colones);
        test.trier();
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
