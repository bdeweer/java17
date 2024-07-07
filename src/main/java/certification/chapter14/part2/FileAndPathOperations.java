package certification.chapter14.part2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileAndPathOperations {

    public static void main(String[] args) {

        File directory = new File("/Users/bertranddeweer/dev/workspace/java17/src/main/java/certification/chapter14/");
        File file = new File(directory, "Test.java");

        System.out.println(directory.getName());
        System.out.println(directory.getParent());

        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.isAbsolute());
        //file.delete();
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.lastModified());
        System.out.println(file.length());

        file.getParentFile().listFiles();

        //file.mkdir(); //Create directory
        //file.mkdirs(); //Create directory including any nonexistent parent directories
        //file.renameTo(new File("dest"); //Renames file / directory denoted

        System.out.println("----------------------------------------------------------");

        Path path = Path.of("/Users/bertranddeweer/dev/workspace/java17/src/main/java/certification/chapter14/PracticeTest.java");

        Path dirPath = Path.of("/Users/bertranddeweer/dev/workspace/java17/src/main/java/certification/chapter14");

        try {

            System.out.println(path.getFileName());
            System.out.println(path.getParent());
            System.out.println(path.isAbsolute());
            System.out.println(path.toAbsolutePath());

            Files.deleteIfExists(path);
            Files.exists(path);
            Files.isDirectory(path);
            Files.isRegularFile(path);
            Files.getLastModifiedTime(path);
            Files.size(path); //IOException
            Files.list(dirPath); //IOException
            //Files.createDirectory(Path.of("test"));
            //Files.createDirectories(Path.of("test"));
            //Files.move(Path.of("src"), Path.of("dest"));

        }catch(IOException e){  }

        io();
        nio();
    }

    public static void io(){
        var file = new File("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt");
        //var file = new File("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/");
        if(file.exists()){
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is directory : " + file.isDirectory());
            System.out.println("Parent path : " + file.getParent());
            if(file.isFile()){
                System.out.println("Size : " + file.length());
                System.out.println("Last modified : " + file.lastModified());
            }
            else {
                for(File f : file.listFiles()){
                    System.out.println("  " + f.getName());
                }
            }
        }
    }

    public static void nio(){
        try {

            var path = Path.of("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/");
            if(Files.exists(path)){
                System.out.println("Absolute Path: " + path.toAbsolutePath());
                System.out.println("Is directory : " + Files.isDirectory(path));
                System.out.println("Parent path : " + path.getParent());
                if(Files.isRegularFile(path)){
                    System.out.println("Size : " + Files.size(path)); //throw IOException
                    System.out.println("Last modified : " + Files.getLastModifiedTime(path)); //throw IOException
                }
                else {
                    try(Stream<Path> stream = Files.list(path)){ //Throw IOException - The stream must be properly closed
                        stream.forEach(p -> System.out.println("   " + p.getFileName()));
                    }
                }
            }
        }catch(IOException e){

            RuntimeException r;
        }
    }
}