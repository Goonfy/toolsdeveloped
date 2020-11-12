package org.academiadecodigo.gnunas;

@FunctionalInterface
public interface MonoOperation<T> {
    T operation(T t1);
}
