class Boss extends Creep
 { 
public Boss(int hp,int bounty, int id){
    hitpoint=hp;
    this.bounty=bounty;
    this.id=id;
    movementspeed =0.5;
    poisonDamage=0;
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

public void move(ArrayList<Integer> moves){
while(!stop){
if(moves.get(movenumber)==0)
xPos--;
else if(moves.get(movenumber)==1)
xPos++;
else if(moves.get(movenumber)==2)
yPos--;
else if(moves.get(movenumber)==3)
yPos++;
}
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
