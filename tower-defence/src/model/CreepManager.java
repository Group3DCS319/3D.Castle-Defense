import java.util.*;
public class CreepManager{
  ArrayList<Creep> aliveCreeps;
  int alive;
  int waveNumber;
  public CreepManager(Wave w){
    int p=0;
    for(int i=0;i<w.getCreepList().size();i++)
      for(int j=0;j<w.getNumberList().get(i);j++){
      aliveCreeps.add( w.getCreepList().get(i));
      (aliveCreeps.get(aliveCreeps.size()-1)).setId(p++);  
    }
    alive=aliveCreeps.size();
    waveNumber=1;
  }
  public void addCreep(Creep c){
    aliveCreeps.add(c);
    aliveCreeps.get(aliveCreeps.size()-1).setId(aliveCreeps.size()-1);
  }
  public void removeCreep(Creep c){
    aliveCreeps.get(c.getId()).kill();
  }
}