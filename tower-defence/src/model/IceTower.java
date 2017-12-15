class IceTower extends Tower
{ 
  double slowDuration,
    slowRate;
  public IceTower(int x, int y, int id){
    xPos=x;
    yPos=y;
    level=1;
    range =1;
    attackRate=1.2;
    damage =20;
    cost=50;
    name="Ice Tower";
    this.id=id;
    slowDuration=2;
    slowRate = 0.25;
  }
  int getLevel(){
    return level;
    
  }
  void fire(int xPos,int yPos){
    ////////////
  }
  void upgrade(){
    attackRate*=1.25;
    range*=1.25;
    level++;
    slowDuration*=1.25;
    slowRate*=1.25;
    damage*=1.5;
    cost *=1.5;
  }
  void setRange(double range){
    this.range=range;
  }
  void sell(){
    //  this=null;
  }
  void setDamage(int damage){
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