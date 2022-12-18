/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosopher_test;

/**
 *
 * @author DELL
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class philosopher extends Thread {

    private fork leftFork;
    private fork rightFork;
    public  final static int Waiting=0;
    public final static int HUNGRY=1;
    public final static int EATING=2;
    public static mainfram0 mf=new mainfram0();

    private final int i ;
    private int state;
    final static int n = 5;
    
    final static String[] st=new String[3];
    public  static int[] pilStatus = new int[n];
    
    public philosopher(int id) {
      this.i = id;
      state = Waiting;
    
    }

    
    @Override
    public void run() {
//    super.run();
        while (true) {
            statusShow();
            
            if(state==Waiting) 
            {
//                logger.printOut(getName() + " is Waiting. ");
                waiting();
                state = HUNGRY;
                
            }
            
            else if(state==HUNGRY)
            {
//                logger.printOut(getName() + " is hungry. ");
//                logger.printOut(getName() + " grabs left fork. ");
                leftFork.occupy(this);
//                logger.printOut(getName() + " grab right fork. ");
                rightFork.occupy(this);
                state = EATING;
                
            }
            else
            {
//                logger.printOut(getName() + " is eating. ");
                eating();
//                logger.printOut(getName() + " is not hungry anymore. ");
//                logger.printOut(getName() + " realeas left fork. ");
                leftFork.release(this);
//                logger.printOut(getName() + " realeas right fork. ");
                rightFork.release(this);
                state = Waiting;
            }
        }
    }
    public static void main(String[] args)
    {
        st[0]="Waiting";
        st[1]="Hungry";
        st[2]="Eating";
       
        philosopher y = new philosopher(0);
        fork f1 = new fork();
        philosopher k = new philosopher(1);
        fork f2 = new fork();
        philosopher g = new philosopher(2);
        fork f3 = new fork();
        philosopher d = new philosopher(3);
        fork f4 = new fork();
        philosopher f = new philosopher(4);
        fork f5 = new fork();
        
        y.setLeftFork(f5);
        y.setRechteFork(f1);

        k.setLeftFork(f1);
        k.setRechteFork(f2);

        g.setLeftFork(f2);
        g.setRechteFork(f3);

        d.setLeftFork(f3);
        d.setRechteFork(f4);

        f.setLeftFork(f4);
        f.setRechteFork(f5);
        mf.show();
        
        for(int i=0;i<n;i++)
            pilStatus[i]=0;
        
        y.start();
        k.start();
        g.start();
        d.start();
        f.start();
    }
    
    private void eating() {
        RandomWait.waitRandom();

    }

    private void waiting() {
        RandomWait.waitRandom();

    }
   
    

    public void setLeftFork(fork leftFork) {
        this.leftFork = leftFork;
    }

    public void setRechteFork(fork rightFork) {
        this.rightFork = rightFork;
    }
    void statusShow() {
      String status;
      if(state==Waiting)
      {
          status="Waiting";
          pilStatus[i]=Waiting;
          mf.setPosition(i,Waiting);
          
          
          
      }
      else if(state==EATING)
      {
          status="Eating";
          pilStatus[i]=EATING;
          mf.setPosition(i,EATING);
          
      }
      else 
      {
          status="Hungry";
          pilStatus[i]=HUNGRY;
          mf.setPosition(i,HUNGRY);
      }
        
      System.out.println("Philosopher " + i + " is " + status);
       // mf.setPosition(i);
    }
}
