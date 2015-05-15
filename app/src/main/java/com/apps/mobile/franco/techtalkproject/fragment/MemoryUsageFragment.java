package com.apps.mobile.franco.techtalkproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.mobile.franco.techtalkproject.R;
import com.apps.mobile.franco.techtalkproject.events.MemoryReadEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by franco.murua on 06/05/2015.
 */
public class MemoryUsageFragment extends Fragment {

    private TextView tvMemory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.memory_layout, container);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvMemory = (TextView) view.findViewById(R.id.tvMemory);
    }

    public void onEventMainThread(MemoryReadEvent event){
        tvMemory.setText(String.valueOf(event.getMemory()));
    }

}
