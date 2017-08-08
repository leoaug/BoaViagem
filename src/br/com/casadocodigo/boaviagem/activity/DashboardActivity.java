package br.com.casadocodigo.boaviagem.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import br.com.casadocodigo.boaviagem.R;
import br.com.casadocodigo.boaviagem.listactivity.ViagemListActivity;



public class DashboardActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		
		inflater.inflate(R.menu.dashbord_menu, menu);
		
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		/**
		 * como e so um item de menu, chamar o finish
		 */
		finish();
		return true;
	}
	
	public void selecionarOpcao(View view) {
		
		/*
			op��es definidas no dashboard.xml com a action selecionarOpcao
		*/
		
		switch (view.getId()) {
			case R.id.nova_viagem:
				startActivity(new Intent(this,ViagemActivity.class));
				break;
	
			case R.id.novo_gasto:
				startActivity(new Intent(this,GastoActivity.class));
				break;
			
			case R.id.minhas_viagens:
				startActivity(new Intent(this,ViagemListActivity.class));
				break;	
				
			default:
				break;
		}
		
		
	}
	/*
	public void voltarDashBoard(View v) {
		
		startActivity(new Intent(this,LoginActivity.class));
		
	}*/
}
