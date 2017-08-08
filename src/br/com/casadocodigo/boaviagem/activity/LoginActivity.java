package br.com.casadocodigo.boaviagem.activity;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.casadocodigo.boaviagem.R;


public class LoginActivity extends Activity {

	private EditText usuario;
	private EditText senha;
	private ProgressDialog progressDialog;
	private Toast toast;
	private String usuarioInformado;
	private String senhaInformado;

	
	/**
	 * metodo default da aplicação
	 */
	@SuppressLint("ShowToast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	
		usuario = (EditText) findViewById(R.id.usuario);
		senha = (EditText) findViewById(R.id.senha);		
		
		toast = Toast.makeText(this, getString(R.string.erro_autenticacao),Toast.LENGTH_SHORT);
	
		
		usuario.setText("");
		senha.setText("");
		usuario.requestFocus();
	}

	/**
	 * metodo default da aplicação
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	/**
	 * metodo default da aplicação
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	/**
	 * action da login definida na login.xml
	 * @param v
	 */
	public void login(View v) throws Exception {
		try {
			
		
			usuarioInformado = usuario.getText().toString();
			senhaInformado = senha.getText().toString();
	
			new LoginAsyncTask().execute();        
		     
			
			Log.d("login","Done");
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("login", "Error: "+e.getMessage());
			throw e;
		}
	}

	public void limpar(View v) {
		
		usuario.setText("");
		senha.setText("");
		usuario.requestFocus();
	}
	
	/**
	 * 
	 * @author c1260311 AsyncTask <Params, Progress, Result>
	 * Result - e o retorno do metodo doInBackground(...) e é o parametro de entrada do metodo onPostExecute(String result)
	 *
	 */
	private class LoginAsyncTask extends AsyncTask<String, Integer , String> {

		@Override
		protected void onPreExecute(){
			progressDialog = ProgressDialog.show(LoginActivity.this, "Por favor Aguarde ...", "Processando");
			progressDialog.setCancelable(true);
			Log.d("onPreExecute","Done");
			
		}

		@Override
		protected String doInBackground(String... params) {
			
			/**
			 * simulando um processamento para testar a mensagem de loading
			 */
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {			
			}
			
			if("leoaug".equals(usuarioInformado) && "334863333".equals(senhaInformado)) {	
				return "sucesso";
				
    		} else {
    			
    			return "erro";
    		}
			
		}
	

		@Override
        protected void onPostExecute(String result){
			
			if(result.equals("sucesso")) {
				startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
			} else {
				
    			toast.show();
			}
		
			progressDialog.dismiss();
		}
		
	}
	
	
}
