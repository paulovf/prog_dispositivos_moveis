package br.ifet.pdm.jogo_memorizacao;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class JogoMemorizacao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_memorizacao);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jogo_memorizacao, menu);
        return true;
    }
    
}
