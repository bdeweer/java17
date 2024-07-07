package certification.chapter14.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {

    public static void main(String[] args) throws IOException {

        Path dirPath2 = Path.of("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir/");
        if(Files.isDirectory(dirPath2)){
            Files.delete(dirPath2);
        }
    }
}