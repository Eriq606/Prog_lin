import java.util.LinkedList;

public class MatriceFraction {
    Fraction[][] valeurs;
    int nbLignes,nbColonnes,nbCoeff;
    
    public MatriceFraction(int nbLignes, int nbColonnes, int nbC) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbCoeff=nbC;
        setValeurs(new Fraction[nbLignes][nbColonnes]);
    }
    public Fraction[][] getValeurs() {
        return valeurs;
    }
    public void setValeurs(Fraction[][] valeurs) {
        this.valeurs = valeurs;
    }
    public int getNbLignes() {
        return nbLignes;
    }
    public void setNbLignes(int nbLignes) {
        this.nbLignes = nbLignes;
    }
    public int getNbColonnes() {
        return nbColonnes;
    }
    public void setNbColonnes(int nbColonnes) {
        this.nbColonnes = nbColonnes;
    }
    public int getNbCoeff() {
        return nbCoeff;
    }
    public void setNbCoeff(int nbCoeff) {
        this.nbCoeff = nbCoeff;
    }
    
    public void modifLigne(int numLigne, Fraction[] nouvelle){
        valeurs[numLigne]=nouvelle;
    }
    public void modifColonne(int numColonne, Fraction[] nouvelle){
        for(int i=0;i<nbLignes;i++){
            valeurs[i][numColonne]=nouvelle[i];
        }
    }
    public String toString(){
        String display="";
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                display+=valeurs[i][j].toString()+" ";
            }
            display+="\n";
        }
        return display;
    }
    public void gauss(int pivot_ligne, int pivot_colonne){
        for(int i=pivot_ligne+1; i<nbLignes; i++){
            Fraction val_annule=valeurs[i][pivot_colonne];
            for(int j=0; j<nbColonnes; j++){
                valeurs[i][j]=valeurs[i][j].addition(new Fraction(-1, 1).multiply(val_annule).multiply(valeurs[pivot_ligne][j]).divide(valeurs[pivot_ligne][pivot_colonne]));
                valeurs[i][j].simplify();
            }
        }
    }
    public void gauss_jordan(int pivot_ligne, int pivot_colonne){
        for(int i=0; i<nbLignes; i++){
            if(i==pivot_ligne){
                continue;
            }
            Fraction val_annule=valeurs[i][pivot_colonne];
            for(int j=0; j<nbColonnes; j++){
                valeurs[i][j]=valeurs[i][j].addition(new Fraction(-1, 1).multiply(val_annule).multiply(valeurs[pivot_ligne][j]).divide(valeurs[pivot_ligne][pivot_colonne]));
                valeurs[i][j].simplify();
            }
        }
    }
    public int getMaxOnLigne(int numLigne){
        int max=0;
        for(int i=1; i<nbColonnes; i++){
            if(valeurs[numLigne][i].getValue()>valeurs[numLigne][max].getValue()){
                max=i;
            }
        }
        return max;
    }
    public int getMinOnLigne(int numLigne){
        int min=0;
        for(int i=1; i<nbColonnes; i++){
            if(valeurs[numLigne][i].getValue()<valeurs[numLigne][min].getValue()){
                min=i;
            }
        }
        return min;
    }
    public int getLigneOptimale(int numColonne){
        int minLigne=0;
        Fraction min,div;
        for(int i=1; i<nbLignes-1; i++){
            div=valeurs[i][nbColonnes-1].divide(valeurs[i][numColonne]);
            min=valeurs[minLigne][nbColonnes-1].divide(valeurs[minLigne][numColonne]);
            if(div.getValue()<min.getValue()&&div.getValue()>0){
                minLigne=i;
            }
        }
        return minLigne;
    }
    public void simplify(int numLigne, int numColonne){
        Fraction pivot=new Fraction(valeurs[numLigne][numColonne].numerateur, valeurs[numLigne][numColonne].denominateur);
        for(int i=0; i<nbColonnes; i++){
            valeurs[numLigne][i]=valeurs[numLigne][i].divide(pivot);
            valeurs[numLigne][i].simplify();
        }
    }
    public void optimise(int optLigne, int optColonne){
        simplify(optLigne, optColonne);
        gauss_jordan(optLigne, optColonne);
    }
    public void maximise(){
        int optColonne=getMaxOnLigne(nbLignes-1);
        double val=valeurs[nbLignes-1][optColonne].getValue();
        if(val>0){
            int optLigne=getLigneOptimale(optColonne);
            optimise(optLigne, optColonne);
            maximise();
        }
    }
    public void minimise(){
        int optColonne=getMinOnLigne(nbLignes-1);
        double val=valeurs[nbLignes-1][optColonne].getValue();
        if(val<0){
            int optLigne=getLigneOptimale(optColonne);
            optimise(optLigne, optColonne);
            maximise();
        }
    }
    public int[] getIndicesNuls(int nbBase){
        int[] indices=new int[nbBase];
        int indice=0;
        for(int i=0; i<getNbColonnes(); i++){
            if(getValeurs()[getNbLignes()-1][i].numerateur==0){
                indices[indice]=i;
                indice++;
            }
        }
        return indices;
    }
    public String[] getNomBases(String[] coeffs, int nbBase){
        int[] indices=getIndicesNuls(nbBase);
        String[] bases=new String[nbBase];
        for(int i=0; i<nbBase; i++){
            bases[i]=coeffs[indices[i]];
        }
        return bases;
    }
}
