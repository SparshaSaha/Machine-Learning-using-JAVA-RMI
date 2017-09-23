import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.apache.commons.math3.*;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;

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

double[][] matrixData = { {1,2,3}, {2,5,3}};

RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

System.out.println(m.transpose().getColumn()[0]);

    try{
      LocateRegistry.createRegistry(2020);
      Naming.rebind("//127.0.0.1:2020/server", new Server());
      System.out.println("Server ready");
    }catch(Exception e){
      System.out.println(e.toString());
    }

  }
}
