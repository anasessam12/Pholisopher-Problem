/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philosopher_test;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
class RandomWait {

    private static Random random = new Random(System.currentTimeMillis());

    public static synchronized void waitRandom() {

        long millis = (long)(random.nextDouble() * 5000);

        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {

            ex.printStackTrace();
        }

    }
}
