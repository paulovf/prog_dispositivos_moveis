package br.ifet.pdm.jogo_memorizacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.util.Log;

public class GerarSequencia {
	private int valorAtual = 0;
	List<Integer> sequencia = new ArrayList<Integer>();
	
	public GerarSequencia() {
		// TODO Auto-generated constructor stub
		sequencia.add(1);
		sequencia.add(2);
		sequencia.add(3);
		sequencia.add(4);
		sequencia.add(5);
		sequencia.add(6);
		embaralhar();
	}

	public boolean verificaSequencia(int valor){
		if(valor == sequencia.get(valorAtual)){
			valorAtual += 1;
			return true;
		}
		return false;
	}

	public void setValorAtual(int valorAtual) {
		this.valorAtual = valorAtual;
	}
	
	public void embaralhar(){
		Collections.shuffle(sequencia);
		Log.d("ERRO FATAL 111", sequencia.toString());
	}
}