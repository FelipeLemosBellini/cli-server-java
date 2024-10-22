import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        int currentYear = LocalDate.now().getYear();
        return currentYear - birthYear;
    }

    @Override
    public int findMax(int a, int b) throws RemoteException {
        return (a > b) ? a : b;
    }

    @Override
    public int findMaxInArray(List<Integer> array) throws RemoteException {
        Integer maxNumber = array.get(0);
        for (Integer i : array) {
            if (array.get(i) > maxNumber) maxNumber = array.get(i);
        }
        return maxNumber;
    }

    @Override
    public int countPrimesIn3D(int[][][] array) throws RemoteException {
        int counter = 0;

        for (int[][] column : array) {
            for (int[] line : column) {
                for (int number : line) {
                    if (isPrime(number)) counter++;
                }
            }
        }

        return counter;
    }


    public static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
