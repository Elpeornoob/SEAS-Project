package SantanderSAS.Model.Domain.Train;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrainManagerSkeleton extends Remote {

    boolean addTrainMercedez(String nombre, String identificador, int capacidadDeCarga, int kilometraje) throws RemoteException;

    boolean addTrainArnold(String nombre, String identificador, int capacidadDeCarga, int kilometraje) throws RemoteException;

    boolean removeTrain(String idTrain) throws RemoteException;

    void editTrain(Train train) throws RemoteException;

    Train getTrain(String idTrain) throws RemoteException;

    Train[] getTrains() throws RemoteException;

}
