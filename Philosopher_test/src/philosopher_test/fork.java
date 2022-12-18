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
public class fork {

    

    private philosopher reservedBy;
    private philosopher occupiedBy;
//

    public synchronized void occupy(philosopher philosopher) {

        if (occupiedBy != null) {

            if (philosopher != occupiedBy) {

                this.reserve(philosopher);//

            }

        } else {
            this.occupiedBy = philosopher;

        }

    }
//

    private synchronized void reserve(philosopher philosopher) {
        this.reservedBy = philosopher;
        try {
            //logger.printOut(philosopher.getName() + " has to wait fork. ");

            this.wait();
        } catch (InterruptedException ex) {
        }
        this.reservedBy = null;
        this.occupy(philosopher);

    }

    public synchronized void release(philosopher philosopher) {
        this.occupiedBy = null;
        if (this.reservedBy != null) {
            this.notifyAll();
        }

    }

}
