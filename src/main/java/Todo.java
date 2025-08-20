public class Todo extends Task{
    public Todo(String description){
        super(description);
    }

    public String typeTag(){
        return "[T]";
    }

    @Override
    public String toString(){
        return "[T]" + this.getStatusIcon() +super.toString();
    }
}
