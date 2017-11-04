import java.util.*;
public class TowerManager{
    ArrayList<Tower> towerList;
   public TowerManager(){
   towerList = new ArrayList<Tower>();
} 
   public void sellTower(Tower t){
   towerList.get(t.getId()).sell();
}
    public void buyTower(Tower t){
towerList.add(t);
}
    public void upgradeTower(Tower tower){
towerList.get(tower.getId()).upgrade();

}
}