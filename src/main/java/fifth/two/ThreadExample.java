package fifth.two;

public class ThreadExample {
    public static void main(String a[]) {
        Rabit rabit;
        // 新建线程rabit
        rabit = new Rabit("rabit", 5, 10);
        // 新建线程tortoise
        Tortoise tortoise = new Tortoise("tortoise", 5, 10);
        // 启动线程tortoise
        tortoise.start();
        // 启动线程rabit
        rabit.start();
    }
}
