package certification.chapter14.part1;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class FileAndPath {

    public static void main(String[] args) throws IOException{

        System.out.println(System.getProperty("file.separator"));

        //File
        File directory = new File("/Users/bertranddeweer/dev/workspace/java17/src/main/resources/certification/chapter14");
        System.out.println("Directory exists : " + directory.exists());

        System.out.println("Is it a file ? " + directory.isFile());
        System.out.println("Is it a directory ? " + directory.isDirectory());

        String [] s = directory.list();
        for(String s1 : s){
            System.out.println("Directory contents (list()" + s1);
        }

        System.out.println("Directory contents (listFiles()) : " + Arrays.toString(directory.listFiles())); //not recursive, not list .. and . for folder - print null if file

        File nullDirectory = null; //Will be ignored if passed to File constructor
        //File file = new File(null, "PracticeTest.java"); //DOES NOT COMPILE, CAST NEEDED

        File file = new File(directory, "zoo-back.txt");
        System.out.println("File exists : " + file.exists()); //check case insensitive

        File newFile = new File(directory, "zoo-back-new.txt");
        System.out.println("File exists : " + newFile.exists()); //check case insensitive
        System.out.println("Creation new file : " + newFile.createNewFile());
        System.out.println("File exists : " + newFile.exists());

        File newDirectory = new File(directory, "new-directory");
        System.out.println("File exists : " + newDirectory.exists()); //check case insensitive
        System.out.println("Creation new file : " + newDirectory.mkdir());
        System.out.println("File exists : " + newDirectory.exists());

        char [] ch = new char[(int)directory.length()];

        //parent must exists!
        File absentDirectory = new File("not-exists");
        File exceptionFile = new File(absentDirectory, "exception.txt");
        try {
            exceptionFile.createNewFile(); //No such file or directory
        }catch(IOException e){

        }


        System.out.println("File separator : " + System.getProperty("file.separator") + " - " + System.lineSeparator());

        System.out.println("------------------- Path ----------------------");

        //Path
        Path zooPath1 = Path.of("/Users/bertranddeweer///////////dev/workspace/java17/src/main/java/certification/chapter14/PracticeTest.java"); //separator is not a problem!
        Path zooPath2 = Path.of("/Users", "/////bertranddeweer////", "dev", "workspace", "java17", "src", "main", "java", "certification", "chapter14", "Test.java");

        Path zooPath3 = Paths.get("/Users/bertranddeweer/dev/workspace/java17/src/main/java/certification/chapter14/PracticeTest.java");
        Path zooPath4 = Paths.get("/Users", "bertranddeweer", "dev", "workspace", "java17", "src", "main", "java", "certification", "chapter14", "Test.java");

        System.out.println(Files.exists(zooPath1)); //check case insensitive, Files is from nio2 apis, nothing related to File!

        File fromPath = zooPath1.toFile();
        Path fromFile = file.toPath();

        //Obtaining a Path from the FileSystems Class
        Path zooPath5 = FileSystems.getDefault().getPath("/Users/bertranddeweer/dev/workspace/java17/src/main/java/certification/chapter14/PracticeTest.java");

    }
}