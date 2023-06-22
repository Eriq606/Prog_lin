public class App {
    public static void main(String[] args) throws Exception {
        String[] coeffs={"t1","t2", "t3","s1","s2", "A1", "A2"};
        
        int[] line1Int={  2,  1,  0, -1,  0, 1, 0, 40};
        int[] line2Int={  1,  2,  1,  0, -1, 0, 1, 50};
        // int[] line3Int={  2,   8,  0,  0, 1, 0, 0, 80};
        int[] line4Int={ -3, -3, -1,  1,  1, 0, 0, -90};

        int[][] lines={line1Int,line2Int, line4Int};

        MatriceFraction b=new MatriceFraction(lines, coeffs);
        int[] base={5, 6};
        b.setBases(base);
        System.out.println(b.toString());
        b.minimise();

        String[] bases=b.getNomBases();
        for(int i=0; i<bases.length; i++){
            System.out.println(bases[i]+" = "+b.getValeurs()[i][b.getNbColonnes()-1]);
        }
        System.out.println("====================");
        System.out.println();
        // DEUXIEME PHASE
        String[] coeffs2={"t1","t2", "t3", "s1","s2"};
        // int nbBases2=3;
        
        int[] line1Int2={  2,  1,  0, -1,  0, 10};
        int[] line2Int2={  1,  2,  1,  0, -1, 20};
        // int[] line3Int={  2,   8,  0,  0, 1, 0, 0, 80};
        int[] line4Int2={ 0,  0, 100, 300, 200, -22000};

        int[][] lines2={line1Int2,line2Int2, line4Int2};

        MatriceFraction b2=new MatriceFraction(lines2, coeffs2);
        int[] base2={0, 1};
        b2.setBases(base2);
        System.out.println(b2.toString());
        b2.minimise();
        // System.out.println(b2.toString());

        String[] bases2=b2.getNomBases();
        for(int i=0; i<bases2.length; i++){
            System.out.println(bases2[i]+" = "+b2.getValeurs()[i][b2.getNbColonnes()-1]);
        }
        System.out.println("====================");
        System.out.println();



        // DEUXIEME PHASE
        /*String[] coeffs2={"x1","x2","s1","s2","s3"};
        int nbBases2=3;
        
        int[] line1Int2={  1,  2, 1,  0, 0, 700};
        int[] line2Int2={  2,  1, 0,  1, 0, 800};
        int[] line3Int2={  0,  1, 0,  0, 1, 300};
        int[] line4Int2={ -40, -50, 0,  0, 0,   0};

        int[][] lines2={line1Int2,line2Int2,line3Int2, line4Int2};

        MatriceFraction b2=new MatriceFraction(lines2, coeffs2);
        int[] base2={2, 3, 4};
        b2.setBases(base2);
        System.out.println(b2.toString());
        b2.minimise();
        System.out.println(b2.toString());

        String[] bases2=b2.getNomBases();
        for(int i=0; i<bases2.length; i++){
            System.out.println(bases2[i]+" = "+b2.getValeurs()[i][b2.getNbColonnes()-1]);
        }*/
    }
}
