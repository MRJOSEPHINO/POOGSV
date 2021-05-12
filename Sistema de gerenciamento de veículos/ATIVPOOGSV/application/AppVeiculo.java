package application;

import java.util.Scanner;

import entities.GerenciarVeiculos;
import entities.Veiculo;

public class AppVeiculo {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		GerenciarVeiculos gv = new GerenciarVeiculos();

		boolean resposta = true;
		int menu;

		while (resposta == true) {

			System.out.println("******************************************");
			System.out.println("   SISTEMA DE GERENCIAMENTO DE VEÍCULO  "  );
			System.out.println("******************************************");
			System.out.println("	POR FAVOR SELECIONE AS OPÇÕES ABAIXO ");
			System.out.println();
			System.out.println("| 1 - Adicionar Veículo");
			System.out.println("| 2 - Remover Veículo ");
			System.out.println("| 3 - Pesquisa por placa");
			System.out.println("| 4 - Mostrar veiculos");
			System.out.println("| 5 - Calculo de impostos");
			System.out.println("| 6 - Mostrar veiculos por tipo de combustivel");
			System.out.println("| 7 - Sair");
		
			menu = entrada.nextInt();
			entrada.nextLine();

			switch (menu) {
			case 1:
				System.out.print("Qual o modelo? ");
				String modelo = entrada.nextLine();
				System.out.print("Qual é a Marca? ");
				String marca = entrada.nextLine();
				System.out.print("Qaul o Ano de Fabricação? ");
				int anoFabricacao = entrada.nextInt();
				entrada.nextLine();
				System.out.print("Qual o valor de Mercado? ");
				double valorMercado = entrada.nextDouble();
				entrada.nextLine();
				System.out.print("Informe qual é a Placa: EX: (BMW0001): ");
				String placa = entrada.nextLine();
				System.out.print("Informe o tipo de combustível (Alcool, Gasolina, Flex, GNV, Diesel): ");
				String tipoCombustivel = entrada.nextLine();
				gv.adicionar(new Veiculo(modelo, marca, anoFabricacao, valorMercado, placa, tipoCombustivel));
				System.out.println("Veículo adicionado.");
				break;
			case 2:
				System.out.print("Qual a placa do carro a ser removido? ");
				placa = entrada.nextLine();
				System.out.println(gv.remover(placa));
				break;
			case 3:
				System.out.print("Qual a placa do carro para pesquisa? ");
				placa = entrada.nextLine();
				Veiculo v = gv.buscarPorPlaca(placa);
				if (v != null) {
					System.out.println(v.imprimir());
				} else {
					System.out.println("Veículo não localizado.");
				}
				break;
			case 4:
				System.out.println(gv.listarVeiculos());
				break;
			case 5:
				System.out.print("Informe a placa do carro: ");
				placa = entrada.nextLine();
				System.out.printf("Imposto: R$ %.2f\n", gv.obterValorImposto(placa));
				break;
			case 6:
				System.out.print("Informe o tipo de combustível do veículo (álcool, gasolina, flex, GNV, diesel): ");
				tipoCombustivel = entrada.nextLine();
				System.out.println(gv.listarVeiculoPorCombustivel(tipoCombustivel));
				break;
			case 7:
				System.out.println("Você escolheu a opção 7 - Sair o programa foi encerrado.");
				resposta = false;
				break;
			default:
				System.out.println("Opção incorreta!");
				break;
			}
		}

		entrada.close();
	}
}
