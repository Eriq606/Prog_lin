public class Fraction {
    int numerateur, denominateur;
    public Fraction(){
    }
    public Fraction(int num, int den){
        setNumerateur(num);
        setDenominateur(den);
    }
    public int getNumerateur() {
        return numerateur;
    }

    public void setNumerateur(int numerateur) {
        this.numerateur = numerateur;
    }

    public int getDenominateur() {
        return denominateur;
    }

    public void setDenominateur(int denominateur) {
        this.denominateur = denominateur;
    }

    public String toString(){
        String display=numerateur+"/"+denominateur;
        return display;
    }
    public double getValue(){
        return getNumerateur()/getDenominateur();
    }
    public Fraction addition(Fraction f){
        int nouveau_num=getNumerateur()*f.getDenominateur()+f.getNumerateur()*getDenominateur();
        int nouveau_den=getDenominateur()*f.getDenominateur();
        return new Fraction(nouveau_num, nouveau_den);
    }
    public Fraction multiply(Fraction f){
        Fraction fract=new Fraction(getNumerateur()*f.getNumerateur(), getDenominateur()*f.getDenominateur());
        return fract;
    }
    public Fraction divide(Fraction f){
        Fraction fract=new Fraction(getNumerateur()*f.getDenominateur(), getDenominateur()*f.getNumerateur());
        return fract;
    }
    public void simplify(){
        double num_p=numerateur;
        double den_p=denominateur;
        int min=(int)num_p;
        if(num_p>=den_p){
            min=(int)den_p;
        }
        for(int i=min; i>=2; i--){
            int num_div=numerateur/i;
            int den_div=denominateur/i;

            double num_pdiv=num_p/i;
            double den_pdiv=den_p/i;

            double num_val=num_pdiv-num_div;
            double den_val=den_pdiv-den_div;

            if(num_val==0&&den_val==0){
                numerateur=num_div;
                denominateur=den_div;
            }
        }
    }
}
