package Fila.EstruturaEstatica;

public abstract class CorpoEstrutura<T> {
    private int capacidade;
    private int tamanho;
    protected T[] elementos;

    @SuppressWarnings("unchecked")
	public CorpoEstrutura(int capacidade) {
        this.setCapacidade(capacidade);
        this.tamanho = 0;
        this.elementos = (T[]) new Object[capacidade];
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        this.capacidade = capacidade;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @SuppressWarnings("unchecked")
    public void aumentarCapacidade() {
        if (this.tamanho < this.capacidade) {
            return;
        }
        capacidade *= 2;
        T[] novosElementos = (T[]) new Object[capacidade];
        System.arraycopy(this.elementos, 0, novosElementos, 0, this.tamanho);
        this.elementos = novosElementos;
    }
}