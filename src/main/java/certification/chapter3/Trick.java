package certification.chapter3;

import java.time.DayOfWeek;

public class Trick {

    public static void main(String[] args) {

        //2
        {
            int temperature = 4;
            long humidity = -temperature + temperature * 3;
            if (temperature >= 4)
                if (humidity < 6)
                    System.out.println("Too low");
                else
                    System.out.println("Just Right");
            else
                System.out.println("Too high");
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //7
        {
            int[] weather = {1, 2, 3};
            for (int i = 0; ++i < 10 && i < weather.length; ) {
                System.out.println(weather[i]);
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //9
        {
            int count = 0;
            BUNNY:
            for (int row = 1; row <= 3; row++)
                RABBIT:for (int col = 0; col < 3; col++) {
                    if ((col + row) % 2 == 0)
                        continue;
                    count++;
                }
            System.out.println(count);
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //10


        //16
        {
            char[] wolf = {'W', 'e', 'b', 'b', 'y'};

            //A
            int q = wolf.length;
            for (; ; ) {
                System.out.print(wolf[--q]);
                if (q == 0) break;
            }
            System.out.println();

            //B
            for (int m = wolf.length - 1; m >= 0; --m) {
                System.out.print(wolf[m]);
            }

            System.out.println();

            //C
            int x = wolf.length - 1;
            for (int j = 0; x >= 0 && j == 0; x--) {
                System.out.print(wolf[x]);
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //17
        {
            int participants = 4, animals = 2, performers = -1;
            while ((participants = participants + 1) < 10) {

            }

            do {
            } while (animals++ <= 1);

            for (; performers < 2; performers += 2) {

            }

            System.out.println(participants);
            System.out.println(performers);
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //20
        {
            int height = 1;
            L1:
            while (height++ < 10) {
                long humidity = 12;

                L2:
                do {
                    if (humidity-- % 12 == 0)
                        break L2;
                    int temperature = 30;
                    L3:
                    for (; ; ) {
                        temperature++;
                        if (temperature > 50)
                            continue L2;
                    }
                } while (humidity > 4);
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        var tailFeathers = 3;
        final var one = 1;
        switch (tailFeathers) {
            case one:
                System.out.println(3 + "");
            default:
            case 3:
                System.out.println(5 + "");
        }
        while(tailFeathers>1){
            System.out.println(--tailFeathers + "");
        }

        System.out.println("-----------------------------------------------------------------------------------------");

        //29
        {
            int y = -2;
            do
                System.out.print(++y + " ");
            while (y <= 5);
        }
    }

    private DayOfWeek getWeekDay(int day, final int thursday) {
        int otherDay = day;
        int Sunday = 0;
        switch (otherDay) {
            default:
                // case 1 : continue; //does not compile
                // case thursday: return DayOfWeek.THURSDAY; //does not compile
            case 2, 10:
                break;
            // case Sunday : return DayOfWeek.SUNDAY; //does not compile
            // case DayOfWeek.MONDAY : return DayOfWeek.MONDAY; //does not compile
        }
        return DayOfWeek.THURSDAY;
    }

    private void getFish(Object fish){
        if(!(fish instanceof String guppy))
            System.out.println("Eat!");
        //else if(!(fish instanceof String guppy)){ // does not compile

      //  }
    }
}

