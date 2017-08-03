package br.com.casadocodigo.boaviagem.constantes;

public enum ConstantesFragment {

	DIALOG_FRAGMENT_DATA_INICIO("datePickerChegada"),
	DIALOG_FRAGMENT_DATA_FIM("datePickerSaida");
	
	private String dialogFragment;
	
	ConstantesFragment(String dialogFragment) {
		this.dialogFragment = dialogFragment;
	}
	
	
	

	
	public String getDialogFragment() {
		return dialogFragment;
	}
	
}



	
