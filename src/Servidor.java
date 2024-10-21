import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Inicia o registro RMI na porta 21099
            Registry registry = LocateRegistry.createRegistry(21099);

            ObjetoRemoto objetoRemoto = new ObjetoRemoto();

            registry.rebind("//localhost/Servicos", objetoRemoto);
            System.out.println("**************************************");
            System.out.println("* UNAERP SERVER INICIADO COM SUCESSO *");
            System.out.println("**************************************");
        } catch (Exception e) {
            System.out.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
