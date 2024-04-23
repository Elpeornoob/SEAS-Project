package SantanderSAS.Model.Domain.Train;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import SantanderSAS.Model.Repository.Train.TrainRepository;

public class TrainManagerPrueba extends UnicastRemoteObject implements TrainManagerSkeleton {
    private static final long serialVersionUID = 123L;
    private final TrainRepository trainRepository;

    protected TrainManagerPrueba(TrainRepository trainRepository) throws RemoteException {
        super();
        this.trainRepository = trainRepository;
    }

    @Override
    public boolean addTrainMercedez(String nombre, String identificador, int capacidadDeCarga, int kilometraje)
            throws RemoteException {
        return trainRepository.addTrain(new TrainMercedezBenz(nombre, identificador, capacidadDeCarga, kilometraje, ""));
    }

    @Override
    public boolean addTrainArnold(String nombre, String identificador, int capacidadDeCarga, int kilometraje)
            throws RemoteException {
        return trainRepository.addTrain(new TrainArnold(nombre, identificador, capacidadDeCarga, kilometraje, ""));
    }

    @Override
    public boolean removeTrain(String idTrain) throws RemoteException {
        return trainRepository.removeTrain(idTrain);
    }

    @Override
    public void editTrain(Train train) throws RemoteException {
        trainRepository.editTrain(train);
    }

    @Override
    public Train getTrain(String idTrain) throws RemoteException {
        return (Train) trainRepository.getTrain(idTrain);
    }

    @Override
    public Train[] getTrains() throws RemoteException {
        return trainRepository.getTrains();
    }

}
