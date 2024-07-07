package certification.chapter3;

public class Part8 {

    public static void main(String[] args) {

        {
            int [][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
            for(int [] mySimpleArray : myComplexArray){
                for (int i = 0; i < mySimpleArray.length; i++) {
                    System.out.print(mySimpleArray[i] + "\t");
                }
                System.out.println();
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int hungryHippopotamus = 8;
            while(hungryHippopotamus>0){
                do{
                    hungryHippopotamus -= 2;
                }while(hungryHippopotamus>5);
                hungryHippopotamus--;
                System.out.print(hungryHippopotamus + ", "); //3, 0
            }
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int [][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
            OUTER_LOOP: for(int [] mySimpleArray : myComplexArray){
                INNER_LOOP: for (int i = 0; i < mySimpleArray.length; i++) {
                    System.out.print(mySimpleArray[i] + "\t");
                }
                System.out.println();
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        {
            int [][] list = {{1,13},{5,2},{2,2}};
            int searchValue = 2;
            int positionX = -1;
            int positionY = -1;

            PARENT_LOOP:
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list[i].length; j++) {
                    if(list[i][j]==searchValue){
                        positionX = i;
                        positionY = j;
                        break PARENT_LOOP;
                    }
                }
            }
            if(positionX == -1 || positionY == -1){
                System.out.println("Value " + searchValue + " not found");
            }
            else {
                System.out.println("Value " + searchValue + " found at: " + "("+positionX+","+positionY+")");
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            CLEANING:
            for (char stables = 'a'; stables <='d' ; stables++) {
                for(int leopard = 1; leopard<4;leopard++){
                    if(stables=='b' || leopard==2){
                        //continue CLEANING;
                        //continue;
                    }
                    System.out.println("Cleaning:"+stables+","+leopard);
                }
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int checkDate = 0;
            while(checkDate<10){
                checkDate++;
                if(checkDate>100){

                    break;
                    //checkDate++; //unreachable code
                }
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        {
            int minute = 1;
            WATCH: while(minute>2){
                if(minute++>2){
                    continue WATCH;
                    //System.out.println(minute); //unreachable code
                }
            }

            int hour = 2;
            switch (hour){
                case 1 :
                    return;
                    //hour++; //unreachable code
                case 2:
            }
        }
    }
}
