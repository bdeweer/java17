package certification.chapter14.part6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part6 {

    public static void main(String[] args) {

        //Mix I/O streams and NIO.2


    }

    private void copyPath(Path input, Path output) throws IOException {

        try(var reader = Files.newBufferedReader(input)){
            var writer = Files.newBufferedWriter(output);

            String line = null;
            while((line=reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
