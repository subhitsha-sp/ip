import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath){
        this.filePath = filePath;
    }


    public ArrayList<Task> load() throws FileNotFoundException{
        try{
            File f = new File(filePath);
            ArrayList<Task> tasklist = new ArrayList<>();

            if(!f.exists()){
                throw new FileNotFoundException("File not found a: " + filePath);
            }

            Scanner s = new Scanner(f);
            while(s.hasNext()){
                String str = s.nextLine();
                char ch = str.charAt(2);

                String[] words = str.split("] ");

                if (ch == 'T'){
                    Todo todo  = new Todo(words[1]);

                    if(str.contains("[X]")){
                        todo.setDone();
                    }
                    tasklist.add(todo);
                }

                if (ch == 'D'){
                    String by = words[1].split("by:")[1].substring(0, words[1].split("by:")[1].length()-1);
                    Deadline deadline = new Deadline(words[1].split(" ")[0] + " /by" + by);

                    if(str.contains("[X]")){
                        deadline.setDone();
                    }

                    tasklist.add(deadline);
                }

                if (ch == 'E'){
                    String desc = words[1].split("\\(from:")[0];
                    String from = words[1].split("from:")[1].split("to: ")[0];
                    String to = words[1].split("from:")[1].split("to: ")[1].substring(0, words[1].split("from:")[1].split("to: ")[1].length() - 1);

                    Event event = new Event(desc + "/from" + from + "/to " + to);

                    if(str.contains("[X]")){
                        event.setDone();
                    }

                    tasklist.add(event);
                }
            }
            return tasklist;
        } catch (BubblesException e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();

    }

    public static void append(String textToAdd) throws IOException {
        try (FileWriter fw = new FileWriter("src/main/bubbles.txt", true)) {
            fw.write(textToAdd);
        }
    }

    public static void write(String textToAdd) throws IOException {
        try (FileWriter fw = new FileWriter("src/main/bubbles.txt")) {
            fw.write(textToAdd);
        }
    }

}
