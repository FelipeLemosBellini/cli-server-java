import java.rmi.Remote;
import java.rmi.RemoteException;

// A interface define a comunicação cliente-servidor.
public interface InterfaceObjRemoto extends Remote {
    int calculateAge(int birthYear) throws RemoteException;
    int findMax(int a, int b) throws RemoteException;
    int findMaxInArray(int[] array) throws RemoteException;
    int countPrimesIn3D(int[][][] array) throws RemoteException;
    int[] generateHistogram(int[][][] array) throws RemoteException;
}
