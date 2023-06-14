package criptografia;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();
		GeradorDeChaves geradorDeChaves = new GeradorDeChaves();
		Criptografia criptografia = new Criptografia();

		String ArquivoEntrada = null;
		String ArquivoSaida = null;
		String ArquivoChavePublica = null;
		String ArquivoChavePrivada = null;

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out
					.println("Digite: (1) Criptografar,  (2): Decriptografar, (3) Gerar arquivos de chaves, (4) Sair");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Opçãoo 1 Criptografar selecionada");
					scanner.nextLine();

					System.out.println("Arquivo para ser criptografado: ");
					ArquivoEntrada = scanner.nextLine();

					System.out.println("Nome do arquivo de saida criptografado: ");
					ArquivoSaida = scanner.nextLine();

					System.out.println("Arquivo de chave publica: ");
					ArquivoChavePublica = scanner.nextLine();

					try {

						byte[] resultado = criptografia.Criptografar(gerenciadorDeArquivos.LerArquivo(ArquivoEntrada),
								geradorDeChaves.GetChavePublica(ArquivoChavePublica));
						gerenciadorDeArquivos.GravarDadosParaArquivo(resultado, ArquivoSaida);
						System.out.println("Arquivo criptografado com sucesso!");

					} catch (IOException e) {

						e.printStackTrace();
					}

					break;

				case 2:
					System.out.println("Opção 2 Decriptografar selecionada");
					scanner.nextLine();

					System.out.println("Arquivo para ser decriptografado: ");
					ArquivoEntrada = scanner.nextLine();

					System.out.println("Nome do arquivo de saida decriptografado: ");
					ArquivoSaida = scanner.nextLine();

					System.out.println("Arquivo de chave privada: ");
					ArquivoChavePrivada = scanner.nextLine();

					try {

						byte[] resultado = criptografia.DeCriptografar(gerenciadorDeArquivos.LerArquivo(ArquivoEntrada),
								geradorDeChaves.GetChavePrivada(ArquivoChavePrivada));
						gerenciadorDeArquivos.GravarDadosParaArquivo(resultado, ArquivoSaida);

						System.out.println("Arquivo descriptografado com sucesso!");
					} catch (IOException e) {

						e.printStackTrace();
					}

					break;

				case 3:
					System.out.println("Opção 3 selecionada");
					scanner.nextLine();
					System.out.println("Digite o caminho para a chave publica:");
					ArquivoChavePublica = scanner.nextLine();
					System.out.println("Digite o caminho para a chave privada:");
					ArquivoChavePrivada = scanner.nextLine();

					geradorDeChaves.GerarParDeChaves(ArquivoChavePublica, ArquivoChavePrivada);

					break;
				case 4:
					System.out.println("Saindo...");
					return;
				default:
					System.out.println("Nenhuma opção válida selecionada");

			}

		}
	}
}
