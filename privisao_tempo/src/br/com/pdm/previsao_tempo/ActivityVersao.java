package br.com.pdm.previsao_tempo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class ActivityVersao extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_versao);
		String version = "Versão do Android: " + Build.VERSION.RELEASE;
		Intent intent = new Intent();
		intent.putExtra("result", version);
		setResult(RESULT_OK, intent);
		finish();
	}
}
