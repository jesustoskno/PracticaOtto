package co.mobiwise.android.baseproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import co.mobiwise.android.baseproject.R;
import co.mobiwise.android.baseproject.api.bus.BusProvider;
import co.mobiwise.android.baseproject.api.bus.Manager;
import co.mobiwise.android.baseproject.api.eventos.GetCiudadesEvent;
import co.mobiwise.android.baseproject.api.eventos.SendCiudadesEvent;
import co.mobiwise.android.baseproject.api.models.Ciudades;

public class MainActivity extends AppCompatActivity {

  private Bus mBus = BusProvider.getInstance();
  private ListView mListViewCiudades;
  //private SwipeRefreshLayout mRefresh;

  private ArrayAdapter<Ciudades> mAdapter;
  private List<Ciudades> mListCiudades;
  private final String mNombre="ObtenerCiudades";
  private final String mText="Lista de ciudades actualizada";
  private final String mTextFail="Lista de ciudades falló al actualizarse";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mListViewCiudades = (ListView) findViewById(R.id.ciudades);
    //mRefresh = (SwipeRefreshLayout) findViewById(R.id.refresh);

    mListCiudades = new ArrayList<>();
    mAdapter = new ArrayAdapter<Ciudades>(this, R.layout.simple_list_item_1, mListCiudades);
    mListViewCiudades.setAdapter(mAdapter);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mBus.post(new GetCiudadesEvent(mNombre.toString()));
      }
    });

    /*mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        mBus.post(new GetCiudadesEvent(mNombre.toString()));
      }
    });*/
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Subscribe
  public void onSendCiudadesEvent(SendCiudadesEvent sendCiudadesEvent){
    //mRefresh.setRefreshing(false);
    if(sendCiudadesEvent.isSuccess()){
      mListCiudades.clear();
      mListCiudades.addAll(sendCiudadesEvent.getNombres());
      mAdapter.notifyDataSetChanged();
      //Snackbar.make(mListViewCiudades, "Lista de ciudades actualizada", Snackbar.LENGTH_LONG).show();
      snaky(mText);
    }else{
      snaky(mTextFail);
    }
  }

  public void snaky (String text){
    Snackbar.make(mListViewCiudades, text, Snackbar.LENGTH_LONG).show();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mBus.register(this);
  }

  @Override
  protected void onPause() {
    super.onPause();
    mBus.unregister(this);
  }
}