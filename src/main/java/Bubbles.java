import java.util.Scanner;
import java.util.ArrayList;

public class Bubbles {
    public static void main(String[] args) {
        Message intro = new Message("Hello! I'm Bubbles 🫧 \nWhat can I do for you?");
        Message exit = new Message("Byeee 👋");
        ArrayList<Task> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String line = "--------------------------------------------------------";

        intro.message();

        String command = scanner.nextLine();
        System.out.println(line);
        if(!command.equals("list")){
            list.add(new Task(command));
        }
        while (!command.equals("bye")) {
            if(!(command.equals("list") || command.startsWith("mark") || command.startsWith("unmark"))) {
                System.out.println("\tadded: " + command);
            }
            System.out.println(line);
            command = scanner.nextLine();
            System.out.println(line);

            if(!command.equals("list") && !command.contains("mark")){
                list.add(new Task(command));
            }
            if(command.equals("list")){
                System.out.println("Here are the tasks in your list: ");
                for(int i = 0; i < list.size(); i++){
                    Task task = list.get(i);
                    System.out.println("\t" + (i+1) + ".[" + task.getStatusIcon() +"] " + task.toString());
                }
            }

            if(command.startsWith("mark")){
                String[] words = command.split(" ");
                Task task = list.get(Integer.parseInt(words[1])-1);
                task.setDone();

                System.out.println("Yayyy! Let's pop this task off!");
                System.out.println("[" + task.getStatusIcon() + "] " + task.getDescription());
            }

            if(command.startsWith("unmark")){
                String[] words = command.split(" ");
                Task task = list.get(Integer.parseInt(words[1])-1);
                task.setNotDone();

                System.out.println("Okieee! Let's bubble it back in!");
                System.out.println("[" + task.getStatusIcon() + "] " + task.getDescription());
            }
        }


        exit.message();
        scanner.close();



    }
}
