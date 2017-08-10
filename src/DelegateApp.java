/**
 * Created by Arsen on 10.08.2017.
 */
public class DelegateApp {
    public static void main(String[] args)
    {
        B b = new B();
        b.f();
    }
}

class A{
    void f(){
        System.out.println("f()");
    }
}

class B{
    A a = new A();
    void f(){
        a.f();
    }
}