package br.com.casadocodigo.boaviagem.listactivity;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ViagemListActivity extends ListActivity implements OnItemClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * simple_list_item_1 j� � uma p�gina padr�o para listagem de dados do android
		 */
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarViagens()));
		ListView listView = getListView();
		listView.setOnItemClickListener(this);
	}

	private List<String> listarViagens() {
		return Arrays.asList("S�o Paulo", "Bonito", "Macei�");
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		TextView textView = (TextView) view;
		String mensagem = "Viagem selecionada: " + textView.getText();
		Toast.makeText(getApplicationContext(), mensagem,
		Toast.LENGTH_SHORT).show();
		startActivity(new Intent(this, GastoListActivity.class));
		
	}
}
