package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText usuario;
	private EditText senha;
	private Button botaoLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		usuario = (EditText) findViewById(R.id.usuario);
		senha = (EditText) findViewById(R.id.senha);		
		botaoLogin = (Button) findViewById(R.id.botaoLogin);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

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
	public void login(View v) {
		
		final String usuarioInformado = usuario.getText().toString();
		final String senhaInformado = senha.getText().toString();
		final ProgressDialog progressDialog= ProgressDialog.show(LoginActivity.this, "", "Só um minuto...", true);

		String mensagemErro = getString(R.string.erro_autenticacao);
		final Toast toast = Toast.makeText(this, mensagemErro,Toast.LENGTH_SHORT);
		
		botaoLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            	progressDialog.show();
       
            	
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                    	
                    	if("leoaug".equals(usuarioInformado) && "334863333".equals(senhaInformado)) {
                			//vai pra outra activity (como se fosse outra action, Controller do Android)
                			startActivity(new Intent(botaoLogin.getContext(),DashboardActivity.class));
                		} else {
                			//mostra mensagem erro
                			
                			toast.show();
                		}
                    	
                    	
                    	progressDialog.dismiss();
                        //whatever you want just you have to launch overhere.
                    }
                }, 1000);//just mention the time when you want to launch your action 

            }
        });
		
		

		
		
		progressDialog.dismiss(); // for close the dialog bar.
	}
}
