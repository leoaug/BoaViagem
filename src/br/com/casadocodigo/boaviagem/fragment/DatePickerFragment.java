package br.com.casadocodigo.boaviagem.fragment;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import br.com.casadocodigo.boaviagem.constantes.ConstantesFragment;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

	private Button dataChegada;
	private Button dataSaida;
	
	public DatePickerFragment(Button dataChegada, Button dataSaida) {
		this.dataChegada = dataChegada;
		this.dataSaida = dataSaida;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		
		// Create a new instance of DatePickerDialog and return it
		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	public void onDateSet(DatePicker datePicker, int year, int month, int day) {
		
		final int ano = year;
		final int mes = month;
		final int dia = day;
	
		if(getTag().equals(ConstantesFragment.DIALOG_FRAGMENT_DATA_INICIO.getDialogFragment())){
			dataChegada.setText(ano + "/" + (mes + 1) + "/" + dia);
		} else {
			dataSaida.setText(ano + "/" + (mes + 1) + "/" + dia);
		}
		
	
	}
}