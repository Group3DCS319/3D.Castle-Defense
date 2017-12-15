import java.util.*;
public class ConsumableManager{
    Glue glue;
    Stun stun;
    Bomb bomb;
public ConsumableManager(){
glue = new Glue();
stun = new Stun();
bomb = new Bomb();
}
    public void consumeStun(){
if(stun.isReady()&&stun.getCharge()>0)
stun.consume();
}
    public void consumeBomb(Point p){
if(bomb.isReady()&&bomb.getCharge()>0){
bomb.setX(p.getX());
bomb.setY(p.getY());
bomb.consume();
}
}
    public void consumeGlue(){
if(glue.isReady()&&glue.getCharge()>0)
glue.consume();
}
}