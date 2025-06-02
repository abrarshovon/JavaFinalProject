/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Abrar
 */

public abstract class Event {
    private int time;

    public Event(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public abstract void process(ShopModel model, ISchedule scheduler);
}
