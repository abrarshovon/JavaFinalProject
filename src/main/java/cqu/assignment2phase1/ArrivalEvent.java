/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Siam
 */


public class ArrivalEvent extends Event {
    public ArrivalEvent(int time) {
        super(time);
    }

    @Override
    public void process(ShopModel model, ISchedule scheduler) {
        int currentTime = getTime();
        Group group = model.arrival(currentTime); // always enters in this phase
        // Schedule next arrival
        scheduler.schedule(new ArrivalEvent(currentTime + 2));
    }
}
