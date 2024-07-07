package certification.chapter10.part11;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class Part11 {

    public static void main(String[] args) {
    }

    public void good() throws IOException {
        ExceptionCaseStudy.create().stream().count();
    }

    public void bad() throws IOException {
        //Supplier<List<String>> s = ExceptionCaseStudy::create;
        Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;
    }

    public void ugly(){
        Supplier<List<String>> s = () -> {
            try {
                return ExceptionCaseStudy.create();
            }catch(IOException e){
                throw new RuntimeException();
            }
        };
    }

    private class ExceptionCaseStudy {

        private static List<String> create() throws IOException {
            throw new IOException();
        }

        private static List<String> createSafe()  {
            try {
                return create();
            }catch(IOException e){
                throw new RuntimeException();
            }
        }
    }
}
