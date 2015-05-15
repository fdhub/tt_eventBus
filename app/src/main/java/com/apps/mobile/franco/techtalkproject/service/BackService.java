package com.apps.mobile.franco.techtalkproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.apps.mobile.franco.techtalkproject.events.CPUUsage;
import com.apps.mobile.franco.techtalkproject.events.GraphEvent;
import com.apps.mobile.franco.techtalkproject.events.MemoryReadEvent;
import com.apps.mobile.franco.techtalkproject.events.ToogleReadingEvent;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import de.greenrobot.event.EventBus;

public class BackService extends Service {

    private CustomProcessor processor;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        processor = new CustomProcessor();
        EventBus.getDefault().register(processor);
        processor.start();
    }

    public class CustomProcessor extends Thread {

        private NumberFormat nf = DecimalFormat.getInstance();
        private boolean interrupted = false;

        public CustomProcessor(){
            nf.setMaximumIntegerDigits(1);
        }

        @Override
        public void run() {

            boolean hasSuscribers = true;
            nf.setMaximumFractionDigits(2);
            int x = 1;

            while(true){
                while( !interrupted && hasSuscribers ){
                    try {

                        String memory = nf.format(Math.random() * 100);
                        String cpu = nf.format(Math.random()*100);

                        Log.d("xxFran", "memory: " + memory + ", cpu: " + cpu);

                        EventBus.getDefault().post(new CPUUsage(cpu));
                        EventBus.getDefault().post(new MemoryReadEvent(memory));
                        EventBus.getDefault().post(new GraphEvent( x, Math.random()));

                        Thread.sleep(1000);

                        hasSuscribers = EventBus.getDefault().hasSubscriberForEvent(CPUUsage.class)
                                || EventBus.getDefault().hasSubscriberForEvent(MemoryReadEvent.class);
                        x++;

                    } catch(Exception e){
                        Log.e("xxFran", "e: " + e);
                    }

                }
            }
        }

        public void onEventBackgroundThread(ToogleReadingEvent event){
            this.interrupted = !interrupted;

        }

    }

}
