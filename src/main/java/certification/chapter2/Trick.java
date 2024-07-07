package certification.chapter2;

public class Trick {

    public static void main(String[] args) {

        int myFavoriteNumber = 8;
        int bird = ~myFavoriteNumber; //-9
        int plane = -myFavoriteNumber; //-8
        var superman = bird == plane ? 5 : 10; //10
        System.out.println(bird + "," + plane + ","+ --superman); //-9, -8, 9


        int i = 8;
        int j = ~i;
        int k = -i;
        int l = i == j ? 5 : 10;

        System.out.println(i + " - " + j + " " + k + " - " + l);

    }
}

class TestPart2 {

    public static void main(String[] args) {

        boolean v1 = true;
        boolean v2 = false;
        Boolean v3 = Boolean.FALSE;

        System.out.println(v1==v2);

        System.out.println(v3);

        System.out.println(3+2-4);




    }
}
