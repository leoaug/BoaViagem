package br.com.casadocodigo.boaviagem.fragment;

import java.util.Calendar;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

	private View viewDatePicker;
	private String dialogFragmenTag;
	

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
	
		
		if(getTag().equals(getDialogFragmenTag())) {
			if(getViewDatePicker() instanceof Button) {
				((Button) getViewDatePicker()).setText(dia + "/" + (mes + 1) + "/" + ano);
			} else if(getViewDatePicker() instanceof TextView) {
				((TextView) getViewDatePicker()).setText(dia + "/" + (mes + 1) + "/" + ano);
			}
		}		
	
	}


	public View getViewDatePicker() {
		return viewDatePicker;
	}

	public void setViewDatePicker(View viewDatePicker) {
		this.viewDatePicker = viewDatePicker;
	}

	public String getDialogFragmenTag() {
		return dialogFragmenTag;
	}

	public void setDialogFragmenTag(String dialogFragmenTag) {
		this.dialogFragmenTag = dialogFragmenTag;
	}
	
	
	
}