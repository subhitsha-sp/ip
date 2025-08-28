public class Todo extends Task{
    public Todo(String description){
        super(description);
    }

    public String typeTag(){
        return "[T]";
    }

    @Override
    public String toString(){
        return "\t[T]" + this.getStatusIcon() + " " +super.toString();
    }
}
