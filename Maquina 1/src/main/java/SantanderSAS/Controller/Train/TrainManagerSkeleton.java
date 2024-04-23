package SantanderSAS.Controller.Train;

import SantanderSAS.Model.Domain.Train.Train;
import bryan.util.list.List;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface TrainManagerSkeleton extends Remote {
    void addTrain(Train train) throws RemoteException;

    void removeTrain(String identificador) throws RemoteException;

    void editTrain(Train train) throws RemoteException;

    List<Map<String, Object>> getTrain(String identificador) throws RemoteException;

    List<Map<String, Object>> getTrains() throws RemoteException;
}