package recursao;

public class GeradorSequencia {
	public void geraSequencia1(int n) {
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			System.out.print(n + " ");
			geraSequencia1(n - 1);
		}
	}

	public void geraSequencia2(int n) {
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			// A ORDEM DOS COMANDOS NA RECURSÃO ESTÁ INVERTIDA
			// VEJA O EFEITO E TENTE ENTENDER O PORQUE DISSO

			// Nesse caso, ele está chamando a recursividade antes de efetuar o print.
			// Como o caso de parada é o "0" ele só consegue efetuar o print depois de chegar nesse caso base
			// Após atingir o caso base, ele vem chamando os passos recursivos anteriores, fazendo dessa maneira o print deles
			geraSequencia2(n - 1);
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		GeradorSequencia gs = new GeradorSequencia();
		System.out.println("Executando metodo de geracao de sequencia 1");
		gs.geraSequencia1(8);
		System.out.println("\n");
		System.out.println("Executando metodo de geracao de sequencia 2");
		gs.geraSequencia2(8);
	}
}
