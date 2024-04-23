package SantanderSAS.Model.Domain;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface TrainManagerStub extends Remote {
    void addTrain(String nombre, String identificador, int capacidadDeCarga, int kilometraje, String tipo) throws RemoteException;

    void removeTrain(String identificador) throws RemoteException;

    void editTrain(String identificador) throws RemoteException;

    Map<String, String> getTrain(String identificador) throws RemoteException;

    List<Map<String, String>> getTrains() throws RemoteException;
}