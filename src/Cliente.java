import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1100);

            InterfaceObjRemoto iObjRemoto = (InterfaceObjRemoto) registry.lookup("//localhost/Servicos");
            Scanner scanner = new Scanner(System.in);

            int choice = 0;
            do {

                System.out.println("Menu:");
                System.out.println("1) Calcular idade");
                System.out.println("2) Encontrar maior entre dois números");
                System.out.println("3) Encontrar maior em um vetor");
                System.out.println("4) Contar números primos em um paralelepípedo");
                System.out.println("0) Sair");
                System.out.print("Escolha uma opção: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Qual ano você nasceu: ");
                        int ageClient = iObjRemoto.calculateAge(scanner.nextInt());
                        System.out.println("Voce tem: " + ageClient + " anos");
                        break;
                    case 2:
                        System.out.print("Digite um numero: ");
                        int firstNumber = scanner.nextInt();
                        System.out.print("Digite outro numero: ");
                        int secondNumber = scanner.nextInt();

                        int maxNumber = iObjRemoto.findMax(firstNumber, secondNumber);

                        System.out.println("/nO maior numero eh: " + maxNumber);
                        break;
                    case 3:
                        System.out.print("Digite 5 números separados por espaço: ");
                        String input = scanner.next();
                        System.out.println(input);
                        String[] numbers = input.split(" ");

                        List<Integer> numberList = new ArrayList<>();

                        for (int i = 0; i < numbers.length; i++) {
                            numberList.add(Integer.parseInt(numbers[i]));
                        }

                        int biggestNumber = iObjRemoto.findMaxInArray(numberList);
                        System.out.println("Maior numero do vetor: " + biggestNumber);

                        break;
                    case 4:
                        Random random = new Random();
                        int side = 256;
                        int column = 256;
                        int line = 256;

                        int[][][] array3D = new int[side][column][line];

                        for (int i = 0; i < side; i++) {
                            for (int j = 0; j < column; j++) {
                                for (int k = 0; k < line; k++) {
                                    array3D[i][j][k] = random.nextInt(100);
                                }
                            }
                        }
                        int counterPrimeNumbers = iObjRemoto.countPrimesIn3D(array3D);
                        System.out.println("existem " + counterPrimeNumbers + " numeros primos dentro desse paralelepipedo ");
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (choice != 0);
            scanner.close();

        } catch (Exception e) {
            System.out.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
