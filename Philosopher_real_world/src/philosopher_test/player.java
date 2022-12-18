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
public class player extends Thread {

    private gloves leftBoxing_gloves;
    private gloves rightBoxing_gloves;

    public player(String name) {
        super(name);
    }

    @Override()
    public void run() {
//    super.run();

        while (true) {

            //not hungry ,waiting
            logger.printOut(getName() + " is waiting . ");
            think();

            //hungry
            logger.printOut(getName() + " wants to play. ");

            //logger.printOut(getName() + " grabs left Boxing_gloves. ");
            leftBoxing_gloves.occupy(this);
            logger.printOut(getName() + " grabs left Boxing_gloves. ");
             
            rightBoxing_gloves.occupy(this);
            logger.printOut(getName() + " grabs right Boxing_gloves. ");
            //eating
            logger.printOut(getName() + " in the Game now . ");

            playing();
            
            logger.printOut(getName() + "  finish the Game . ");

            //release
            logger.printOut(getName() + " realeas left Boxing_gloves. ");
            leftBoxing_gloves.release(this);

            logger.printOut(getName() + " realeas right Boxing_gloves. ");
            rightBoxing_gloves.release(this);

        }
    }

    private void playing() {
        RandomWait.waitRandom();

    }

    private void think() {
        RandomWait.waitRandom();

    }

    public void setleftBoxing_gloves(gloves leftBoxing_gloves) {
        this.leftBoxing_gloves = leftBoxing_gloves;
    }

    public void setrightBoxing_gloves(gloves rightBoxing_gloves) {
        this.rightBoxing_gloves = rightBoxing_gloves;
    }

}
