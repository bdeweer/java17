package tests.chapter6;

import java.util.*;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;

public class Test {

    public static void main(String[] args) {

        //9
        Stream.of(1,2,3).parallel().sequential();

        IntConsumer intConsumer;
        LongSupplier longSupplier;

        BooleanSupplier booleanSupplier;

        IntSupplier intSupplier;
        Function function;

        Supplier supplier;
        DoubleConsumer doubleConsumer;

        UnaryOperator unaryOperator;
        Consumer consumer;

        BinaryOperator binaryOperator;
        BiFunction biFunction;

        BiPredicate biPredicate;
        BiConsumer biConsumer;

        Predicate predicate;

        Comparator comparator;
        Comparable comparable;

        Stream<Integer> stream = List.of(1,2,3).parallelStream();
        stream.sequential();

        //Not generic!
        IntUnaryOperator intUnaryOperator;
        DoubleUnaryOperator doubleUnaryOperator;
        LongUnaryOperator longUnaryOperator;

        IntBinaryOperator intBinaryOperator;
        DoubleBinaryOperator doubleBinaryOperator;
        LongBinaryOperator longBinaryOperator;

        DoubleFunction<Integer> doubleFunction;
        ToDoubleFunction toDoubleFunction;

        //10
        var odds = IntStream.iterate(1, a -> a + 2);
        var evens = IntStream.iterate(2, a -> a + 2);
        var sum = IntStream.concat(odds, evens).limit(3).sum();
        System.out.println(sum);

        //12
        var empty = Optional.empty();
        System.out.println(empty.isPresent()); //false (empty optional)

        //var param = Optional.of(null); //NPE
       // System.out.println(param.isPresent());

        var methods = Optional.ofNullable(null);
        System.out.println(methods.isPresent()); //false (empty optional)

        //13
        DoubleSupplier doubleSupplier = () -> {
            Double d = 4.0;
            return d;
        };

         Double dr = doubleSupplier.getAsDouble();
       // System.out.println(dr);

        Supplier<Double> supplier1 = () -> {
            double i = 3.0d;
            return i;

        };

        Double aDouble = supplier1.get(); //implicit autoboxing


        //15
        var stream15 = Stream.of(1,2,3);
        System.out.println(stream15.findAny());

        //20
        ToDoubleBiFunction toDoubleBiFunction;

        //22
        Function<Integer, ArrayList> arrayListFunction = n -> new ArrayList<>(n);
        Function<Integer, ArrayList> arrayListFunction2 = ArrayList::new;

        IntFunction<Double> c;

        //23
        OptionalDouble optionalDouble1 = DoubleStream.of(1.0d, 2.0d, 3.0d).average();
        System.out.println(optionalDouble1);

        long count = DoubleStream.of(1.0d, 2.0d, 3.0d).count();
        System.out.println(count);

        OptionalDouble max = DoubleStream.of(1.0d, 2.0d, 3.0d).max();
        System.out.println(max);

        double sum2 = DoubleStream.of(1.0d, 2.0d, 3.0d).sum();
        System.out.println(sum2);

        //27
        Map<Integer, List<String>> collect27 = Stream
                .of("1", "2222", "33", "2")
                .collect(
                        Collectors.groupingBy(String::length)
                );
        System.out.println(collect27);

        Map<Boolean, Set<String>> collect27bis =
                Stream
                        .of("1", "2222", "33", "2", "")
                        .collect(
                                Collectors.groupingBy(
                                        String::isEmpty,
                                        //Collectors.toCollection(HashSet::new)
                                        Collectors.toSet()
                                )
                        )
                ;

        System.out.println(collect27bis);

        //28
        Set<String> set = new HashSet<>();
        set.add("tire-");
        List<String> list = new LinkedList<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.push("wheel-");
        Stream
                .of(set, list, queue)
                //.flatMap(s -> s.s) //DNC : flatMap works with streams rather than collections
                //.flatMap(s -> s.stream())
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        //54
        var s54 = Stream.of("speak", "bark", "meow", "growl");
        BinaryOperator<String> merge = (a,b) -> a; //the merge function says to use the first one
        var map54 = s54.collect(Collectors.toMap(String::length, k -> k, merge));
        System.out.println(map54);
        System.out.println(map54.size() + " " + map54.get(4));

        //56
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        Stream<Integer> streamInt = intStream.boxed().parallel();

        //57
        var stream57 = Stream.iterate(1, i -> i + 1);
        var b57 = stream57.anyMatch(i -> i > 5);
        System.out.println(b57);

        //63
        BiFunction<String, Integer, Character> biFunction63 = String::charAt;

        //69
        var data69 = List.of(1,2,3);
        int f69 = data69.parallelStream().reduce(1, (a,b) -> a+b, (a,b) -> a+b);
        System.out.println(f69);

        //70
        var s70 = IntStream.empty();
        s70.average().ifPresent(System.out::println);

        var s70bis = IntStream.of(-1, 0, 1);
        System.out.println(s70bis.average().getAsDouble());

        //73
        IntSupplier intSupplier73 = () -> {return 1/0;};

        //79
        var p = List.of(new StringBuilder("hello"), new StringBuilder("goodbye"));
        var q =
                p
                        .parallelStream()
                        .reduce(0,  (x,y) -> x + y.length(), Integer::sum);

        //var q2 = p.parallelStream().reduce(0, (w,x) -> w + x.length(), (y, z) -> y.length() + z+length() );
        System.out.println(q);

        //80
        var bools = Stream.of(Boolean.TRUE, null);
        var map =
                bools
                        .limit(1) //remove it -> NPE
                        .collect(Collectors.partitioningBy(b -> b));
        System.out.println(map);

        //81
        var apples = List.of(1,2);
        var oranges = List.of(1,2);

        System.out.println(
                Stream
                        .of(1,2,1,2)
                        .flatMapToInt(IntStream::of)
                        .peek(System.out::print)
                        .count()
        );

        System.out.println(
                Stream
                        .of(apples, oranges)
                        .flatMap(List::stream)
                        .peek(System.out::print)
                        .count()
        );

        //84
        IntSummaryStatistics stats = Stream.of(20,40).mapToInt(a -> a).summaryStatistics();
        System.out.println(stats);

        //86
        System.out.println(IntStream.of(1,2).reduce(0, Integer::sum));
        System.out.println(IntStream.of(1,2).sum());
        System.out.println(Stream.of(1,2).reduce(0, Integer::sum));
        //System.out.println(Stream.of(1,2).sum());

        //87
         Stream
                .generate(() -> 'a')
                //.filter(c -> c < 'b')
                //.sorted()
                .findFirst();
                //.ifPresent(System.out::println);

        //91
        var r = new Random();
        var data = Stream.generate(() -> String.valueOf(r.nextInt()))
                .limit(50_000)
                .collect(Collectors.toSet());
        //var map91 = data.stream().collect(Collectors.groupingBy(String::length)); //serial
        var map91 = data.parallelStream().collect(Collectors.groupingByConcurrent(String::length));


        //92
        Stream.of("one", "two", "bloat")
                .limit(1)
                .map(String::toUpperCase)
                .sorted().forEach(System.out::println);

        //96
        var s = Stream.of("over the river", "through the woods", "to grandmother's house we go");
        s.filter(n -> n.startsWith("t"))
                .sorted(Comparator.reverseOrder())
                //.sorted(Comparator::reverseOrder)
                .findFirst()
                .ifPresent(System.out::println);

        //97
        LongStream.of(9).mapToDouble(p97 -> p97 ).forEach(System.out::println); //9.0
        LongStream.of(9).mapToInt(p97bis -> (int)p97bis ).forEach(System.out::println);

        //100
        var s100 = "fish";
        //Predicate<String> pred = (a) -> s100.contains(a);
        BiPredicate<String, String> pred = (a, b) -> s100.contains(a);
        System.out.println(pred.test("fish", "is"));

        shareToys();



        //109
        System.out.println(Stream.of(new Dog("Yanka"), new Dog("Jiro")).findFirst().get());

        //111
        Stream<Integer> s1 = Stream.of(8,2);
        Stream<Integer> s2 = Stream.of(10,20);
        s2 = s1.filter(n -> n>4); //stream de 8
        s1 = s2.filter(n -> n<1); //empty stream
        System.out.println(s1.count()); //0
        //System.out.println(s2.count()); //1

        //114
        DoubleToLongFunction doubleToLongFunction1 = a -> null==null ? 1 : 2L;
        DoubleToLongFunction doubleToLongFunction2 = e -> (int)(10.0*e);
        DoubleToLongFunction doubleToLongFunction3 = (double m) -> {long p2 = (long)m; return p2;};
        //DoubleToLongFunction doubleToLongFunction4 = (Double ss) -> ss.longValue();

        //116
        Stream.of("eeny", "meeny", "miny", "moe")
                .collect(Collectors.partitioningBy(x -> x.charAt(0) == 'e'))
                .get(false)
                .stream()
                .collect(Collectors.groupingBy(String::length))
                .get(4)
                .forEach(System.out::println);

        Stream.of("eeny", "meeny", "miny", "moe")
                .filter(x -> x.charAt(0) != 'e')
                .collect(Collectors.groupingBy(String::length))
                .get(4)
                .forEach(System.out::println);

        /*Stream.of("eeny", "meeny", "miny", "moe")
                .collect(Collectors.groupingBy(x -> x.charAt(0) == 'e'))
                .get(false)
                .stream()
                .collect(Collectors.partitioningBy(x -> x.length()>3))
                .get(4)
                .forEach(System.out::println);*/

        Stream.of("eeny", "meeny", "miny", "moe")
                .collect(Collectors.groupingBy(x -> x.charAt(0) == 'e'))
                .get(false)
                .stream()
                .collect(Collectors.groupingBy(String::length))
                .get(4)
                .forEach(System.out::println);

        Stream.of("eeny", "meeny", "miny", "moe")
                .collect(Collectors.partitioningBy(x -> x.charAt(0) == 'e'))
                .get(false)
                .stream()
                .collect(Collectors.partitioningBy(x -> x.length() ==4))
                .get(true)
                .forEach(System.out::println);

        //138
        Set<String> set138 = new HashSet<>();
        set138.add("tire-");
        List<String> list138 = new LinkedList<>();
        Deque<String> queue138 = new ArrayDeque<>();
        queue138.push("wheel-");
        Stream.of(set138, list138, queue138)
                .flatMap(x -> x.stream())
                .forEach(System.out::print);
        System.out.println("");


        //142
        var landmarks = Set.of("Eiffel Tower", "Statue of Liberty", "Stonehenge", "Mount Fuji");

        var result =
                landmarks
                .stream()
                .collect(Collectors.partitioningBy(b -> b.contains( " ")))
                .entrySet()
                .stream()
                .flatMap(t -> t.getValue().stream())
                .collect(Collectors.groupingBy(s142 -> !s142.startsWith("S")));
        System.out.println(result);

        //150
        var odds150 = IntStream.iterate(1, a -> a + 2);
        var evens150 = IntStream.iterate(2, a -> a + 2);
        //var sum150 = Stream.concat(odds150, evens150).limit(3).sum();
        var sum150 = IntStream.concat(odds150, evens150).limit(3).sum();
        System.out.println(sum);
    }

    static class Dog implements Comparable{

        public Dog(String name){
            this.name = name;
        }

        String name;
        @Override
        public int compareTo(Object o) {
            return name.compareTo(((Dog)o).name);
        }

        @Override
        public String toString(){
            return name;
        }
    }

    private static void shorted(Optional<Boolean> opt){
        opt.map(x -> "run: " + x).ifPresent(System.out::println);
    }

    //106
    static void shareToys(){
        record Toy(String name){}

        var toys = Stream.of("Jack in the box", "Slinky", "Yo-Yo", "Rubik's Cube");

        var spliterator = toys.spliterator();
        var batch = spliterator.trySplit();
        var more = batch.tryAdvance(x -> {});
        System.out.println(more);
        spliterator.tryAdvance(System.out::println);

    }

}

class Lambda {

    static int i;

    public static void main(String[] args) {

        System.out.println(i);
    }
}

class Asteroid {

    public Double mine(BiFunction<Integer, Double, Double> v){
        return v.apply(1,2.0);

    }
    public static void main(String[] args) {
        new Asteroid().mine((s,p) -> s+p);
    }
}


class Market {
    private static void checkPrices(List<Double> prices, Consumer<Double> scanner){
        prices.forEach(scanner);
    }

    public static void main(String[] args) {
        List<Double> prices = List.of(1.2, 6.5, 3.0);
        checkPrices(prices, p -> {
          //  String result = p < 5 ? "Correct": " Too high";
            //System.out.println(result);
            System.out.println("OK");
        });
    }
}

class Concat {
    public String concat1(List<String> values){
        return
                values
                        .parallelStream()
                        .reduce("a", (x,y) -> x + y, String::concat);
    }

    public String concat2(List<String> values){
        return
                values
                        .parallelStream()
                        .reduce(
                                (w,z) -> z+w)
                        .get();
    }

    public static void main(String[] args) {
        Concat c = new Concat();
        var list = List.of("Cat", "Hat");
        String x = c.concat1(list);
        String y = c.concat2(list);
        System.out.println(x + " " + y);
    }
}

record Car(String model, int year){
    @Override
    public String toString(){
        return model;
    }

    public static void main(String[] args) {

        var cars = new ArrayList<Car>(); //<Car> obligé! attention à ne pas omettre
        cars.add(new Car("Mustang", 1967));
        cars.add(new Car("Thunderbird", 1967));
        cars.add(new Car("Escort", 1975));
        var map = cars.stream().collect(Collectors.groupingByConcurrent(Car::year));
        System.out.println(map);
    }
}

@FunctionalInterface
interface Study {
    abstract int learn(String subject, int duration);
}

class BiologyMaterial implements Study {

    @Override
    public int learn(String subject, int duration) {
        if(subject == null)
            return duration;
        else
            return duration + 1;
    }
}

class Scientist {
    public static void main(String[] args) {
        final Study s = new BiologyMaterial();
        System.out.println(s.learn(args[0], Integer.parseInt(args[1])));
    }
}

//58
class Cheater {
    int count = 0;
    public void sneak(Collection<String> coll){
        coll.stream().peek(r -> {
            count ++;
            System.out.println(r);
        }).findFirst();
    }

    public static void main(String[] args) {
        var c = new Cheater();
        c.sneak(Arrays.asList("weasel"));
    }
}

//66
record Ballot(String name, int judgeNumber, int score){

    public static void main(String[] args) {
        Stream<Ballot> ballots = Stream.of(
                new Ballot("Mario", 1, 10),
                new Ballot("Luigi", 1, 8),
                new Ballot("Mario", 2, 9),
                new Ballot("Luigi", 2, 8));

        var scores = ballots.collect(Collectors.groupingBy(Ballot::name, Collectors.summingInt(Ballot::score)));
        System.out.println(scores.get("Mario"));

    }
}

//83
class Sun {
    public static void dawn(
            //DoubleUnaryOperator doubleUnaryOperator //OK
            //Function<String, String> function ///OK
            //IntToLongFunction intToLongFunction //OK
            UnaryOperator<String> unaryOperator
    ){

    }

    public static void main(String[] args) {
        dawn(s -> s + 1);
    }
}

//93
class Magician {
    public void magic(BinaryOperator<Long> lambda){
        lambda.apply(3L, 7L);
    }

    public static void main(String[] args) {
        Magician magician = new Magician();
        magician.magic((b,w) -> (long)w.intValue());
    }
}

//98

class ConvertToCents {
    //static DoubleToIntFunction f = p -> p * 100;
    static DoubleToIntFunction f = p -> (int)p * 100;

    public Predicate<String> testA(){
        return s -> s.length() > 0;
    }
}

//115
class Divide {
    static float divide(Stream<Float> s){
        return s.reduce(1.0f, (a,b) -> a/b, (a,b) -> a/b);
    }

    public static void main(String[] args) {
        System.out.println(divide(Set.of(1f, 2f, 3f, 4f).stream()));
        System.out.println(divide(List.of(1f, 2f, 3f, 4f).stream()));
        //System.out.println(divide(List.of(1f, 2f, 3f, 4f).parallel()));
        System.out.println(divide(List.of(1f).parallelStream()));
    }
}

//124
class Petar {

    public static void main(String[] args) {

        record Pet(int age){}
        record PetSummary(long count, int sum){}

        var summary = Stream.of(new Pet(2), new Pet(5), new Pet(8))
                .collect(
                        Collectors
                                .teeing(
                                        Collectors.counting(),
                                        Collectors.summingInt(Pet::age),
                                        PetSummary::new
                                )
                )
                ;

        System.out.println(summary);

    }
}

//146
class Compete {
    public static void main(String[] args) {
        Stream<Integer> is = Stream.of(8,6,9);
        Comparator<Integer> c146 = (a,b) -> a - b;
        is.sorted(c146).forEach(System.out::print);
    }
}

//148
class Warehouse {
    private int quantity = 40;
    private final BooleanSupplier stock;
    {
        stock = () -> quantity > 0;
    }
    public void checkInventory(){
        if(stock.getAsBoolean()){
            System.out.println("Plenty");
        }
        else {
            System.out.println("On backorder");
        }
    }

    public static void main(String[] args) {
        final Warehouse warehouse = new Warehouse();
        warehouse.checkInventory();
    }
}

//149
record Thermometer(String feelsLike, double temp){
    @Override
    public String toString(){
        return feelsLike;
    }

    public static void main(String[] args) {
        var readings = List.of(new Thermometer("HOT", 72), new Thermometer("Too cold", 0) ,new Thermometer("Just right", 72));

        readings.parallelStream()
                .collect(
                        Collectors
                                .groupingByConcurrent(Thermometer::temp)
                )
                .forEach((a, b) -> System.out.println(a + " " + b));
    }
}