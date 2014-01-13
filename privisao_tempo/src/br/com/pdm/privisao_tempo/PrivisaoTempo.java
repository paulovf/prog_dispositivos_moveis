package br.com.pdm.privisao_tempo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PrivisaoTempo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_privisao_tempo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.privisao_tempo, menu);
		return true;
	}

}
