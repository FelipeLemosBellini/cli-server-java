import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// A interface define a comunicação cliente-servidor.
public interface InterfaceObjRemoto extends Remote {
    int calculateAge(int birthYear) throws RemoteException;
    int findMax(int a, int b) throws RemoteException;
    int findMaxInArray(List<Integer> array) throws RemoteException;
    int countPrimesIn3D(int[][][] array) throws RemoteException;
}
