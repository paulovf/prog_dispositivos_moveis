package br.ifet.pdm.jogo_memorizacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaFinal extends Activity {
	//private RelativeLayout telaFinal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        //telaFinal = (RelativeLayout)findViewById(R.id.tela_final);
        setContentView(R.layout.atividade_tela_final);
	}
	
    public void voltar(View component){
    	this.finish();
    }
    
    public void sobre(View component){
    	startActivity(new Intent("sobre"));
    	this.finish();
    }
    
}
