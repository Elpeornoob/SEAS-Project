package SantanderSAS.Model.Domain;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrainManagerSkeleton extends Remote {
    void addTrain(Train train) throws RemoteException;
    void removeTrain(String identificador) throws RemoteException;
    void editTrain(Train train) throws RemoteException;
    Train getTrain(String identificador) throws RemoteException;
    Train[] getTrains() throws RemoteException;
}