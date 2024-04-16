package SantanderSAS.Model.Domain;

public class Train {
    private String nombre;
    private String identificador;
    private int capacidadDeCarga;
    private int kilometraje;
    private String tipo;

    public Train(String nombre, String identificador, int capacidadDeCarga, int kilometraje, String tipo) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.capacidadDeCarga = capacidadDeCarga;
        this.kilometraje = kilometraje;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getCapacidadDeCarga() {
        return capacidadDeCarga;
    }

    public void setCapacidadDeCarga(int capacidadDeCarga) {
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}