import java.util.*;

public class UsingGenerics {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        GenericClass<Integer> obj = new GenericClass<Integer>(n);
        int data = obj.returnData(); // without being explicitly type casted to int primitive type
        System.out.println(data);
        obj.displayData();

        // USing object reference to achieve generic nature

        GenericClassWithObject obj1 = new GenericClassWithObject(n);
        int data1 = (Integer) obj1.returnData(); // without being explicitly type casted to int primitive type
        System.out.println(data1);
        obj.displayData();

        s.close();
    }
}

class GenericClass<T> {

    T object;

    GenericClass(T obj) {
        object = obj;
    }

    public void displayData() {
        System.out.println(object.getClass().getName());
    }

    public T returnData() {
        return object;
    }

}

class GenericClassWithObject {

    Object object;

    GenericClassWithObject(Object obj) {
        object = obj;
    }

    public void displayData() {
        System.out.println(object.getClass().getName());
    }

    public Object returnData() {
        return object;
    }

}