public class Event extends Task{
    protected String task;
    protected String from;
    protected String to;

    public Event(String description) throws BubblesException{
        super(description);
//        try {
            String[] words = description.split("/from");

            if (words[0].trim().isEmpty()) {
                throw new BubblesException("Woops! You forgot to add in the description!");
            }
            this.task = words[0];
            if(!description.contains("/from")){
                throw new BubblesException("Woops! You forgot to add in the from timing!");
            }

        if(!description.contains("/to")){
            throw new BubblesException("Woops! You forgot to add in the to timing!");
        }
            words = words[1].split("/to");



            if (words[0].trim().isEmpty()) {
                throw new BubblesException("Woops! You forgot to add in the from timing!");
            }


            if (words[1].trim().isEmpty()) {
                throw new BubblesException("Woops! You forgot to add the to timing!");
            }
            this.from = words[0];
            this.to = words[1];
//        } catch (BubblesException e){
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public String toString(){
        return "\t[E]" + this.getStatusIcon() + this.task + "(from:" + this.from + "to:" + this.to +")";
    }
}
