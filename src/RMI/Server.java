package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            RemoteInterface remoteObject = new RemoteImplementation();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteObject", remoteObject);

            System.out.println("Server ready");
        } catch (RemoteException e) {
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
