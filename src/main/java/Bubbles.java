import java.util.Scanner;
import java.util.ArrayList;

public class Bubbles {
    public static void main(String[] args) {
        Message intro = new Message("Hello! I'm Bubbles 🫧 \nWhat can I do for you?");
        Message exit = new Message("Byeee 👋");
        ArrayList<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String line = "--------------------------------------------------------";

        intro.message();

        String command = scanner.nextLine();
        System.out.println(line);
        if(!command.equals("list")){
            list.add(command);
        }
        while (!command.equals("bye")) {
            if(!command.equals("list")) {
                System.out.println("\tadded: " + command);
            }
            System.out.println(line);
            command = scanner.nextLine();
            System.out.println(line);

            if(!command.equals("list")){
                list.add(command);
            }
            else{
                for(int i = 0; i < list.size(); i++){
                    System.out.println("\t" + (i+1) + ". " + list.get(i));
                }
            }
        }


        exit.message();
        scanner.close();



    }
}
