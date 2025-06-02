/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Siam
 */


import java.util.*;

public class ShopSimulator implements ISchedule {
    private ArrayList<Event> events;
    private int clock;
    private ShopModel model;

    public ShopSimulator(ShopModel model) {
        this.model = model;
    }

    public void initialize(Event e) {
        events = new ArrayList<>();
        events.add(e);
    }

    public void run(int stopTime) {
        if (events == null || events.isEmpty()) return;
        Event e = events.remove(0);
        clock = e.getTime();
        while (clock <= stopTime) {
            e.process(model, this);
            if (events.isEmpty()) break;
            e = events.remove(0);
            clock = e.getTime();
        }
    }

    @Override
    public void schedule(Event e) {
        // Keep the list sorted by event time
        int i = 0;
        while (i < events.size() && events.get(i).getTime() <= e.getTime()) {
            i++;
        }
        events.add(i, e);
    }
}
