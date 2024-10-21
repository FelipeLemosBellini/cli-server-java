import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(21099);

            InterfaceObjRemoto iObjRemoto = (InterfaceObjRemoto) registry.lookup("//localhost/Servicos");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            do {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("Menu:");
                System.out.println("1) Calcular idade");
                System.out.println("2) Encontrar maior entre dois números");
                System.out.println("3) Encontrar maior em um vetor");
                System.out.println("4) Contar números primos em um paralelepípedo");
                System.out.println("5) Gerar histograma de uma imagem 3D");
                System.out.println("0) Sair");
                System.out.print("Escolha uma opção: ");


                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

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
