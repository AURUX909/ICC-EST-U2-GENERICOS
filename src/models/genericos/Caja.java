package models.genericos;

public class Caja<T> {
    private T t;

    public void guardar(T t) {
        this.t = t;
    }

    public T obtener() {
        return t;
    }

}