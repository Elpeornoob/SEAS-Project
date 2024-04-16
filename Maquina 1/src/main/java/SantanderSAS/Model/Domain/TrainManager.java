package SantanderSAS.Model.Domain;

import SantanderSAS.Model.Repository.TrainRepository;

public class TrainManager {
    private TrainRepository trainRepository;

    public TrainManager(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }

    public void addTrain(Train train){
        trainRepository.addTrain(train);
    }

    public void removeTrain(String identificador){
        trainRepository.removeTrain(identificador);
    }

    public void editTrain(Train train){
        trainRepository.editTrain(train);
    }

    public Train getTrain(String identificador){
        return trainRepository.getTrain(identificador);
    }

    public Train[] getTrains(){
        return trainRepository.getTrains();
    }
}
