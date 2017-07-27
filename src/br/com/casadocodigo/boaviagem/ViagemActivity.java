package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViagemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_viagem);
	}
	
	public void voltarTipoViagem(View view) {
		startActivity(new Intent(this,DashboardActivity.class));
	}
	
	public void selecionarData(View view){
		showDialog(view.getId());
	}
}
