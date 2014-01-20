package br.com.pdm.previsao_tempo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ObterTemperatura extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		/*Log.d("ERRO FATAL 717", "0");
		String cidade = arg0[0];
		Log.d("ERRO FATAL 717", "1");
		String url = "http://www.previsaodotempo.org/api.php?city=";
		Log.d("ERRO FATAL 717", "2");
		cidade = cidade.replace(" ", "+");
		Log.d("ERRO FATAL 717", "3");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		Log.d("ERRO FATAL 717", "4");
		HttpGet request = new HttpGet(url+cidade);
		Log.d("ERRO FATAL 717", "5");
		try{
			Log.d("ERRO FATAL 717", "6");
			HttpResponse resposta = httpClient.execute(request);
			HttpEntity httpEntity = resposta.getEntity();
			String html = EntityUtils.toString(httpEntity);
			Log.d("ERRO FATAL 717", html.toString());
			return html;
		}catch(Exception e){
			Log.d("ERRO FATAL 717", "7");
			Log.d("ERRO FATAL 172", e.getMessage().toString());
			return "";
		}*/
		try{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://www.previsaodotempo.org/api.php?city=Rio+De+Janeiro");
			HttpResponse resposta = httpClient.execute(request);
			HttpEntity httpEntity = resposta.getEntity();
			String html = EntityUtils.toString(httpEntity);
			Log.d("TESTE", html.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		Log.d("TESTE", "TESTE");
		return "retorno";
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		Log.d("Temperatura", result.toString());
	}
}
