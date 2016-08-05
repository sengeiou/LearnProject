public class Adapter extends Adaptee implements Target{

    public String request(){
        super.doSomething();
        return "im adapter";
    }

}
