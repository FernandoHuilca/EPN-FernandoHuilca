import Characters.Player;

public class BadIceCream {

    private Player player;
    private Level level;


    public BadIceCream(){
        player = new Player();
        level = new Level();
    }

    public void movePlayer(int direction){
        if (isColliding()){
            return;
        }
        player.move(direction); //player.setPositionX(player.getPositionX()++);
        isCollidingWithAnEnemy();
    }



















    private void isCollidingWithAnEnemy() {
        if (player.getPosition() == level.getPositionEnemy()){
            System.out.println("TE MORISTE!!");
            //player.die();
        }
    }

    private boolean isColliding() {
        if (level.isColliding(player.getPosition())){
            System.out.println("No se puede mover porque hay un bloque ");
            return true;
        }
        return false;
    }




}