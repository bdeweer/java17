package certification.chapter11.bundle;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {

        var props = new Properties();
        props.setProperty("name", "Our zoo");
        props.setProperty("open", "10am");

        System.out.println(props.getProperty("camel"));
        System.out.println(props.getProperty("camel", "Bob"));

        System.out.println(props.get("open"));
        //props.get("open", "soon"); //doesnt compile

    }
}
