<<<<<<<< HEAD:Maquina 1/src/main/java/SantanderSAS/Model/Domain/Train/TrainManager.java
package SantanderSAS.Model.Domain.Train;
========
package SantanderSAS.Controller;
>>>>>>>> 0536a787305139f1cf3f6fdc4363820fce30a5f1:Maquina 1/src/main/java/SantanderSAS/Controller/TrainManager.java

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

<<<<<<<< HEAD:Maquina 1/src/main/java/SantanderSAS/Model/Domain/Train/TrainManager.java
========
import SantanderSAS.Model.Domain.Train;
>>>>>>>> 0536a787305139f1cf3f6fdc4363820fce30a5f1:Maquina 1/src/main/java/SantanderSAS/Controller/TrainManager.java
import SantanderSAS.Model.Repository.TrainRepository;

public class TrainManager extends UnicastRemoteObject implements TrainManagerSkeleton {
    private static final long serialVersionUID = 123L;
    private TrainRepository trainRepository;

    public TrainManager(TrainRepository trainRepository) throws RemoteException {
        super();
        this.trainRepository = trainRepository;
    }

    public void addTrain(Train train) throws RemoteException {
        trainRepository.addTrain(train);
    }

    public void removeTrain(String identificador) throws RemoteException {
        trainRepository.removeTrain(identificador);
    }

    public void editTrain(Train train) throws RemoteException {
        trainRepository.editTrain(train);
    }

    public Train getTrain(String identificador) throws RemoteException {
        return trainRepository.getTrain(identificador);
    }

    public Train[] getTrains() throws RemoteException {
        return trainRepository.getTrains();
    }
}