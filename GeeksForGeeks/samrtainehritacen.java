public class samrtainehritacen {

    public static void main(String[] args) {

        samrtainehritacen obj = new samrtainehritacen();
        father.aggregation(obj);
        obj.getmessage();
    }

    public void getmessage() {
        System.out.println("Hi i can play cricket");
    }

}

class father extends A {

    // int a, n;
    father() {
        System.out.println("Hi i am in father");
    }

    public static void aggregation(samrtainehritacen obj) {
        // obj.getmessage();
    }

    public void getmsg() {
        System.out.println("Hi i can do swiming");
    }

    public void getcolor() {
        System.out.println("Hi my hair colour is black");
    }
}

class A {
    A() {
        System.out.println("hi in class A");
    }
}
