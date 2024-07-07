package certification.chapter14;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws IOException {


        var p1 = Path.of("/zoo/./bear", "../food.txt");
        var p2 = Path.of("/lion");
        System.out.println(p1.normalize()); //zoo/food.txt
        System.out.println(p1.normalize().resolve(p2)); //absolute path passed to resolve()

        System.out.println(p1.normalize().relativize(p2)); //affiche le chemin relatif entre /zoo/food.txt et /lien -> ../../lion

        var p3 = Path.of("/zoo/animals/bear/koala/food.txt");
        System.out.println(p3.subpath(1,3).getName(1)); //1 inclus à 3 exclus [animals/bear] //bear

        var p4 = Path.of("/pets/../cat.txt");
        var p5 = Paths.get("./dog.txt");

        System.out.println(p5.resolve(p4)); //resolving absolute path


        System.out.println("------------------------------------------------------------------------------------------");

        new File("a", "b"); //max 2 params
        //new File("a", new File("b")); //second arg can't be a file
        new File(new File("a"), "b");

        System.out.println("------------------------------------------------------------------------------------------");

        var p6 = Path.of("/lizard", ".").resolve(Path.of("walking.txt"));
        System.out.println(p6);
        var p7 = new File("/lizard/././actions/../walking.txt").toPath();
        System.out.println(p7);

        //System.out.println(Files.isSameFile(p6, p7)); //true
        System.out.println(p6.equals(p7)); //check path

        System.out.println("------------------------------------------------------------------------------------------");
        var f = Path.of("monkeys");
        try(var m = Files.find(f, 0, (p,a) -> a.isSymbolicLink())){
            m.map(s -> s.toString()).collect(Collectors.toList()).stream().filter(s -> s.toString().endsWith(".txt")).forEach(System.out::println);
        }

    }
}
