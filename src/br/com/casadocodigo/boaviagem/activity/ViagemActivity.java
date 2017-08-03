package br.com.casadocodigo.boaviagem.activity;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import br.com.casadocodigo.boaviagem.R;
import br.com.casadocodigo.boaviagem.R.id;
import br.com.casadocodigo.boaviagem.R.layout;

public class ViagemActivity extends Activity {

	private int ano, mes, dia;
	
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
	

	private OnDateSetListener listener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			ano = year;
			mes = monthOfYear;
			dia = dayOfMonth;
		
			dataChegada.setText(dia + "/" + (mes+1) + "/" + ano);
			dataSaida.setText(dia + "/" + (mes+1) + "/" + ano);
		}
	};

	
	@Override
	protected Dialog onCreateDialog(int id) {
	
		if(R.id.dataChegada == id || R.id.dataSaida == id) {
			return new DatePickerDialog(this, listener, ano, mes, dia);
		}
	
		return null;
	}
	
	public void selecionarData(View view){
		showDialog(view.getId());
		
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
