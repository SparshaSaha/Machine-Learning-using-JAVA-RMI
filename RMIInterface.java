import java.rmi.*;
public interface RMIInterface extends Remote{
  public String hello(String name)throws RemoteException;
  public int calculate(int a,int b)throws RemoteException;
}
