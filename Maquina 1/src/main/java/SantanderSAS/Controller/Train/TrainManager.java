package SantanderSAS.Controller.Train;

import SantanderSAS.Model.Domain.Train.Train;
import SantanderSAS.Model.Repository.Train.TrainRepository;
import bryan.util.list.List;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class TrainManager extends UnicastRemoteObject implements TrainManagerSkeleton {
    private static final long serialVersionUID = 123L;
    private final TrainRepository trainRepository;

    public TrainManager(TrainRepository trainRepository) throws RemoteException {
        super();
        this.trainRepository = trainRepository;
    }

    public void addTrain(String nombre, String identificador, int capacidadDeCarga, int kilometraje, String tipo) throws RemoteException {
        trainRepository.addTrain(new Train(nombre, identificador, capacidadDeCarga, kilometraje, tipo));
    }

    public void removeTrain(String identificador) throws RemoteException {
        trainRepository.removeTrain(identificador);
    }

    public void editTrain(String nameTrain) throws RemoteException {
        trainRepository.editTrain(nameTrain);
    }

    public Map<String, String> getTrain(String identificador) throws RemoteException {
    return trainRepository.getTrain(identificador);
}

    public List<Map<String, String>> getTrains() throws RemoteException {
        return trainRepository.getTrains();
    }

}