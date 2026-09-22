package functional_interfaces_example;

public class Main {
    public static void main(String[] args) {
        Calculator add = Integer::sum;
        Calculator multiply = (a, b) -> a * b;


        System.out.println(add.operate(5,3));
        System.out.println(multiply.operate(5,3));

        // we can call static method with Class name
        Calculator.print();

        // we can call default name with the help of reference name
        multiply.hello();
    }
}
