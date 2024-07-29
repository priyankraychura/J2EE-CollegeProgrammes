package RMI;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);

            RemoteInterface stub = (RemoteInterface) registry.lookup("RemoteObject");

            System.out.println(stub.sayHello());
            System.out.println(stub.sayBye());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
