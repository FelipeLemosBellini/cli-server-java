import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1100);

            InterfaceObjRemoto objetoRemoto = new ObjetoRemoto();

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
