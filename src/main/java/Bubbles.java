import java.util.Scanner;
import java.util.ArrayList;

public class Bubbles {
    public static void main(String[] args) throws BubblesException{
        Message intro = new Message("Hello! I'm Bubbles 🫧 \nWhat can I do for you?");
        Message exit = new Message("Byeee 👋");
        ArrayList<Task> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String line = "--------------------------------------------------------";

        intro.message();

        String command = scanner.nextLine();
        System.out.println(line);

        try {
            if (command.startsWith("todo")) {
                try {
                    String[] words = command.split("todo", 2);
                    if (words.length < 2 || words[1].isEmpty()) {
                        throw new BubblesException("Oopsies! You forgot to give me the description 🤭");
                    }
                    Todo todo = new Todo(words[1]);
                    list.add(todo);
                    System.out.println("New bubble added to your list 📃");
                    System.out.println(todo.toString());
                    System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");
                } catch (BubblesException e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.startsWith("deadline")) {
                try {
                    if(!command.contains("/by")){
                        throw new BubblesException("Woops! You forgot to add the deadline!");
                    }
                    String[] words = command.split("deadline", 2);
                    Deadline deadline = new Deadline(words[1]);
                    list.add(deadline);
                    System.out.println("New bubble added to your list 📃");
                    System.out.println(deadline.toString());
                    System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");
                } catch(BubblesException e){
                    System.out.println(e.getMessage());
                }
            } else if (command.startsWith("event")) {
                String[] words = command.split("event", 2);
                Event event = new Event(words[1]);
                list.add(event);
                System.out.println("New bubble added to your list 📃");
                System.out.println(event.toString());
                System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");
            } else{
                throw new BubblesException("Sawwryy... that one bounced right off my bubblehead! I don't understand it yet 🥺");
            }
        } catch(BubblesException e){
            System.out.println(e.getMessage());
        }

        while (!command.equals("bye")) {

            System.out.println(line);
            command = scanner.nextLine();
            System.out.println(line);

            try {
                if (command.startsWith("todo")) {
                    try {
                        String[] words = command.split("todo", 2);
                        if (words.length < 2 || words[1].isEmpty()) {
                            throw new BubblesException("Oopsies! You forgot to give me the description 🤭");
                        }
                        Todo todo = new Todo(words[1]);
                        list.add(todo);
                        System.out.println("New bubble added to your list 📃");
                        System.out.println(todo.toString());
                        System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");
                    } catch (BubblesException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (command.startsWith("deadline")) {
                    try {
                        if(!command.contains("/by")){
                            throw new BubblesException("Woops! You forgot to add the deadline!");
                        }
                        String[] words = command.split("deadline", 2);
                        Deadline deadline = new Deadline(words[1]);
                        list.add(deadline);
                        System.out.println("New bubble added to your list 📃");
                        System.out.println(deadline.toString());
                        System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");
                    } catch(BubblesException e){
                        System.out.println(e.getMessage());
                    }
                } else if (command.startsWith("event")) {
                    String[] words = command.split("event", 2);
                    Event event = new Event(words[1]);
                    list.add(event);
                    System.out.println("New bubble added to your list 📃");
                    System.out.println(event.toString());
                    System.out.println("Wohoo! You've got " + list.size() + " sparkly tasks floating in your list! ✨");
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
                        task.setDone();

                        System.out.println("Yayyy! Let's pop this task off 🥳");
                        System.out.println(task);
                    }

                } else if (command.startsWith("unmark")) {
                    String[] words = command.split(" ");
                    Task task = list.get(Integer.parseInt(words[1]) - 1);

                    if(task.getStatusIcon().equals("[ ]")){
                        System.out.println("Ayyyy! This task is already unmarked! 😅");
                    }

                    else {
                        task.setNotDone();

                        System.out.println("Okieee! Let's bubble it back in!");
                        System.out.println(task);
                    }
                } else if(command.startsWith("delete")){
                    String[] words = command.split(" ");
                    Task task = list.get(Integer.parseInt(words[1]) - 1);
                    list.remove(Integer.parseInt(words[1]) - 1);

                    System.out.println("Poof! The task has drifted off from your list!");
                    System.out.println(task);
                    System.out.println("Juss " + list.size() + " more tasks waiting to drift away!");
                }

                else {
                    throw new BubblesException("Sawwryy... that one bounced right off my bubblehead! I don't understand it yet 🥺");
                }
            } catch (BubblesException e){
                System.out.println(e.getMessage());
            }
        }


        exit.message();
        scanner.close();



    }
}
