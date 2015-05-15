package com.apps.mobile.franco.techtalkproject.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.apps.mobile.franco.techtalkproject.R;
import com.apps.mobile.franco.techtalkproject.events.ToogleReadingEvent;
import com.apps.mobile.franco.techtalkproject.fragment.CpuUsageFragment;

import de.greenrobot.event.EventBus;


public class MainActivity extends ActionBarActivity implements CpuUsageFragment.OnFragmentInteractionListener, View.OnClickListener {

    private Button btnToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(R.layout.activity_main, null);
        btnToggle = (Button)rootView.findViewById(R.id.btnToggle);
        btnToggle.setOnClickListener(this);
        setContentView(rootView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new ToogleReadingEvent());
        if(btnToggle.getText().equals(getString(R.string.action_stop))){
            btnToggle.setText(R.string.action_resume);
        }else{
            btnToggle.setText(R.string.action_stop);
        }
    }
}
