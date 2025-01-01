package Fila.Filas;

import Fila.EstruturaEstatica.CorpoEstrutura;

public class Fila<T> extends CorpoEstrutura<T> {

    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileirar(T value) {
        this.aumentarCapacidade();
        this.elementos[getTamanho()] = value;
        setTamanho(getTamanho() + 1);
    }

    public T desenfileirar() throws Exception {
        if (this.estaVazia()) {
            throw new Exception("Fila já vazia!");
        }

        T elementoRemovido = this.elementos[0];

        for (int i = 0; i < getTamanho() - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }

        this.elementos[getTamanho() - 1] = null;
        setTamanho(getTamanho() - 1);

        return elementoRemovido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getTamanho(); i++) {
            sb.append(this.elementos[i]);
            if (i < getTamanho() - 1) {
                sb.append(", ");
            }
        }
        return '[' + sb.toString() + ']';
    }
}