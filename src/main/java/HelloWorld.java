import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HelloWorld {
    public void  info (String pathFile, String file_name)  {
        try { if (!Files.exists(Paths.get(pathFile+file_name))) {

            System.out.println("The specified path does not exist");
            return;}
            File file = new File(pathFile+file_name);
            Scanner scanner = new Scanner(file);
            int words = 0;
            int lines = 0;

            while (scanner.hasNextLine()) {
                lines++;
                //String input = "Hello Java! Hello JavaScript! JavaSE 8.";
                Pattern pattern = Pattern.compile("\\s+");
                //String[] words = pattern.split(input);
                String[] array = scanner.nextLine().split("[ ,.!?]");
                int count =0;
                for(String word:array){
                    if(!word.isEmpty()) {
                        count = count + 1;
                    }
                }

                words = words + count;
            }

            System.out.println("Number of words - " + words);
            System.out.println("Number of lines - " + lines);
            scanner.close();
            System.out.println("Number of lines - " + file.length());
            System.out.println("Size - " + Files.size(Paths.get(pathFile+file_name)));
            System.out.println( "Last modification date - "
                    + Files.getLastModifiedTime(Paths.get(pathFile+file_name)));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException e)
        {System.out.println(e.getMessage().toString());}

    }

    public void  read (String pathFile, String file_name)  {
        try {List<String> lines = Files.readAllLines(Paths.get(pathFile+file_name), UTF_8);
            if (!Files.exists(Paths.get(pathFile+file_name))) {

                System.out.println("The specified path does not exist");
                return;
            }
            for (String s: lines) {
                System.out.println(s);
            }


        }catch (IOException e)
        {System.out.println(e.getMessage().toString());}
    }

    public void  create (String pathFile, String file_name)  {
        try {
            File file = new File(pathFile);

            if (!file.exists()) {
                System.out.println("The specified path does not exist");
                return;
            }
            Path path = Paths.get(pathFile + file_name);
            path.normalize();
            if (Files.exists(path)) {
                System.out.println("file exists");
                System.out.println("to overwrite select 1");
                System.out.println("refusal to rewrite 2");
                Scanner in = new Scanner(System.in);
                int select = in.nextInt();
                if (select == 1) {
                    Path testFile1 = Files.createFile(path);
                    if (Files.exists(path)) {
                        System.out.println("file overwritten");
                    }
                } if (select == 2) return;
            }
            Path testFile1 = Files.createFile(path);
            System.out.println("file created successfully");
        }catch (IOException e)
        {System.out.println(e.getMessage().toString());}
    }
    public static void  print ( String nameComand) {
        String [] comands = {"info  [path] [file-name] - Displays brief information on the specified file:" +
                "\n"+ "number of characters, lines, words, date and time of"+
                "\n"+"the last change, file size \n",
                "create  [path] [file-name] - Creates a text file at the specified path."+"\n"+
                        "If the path does not exist, display an appropriate message. " +"\n"+
                        "If the file already exists, prompt to overwrite it\n",
                "read  [path] [file-name] - Reads a file at the specified path and prints the" +"\n"+
                        " text to the console. If the specified path and / or file does not exist," +"\n"+
                        " display a corresponding message\n",
                "help - Displays all available commands and information to the console",
                "help [command] - Displays information on the specified command to the console",
                "exit [command] - Closing the program"};
        for (int i=0; i<comands.length;i++){
            if (nameComand== "info  [path] [file-name]")
                System.out.println(comands[1]);
            if (nameComand== "create  [path] [file-name]")
                System.out.println(comands[2]);
            if (nameComand== "read  [path] [file-name]")
                System.out.println(comands[3]);
            if (nameComand== "help[command]")
                System.out.println(comands[5]);
            if (nameComand== "help")
                System.out.println(comands[i]);
            if (nameComand== "exit")
                System.out.println(comands[6]);
        }
    }
    public static void  help () {
        print ( "help");
    }
    public static void  help (String comand) {
        print ( comand);
    }
    public static void exitEditor() {
        System.exit(0);
    }
}
