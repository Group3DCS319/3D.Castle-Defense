class PoisonTower extends Tower
 { 
double poisonDuration,
poisonDamage;
public PoisonTower(int x, int y, int id){
    xPos=x;
    yPos=y;
    level=1;
    range =1;
    attackRate=1.25;
    damage =25;
    cost=40;
    name="Poison Tower";
    this.id=id;
    poisonDamage=5;
    poisonDuration=4;
    
}
int getLevel(){
     return level;
     
 }
 void fire(int xPos,int yPos){
     ////////////
 }
 void upgrade(){
     poisonDamage*=1.25;
     poisonDuration*=1.25;
     attackRate*=1.25;
     range*=1.25;
     level++;
     damage*=1.5;
     cost *=1.5;
 }
 void setRange(double range){
     this.range=range;
 }
 void sell(){
    // this=null;
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