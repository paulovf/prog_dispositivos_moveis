package br.ifet.pdm.jogo_memorizacao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class JogoMemorizacao extends Activity {

	private RelativeLayout telaPrincipal;
	private GerarSequencia gerarSequencia;
	private ProgressBar barraDeProgresso;
	private int progresso;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
        setContentView(R.layout.jogo_memorizacao);
        barraDeProgresso = (ProgressBar)findViewById(R.id.barra_de_progresso);
        barraDeProgresso.setBackgroundColor(Color.BLACK);
        gerarSequencia = new GerarSequencia();
        this.progresso = 0;
    }
    
    public void botao1(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.BLUE);
    	verificaCor(1, component);
    }
    
    public void botao2(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.RED);
    	verificaCor(2, component);
    }
    
    public void botao3(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.GREEN);
    	verificaCor(3, component);
    }
    
    public void botao4(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.rgb(255, 168, 0));
    	verificaCor(4, component);
    }
    
    public void botao5(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.rgb(166, 166, 160));
    	verificaCor(5, component);
    }
    
    public void botao6(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.rgb(124, 68, 2));
    	verificaCor(6, component);
    }
    
    public void reiniciar(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.WHITE);
    	gerarSequencia = new GerarSequencia();
        barraDeProgresso.setProgress(0);
    	progresso = 0;
    }
    
    public void verificaCor(int valor, View component){
    	if(!gerarSequencia.verificaSequencia(valor)){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			builder.setMessage("Você perdeu.");
			AlertDialog alert = builder.create();
			alert.setCancelable(false);
			alert.show();    		
    		reiniciar(component);
    	}else{
    		this.progresso ++;
    		barraDeProgresso.incrementProgressBy(1);
    		if(this.progresso == 6){
    			startActivity(new Intent("tela_final"));
    			reiniciar(component);
    		}
    	}
    }
}