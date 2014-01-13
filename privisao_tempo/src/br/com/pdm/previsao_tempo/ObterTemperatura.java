package br.com.pdm.previsao_tempo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class ObterTemperatura extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		String cidade = arg0[0];
		String url = "http://www.previsaodotempo.org/api.php?city=";
		cidade = cidade.replace(" ", "+");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(url+cidade);
		try{
			HttpResponse resposta = httpClient.execute(request);
			HttpEntity httpEntity = resposta.getEntity();
			String html = EntityUtils.toString(httpEntity);
			Log.d("ERRO FATAL 717", html.toString());
			return html;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		Log.d("Temperatura", result.toString());
	}
}
