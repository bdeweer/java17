package certification.chapter14.part4;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Part4 {

    public static void main(String[] args) throws IOException {

        //making directory

        //Create directory
        //Files.createDirectory(Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/test"));

        Path created = Files.createDirectories(Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/test/1/2/3")); //create directories
        System.out.println(created);
        //Files.delete(Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/test"));


        //copying files

        //file
        Files.copy(Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt"), Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/test/zoo.txt"), StandardCopyOption.REPLACE_EXISTING);

        //directory

        //shallow copy by default
        Files.copy(
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/"),
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14-back"),
                StandardCopyOption.REPLACE_EXISTING
        );

        //replace if exists
        /*Files.copy(
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt"),
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/test/zoo.txt"),
                StandardCopyOption.REPLACE_EXISTING
        );*/

        //Copying with I/O Streams
        /*try(var is = new FileInputStream("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt")){
            Files.copy(is, Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/test/zoo2.txt"), StandardCopyOption.REPLACE_EXISTING);
        }*/

        /*Files.copy(
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt"),
                System.out
        );*/

        //Copying Files into a Directory
        /*Files.copy(
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt"),
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir/zoo.txt"),
                StandardCopyOption.REPLACE_EXISTING
        );*/

        //Moving or renaming Paths
        /*Files.move(
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14-moved"),
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14")
        );*/

        /*Files.move(
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt"),
                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo-back.txt")
        );*/

        //Deleting a File with delete() and deleteIfExists()

        //Directory must be empty, otherwise throw an Exception
        //Files.delete(Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt"));
        //System.out.println(Files.deleteIfExists(Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt")));


        //Comparing Files with isSameFile() and mismatch()

        //To compare file do not use .equals()

        //follow symbolic links
        System.out.println(
                Files
                        .isSameFile(
                                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir"),
                                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir")
                        )
        );

        //differents files
        System.out.println(
                Files
                        .isSameFile(
                                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir/zoo.txt"),
                                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir2/zoo.txt")
                        )
        );

        //Same => returns -1 then returns the 0 based index of difference : 3 in this case
        System.out.println(
                Files
                        .mismatch(
                                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir/zoo2.txt"),
                                Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/dir2/zoo2.txt")
                        )
        );

    }
}
