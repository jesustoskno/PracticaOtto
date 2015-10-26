package co.mobiwise.android.baseproject.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.mobiwise.android.baseproject.utils.BusUtil;

public abstract class _BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onResume() {
    super.onResume();
    BusUtil.BUS.register(this);
  }

  @Override
  protected void onPause() {
    try {
      BusUtil.BUS.unregister(this);
    } catch (Exception ignore) {
    }
    super.onPause();
  }
}