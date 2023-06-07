public class App {
    public static void main(String[] args) throws Exception {
        MatriceFraction a=new MatriceFraction(4, 7, 4);
        Fraction[] ligne1={new Fraction(3, 1),
                            new Fraction(2, 1),
                            new Fraction(1, 1),
                            new Fraction(1, 1),
                            new Fraction(0, 1),
                            new Fraction(0, 1),
                            new Fraction(10, 1)};
        Fraction[] ligne2={new Fraction(1, 1),
                            new Fraction(5, 1),
                            new Fraction(-2, 1),
                            new Fraction(0, 1),
                            new Fraction(1, 1),
                            new Fraction(0, 1),
                            new Fraction(8, 1)};
        Fraction[] ligne3={new Fraction(2, 1),
                            new Fraction(3, 1),
                            new Fraction(3, 1),
                            new Fraction(0, 1),
                            new Fraction(0, 1),
                            new Fraction(1, 1),
                            new Fraction(20, 1)};
        Fraction[] ligne4={new Fraction(2, 1),
                            new Fraction(3, 1),
                            new Fraction(7, 1),
                            new Fraction(0, 1),
                            new Fraction(0, 1),
                            new Fraction(0, 1),
                            new Fraction(0, 1)};
        // Fraction[] ligne1={new Fraction(1, 1),
        //     new Fraction(1, 1),
        //     new Fraction(2, 1),
        //     new Fraction(-1, 1),
        //     new Fraction(0, 1),
        //     // new Fraction(0, 1),
        //     new Fraction(10, 1)};
        // Fraction[] ligne2={new Fraction(2, 1),
        //             new Fraction(3, 1),
        //             new Fraction(0, 1),
        //             new Fraction(0, 1),
        //             new Fraction(0, 1),
        //             // new Fraction(0, 1),
        //             new Fraction(7, 1)};
        // // Fraction[] ligne3={new Fraction(2, 1),
        // //             new Fraction(3, 1),
        // //             new Fraction(3, 1),
        // //             new Fraction(0, 1),
        // //             new Fraction(0, 1),
        // //             new Fraction(1, 1),
        // //             new Fraction(20, 1)};
        // Fraction[] ligne4={new Fraction(3, 1),
        //             new Fraction(2, 1),
        //             new Fraction(4, 1),
        //             new Fraction(0, 1),
        //             new Fraction(0, 1),
        //             // new Fraction(0, 1),
        //             new Fraction(0, 1)};
        a.modifLigne(0, ligne1);
        a.modifLigne(1, ligne2);
        a.modifLigne(2, ligne3);
        a.modifLigne(3, ligne4);

        String[] coeffs={"x","y","z","s1","s2","s3"};
        int nbBases=3;

        System.out.println(a.toString());

        a.maximise();
        String[] bases=a.getNomBases(coeffs, nbBases);
        Fraction[] rep=new Fraction[a.nbLignes];
        for(int i=0; i<a.nbLignes; i++){
            rep[i]=a.valeurs[i][a.nbColonnes-1];
        }

        System.out.println(a.toString());

        for(int i=0; i<rep.length-1; i++){
            System.out.println(bases[i]+" = "+rep[i].toString());
        }
        System.out.println("Resultat: "+rep[rep.length-1].toString());
    }
}
