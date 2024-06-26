
package SantanderSAS.Model.Repository.Train;

import SantanderSAS.Model.Domain.Train.Train;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonAdapter;
import SantanderSAS.Shared.FileJsonAdapter.FileJsonInterface;
import bryan.util.list.List;

import java.util.ArrayList;
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

    public void editTrain(String nameTrain, String newNombre, String newIdentificador, int newCapacidadDeCarga, int newKilometraje, String newTipo) {
    TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
    for (int i = 0; i < trainEntities.length; i++) {
        if (trainEntities[i].nombre.equals(nameTrain)) {
            trainEntities[i] = new TrainEntity(newNombre, newIdentificador, newCapacidadDeCarga, newKilometraje, newTipo);
        }
    }
    fileJson.writeObjects(pathFile, trainEntities);
}

    public Map<String, String> getTrain(String identificador) {
        TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
        for (TrainEntity trainEntity : trainEntities) {
            if (trainEntity.identificador.equals(identificador)) {
                Map<String, String> trainMap = new HashMap<>();
                trainMap.put("nombre", trainEntity.nombre);
                trainMap.put("identificador", trainEntity.identificador);
                trainMap.put("capacidadDeCarga", String.valueOf(trainEntity.capacidadDeCarga));
                trainMap.put("kilometraje", String.valueOf(trainEntity.kilometraje));
                trainMap.put("tipo", trainEntity.tipo);
                return trainMap;
            }
        }
        return null;
    }

    public List<Map<String, String>> getTrains() {
    TrainEntity[] trainEntities = fileJson.getObjects(pathFile, TrainEntity[].class);
    if (trainEntities == null) {
        return (List<Map<String, String>>) new ArrayList<>(); // Devuelve una lista vacía si no se encontraron trenes
    }
    List<Map<String, String>> trains = (List<Map<String, String>>) new ArrayList<>();
    for (TrainEntity trainEntity : trainEntities) {
        Map<String, String> trainMap = new HashMap<>();
        trainMap.put("nombre", trainEntity.nombre);
        trainMap.put("identificador", trainEntity.identificador);
        trainMap.put("capacidadDeCarga", String.valueOf(trainEntity.capacidadDeCarga));
        trainMap.put("kilometraje", String.valueOf(trainEntity.kilometraje));
        trainMap.put("tipo", trainEntity.tipo);
        trains.add(trainMap);
    }
    return trains;
}
}