package certification.chapter7;

public class Part43 {
}


class ZooGiftShop {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice){
        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }
}


class ZooGiftShop2 {
    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice){

        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }
}


class Gorilla {
    interface Climb {}
    Climb climbing = new Climb(){};
}