import java.io.*;
import java.util.*;

public class ArbreB {
    // M >= 2
    public static int M = 3;
    public Noeud racine;
    
    private static final class Noeud {
        public final boolean estFeuille;
        public final String[] cles;
        public final String[] valeurs;
        public final Noeud[] enfants;
        public int taille = 0; 

        public Noeud(boolean feuille) {
            this.estFeuille = feuille;
            this.cles = new String[M];
            if (estFeuille) {
                this.valeurs = new String[M];
                this.enfants = null;
            } else {
                this.valeurs = null;
                this.enfants = new Noeud[M + 1];
            }
        }

        public String toString() {
            StringBuilder b = new StringBuilder();
            if (this.estFeuille) b.append("Feuille(");
            else b.append("Noeud(");

            if (!this.estFeuille) b.append(this.enfants[0]).append(" | ");

            for(int i = 0; i < this.taille; i++) {
                b.append(this.cles[i]);
                b.append((this.estFeuille) ? ": " : " | ");
                if (this.estFeuille)
                    b.append(this.valeurs[i]);
                else
                    b.append(this.enfants[i + 1]);
                if (i + 1 < this.taille)
                    b.append((this.estFeuille) ? ", " : " | ");
            }

            b.append(")");

            return b.toString();
        }
    }

    // classe utile pour le retour de valeur
    // dans les méthodes où un split est effectué 
    public static final class Paire {
        public final String cle;
        public final Noeud noeud;

        public Paire(String c, Noeud n) {
            this.cle = c;
            this.noeud = n;
        }

        public String toString() {
            return "(" + this.cle + ", " + this.noeud + ")";
        }
    }

    public ArbreB() {
        this.racine = new Noeud(true);
    }

    private int positionPour(Noeud n, String cle) {
        for (int pos = 0; pos < n.taille; pos++) {
            if(cle.compareTo(n.cles[pos])<0)return pos;
        }
        if(n.taille == ArbreB.M)return ArbreB.M;
        return n.taille;
    }

    private void decalerDeUn(Noeud n, int pos) {
        if (pos>=n.taille){n.taille++; return;}
        for (int i=n.taille;i>pos;i--){
            n.cles[i]=n.cles[i-1];
            if(n.estFeuille) n.valeurs[i]=n.valeurs[i-1];
            else n.enfants[i+1]=n.enfants[i];
        }
        n.cles[pos]=null;
        if(n.estFeuille) n.valeurs[pos]=null;
        else n.enfants[pos+1]=null; 
        n.taille++;
    }

    private void insererA(Noeud n, int pos, String cle, String valeur, Noeud enfant) {
        decalerDeUn(n, pos);
        n.cles[pos]=cle;
        if(n.estFeuille) n.valeurs[pos]=valeur;
        else n.enfants[pos+1]=enfant;
    }

    public void ajouter(String cle, String valeur) {
        Paire p =ajouterRec(racine, cle, valeur);
        if (p!=null){
            Noeud n=new Noeud(false);
            n.cles[0]=p.cle;
            n.enfants[0]=racine;
            n.enfants[1]=p.noeud;
            n.taille++;
            racine=n;
            //faire que quand on remonte j'usqua al racine on cree une nouvelle racine et racorde les 2 fils .
        }
    }

    private Paire ajouterRec(Noeud n, String cle, String valeur){
        int pos =positionPour(n, cle);
        if (n.estFeuille){
            if(n.taille==M) {
                return splitFeuille(n, cle, valeur);
            }
            else {
                insererA(n, pos, cle, valeur, null);
                return null;
            }
        }
        else {
            Paire p = ajouterRec(n.enfants[pos], cle, valeur);
            if(p==null)return null;
            if(n.taille==M){
                return splitInterne(n, p.cle, p.noeud);
            }
            pos=positionPour(n, p.cle);
            insererA(n, pos, p.cle, null, p.noeud);
            return null;
        }
    }

    
    public String recherche(String cle) {
        return rechercheRec(racine,cle);
    }
    
    private String rechercheRec(Noeud n, String cle) {
        if (n.estFeuille){
            int pos=0;
            while(!(n.cles[pos].equals(cle))){
                pos++;
            }
            return n.cles[pos];
        }
        int pos=positionPour(n, cle);
        rechercheRec(n.enfants[pos], cle);
        return "No key on tree";
    }

    private Paire splitFeuille(Noeud n, String cle, String valeur) {
        Noeud droit = new Noeud(true);
        int posMed = M/2;
        int posAjout = positionPour(n, cle);
        int decal = (posAjout <= posMed) ? 0 : 1;

		for (int i = posMed+decal; i < ArbreB.M; i++) {
			droit.cles[i-posMed-decal]=n.cles[i];
			droit.valeurs[i-posMed-decal]=n.valeurs[i];
            droit.taille++;
            n.taille--;
        }
		if(posAjout > posMed) insererA(droit, posAjout-posMed-1, cle, valeur, null);
		else insererA(n, posAjout, cle, valeur, null);

		String medCle=n.cles[n.taille-1];
        Paire paire= new Paire(medCle, droit);
		return paire;
    }

    private Paire splitInterne(Noeud n, String cle, Noeud enfant) {
        Noeud droit = new Noeud(false);

        // position mediane dans le noeud avec un élément en plus
        int posMed = M/2;
        int posAjout = positionPour(n, cle);

        // copie de la partie droite du noeud

        // si on insere à gauche de la position mediane,
        // les elt droit commence à la position mediane ie decal = 0
        int decal = (posAjout <= posMed) ? 0 : 1;
        for(int i = 0; posMed + decal + i < n.taille; i++) 
            insererA(droit, i , n.cles[posMed + decal + i], null, n.enfants[posMed + decal + i + 1]);
        // quand la clé mediane est la clé insérée, le premier enfant droit est l'enfant insérée
        // sinon c'est l'enfant à droite de la clé médiane
        if (posMed == posAjout)
            droit.enfants[0] = enfant;
        else
            droit.enfants[0] = n.enfants[posMed + decal];
        
        n.taille = M/2;
        if (posAjout > posMed)
            insererA(droit, posAjout - posMed - 1, cle, null, enfant);
        else if (posAjout < posMed)
            insererA(n, posAjout, cle, null, enfant);

        String c = (posMed == posAjout) ? cle : n.cles[posMed]; 
        Paire p = new Paire(c, droit);

        return p;
    }

    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(this.racine);
        return b.toString();
    }
    
    public static void main(String[] args) throws Exception {
        //testSimple();
        //testSplitPair();
        //testSplitImpair();
        //testCommunes();
        testTd();
    }

    public static void testTd() {
        
        M=4;
        ArbreB a=new ArbreB();

        a.ajouter("03","allier");
        a.ajouter("36","indre");
        a.ajouter("18","cher");
        a.ajouter("75","paris");
        a.ajouter("39","jura");
        a.ajouter("09","arriege");
        a.ajouter("81","tarn");
        a.ajouter("11","aude");
        a.ajouter("12","aveyron");
        a.ajouter("25","doubs");
        a.ajouter("73","savoie");
        a.ajouter("55","meuse");
        a.ajouter("15","cantal");
        a.ajouter("51","marne");
        a.ajouter("42","loire");
        a.ajouter("40","landes");
        a.ajouter("14","calvados");
        a.ajouter("30","gard");
        a.ajouter("84","vaucluse");
        a.ajouter("07","ardeche");

        System.out.println(a);
    }

    public static void testSplitPair(){

        
        System.out.println("\ncas M pair\n");
        M =4;

		ArbreB a = new ArbreB();
		a.ajouter("a", "arbre");
		a.ajouter("c", "chat");
		a.ajouter("e", "env");
		a.ajouter("g", "golf");
        System.out.println(a);

        a.ajouter("b", "bateau");
        System.out.println(a);

		ArbreB b = new ArbreB();
		b.ajouter("a", "arbre");
		b.ajouter("c", "chat");
		b.ajouter("e", "env");
		b.ajouter("g", "golf");

        b.ajouter("d", "deep");
        System.out.println(b);
        
		ArbreB c = new ArbreB();
		c.ajouter("a", "arbre");
		c.ajouter("c", "chat");
		c.ajouter("e", "env");
		c.ajouter("g", "golf");

        c.ajouter("f", "file");
        System.out.println(c);		
	}

    public static void testSplitImpair(){

        
        System.out.println("\ncas M impair\n");
        M =3;

		ArbreB a = new ArbreB();
		a.ajouter("a", "arbre");
		a.ajouter("c", "chat");
		a.ajouter("e", "env");
        System.out.println(a);

        a.ajouter("b", "bateau");
        System.out.println(a);

		ArbreB b = new ArbreB();
		b.ajouter("a", "arbre");
		b.ajouter("c", "chat");
		b.ajouter("e", "env");

        b.ajouter("d", "deep");
        System.out.println(b);
        
		ArbreB c = new ArbreB();
		c.ajouter("a", "arbre");
		c.ajouter("c", "chat");
		c.ajouter("e", "env");

        c.ajouter("f", "file");
        System.out.println(c);		
	}

    public static ArbreB testSimple() {
        ArbreB a = new ArbreB();

        a.ajouter("e", "eclat");
        System.out.println(a);

        a.ajouter("a", "ajout");
        System.out.println(a);

        a.ajouter("c", "coucou");
        System.out.println(a);

        a.ajouter("b", "bouh");
        System.out.println(a);

        a.ajouter("d", "doudou");
        System.out.println(a);

        a.ajouter("h", "herbe");
        System.out.println(a);

        a.ajouter("i", "iris");
        System.out.println(a);

        a.ajouter("f", "flot");
        System.out.println(a);

        a.ajouter("g", "girafe");
        System.out.println(a);
        return a;
    }

    public static ArbreB testCommunes() throws Exception {
        ArbreB a = new ArbreB();
        File f = new File("communes.txt");
        Scanner sc = new Scanner(f);
        int compteur = 0;
        long t0 = System.currentTimeMillis();

        
        while (sc.hasNext()) {
            // on invente une addresse d'enregistrement pour chaque commune
            a.ajouter(sc.nextLine(), String.format("F1.%s.%s", compteur/1024, compteur%1024));
            compteur++;
        }
        sc.close();

        long t1 = System.currentTimeMillis();
        System.out.println(String.format("temps de construction %s ms", t1 - t0));

        System.out.println(String.format("recherche pour 'Chinon' %s", a.recherche("Chinon")));

        System.out.println(String.format("recherche pour 'Mars' %s", a.recherche("Mars")));
        long t2 = System.currentTimeMillis();
        System.out.println(String.format("temps de recherche %s ms", t2 - t1));

        return a;
    }
}
