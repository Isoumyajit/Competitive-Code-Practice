public class Design_Patterns_SingletonClass {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                temp x = temp.getInstance();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                temp x = temp.getInstance();
            }
        });
        t1.start();
        t2.start();
    }
}

class temp {

    public static temp temp_singleton_obj;

    private temp() {
        System.out.println("Instance Created");
        // temp_singleton_obj = new temp();
    }

    public static synchronized temp getInstance() {
        if (temp_singleton_obj == null)
            temp_singleton_obj = new temp();
        return temp_singleton_obj;
    }
}
