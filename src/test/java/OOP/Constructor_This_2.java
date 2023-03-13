package OOP;

public class Constructor_This_2 extends Constructor_Super{

    int a;

    /** Default Constructor*/
    public Constructor_This_2(int a){
        super(a);   /** parent class constructor is invoked */
        this.a=a;
    }

    public int increment(){
        a=a+1;
        return a;
    }

    public int decrement(){
        a=a-1;
        return a;
    }

}
