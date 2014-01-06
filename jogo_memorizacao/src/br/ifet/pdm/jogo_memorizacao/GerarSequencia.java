package br.ifet.pdm.jogo_memorizacao;


public class GerarSequencia {
	private static final int AZUL = 1;
	private static final int VERMELHO = 2;
	private static final int VERDE = 3;
	private static final int LARANJA = 4;
	private static final int CINZA = 5;
	private static final int MARRON = 6;
	private int sequencia[] = {MARRON, CINZA, LARANJA, VERDE, VERMELHO, AZUL};
	private int valorAtual = 0;

	public boolean verificaSequencia(int valor){
		if(valor == sequencia[valorAtual]){
			valorAtual += 1;
			return true;
		}
		return false;
	}
}
