abstract class Creep
 { 
protected int hitpoint, movenumber,
bounty, 
id, 
curHitpoint, xPos, yPos;
protected ArrayList<Integer> moves;
protected double movementspeed, curSpeed, slowRate, stunDuration, slowDuration, poisonDuration, poisonDamage;
protected String name;
protected boolean slowed, stunned, dead, poisoned, stop;
abstract void slow(double slowRate, double slowDuration);
abstract int getHP();
abstract void damage(int damageTaken);
abstract void poison(double poisonDamage, double poisonDuration);
abstract boolean inRange(double range);
abstract void stun(double duration);
abstract boolean isDead();
abstract void move();
abstract void stop();
abstract int getId();
abstract void setId(int i);
abstract double getCurSpeed();
abstract double getMaxSpeed();
abstract void stop(double duration);
abstract void kill();
abstract void update();
}
