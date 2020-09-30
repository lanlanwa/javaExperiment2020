package fifth.two;

class Rabit extends Thread {
    int sleepTime = 0, liveLength = 0;

    public Rabit(String name, int sleepTime, int liveLength) {
        // 调用父类构造函数，设置线程的名字为name
        super(name);
        this.sleepTime = sleepTime;
        this.liveLength = liveLength;
    }

    @Override
    public void run() {
        while (true) {
            liveLength--;
            System.out.println("*_*");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
            }
            if (liveLength <= 0) {
                System.out.println(getName() + "进入死亡状态\n");
                break;
            }
        }
    }
}
