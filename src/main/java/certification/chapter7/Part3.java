package certification.chapter7;

public class Part3 {
}


interface HasTail {
    public int getTailLength();
}

interface HasWhiskers {
    public int getNumberOfWhiskers();
}

abstract class HarborSeal implements HasTail, HasWhiskers{

}

class CommonSeal extends HarborSeal {

    @Override
    public int getTailLength() {
        return 0;
    }

    @Override
    public int getNumberOfWhiskers() {
        return 0;
    }
}