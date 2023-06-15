public class App {
    public static void main(String[] args) throws Exception {
        String[] coeffs={"x","y","z","s1","s2","s3"};
        int nbBases=3;
        
        int[] line1Int={3, 2, 1, 1, 0, 0, 10};
        int[] line2Int={1, 5,-2, 0, 1, 0,  8};
        int[] line3Int={2, 3, 3, 0, 0, 1, 20};
        int[] line4Int={2, 3, 7, 0, 0, 0,  0};

        int[][] lines={line1Int,line2Int,line3Int,line4Int};

        MatriceFraction b=new MatriceFraction(lines);
        b.maximise();
        System.out.println(b.toString());
    }
}
