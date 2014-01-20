package br.com.pdm.previsao_tempo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PrevisaoTempo extends Activity {

	private static final int reqCode = 1;
	private TextView campoTexto;
	private TextView campoTextoCidade;
	private TextView campoTextoErro;
	private String cidade;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_previsao_tempo);
		campoTexto = (TextView)findViewById(R.id.campo_texto_dados);
		campoTextoCidade = (TextView)findViewById(R.id.atividade_previsao_tempo_campo_cidade);
		campoTextoErro = (TextView)findViewById(R.id.atividade_previsao_tempo_campo_erro);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == reqCode){
			if(resultCode == RESULT_OK){
				campoTexto.setText(data.getStringExtra("result"));
			}
		}
	}
	
	public void obterDados(View Component){
		Intent intent = new Intent(this, ActivityVersao.class);
		startActivityForResult(intent, reqCode);		
	}
	
	public void buscarCidade(View Component){

		cidade = campoTextoCidade.getText().toString();
		if(cidade != null || cidade.equals(" ")){
			ObterTemperatura obterTemperatura = new ObterTemperatura();
			obterTemperatura.execute(cidade);
			Toast.makeText(this, cidade, Toast.LENGTH_SHORT).show();
			campoTextoErro.setText("");
		}else{
			campoTextoErro.setText("Forneça um nome de cidade válido!");
		}
	}
}