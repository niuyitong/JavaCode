import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<String> {
    private int ticket = 10 ; // 一共10张票
    @Override
    public String call() throws Exception {
        while(this.ticket>0){
            System.out.println("剩余票数："+this.ticket -- );
        }
        return "票卖完了，下次吧。。。" ;
    }
}
public class TestDemo {
    public static void main(String[] args) throws Exception {
        FutureTask<String> task = new FutureTask<>(new MyThread()) ;
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(task.get());
    }
}
