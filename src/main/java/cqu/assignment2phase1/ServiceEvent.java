/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Abrar
 */


public class ServiceEvent extends Event {
    private Group group;
    public ServiceEvent(int time, Group group) {
        super(time);
        this.group = group;
    }
    @Override
    
    public void process(ShopModel model, ISchedule scheduler) {
        model.service(getTime(), group);
        scheduler.schedule(new DepartureEvent(getTime() + 10, group));
    }


}
