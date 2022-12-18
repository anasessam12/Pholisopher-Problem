/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosopher_test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class gloves {

    private player reservedBy; 
    private player occupiedBy;
//
       //who have the fork
    public synchronized void occupy(player player) {

        if (occupiedBy != null) {

            if (player != occupiedBy) {

                this.reserve(player);//

            }

        } else {
            this.occupiedBy = player;

        }

    }
//
                        //who reserved the fork
    private synchronized void reserve(player player) {
        this.reservedBy = player;
        try {
            logger.printOut(player.getName() + " has to wait boxing gloves. ");

            this.wait();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.reservedBy = null;
        this.occupy(player);

    }

    public synchronized void release(player player) {
        this.occupiedBy = null;
        if (this.reservedBy != null) {
            this.notifyAll(); //wake up all thread
        }

    }

}
