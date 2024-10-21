import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import static java.lang.System.in;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceObjRemoto {

    // Construtor pode lançar  RemoteException
    public ObjetoRemoto() throws RemoteException {
        super();
        System.out.println("Programa Remoto Instanciado com sucesso");
        System.out.println("Aguardando solicitacao de operacoes");
    }

    @Override
    public int calculateAge(int birthYear) throws RemoteException {
        int currentYear = Calendar.YEAR;
        return currentYear - birthYear;
    }

    @Override
    public int findMax(int a, int b) throws RemoteException {
        return (a > b) ? a : b;
    }

    @Override
    public int findMaxInArray(int[] array) throws RemoteException {
        int maxNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

    @Override
    public int countPrimesIn3D(int[][][] array) throws RemoteException {
        return 0;
    }

    @Override
    public int[] generateHistogram(int[][][] array) throws RemoteException {
        return new int[0];
    }
}
