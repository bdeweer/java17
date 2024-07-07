package certification.chapter14.part5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IOStreams {

    public static void main(String[] args) throws IOException{

        List<String> strings = Files.readAllLines(Path.of(""));
        Stream<String> lines = Files.lines(Path.of(""));


    }

    void copyStream(InputStream in, OutputStream out) throws IOException {

        int b;
        while((b = in.read()) != -1){
            out.write(b);
        }
    }

    void copyStream(Reader in, Writer out) throws IOException {

        int b;
        while((b = in.read()) != -1){
            out.write(b);
        }
    }

    //low level
    void copyStreamBuffer(InputStream in, OutputStream out) throws IOException {
        int batchSize = 1024;
        var buffer = new byte[batchSize];
        int lengthRead;
        while((lengthRead = in.read(buffer, 0, batchSize)) > 0){
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }


    //high level
    void copyTextFile(File src, File dest) throws IOException{
        try(var reader = new BufferedReader(new FileReader(src))){
            var writer = new BufferedWriter(new FileWriter(dest));
            String line = null;
            while((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
        }
    }

    void copyByteFile(File src, File dest) throws IOException{
        try(var reader = new BufferedInputStream(new FileInputStream(src))){
            var writer = new BufferedOutputStream(new FileOutputStream(dest));
            byte [] line = null;
            while((line = reader.readAllBytes()) != null){
                writer.write(line);
            }
        }
    }

    void copyByteFile2(File src, File dest) throws IOException{
        try(var reader = new BufferedReader(new FileReader(src))){
            var writer = new PrintWriter(new FileWriter(dest));
            String line = null;
            while((line = reader.readLine()) != null){
                writer.println(line);
            }
        }
    }

    void copyByteFile3(File file1, File file2) throws IOException{
        var reader = new InputStreamReader(new FileInputStream(file1));
        try(var writer = new FileWriter(file2)){
            char [] buffer = new char[10];
            while(reader.read(buffer) != -1){ //bad!!
                writer.write(buffer);
            }
        }
    }

    static void copyByteFile4(File file1, File file2) throws IOException {
        var reader = new InputStreamReader(new FileInputStream(file1));
        try(var writer = new FileWriter(file2)){
            char [] buffer = new char[10];
            int read = 0;
            while((read = reader.read(buffer)) != -1){ //good!!
                //     System.out.println(read);
                writer.write(Arrays.copyOfRange(buffer, 0, read));
            }
        }
    }

    //Enhancing with Files class
    private void copyPathAsString(Path input, Path output) throws IOException{
        String string = Files.readString(input);
        Files.writeString(output, string);
    }

    private void copyPathAsBytes(Path input, Path output) throws IOException{
        byte [] bytes = Files.readAllBytes(input);
        Files.write(output, bytes);
    }

    private void copyPathAsLines(Path input, Path output) throws IOException{
        List<String> lines = Files.readAllLines(input);
        Files.write(output, lines);
    }

    private void readLazily(Path path) throws IOException {
        try(Stream<String> s = Files.lines(path)){
            s.forEach(System.out::println);
        }
    }
}