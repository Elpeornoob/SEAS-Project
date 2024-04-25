package SantanderSAS.Shared.FileJsonAdapter;

public interface FileJsonInterface<E> {
    E getObject(String pathFile, Class<E> classOfT);

    E[] getObjects(String pathFile, Class<E[]> classOfT);

    Boolean writeObject(String pathFile, E object);

    Boolean writeObjects(String pathFile, E[] objects);
}
