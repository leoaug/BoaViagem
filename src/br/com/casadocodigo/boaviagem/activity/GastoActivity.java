package br.com.casadocodigo.boaviagem.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import br.com.casadocodigo.boaviagem.R;
import br.com.casadocodigo.boaviagem.constantes.ConstantesFragment;
import br.com.casadocodigo.boaviagem.fragment.DatePickerFragment;

public class GastoActivity extends Activity {

	/**
	 * é uma combobox
	 */
	private Spinner categoria;
	private Button data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gasto);
		
		categoria = (Spinner) findViewById(R.id.categoria);
		data = (Button) findViewById(R.id.data);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categoria_gasto,android.R.layout.simple_spinner_item);
	
		categoria.setAdapter(adapter);
				
	}
	
	public void selecionarData(View view){

		DatePickerFragment newFragment = new DatePickerFragment();
		if(view.getId() == R.id.data) {
			newFragment.show(getFragmentManager(), ConstantesFragment.DIALOG_FRAGMENT_DATA_INICIO.getDialogFragment());
			newFragment.setViewDatePicker(data);
			newFragment.setDialogFragmenTag(newFragment.getTag());
		}
	}
}
