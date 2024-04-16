<<<<<<<< HEAD:Maquina 1/src/main/java/SantanderSAS/Model/Domain/Train/TrainManagerSkeleton.java
package SantanderSAS.Model.Domain.Train;
========
package SantanderSAS.Controller;

import SantanderSAS.Model.Domain.Train;
>>>>>>>> 0536a787305139f1cf3f6fdc4363820fce30a5f1:Maquina 1/src/main/java/SantanderSAS/Controller/TrainManagerSkeleton.java

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TrainManagerSkeleton extends Remote {
    void addTrain(Train train) throws RemoteException;
    void removeTrain(String identificador) throws RemoteException;
    void editTrain(Train train) throws RemoteException;
    Train getTrain(String identificador) throws RemoteException;
    Train[] getTrains() throws RemoteException;
}