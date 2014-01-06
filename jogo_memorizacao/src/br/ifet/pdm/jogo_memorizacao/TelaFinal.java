package br.ifet.pdm.jogo_memorizacao;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class TelaFinal extends Activity {
	private RelativeLayout telaFinal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        //telaFinal = (RelativeLayout)findViewById(R.id.tela_final);
        setContentView(R.layout.atividade_tela_final);
        telaFinal = (RelativeLayout)findViewById(R.id.tela_final);
        telaFinal.setBackgroundColor(Color.rgb(255, 168, 0));
	}
	
    public void voltar(View component){
    	this.finish();
    }
    
    public void sobre(View component){
    	startActivity(new Intent("sobre"));
    	this.finish();
    }
    
}
