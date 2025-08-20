public class Event extends Task{
    protected String task;
    protected String from;
    protected String to;

    public Event(String description){
        super(description);

        String[] words = description.split("/from");
        this.task = words[0];
        words = words[1].split("/to");
        this.from = words[0];
        this.to = words[1];
    }

    @Override
    public String toString(){
        return "[E]" + this.getStatusIcon() + this.task + "(from:" + this.from + "to:" + this.to +")";
    }
}
