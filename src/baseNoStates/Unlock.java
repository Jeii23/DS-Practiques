package baseNoStates;

public class Unlock extends Status{
  public void locked() {setLocked(true);}
  public void unlock() {setLocked(false);}

}
