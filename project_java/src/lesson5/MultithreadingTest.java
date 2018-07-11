package lesson5;

public class MultithreadingTest {

    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("thread_" + i);
                }
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("thread1_" + i);
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("thread2_" + i);
                }
            }
        });
        thread2.start();



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        }).start();


    }


}
