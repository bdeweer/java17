package certification.chapter14.part3;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Part3 {

    public static void main(String[] args) {

        Path p = Path.of("whale");
        Path resolved = p.resolve(p);

        System.out.println(p);
        System.out.println(resolved);

        System.out.println(Path.of("/zoo/../home").getParent().normalize().toAbsolutePath());

        Path path = Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt");
        System.out.println("The Path Name is : " + path);
        System.out.println("The Path FileName is : " + path.getFileName());
        //These methods do not include the root directory as part of the path
        for (int i = 0; i <path.getNameCount() ; i++) {
            System.out.println("   Element " + i + " is : " + path.getName(i));
        }

        System.out.println("subpath(0,3) " + path.subpath(0, 3)); //0 inclusive, 3 exclusive //doesnt include first /
        System.out.println("subpath(1,2) " + path.subpath(1, 2)); //1 inclusive, 2 exclusive
        System.out.println("subpath(1,3) " + path.subpath(1, 3)); //1 inclusive, 3 exclusive

        //System.out.println(path.subpath(0, 39)); // IllegalArgumentException

        var p2 = Path.of("/");
        System.out.println(p2.getNameCount()); //0
        //System.out.println(p2.getName(0)); //IllegalArgumentException

        System.out.println("Filename : " + path.getFileName()); //zoo.txt

        System.out.println("Root is : " + path.getRoot()); // / not Users!! - null for relative path

        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null){
            System.out.println("Current parent is : " + currentParent);
        }
    }
}
