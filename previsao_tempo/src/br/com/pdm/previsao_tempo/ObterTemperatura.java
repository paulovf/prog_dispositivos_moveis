package br.com.pdm.previsao_tempo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class ObterTemperatura extends AsyncTask<String, Void, String> {
	
	private String cidade;
	private Context context;
		
	public ObterTemperatura(Context context) {
		this.context = context.getApplicationContext();
	}

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		this.cidade = arg0[0];
		String url = "http://www.previsaodotempo.org/api.php?city=";
		String cidade = this.cidade.replace(" ", "+");
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(url+cidade);
		try{
			HttpResponse resposta = httpClient.execute(request);
			HttpEntity httpEntity = resposta.getEntity();
			String html = EntityUtils.toString(httpEntity);
			JSONObject resultadoDados = new JSONObject(html.toString());
			JSONObject dadosTemperatura = new JSONObject(resultadoDados.getJSONObject("data").toString());
			double temperatura = (Double.parseDouble(dadosTemperatura.get("temperature").toString()) - 32) / 1.8;
			return String.format("%.2f", temperatura);
		}catch(Exception e){
			return "";
		}
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		Log.d("temp", result);
		Intent intent = new Intent();
		intent.setClass(context,AtividadeTemperatura.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("temperatura", result);
		intent.putExtra("cidade", this.cidade);
		context.startActivity(intent);
	}
}
