
package SantanderSAS.Model.Repository.Train;

import SantanderSAS.Model.Domain.Train.Train;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonInterface;

import java.util.HashMap;
import java.util.Map;

public class TrainRepository {

    private final FileJsonInterface<TrainEntity> fileJson;
    private final String pathFile;

    public TrainRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean addTrain(Train train) {
        try {
            TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
            TrainEntity[] newTrainEntities = new TrainEntity[trainEntities.length + 1];
            System.arraycopy(trainEntities, 0, newTrainEntities, 0, trainEntities.length);
            newTrainEntities[newTrainEntities.length - 1] = new TrainEntity(train.getNombre(), train.getIdentificador(), train.getCapacidadDeCarga(), train.getKilometraje(), train.getTipo());
            fileJson.writeObjects(pathFile, newTrainEntities);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean removeTrain(String identificador) {
        try {
            TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
            TrainEntity[] newTrainEntities = new TrainEntity[trainEntities.length - 1];
            int j = 0;
            for (TrainEntity trainEntity : trainEntities) {
                if (!trainEntity.identificador.equals(identificador)) {
                    newTrainEntities[j] = trainEntity;
                    j++;
                }
            }
            fileJson.writeObjects(pathFile, newTrainEntities);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void editTrain(Train train) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        for (int i = 0; i < trainEntities.length; i++) {
            if (trainEntities[i].identificador.equals(train.getIdentificador())) {
                trainEntities[i] = new TrainEntity(train.getNombre(), train.getIdentificador(), train.getCapacidadDeCarga(), train.getKilometraje(), train.getTipo());
            }
        }
        fileJson.writeObjects(pathFile, trainEntities);
    }

    public Map<String, Object> getTrain(String identificador) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        for (TrainEntity trainEntity : trainEntities) {
            if (trainEntity.identificador.equals(identificador)) {
                Map<String, Object> trainMap = new HashMap<>();
                trainMap.put("nombre", trainEntity.nombre);
                trainMap.put("identificador", trainEntity.identificador);
                trainMap.put("capacidadDeCarga", trainEntity.capacidadDeCarga);
                trainMap.put("kilometraje", trainEntity.kilometraje);
                trainMap.put("tipo", trainEntity.tipo);
                return trainMap;
            }
        }
        return null;
    }


    public Train[] getTrains() {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        if (trainEntities == null) {
            return new Train[0]; // Devuelve una matriz vacía si no se encontraron trenes
        }
        Train[] trains = new Train[trainEntities.length];
        for (int i = 0; i < trainEntities.length; i++) {
            trains[i] = new Train(trainEntities[i].nombre, trainEntities[i].identificador, trainEntities[i].capacidadDeCarga, trainEntities[i].kilometraje, trainEntities[i].tipo);
        }
        return trains;
    }
}