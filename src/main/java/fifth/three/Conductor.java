package fifth.three;


/**
 * @author ZD
 * @date 2020-09-30 14:21
 */
public class Conductor implements Runnable {
    private Wallet wallet;

    public Conductor(int fiveNumbers, int tenNumbers, int twentyNumbers) {
        this.wallet = new Wallet(fiveNumbers, tenNumbers, twentyNumbers);
    }

    /**
     * 卖票实现
     *
     * @param moneyAmount:   给的钱数
     * @param ticketNumbers: 买的票数
     * @return 找回的钱
     * @author ZD
     * @date 2020-10-03
     */
    private Wallet sellTicket(int moneyAmount, int ticketNumbers) {
        switch (moneyAmount) {
            case 20:
                switch (ticketNumbers) {
                    case 2:
                        if (this.wallet.add(0, -1, 1)) {
                            return new Wallet(0, 1, 0);
                        } else {
                            return new Wallet(true);
                        }

                    case 1:
                        if (this.wallet.add(-1, -1, 1)) {
                            return new Wallet(1, 1, 0);
                        } else {
                            return new Wallet(true);
                        }
                    default:
                        return new Wallet(true);
                }
            case 10:
                switch (ticketNumbers) {
                    case 2:
                        if (this.wallet.add(0, 1, 0)) {
                            return new Wallet(0, 0, 0);
                        } else {
                            return new Wallet(true);
                        }
                    case 1:
                        if (this.wallet.add(-1, 1, 0)) {
                            return new Wallet(1, 0, 0);
                        } else {
                            return new Wallet(true);
                        }
                    default:
                        return new Wallet(true);
                }
            case 5:
                if (this.wallet.add(1, 0, 0)) {
                    return new Wallet(0, 0, 0);
                } else {
                    return new Wallet(true);
                }
            default:
                return new Wallet(true);
        }
    }

    /**
     * 卖票调用
     *
     * @param people:        买票人
     * @param ticketNumbers: 买的票数
     * @author ZD
     * @date 2020-10-03
     */
    public boolean sellTicket(BookingPeople people, int ticketNumbers) {
        Wallet change = sellTicket(people.getWallet().getTotalMoney(), ticketNumbers);
        if (change.isMisMark()) {
            System.out.println(people.getName() + "顾客交易失败，售票员零钱不足");
            return false;
        }
        people.getWallet().add(change);
        people.setBought(true);
        System.out.println(people.getName() + "顾客购买了一张票");
        return true;
    }

    public static void main(String[] args) {

        Conductor conductor = new Conductor(1, 0, 0);
        Thread zhao = new Thread(conductor, "赵");
        Thread qian = new Thread(conductor, "钱");
        Thread sun = new Thread(conductor, "孙");
        Thread li = new Thread(conductor, "李");
        Thread zhou = new Thread(conductor, "周");
        zhao.setPriority(10);
        qian.setPriority(9);
        sun.setPriority(8);
        li.setPriority(7);
        zhou.setPriority(6);

        zhao.start();
        while (true) {
            if (Thread.State.WAITING.equals(zhao.getState()) || Thread.State.TERMINATED.equals(zhao.getState())) {
                qian.start();
                break;
            }
        }
        while (true) {
            if (Thread.State.WAITING.equals(qian.getState()) || Thread.State.TERMINATED.equals(qian.getState())) {
                sun.start();
                break;
            }
        }
        while (true) {
            if (Thread.State.WAITING.equals(sun.getState()) || Thread.State.TERMINATED.equals(sun.getState())) {
                li.start();
                break;
            }
        }
        while (true) {
            if (Thread.State.WAITING.equals(li.getState()) || Thread.State.TERMINATED.equals(li.getState())) {
                zhou.start();
                break;
            }

        }


    }

    @Override
    public synchronized void run() {
        buyTicket();
    }

    private void buyTicket() {
        boolean isSuccess = false;
        while (!isSuccess) {
            if ("赵".equals(Thread.currentThread().getName())) {
                isSuccess = sellTicket(new BookingPeople("赵", 0, 0, 1), 2);
                if (!isSuccess) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.notifyAll();
                }
            } else if ("钱".equals(Thread.currentThread().getName())) {
                isSuccess = sellTicket(new BookingPeople("钱", 0, 0, 1), 1);
                if (!isSuccess) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.notifyAll();
                }
            } else if ("孙".equals(Thread.currentThread().getName())) {
                isSuccess = sellTicket(new BookingPeople("孙", 0, 1, 0), 1);
                if (!isSuccess) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.notifyAll();
                }
            } else if ("李".equals(Thread.currentThread().getName())) {
                isSuccess = sellTicket(new BookingPeople("李", 0, 1, 0), 2);
                if (!isSuccess) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.notifyAll();
                }
            } else if ("周".equals(Thread.currentThread().getName())) {
                isSuccess = sellTicket(new BookingPeople("周", 1, 0, 0), 1);
                if (!isSuccess) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.notifyAll();
                }
            }
        }
    }
}
