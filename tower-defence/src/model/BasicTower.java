public class BasicTower extends Tower{
  public BasicTower(int x, int y, int id){
    xPos=x;
    yPos=y;
    level=1;
    range =1;
    attackRate=1.2;
    damage =30;
    cost=20;
    name="Basic Tower";
    this.id=id;
  }
  public int getLevel(){
    return level;
    
  }
  
  
  void fire(int xPos,int yPos){
    ////////////
  }
  void upgrade(){
    attackRate*=1.25;
    range*=1.25;
    level++;
    damage*=1.5;
    cost *=1.5;
  }
  void setRange(double range){
    this.range=range;
  }
  public void sell(){
    // this=null;
  }
  public void setDamage(int damage){
    this.damage=damage;
    
  }
  void setCost(int cost){
    this.cost=cost;
    
  }
  void setAttackRate(double attackRate){
    this.attackRate=attackRate;
  }
  int getId(){
    return id;
  }
  
}