class Ironback extends Creep
 { 
public Ironback(int hp,int bounty, int id){
    hitpoint=hp;
    this.bounty=bounty;
    this.id=id;
    movementspeed =0.5;
    poisonDamage=0;
    curSpeed = 0.5;
    name="Ironback";
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
    slowed=true;
    if(this.slowRate<slowRate){
    this.slowRate=slowRate;
    this.slowDuration=slowDuration;
    curSpeed=movementspeed*(1-slowRate);
}
    
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
    //this=null;
}
public void setId(int i){
    id=i;
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
    if(slowDuration<=0){
        slowRate=0;
        slowed=false;
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
}
