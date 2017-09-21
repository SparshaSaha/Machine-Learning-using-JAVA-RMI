import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server extends UnicastRemoteObject implements RMIInterface{
  protected Server()throws RemoteException
  {
    super();
  }

  @Override
  public String hello(String name)throws RemoteException{
    System.out.println(name);

    return "printed";
  }

  @Override
  public int calculate(int a,int b)throws RemoteException
  {
    int z=a+b;

    return z;
  }

  public static void main(String args[]){

    try{
      LocateRegistry.createRegistry(2020);
      Naming.rebind("//127.0.0.1:2020/server", new Server());
      System.out.println("Server ready");
    }catch(Exception e){
      System.out.println(e.toString());
    }

  }
}
