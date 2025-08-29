package bubbles;
import java.util.Scanner;


public class Bubbles {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Bubbles(String filePath){
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            tasks = new TaskList();
        }
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        String command = "";

        ui.showWelcome();
        ui.showLine();

        while (!command.equals("bye")) {
            command = scanner.nextLine();
            ui.showLine();

            try {
                Command c = Parser.parse(command);
                c.execute(tasks, ui, storage);
            } catch (BubblesException e) {
                ui.showBubblesException(e);
            }

            ui.showLine();
        }

        ui.showExit();
        scanner.close();

    }

    public static void main(String[] args) {
        new Bubbles("src/main/bubbles.txt").run();
    }
}