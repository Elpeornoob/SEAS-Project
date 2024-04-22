package SantanderSAS.Model.Repository;

import java.io.Serializable;

public class TrainEntity implements Serializable {
    String nombre;
    String identificador;
    int capacidadDeCarga;
    int kilometraje;
    String tipo;

    public TrainEntity(String nombre, String identificador, int capacidadDeCarga, int kilometraje, String tipo) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.capacidadDeCarga = capacidadDeCarga;
        this.kilometraje = kilometraje;
        this.tipo = tipo;
    }
}