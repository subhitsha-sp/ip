package bubbles;

public class FindCommand extends Command{
    private String command;
    private String word;

    public FindCommand(String command) {
        super(command);
        this.command = command;
        this.word = command.substring(5).trim();
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        int i = 1;
        int count = 0;

        for(Task task: tasks.getAll()) {
            String str = task.toString();

            if (str.substring(7).trim().contains(this.word)) {
                count++;
            }
        }

        if (count > 0) {
            System.out.println("Here are the bubbles that match: ");
        } else {
            System.out.println("Uh-oh! Not found in my bubble land!");
        }

        for(Task task: tasks.getAll()){
            String str = task.toString();

            if (str.substring(7).trim().contains(this.word)) {
                System.out.println("\t" + Integer.toString(i) + "." + task);
                i ++;
            }
        }
    }
}
