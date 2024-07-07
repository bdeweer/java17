package certification.chapter14.part11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {


        Path p1 = Paths.get("/home");
        Path p2 = Paths.get("");

        System.out.println(p1.resolve(p2));
    }
}

class Roller<E extends Wheel>{}
class Wheel {}
class CartWheel extends Wheel {}

class RollingContest {

    Roller<? super Wheel> a = new Roller<Wheel>();
}

