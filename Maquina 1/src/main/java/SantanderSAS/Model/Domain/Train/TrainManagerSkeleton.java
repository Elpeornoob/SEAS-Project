package SantanderSAS.Model.Domain.Train;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrainManagerSkeleton extends Remote{
    
    public boolean addTrainMercedez(String nombre, String identificador, int capacidadDeCarga, int kilometraje) throws RemoteException;

    public boolean addTrainArnold(String nombre, String identificador, int capacidadDeCarga, int kilometraje) throws RemoteException;

    public boolean removeTrain(String idTrain) throws RemoteException;

    public void editTrain(Train train) throws RemoteException;

    public Train getTrain(String idTrain) throws RemoteException;

    public Train[] getTrains() throws RemoteException;

}
