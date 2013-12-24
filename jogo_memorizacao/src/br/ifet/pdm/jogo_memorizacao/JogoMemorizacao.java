package br.ifet.pdm.jogo_memorizacao;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class JogoMemorizacao extends Activity {

	private RelativeLayout telaPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
        setContentView(R.layout.jogo_memorizacao);
    }
    
    public void botao1(View component){
    	telaPrincipal = (RelativeLayout)findViewById(R.id.tela_principal);
    	telaPrincipal.setBackgroundColor(Color.BLUE);
    }
    
    public void botao2(View component){
    	telaPrincipal.setBackgroundColor(Color.RED);
    }
    
    public void botao3(View component){
    	telaPrincipal.setBackgroundColor(Color.GREEN);
    }
    
    public void botao4(View component){
    	Toast.makeText(this, "Botao Laranja", Toast.LENGTH_LONG).show();
    }
    
    public void botao5(View component){
    	Toast.makeText(this, "Botao Cinza", Toast.LENGTH_LONG).show();
    	telaPrincipal.setBackgroundColor(Color.CYAN);
    }
    
    public void botao6(View component){
    	Toast.makeText(this, "Botao Marrom", Toast.LENGTH_LONG).show();
    }
    
    public void reiniciar(View component){
    	telaPrincipal.setBackgroundColor(Color.WHITE);
    }    
}