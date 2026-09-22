package functional_interfaces_example;

@FunctionalInterface
public interface Calculator {

    int operate(int a, int b);

    static void print(){
        System.out.println("hello static method");
    }



    default void hello(){
        System.out.println("hello default method");
    }
}
