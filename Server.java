import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.apache.commons.math3.*;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;

import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.ArrayRealVector;


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

    //linear_regression_train();

  }

  @Override
  public double linear_regression_train(double[] x)
  {
    double x_data[][]=get_x_data();
    double y_data[][]=get_y_data();

    //Start Training

    RealMatrix X=MatrixUtils.createRealMatrix(x_data);

    RealMatrix Y =MatrixUtils.createRealMatrix(y_data);



    Y=Y.transpose();

    RealMatrix theta;

    RealMatrix X_transpose=X.transpose();

    RealMatrix X_trans_X_mul=X_transpose.multiply(X);

    RealMatrix Inverse=MatrixUtils.inverse(X_trans_X_mul);

    RealMatrix BufferMatrix=Inverse.multiply(X_transpose);

    RealMatrix final_theta=BufferMatrix.multiply(Y.transpose());

    //End of Training

    System.out.println(final_theta.toString());
    System.out.println(Y.toString());

    return 23.58;

  }

  public  double[][] get_x_data()
  {
      double[][] x={{25,15,28},{23,45,43}};
      return x;

  }

  public  double[][] get_y_data()
  {
    double [][] y={{2},{5}};
    return y;

  }

}
