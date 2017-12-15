import java.util.*;
public class WaveManager{
  ArrayList<Wave> waveList;
  int currentWaveLevel;
  CreepManager creepManager;
  public WaveManager(ArrayList<Wave> wlist, CreepManager cm, int curwave){
    waveList= wlist;
    creepManager=cm;
    currentWaveLevel=curwave;
  }
  public void addWave(Wave w){
    waveList.add(w);}
  public void removeWave(int i){
    if(i<currentWaveLevel)
      currentWaveLevel--;
    waveList.remove(i);
  }
}