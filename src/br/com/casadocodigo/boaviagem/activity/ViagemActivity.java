package br.com.casadocodigo.boaviagem.activity;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.casadocodigo.boaviagem.R;
import br.com.casadocodigo.boaviagem.constantes.ConstantesFragment;
import br.com.casadocodigo.boaviagem.fragment.DatePickerFragment;

public class ViagemActivity extends Activity {

	
	private Button dataChegada;
	private Button dataSaida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_viagem);
		
		dataChegada = (Button) findViewById(R.id.dataChegada);
		dataChegada.setText("Selecione");
		
		dataSaida = (Button) findViewById(R.id.dataSaida);
		dataSaida.setText("Selecione");
	}
	
	
	public void selecionarData(View view){

		DatePickerFragment newFragment = new DatePickerFragment();
		if(view.getId() == R.id.dataChegada) {
			newFragment.show(getFragmentManager(), ConstantesFragment.DIALOG_FRAGMENT_DATA_INICIO.getDialogFragment());
			newFragment.setViewDatePicker(dataChegada);
			newFragment.setDialogFragmenTag(newFragment.getTag());
		
		} else {
			newFragment.show(getFragmentManager(), ConstantesFragment.DIALOG_FRAGMENT_DATA_FIM.getDialogFragment());
			newFragment.setViewDatePicker(dataSaida);
			newFragment.setDialogFragmenTag(newFragment.getTag());
		}
		
	}
	
	/**
	 * 
	 * @param view metodo para voltar para o dashboard
	 */	
	public void salvarViagem(View view) {
		
	}
	
	public void voltarTipoViagem(View view) {
		startActivity(new Intent(this,DashboardActivity.class));
	}
	

}
