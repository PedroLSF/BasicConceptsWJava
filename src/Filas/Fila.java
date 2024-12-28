package Filas;

import EstruturaEstatica.CorpoEstrutura;

public class Fila<T> extends CorpoEstrutura {
	private int capacidade;
	private int tamanho;
	private T[] elementos;

	@SuppressWarnings("unchecked")
	public Fila(int capacidade) {
		if (capacidade <= 0) {
			throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
		}
		this.capacidade = capacidade;
		this.tamanho = 0;
		this.elementos = (T[]) new Object[capacidade];
	}

	@Override
	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void aumentarCapacidade() {
		if (!(this.elementos.length == capacidade))
			return;
		capacidade *= 2;
		T[] novosElementos = (T[]) new Object[capacidade];

		System.arraycopy(this.elementos, 0, novosElementos, 0, this.tamanho);
		this.elementos = novosElementos;
	}

	public void enfileirar(T value) {
		this.aumentarCapacidade();
		this.elementos[tamanho] = value;
		tamanho++;
	}

	public T desenfileirar() throws Exception {
		if (this.estaVazia()) {
			throw new Exception("Fila já vazia!");
		}

		T elementoRemovido = this.elementos[0];

		for (int i = 0; i < tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i + 1];
		}

		this.elementos[tamanho - 1] = null;
		tamanho--;

		return elementoRemovido;
	}

	public int getCapacidade() {
		return capacidade;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.tamanho; i++) {
			sb.append(this.elementos[i]);
			if (i < this.tamanho - 1) {
				sb.append(", ");
			}
		}
		return '[' + sb.toString() + ']';
	}

}
