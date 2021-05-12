package entities;

import java.util.ArrayList;
import java.util.List;

public class GerenciarVeiculos {
	private List<Veiculo> automotores = new ArrayList<>();

	public GerenciarVeiculos() {
	}
	public void adicionar(Veiculo a) {
		automotores.add(a);
	}
	public boolean remover(String placa) {
		for (Veiculo v : automotores) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				automotores.remove(v);
				return true;
			}
		}
		return false;
	}
	public Veiculo buscarPorPlaca(String placa) {
		for (Veiculo v : automotores) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				return v;
			}
		}
		return null;
	}
	public String listarVeiculos() {
		String x = "";
		for (Veiculo v : automotores) {
			x += v.imprimir().toString();
		}
		return x;
	}
	public double obterValorImposto(String placa) {
		for (Veiculo v : automotores) {
			if (v.getPlaca().equalsIgnoreCase(placa)) {
				return v.calcularImposto(v.getAno(), v.getCombustivel());
			}
		}
		return -1;
	}
	public String listarVeiculoPorCombustivel(String combustivel) {
		String x = "";
		for (Veiculo v : automotores) {
			if (v.getCombustivel().equalsIgnoreCase(combustivel)) {
				x += v.imprimir().toString();
			}
		}
		if (x == "")
			return "Veículo não Localizado.";
		else
			return x;
	}
}