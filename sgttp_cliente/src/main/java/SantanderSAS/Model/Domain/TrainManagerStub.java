package SantanderSAS.Model.Domain;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrainManagerStub extends Remote {
    void addTrain(String ) throws RemoteException;

    void removeTrain(String identificador) throws RemoteException;

    void editTrain(Train train) throws RemoteException;

    Map<String, String> getTrain(String identificador) throws RemoteException;

    List<Map<String, String>> getTrains() throws RemoteException;
}