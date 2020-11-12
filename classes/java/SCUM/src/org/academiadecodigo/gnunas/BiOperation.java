package org.academiadecodigo.gnunas;

@FunctionalInterface
public interface BiOperation<T> {
    T operation(T t1, T t2);
}
