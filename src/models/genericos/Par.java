package models.genericos;

public class Par<K, V> {
    private K clave;
    private V valor;

    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K obtenerClave() {
        return clave;
    }

    public void establecerClave(K clave) {
        this.clave = clave;
    }

    public V obtenerValor() {
        return valor;
    }

    public void establecerValor(V valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Par [clave=" + clave + ", valor=" + valor + "]";
    }

}