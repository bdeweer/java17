package certification.chapter7;

public class Part21 {
}

enum Season4 {

    WINTER {
        @Override
        public String getHours() {
            return "10am-3pm";
        }
    }, SUMMER{
        @Override
        public String getHours() {
            return "9am-7pm";
        }
    }, SPRING{
        @Override
        public String getHours() {
            return super.getHours();
        }
    }, FALL;

    public String getHours(){
        return "9am-5pm";
    }
}
