public class Deadline extends Task{
    protected String by;
    protected String task;

    public Deadline(String description) throws BubblesException{
        super(description);
        String[] words = description.split("/by");
        this.task = words[0];

        if(this.task.trim().isEmpty()){
            throw new BubblesException("Woops! You forgot to add the description!");
        }
        this.by = words[1];
    }

    @Override
    public String toString(){
        return "\t[D]" + this.getStatusIcon() + this.task + "(by:" +  this.by + ")";
    }
}
