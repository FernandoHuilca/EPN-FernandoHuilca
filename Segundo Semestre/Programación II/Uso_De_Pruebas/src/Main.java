import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.lang.management.PlatformLoggingMXBean;

public class Main {
    public static void main(String[] args) {

        //Dado: que existe un player y un enemigo:
        Player player;
        Monstruo monstruo;
        //Cuando: Estos dos se encuentran en la misma posición el player muere
        player = new Player(2,2);
        monstruo = new Monstruo(2,2);
        //ENTONCES:
        assertTrue(player.estaMuerto());



		//Dado: que existe un player y una fruta:
		Player player;
		Fruta fruta;
		//Cuando: Estos dos se encuentran en la misma posición
		player = new Player(5,5);
        fruta = new Fruta(5, 5);
		//ENTONCES: el player aumenta sus objetosRecolectados
		assertTrue(player.getObjetosRecolectados());



    }
}