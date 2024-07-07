package certification.chapter4;

public class Part10 {

    public static void main(String[] args) {

        int [][] vars1; //2D array
        int vars2 [][]; //2D arrays
        int [] vars3 []; //2D arrays
        int [] vars4 [], space [][]; //2D and 3D array

        String [][] rectangle = new String[3][2];

        rectangle[0][1] = "set";

        int [][] differentSizes = {{1,4},{3},{9,8,7}};

        //int [][] argz = new int [][]; //does not compile
        //int [][] argz = new int [][4]; //does not compile
        int [][] argz = new int [4][];
        argz[0] = new int[5];
        argz[1] = new int[3];

        var twoD = new int[3][2];
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                System.out.print(twoD[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //same :
        for(int [] inner : twoD) {
            for (int num : inner)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
