import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bubbles {
    private static void write(String textToAdd) throws IOException {
        try {
            FileWriter fw = new FileWriter("src/main/bubbles.txt");
            fw.write(textToAdd);
            fw.close();
        } catch (IOException e){
            System.out.println("Error : Something went wrong!");
        }
    }

    private static void append(String textToAppend) throws IOException {
        FileWriter fw = new FileWriter("src/main/bubbles.txt", true);
        fw.write(textToAppend);
        fw.close();
    }

    public static void main(String[] args) throws BubblesException, FileNotFoundException{
        Message intro = new Message("Hello! I'm Bubbles 🫧 \nWhat can I do for you?");
        Message exit = new Message("Byeee 👋");
        ArrayList<Task> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String line = "--------------------------------------------------------";

        intro.message();

        try{
            File f = new File("src/main/bubbles.txt");
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
                    list.add(todo);
                }

                if (ch == 'D'){
                    String by = words[1].split("by:")[1].substring(0, words[1].split("by:")[1].length()-1);
                    Deadline deadline = new Deadline(words[1].split(" ")[0] + " /by" + by);

                    if(str.contains("[X]")){
                        deadline.setDone();
                    }

                    list.add(deadline);
                }

                if (ch == 'E'){
                    String desc = words[1].split("\\(from:")[0];
                    String from = words[1].split("from:")[1].split("to: ")[0];
                    String to = words[1].split("from:")[1].split("to: ")[1].substring(0, words[1].split("from:")[1].split("to: ")[1].length() - 1);

                    Event event = new Event(desc + "/from" + from + "/to " + to);

                    if(str.contains("[X]")){
                        event.setDone();
                    }

                    list.add(event);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Error: The given file wasn't found.");
        }

        String command = "";
        while (!command.equals("bye")) {


            command = scanner.nextLine();
            System.out.println(line);

            try {
                if (command.startsWith("todo")) {
                    try {
                        String[] words = command.split("todo", 2);
                        if (words.length < 2 || words[1].isEmpty()) {
                            throw new BubblesException("Oopsies! You forgot to give me the description 🤭");
                        }
                        Todo todo = new Todo(words[1].trim());
                        list.add(todo);
                        System.out.println("New bubble added to your list 📃");
                        System.out.println(todo.toString());
                        Bubbles.append(todo.toString() + "\n");
                        System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");

                    } catch (BubblesException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (IOException e){
                        System.out.println("Error : Something went wrong!");
                    }
                } else if (command.startsWith("deadline")) {
                    try {
                        if(!command.contains("/by")){
                            throw new BubblesException("Woops! You forgot to add the deadline!");
                        }
                        String[] words = command.split("deadline", 2);
                        Deadline deadline = new Deadline(words[1].trim());
                        list.add(deadline);
                        System.out.println("New bubble added to your list 📃");
                        System.out.println(deadline.toString());
                        Bubbles.append(deadline.toString() + "\n");
                        System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");
                    } catch(BubblesException e){
                        System.out.println(e.getMessage());
                    }
                    catch (IOException e){
                        System.out.println("Error : Something went wrong!");
                    }
                } else if (command.startsWith("event")) {
                    try {
                        String[] words = command.split("event", 2);
                        Event event = new Event(words[1].trim());
                        list.add(event);
                        System.out.println("New bubble added to your list 📃");
                        System.out.println(event.toString());
                        Bubbles.append(event.toString() + "\n");
                        System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");

                    } catch (IOException e){
                        System.out.println("Error : Something went wrong!");
                    }
                } else if (command.equals("list")) {
                    System.out.println("Here are the tasks in your list: ");
                    for (int i = 0; i < list.size(); i++) {
                        Task task = list.get(i);
                        System.out.println("\t" + (i + 1) + "." + task.toString());
                    }
                } else if (command.startsWith("mark")) {
                    String[] words = command.split(" ");
                    Task task = list.get(Integer.parseInt(words[1]) - 1);

                    if(task.getStatusIcon().equals("[X]")){
                        System.out.println("Ayyyy! This task is already marked! 😅");
                    }

                    else {
                        try {
                            task.setDone();

                            System.out.println("Yayyy! Let's pop this task off 🥳");
                            System.out.println(task);

                            write(list.get(0).toString() + "\n");

                            for (int i = 1; i < list.size(); i++) {
                                Task write_task = list.get(i);
                                System.out.println(write_task);
                                append(write_task.toString() + "\n");
                            }
                        } catch(IOException e){
                            System.out.println("Error : Something went wrong!");
                        }
                    }

                } else if (command.startsWith("unmark")) {
                    String[] words = command.split(" ");
                    Task task = list.get(Integer.parseInt(words[1]) - 1);

                    if(task.getStatusIcon().equals("[ ]")){
                        System.out.println("Ayyyy! This task is already unmarked! 😅");
                    }

                    else {
                        try {
                            task.setNotDone();

                            System.out.println("Okieee! Let's bubble it back in!");
                            System.out.println(task);

                            write(list.get(0).toString() + "\n");

                            for (int i = 1; i < list.size(); i++) {
                                Task write_task = list.get(i);
                                append(write_task.toString() + "\n");
                            }

                        } catch(IOException e){
                        System.out.println("Error : Something went wrong!");
                    }
                    }
                } else if(command.startsWith("delete")){
                    try{
                    String[] words = command.split(" ");
                    Task task = list.get(Integer.parseInt(words[1]) - 1);
                    list.remove(Integer.parseInt(words[1]) - 1);

                    System.out.println("Poof! The task has drifted off from your list!");
                    System.out.println(task);
                    System.out.println("Juss " + list.size() + " more tasks waiting to drift away!");

                    write(list.get(0).toString() + "\n");

                    for (int i = 1; i < list.size(); i++) {
                        Task write_task = list.get(i);
                        append(write_task.toString() + "\n");
                    }

                } catch (IOException e){
                        System.out.println("Error : Something went wrong!");
                    }
                }


                else {
                    throw new BubblesException("Sawwryy... that one bounced right off my bubblehead! I don't understand it yet 🥺");
                }

                System.out.println(line);

            } catch (BubblesException e){
                System.out.println(e.getMessage());
            }
        }
        
        exit.message();
        scanner.close();

    }
}
