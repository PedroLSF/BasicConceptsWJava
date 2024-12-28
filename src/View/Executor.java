package View;

import java.util.Scanner;
import Filas.*;

public class Executor {
	public static void main(String[] args) {
		int capacidade;

		try (Scanner scan = new Scanner(System.in)) {
			capacidade = scan.nextInt();
		}

		Fila<Integer> fila = new Fila<Integer>(capacidade);

		fila.enfileirar(1);
		fila.enfileirar(2);
		fila.enfileirar(3);

		System.out.println(fila.toString());

		try {
			fila.desenfileirar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(fila.toString());
	}
}
