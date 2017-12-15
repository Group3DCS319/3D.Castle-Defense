class Bomb implements Consumable
{ 
  int charge, 
    chargeMax, 
    cooldown, 
    cooldownMax,
    damage,
    x,
    y;
  double radius;
  boolean ready;
  public Bomb(){
    x=0;
    y=0;
    damage=200;
    radius=4;
    chargeMax=5;
    charge=chargeMax;
    cooldownMax=250;
    cooldown=0;
    ready=true;
  }
  public int getCharge(){
    return charge;
  }
  public void setX(int x){
    this.x=x;
  }
  public void setY(int y){
    this.y=y;
  }
  public void update(){
    if(cooldown<=0)
      ready= true;
    else 
      ready=false;
  }
  public boolean isReady(){
    return ready;
  }
  public void consume(){
    if(charge>0){
      ready=false;
      cooldown=cooldownMax;
      charge--;}
  }
}