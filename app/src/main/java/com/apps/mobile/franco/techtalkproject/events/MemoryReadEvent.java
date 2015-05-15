package com.apps.mobile.franco.techtalkproject.events;

/**
 * Created by franco.murua on 07/05/2015.
 */
public class MemoryReadEvent {

    private String memory;

    public MemoryReadEvent(String memory){
        this.memory = memory;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
