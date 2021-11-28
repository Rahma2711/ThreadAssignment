public class ThreadAssignment {

    static class Counter {
        void count() {
            for (int i = 350; i >0; i--) {
                System.out.println(i);
            }
            System.out.println("FINISH !");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public synchronized void run() {
            counter.count();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread th1 = new MyThread(counter);
        MyThread th2 = new MyThread(counter);
        th1.start();
        try{
            th1.join();
        }catch(InterruptedException e ){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        th2.start();
        try{
            th2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("DONE !");

    }
}
