package SantanderSAS.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import SantanderSAS.Model.Domain.Train.Train;
import SantanderSAS.Model.Repository.TrainRepository;

public class TrainManager extends UnicastRemoteObject implements TrainManagerSkeleton {
    private static final long serialVersionUID = 123L;
    private final TrainRepository trainRepository;

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