package com.apps.mobile.franco.techtalkproject.events;

import com.jjoe64.graphview.series.DataPoint;

/**
 * Created by franco on 14/05/2015.
 */
public class GraphEvent {


    private DataPoint dataPoint;

    public GraphEvent(double x, double y){
        dataPoint = new DataPoint(x, y);
    }

    public DataPoint getDataPoint() {
        return dataPoint;
    }

    public void setDataPoint(DataPoint dataPoint) {
        this.dataPoint = dataPoint;
    }
}
