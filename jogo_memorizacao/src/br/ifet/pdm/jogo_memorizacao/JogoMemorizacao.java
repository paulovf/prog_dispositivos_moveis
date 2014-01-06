package br.ifet.pdm.jogo_memorizacao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class JogoMemorizacao extends Activity {

	private RelativeLayout telaPrincipal;
	private GerarSequencia gerarSequencia;
	private ProgressBar barraDeProgresso;
	private List<Button> botoes = new ArrayList<Button>();
	private int progresso;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
        setContentView(R.layout.jogo_memorizacao);
        barraDeProgresso = (ProgressBar)findViewById(R.id.barra_de_progresso);
        barraDeProgresso.setBackgroundColor(Color.BLACK);
        barraDeProgresso.getProgressDrawable().setColorFilter(Color.YELLOW, Mode.SRC_IN);
        gerarSequencia = new GerarSequencia();
        this.progresso = 0;
        botoes.add((Button)findViewById(R.id.botao_1));
        botoes.add((Button)findViewById(R.id.botao_2));
        botoes.add((Button)findViewById(R.id.botao_3));
        botoes.add((Button)findViewById(R.id.botao_4));
        botoes.add((Button)findViewById(R.id.botao_5));
        botoes.add((Button)findViewById(R.id.botao_6));
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onRestoreInstanceState(savedInstanceState);
    	gerarSequencia.embaralhar();
    }
    
    public void botao1(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.BLUE);
    	ocultarBotao(botoes.get(0));
    	verificaCor(1, component);
    }
    
    public void botao2(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.RED);
    	ocultarBotao(botoes.get(1));
    	verificaCor(2, component);
    }
    
    public void botao3(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.GREEN);
    	ocultarBotao(botoes.get(2));
    	verificaCor(3, component);
    }
    
    public void botao4(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.rgb(255, 168, 0));
    	ocultarBotao(botoes.get(3));
    	verificaCor(4, component);
    }
    
    public void botao5(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.rgb(166, 166, 160));
    	ocultarBotao(botoes.get(4));
    	verificaCor(5, component);
    }
    
    public void botao6(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.rgb(124, 68, 2));
    	ocultarBotao(botoes.get(5));
    	verificaCor(6, component);
    }
    
    public void reiniciar(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.WHITE);
    	gerarSequencia.setValorAtual(0);
        barraDeProgresso.setProgress(0);
        for(Button b: botoes)
        	b.setVisibility(View.VISIBLE);
    	progresso = 0;
    	gerarSequencia.embaralhar();
    }
    
    public void verificaCor(int valor, View component){
    	if(!gerarSequencia.verificaSequencia(valor)){
			/*AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			builder.setMessage("Você perdeu.");
			AlertDialog alert = builder.create();
			alert.setCancelable(false);
			alert.show();*/
        	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
        	telaPrincipal.setBackgroundColor(Color.WHITE);
        	gerarSequencia.setValorAtual(0);
            barraDeProgresso.setProgress(0);
            for(Button b: botoes)
            	b.setVisibility(View.VISIBLE);
        	progresso = 0;
    	}else{
    		this.progresso ++;
    		barraDeProgresso.incrementProgressBy(1);
    		if(this.progresso == 6){
    			startActivity(new Intent("tela_final"));
    			reiniciar(component);
    		}
    	}
    }
    
    public void ocultarBotao(Button botao){
    	botao.setVisibility(View.INVISIBLE);
    }
}