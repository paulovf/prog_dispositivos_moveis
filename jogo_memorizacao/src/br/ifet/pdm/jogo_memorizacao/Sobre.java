package br.ifet.pdm.jogo_memorizacao;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Sobre extends Activity {
	private RelativeLayout telaSobre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.atividade_sobre);
        telaSobre = (RelativeLayout)findViewById(R.id.tela_sobre);
        telaSobre.setBackgroundColor(Color.rgb(255, 168, 0));
	}
	
    public void voltar(View component){
    	this.finish();
    }
}
