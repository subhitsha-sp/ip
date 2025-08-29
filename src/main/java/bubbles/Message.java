package bubbles;

public class Message {
    String msg;
    public Message(String msg){
        this.msg = msg;
    }

    public void message(){
        System.out.println(this.msg);
        System.out.println("--------------------------------------------------------");
    }
}
