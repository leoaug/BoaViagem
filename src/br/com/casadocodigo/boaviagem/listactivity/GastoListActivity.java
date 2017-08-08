package br.com.casadocodigo.boaviagem.listactivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;
import br.com.casadocodigo.boaviagem.R;


public class GastoListActivity extends ListActivity  implements OnItemClickListener {

	private List<Map<String, Object>> gastos;
	// atributos, método onCreate, listarGastos e onItemClick
	private String dataAnterior = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] de = { "data", "descricao", "valor", "categoria" };
		int[] para = { R.id.data, R.id.descricao,R.id.valor, R.id.categoria };
		SimpleAdapter adapter = new SimpleAdapter(this,listarGastos(), R.layout.lista_gasto, de, para);
		
		adapter.setViewBinder(new GastoViewBinder());
		
		setListAdapter(adapter);
		
		getListView().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
		Map<String, Object> map = gastos.get(position);
		
		String descricao = (String) map.get("descricao");
		String mensagem = "Gasto selecionada: " + descricao;
		Toast.makeText(this, mensagem,Toast.LENGTH_SHORT).show();
	}
	
	private List<Map<String, Object>> listarGastos() {
		gastos = new ArrayList<Map<String, Object>>();
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("data", "04/02/2012");
		item.put("descricao", "Diária Hotel");
		item.put("valor", "R$ 260,00");
		item.put("categoria", R.color.categoria_hospedagem);
		gastos.add(item);
		// pode adicionar mais informações de viagens
		return gastos;
	}
	private class GastoViewBinder implements ViewBinder {

		@Override
		public boolean setViewValue(View view, Object data, String textRepresentation) {
			if(view.getId() == R.id.data){
				if(!dataAnterior.equals(data)){
					TextView textView = (TextView) view;
					textView.setText(textRepresentation);
					dataAnterior = textRepresentation;
					view.setVisibility(View.VISIBLE);
				} else {

					view.setVisibility(View.GONE);
				}
				return true;
			}
			if(view.getId() == R.id.categoria){
				Integer id = (Integer) data;
				
				/**
				 * deprecated				 
				view.setBackgroundColor(getResources().getColor(id));
				*/
				view.setBackgroundColor(ContextCompat.getColor(getBaseContext(), id));
				return true;
			}
			return false;
		}



	}

}
