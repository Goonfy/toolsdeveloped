package org.academiadecodigo.gnunas;

public class Machine<T> {

    public T operation(T t1, MonoOperation<T> monoOperation) {
        return monoOperation.operation(t1);
    }

    public T operation(T t1, T t2, BiOperation<T> biOperation) {
        return biOperation.operation(t1, t2);
    }
}
