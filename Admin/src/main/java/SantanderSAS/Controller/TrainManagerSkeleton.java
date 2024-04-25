package SantanderSAS.Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import SantanderSAS.Model.Domain.Train.Train;

public interface TrainManagerSkeleton extends Remote {
    void addTrain(Train train) throws RemoteException;
    void removeTrain(String identificador) throws RemoteException;
    void editTrain(Train train) throws RemoteException;
    Train getTrain(String identificador) throws RemoteException;
    Train[] getTrains() throws RemoteException;
}