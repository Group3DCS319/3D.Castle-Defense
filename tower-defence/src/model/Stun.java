class Stun implements Consumable
{ 
  int charge, 
    chargeMax, 
    cooldown, 
    cooldownMax;
  double duration;
  boolean ready;
  public Stun(){
    chargeMax=5;
    charge=chargeMax;
    cooldownMax=210;
    cooldown=0;
    ready=true;
    duration=3;
  }
  
  public int getCharge(){
    return charge;
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