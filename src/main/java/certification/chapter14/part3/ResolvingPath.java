package certification.chapter14.part3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolvingPath {

    public static void main(String[] args) throws IOException {

        //resolve (concatenation)
        Path p1 = Path.of("/cats/../panther");
        Path p2 = Path.of("food");

        System.out.println(p1.resolve(p2)); // /cats/../panther/food

        Path p3 = Path.of("/turkey/food");
        //You cannot combine two absolute paths using resolve()
        System.out.println(p3.resolve("/tiger/cage")); // /tiger/cage

        //relativizing

        //relativizing path : constructing the relative path from one Path ot another
        //requires both path to be absolute or relative and throws an exception (IllegalArgumentException) if the types are mixed
        //Sur Windows, la lettre du lecteur d'un path absolut doit être la même.

        var p4 = Path.of("fish.txt");
        var p5 = Path.of("friendly/birds.txt");

        System.out.println(p4.relativize(p5)); //../friendly/birds.txt
        System.out.println(p5.relativize(p4)); //../../fish.txt

        //Normalize a path : eliminate unnecessary redundancies in a path

        System.out.println(Path.of("./armadillo/../shells.txt").normalize()); // shells.txt
        System.out.println(Path.of("/cats/../panther/food").normalize()); // /panther/food
        System.out.println(Path.of("../../fish.txt").normalize()); // ../../fish.txt

        var p6 = Paths.get("/pony/../weather.txt");
        var p7 = Paths.get("/weather.txt");
        System.out.println(p6.equals(p7)); //false
        System.out.println(p6.normalize().equals(p7.normalize())); //true

        //Retrieving the real File System Path
        //System.out.println(p6.toRealPath()); //NoSuchFileException

        Path realPath = Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14/zoo.txt");
        System.out.println("Real path : " + realPath.toRealPath());

        //toRealPath follow symbolic link, LinkOption to ignore them

        //Get a Path of the current working directory
        Path current = Paths.get(".").toRealPath();
        System.out.println(current);

    }
}
