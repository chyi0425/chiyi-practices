package com.chiyi.concurrency.lock;

/**
 * @author chiyi
 */
public class Run {

    public static void main(String[] args) {
        Service service = new Service("xiaobaoge");

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }

}

class Service {

    String anyString = new String();

    public Service(String anyString) {
        this.anyString = anyString;
    }

    public void setUsernamePassword(String username, String password) {
        try {
            synchronized (anyString) {
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
                Thread.sleep(3000);
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("a", "aa");

    }

}

class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.setUsernamePassword("b", "bb");

    }
}
