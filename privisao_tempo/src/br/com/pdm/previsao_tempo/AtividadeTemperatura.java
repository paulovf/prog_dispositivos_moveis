package br.com.pdm.previsao_tempo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AtividadeTemperatura extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.atividade_temperatura);

		Intent intent = getIntent();
		Bundle dados = intent.getExtras();
		String cidade = dados.getString("cidade").toString();
		
		TextView campoTextoCidade = (TextView)findViewById(R.id.atividade_temperatura_titulo);
		TextView campoTextoTemperatura = (TextView)findViewById(R.id.atividade_temperatura_temperatura);
        
		ProgressBar barraDeProgresso = (ProgressBar)findViewById(R.id.atividade_previsao_tempo_barra_progresso_temperatura);
		try{
			double temperatura = Double.parseDouble(dados.getString("temperatura").toString().replace(",", "."));

	        barraDeProgresso.setBackgroundColor(Color.BLACK);
	        barraDeProgresso.getProgressDrawable().setColorFilter(Color.RED, Mode.SRC_IN);
			barraDeProgresso.setProgress((int)temperatura);
			campoTextoCidade.setText(cidade);
			campoTextoTemperatura.setText(String.valueOf(temperatura) + " °C");
			
		}catch(NumberFormatException e){
			campoTextoCidade.setText(cidade);
			campoTextoTemperatura.setText("Cidade não encontrada.");
		}
	}
	
    public void voltar(View component){
    	this.finish();
    }
}