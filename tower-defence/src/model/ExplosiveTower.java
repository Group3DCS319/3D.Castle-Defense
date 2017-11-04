class ExplosiveTower extends Tower
 { 
double explosionRange,
explosionDamage;
public ExplosiveTower(int x, int y, int id){
    xPos=x;
    yPos=y;
    level=1;
    range =1;
    attackRate=1.5;
    damage =30;
    cost=50;
    name="Explosive Tower";
    this.id=id;
    explosionDamage=20;
    explosionRange=0.5;
    
}
int getLevel(){
     return level;
     
 }
 void fire(int xPos,int yPos){
     ////////////
 }
 void upgrade(){
     explosionDamage*=1.25;
     explosionRange*=1.25;
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