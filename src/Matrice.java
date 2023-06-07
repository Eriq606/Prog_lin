public class Matrice {
    double[][] valeurs;
    int nbLignes,nbColonnes;
    public double[][] getValeurs() {
        return valeurs;
    }
    public void setValeurs(double[][] valeurs) {
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
    public Matrice(int nbL, int nbC){
        setNbLignes(nbL);
        setNbColonnes(nbC);
        setValeurs(new double[getNbLignes()][getNbColonnes()]);
    }
    public void modifLigne(int numLigne, double[] nouvelle){
        valeurs[numLigne]=nouvelle;
    }
    public void modifColonne(int numColonne, double[] nouvelle){
        for(int i=0;i<nbLignes;i++){
            valeurs[i][numColonne]=nouvelle[i];
        }
    }
    public String toString(){
        String display="";
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                display+=valeurs[i][j]+" ";
            }
            display+="\n";
        }
        return display;
    }
    public void gauss(int pivot_ligne, int pivot_colonne){
        for(int i=pivot_ligne+1; i<nbLignes; i++){
            double val_annule=valeurs[i][pivot_colonne];
            for(int j=0; j<nbColonnes; j++){
                valeurs[i][j]=valeurs[i][j]+(-val_annule*valeurs[pivot_ligne][j]/valeurs[pivot_ligne][pivot_colonne]);
            }
        }
    }
    public void gauss_jordan(int pivot_ligne, int pivot_colonne){
        for(int i=0; i<nbLignes; i++){
            if(i==pivot_ligne){
                continue;
            }
            double val_annule=valeurs[i][pivot_colonne];
            for(int j=0; j<nbColonnes; j++){
                valeurs[i][j]=valeurs[i][j]+(-val_annule*valeurs[pivot_ligne][j]/valeurs[pivot_ligne][pivot_colonne]);
            }
        }
    }
    public double getMaxOnLigne(int numLigne){
        double max=valeurs[numLigne][0];
        for(int i=1; i<nbColonnes; i++){
            if(valeurs[numLigne][i]>max){
                max=valeurs[numLigne][i];
            }
        }
        return max;
    }
}
