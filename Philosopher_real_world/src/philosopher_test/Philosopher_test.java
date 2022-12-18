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
public class Philosopher_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        player boxing_player_1 = new player("  boxing_player_1");
        gloves f1 = new gloves();
        player boxing_player_2 = new player("  boxing_player_2");
        gloves f2 = new gloves();
        player boxing_player_3 = new player("boxing_player_3");
        gloves f3 = new gloves();
        player boxing_player_4 = new player("boxing_player_4");
        gloves f4 = new gloves();
        player boxing_player_5 = new player("boxing_player_5");
        gloves f5 = new gloves();

        boxing_player_1.setleftBoxing_gloves(f5);
        boxing_player_1.setrightBoxing_gloves(f1);

        boxing_player_2.setleftBoxing_gloves(f1);
        boxing_player_2.setrightBoxing_gloves(f2);

        boxing_player_3.setleftBoxing_gloves(f2);
        boxing_player_3.setrightBoxing_gloves(f3);

        boxing_player_4.setleftBoxing_gloves(f3);
        boxing_player_4.setrightBoxing_gloves(f4);

        boxing_player_5.setleftBoxing_gloves(f4);
        boxing_player_5.setrightBoxing_gloves(f5);

        boxing_player_1.start();
        boxing_player_2.start();
        boxing_player_3.start();
        boxing_player_4.start();
        boxing_player_5.start();

    }

}
