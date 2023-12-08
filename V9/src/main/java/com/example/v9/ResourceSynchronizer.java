package com.example.v9;

public class ResourceSynchronizer {
    private int sharedResource;

    public ResourceSynchronizer() {
        this.sharedResource = 0;
    }

    public synchronized void incrementResource() {

        sharedResource++;
        System.out.println(Thread.currentThread().getName() + " увеличил ресурс. Текущее значение: " + sharedResource);
    }

    public synchronized void decrementResource() {
        sharedResource--;
        System.out.println(Thread.currentThread().getName() + " уменьшил ресурс. Текущее значение: " + sharedResource);
    }

    public synchronized int getSharedResource() {
        return sharedResource;
    }

    public static void main(String[] args) {
        ResourceSynchronizer synchronizer = new ResourceSynchronizer();


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronizer.incrementResource();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronizer.decrementResource();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Конечное значение ресурса: " + synchronizer.getSharedResource());
    }
}
