package fifth.two;

class Tortoise extends Thread {
    int sleepTime = 0, liveLength = 0;

    public Tortoise(String name, int sleepTime, int liveLength) {
        this.sleepTime = sleepTime;
        this.liveLength = liveLength;
        // 设置线程的名字为name
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            liveLength--;
            System.out.println("@_@");
            try {
                // 让线程调用sleep()方法进入中断状态
                sleep(sleepTime);
            } catch (InterruptedException e) {
            }
            if (liveLength <= 0) {
                System.out.println(getName() + "进入死亡状态\n");
                // 结束run()方法的语句
                return;
            }
        }
    }
}
