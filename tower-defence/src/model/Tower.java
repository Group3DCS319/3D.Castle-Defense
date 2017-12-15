abstract class Tower
{ 
  protected int xPos, 
    yPos ,
    id, 
    level,
    cost;
  protected double damage,
    range,
    attackRate;
  protected String name;
  abstract int getLevel();
  abstract void fire(int xPos,int yPos);
  abstract void upgrade();
  abstract void setRange(double range);
  abstract void sell();
  abstract void setDamage(int damage);
  abstract void setCost(int cost);
  abstract void setAttackRate(double attackRate);
  abstract int getId();
}