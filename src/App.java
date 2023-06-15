public class App {
    public static void main(String[] args) throws Exception {
        String[] coeffs={"x","y","s1","s2","s3"};
        int nbBases=3;
        
        int[] line1Int={1, 2, 1, 0, 0, 700};
        int[] line2Int={2, 1, 0, 1, 0, 800};
        int[] line3Int={0, 1, 0, 0, 1, 300};
        int[] line4Int={40, 50, 0, 0, 0,  0};

        int[][] lines={line1Int,line2Int,line3Int, line4Int};

        MatriceFraction b=new MatriceFraction(lines);
        b.maximise();
        System.out.println(b.toString());

        String[] bases=b.getNomBases(coeffs, nbBases);
        for(int i=0; i<bases.length; i++){
            System.out.println(bases[i]+" = "+b.getValeurs()[i][b.getNbColonnes()-1]);
        }
    }
}
