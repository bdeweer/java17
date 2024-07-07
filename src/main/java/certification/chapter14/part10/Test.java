package certification.chapter14.part10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class Test {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("/Users/bertranddeweer/dev/workspace/java17/src/main/java/certification/chapter14/PracticeTest.java");

        //read attributes
        BasicFileAttributes attributes1 = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(attributes1.isDirectory());
        System.out.println(attributes1.isRegularFile());
        System.out.println(attributes1.size());

        //modify attributes
        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attributes = view.readAttributes();

        //Modify last modified time
        FileTime lastModifiedTime = FileTime.fromMillis(attributes.lastModifiedTime().toMillis() + 10_000);
        view.setTimes(lastModifiedTime, null, null);



    }
}
