class Glue implements Consumable
{ 
  int charge, 
    chargeMax, 
    cooldown, 
    cooldownMax;
  double duration;
  boolean ready;
  public Glue(){
    chargeMax=5;
    charge=chargeMax;
    cooldownMax=160;
    cooldown=0;
    ready=true;
    duration=5;
  }
  
  public int getCharge(){
    return charge;
  }
  public boolean isReady(){
    return ready;
  }
  public void update(){
    if(cooldown>0)
      ready=false;
    else
      ready=true;
  }
  public void consume(){
    if(charge>0){
      ready=false;
      cooldown=cooldownMax;
      charge--;
    }
  }
}