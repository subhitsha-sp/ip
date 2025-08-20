public class Deadline extends Task{
    protected String by;
    protected String task;

    public Deadline(String description){
        super(description);
        String[] words = description.split("/by");
        this.task = words[0];
        this.by = words[1];
    }

    @Override
    public String toString(){
        return "[D]" + this.getStatusIcon() + this.task + "(by:" +  this.by + ")";
    }
}
