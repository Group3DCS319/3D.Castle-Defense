class Point
{ 
  
  int row, column;
  public Point(int x , int y){
    row=x;
    column=y;
  }
  public void setY(int y){column=y;}
  public void setX(int x){row=x;}
  public int getX(){return row;}
  public int getY(){return column;}
}
