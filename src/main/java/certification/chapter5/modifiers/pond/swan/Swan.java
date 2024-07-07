package certification.chapter5.modifiers.pond.swan;

import certification.chapter5.modifiers.pond.shore.Bird;

public class Swan extends Bird {

    public void swim(){
        //not in the same package but extend it -> access to protected members
        floatInWater();
        System.out.println(text);
    }

    public void helpOtherSwanSwim(){
        Swan other = new Swan();
        //can use protected members of Bird
        //refer to a Swan object (Swam inherits from Bird)
        other.floatInWater();
        System.out.println(other.text);
    }

    public void helpOtherBirdSwim(){
        //Bird is used rather than inheritance
        //Bird is a different package
        //this code isn't inherited from Bird (no access to protected members)
        Bird other = new Bird();
        //other.floatInWater(); //does not compile
        //System.out.println(other.text); //does not compile
    }
}
