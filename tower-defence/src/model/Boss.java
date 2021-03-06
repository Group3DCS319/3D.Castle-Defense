import java.util.*;
class Boss extends Creep
{ 
  int xPos,yPos;
  public Boss(int hp,int bounty, int id){
    hitpoint=hp;
    this.bounty=bounty;
    this.id=id;
    movementspeed =0.5;
    poisonDamage=0;
    moves = new ArrayList<Integer>();
    movenumber=0;
    curSpeed = 0.5;
    name="Boss";
    slowed=false;
    stop=false;
    stunned=false;
    curHitpoint=hp;
    poisoned=false;
    dead=false;
    slowRate=0;
    poisonDuration=0;
    slowDuration=0;
    stunDuration=0;
  }
  public void slow(double slowRate,double slowDuration){
    
  }
  public void setPos(int x, int y){
    xPos=x;
    yPos=y;
  }
  
  public int getHP(){
    
    return curHitpoint;}
  public void damage(int damageTaken){
    curHitpoint-=damageTaken;
    if(curHitpoint<=0)
      dead=true;
  }
  public int getId(){
    return id;
  }
  public void kill(){
    dead=true;
  }
  public void setId(int i){
    id=i;
  }
  public void poison(double poisonDamage, double poisonDuration){
    
  }
  public void update(){
    
  }
  public boolean inRange(double range){
    /////////
    return false;
  }
  public void stun(double duration){
    
    
  }
  
  public boolean isDead(){
    return dead;
    
  }
  public void setMoves(ArrayList<Integer> m){moves=m;}
  
  public void move(){
    if(moves.get(movenumber)==0)
      pos.setX(pos.getX()-1);
    else if(moves.get(movenumber)==1)
      pos.setX(pos.getX()+1);
    else if(moves.get(movenumber)==2)
      pos.setY(pos.getY()-1);
    else if(moves.get(movenumber)==3)
      pos.setY(pos.getY()+1);
    movenumber++;
  }
  public void stop(){
    curSpeed=0;
    stop=true;
  }
  public void stop(double durat){
    curSpeed=0;
    if(durat>stunDuration)
      stunDuration=durat;
  }
  public double getCurSpeed(){
    return curSpeed;
  }
  public double getMaxSpeed(){
    return movementspeed;
  }
}
