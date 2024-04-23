package SantanderSAS.Model.Domain;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrainManagerStub extends Remote {
    void addTrain(String name, String id, String capacidadDeCarga, String kilometraje, String tipo) throws RemoteException;

    void removeTrain(String identificador) throws RemoteException;

    void editTrain(String id) throws RemoteException;

    
}