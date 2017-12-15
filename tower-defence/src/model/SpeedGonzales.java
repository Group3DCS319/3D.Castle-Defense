import java.util.*;

class SpeedGonzales extends Creep
{ 
  public SpeedGonzales(int hp,int bounty, int id){
    hitpoint=hp;
    this.bounty=bounty;
    this.id=id;
    movementspeed =1;
    curSpeed = 1;
    poisonDamage=0;
    name="Speedy Gonzales";
    slowed=false;
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
  public int getId(){
    return id;
  }
  public void setId(int i){
    id=i;
  }
  public int getHP(){
    
    return curHitpoint;}
  public void damage(int damageTaken){
    curHitpoint-=damageTaken;
    if(curHitpoint<=0)
      dead=true;
  }
  
  public void kill(){
    //  this=null;
  }
  
  public void poison(double poisonDamage, double poisonDuration){
    poisoned=true;
    if(poisonDamage>this.poisonDamage){
      this.poisonDamage=poisonDamage;
      this.poisonDuration=poisonDuration;
    }
  }
  public void update(){
    if(poisonDuration<=0){
      poisoned=false;
      poisonDamage=0;    
    }
    
    if(stunDuration<=0){
      move();
      stunned=false;
    }
  }
  public boolean inRange(double range){
    /////////
    return false;
  }
  public void stun(double duration){
    stunned=true;
    stop();
    if(stunDuration<duration){
      stunDuration=duration;
    }
    
  }
  
  public boolean isDead(){
    return dead;
    
  }
  
  public void move(){
    ///////////
  }
  public void stop(){
    curSpeed=0;
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
  public void setMoves(ArrayList<Integer> m){}
  public void setPos(int x, int y){}
}
