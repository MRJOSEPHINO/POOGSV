package entities;

public class Veiculo {

	private String modelo;
	private String marca;
	private int ano;
	private double valorDeMercado;
	private String placa;
	private String combustivel;

	public Veiculo(String modelo, String marca, int ano, double valorDeMercado, String placa, String combustivel) {
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.valorDeMercado = valorDeMercado;
		this.placa = placa;
		this.combustivel = combustivel;
	}

	public String getModelo() {
		return modelo;
	}
	public String getMarca() {
		return marca;
	}
	public int getAno() {
		return ano;
	}
	public double getValorDeMercado() {
		return valorDeMercado;
	}
	public String getPlaca() {
		return placa;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setValorDeMercado(double valorDeMercado) {
		this.valorDeMercado = valorDeMercado;
	}
	public double calcularImposto(int ano, String combustivel) {
		if (2021 - ano > 20) {
			return 0;
		} else if (combustivel.equalsIgnoreCase("GNV") || combustivel.equalsIgnoreCase("Alcool")) {
			return getValorDeMercado() * 0.03;
		} else {
			return getValorDeMercado() * 0.04;
		}
	}
	public String imprimir() {
		return "Modelo: " + modelo + ", Marca: " + marca + ", Ano: " + ano + ", Valor de Mercado: R$ " + valorDeMercado
				+ ", Placa: " + placa + ", Combustível: " + combustivel + "\n";
	}

}
