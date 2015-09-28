package com.clouway.task2;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class MyThread extends Thread implements Runnable {
    public  int myCounter;
    private final String name;
    public final int max;

    public MyThread(String name,int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()){
            try {
                this.sleep((long)(3000*Math.random()));
                myCounter++;
                System.out.println(name+"- "+myCounter);
                if (this.myCounter==this.max){
                    this.interrupt();
                }
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}