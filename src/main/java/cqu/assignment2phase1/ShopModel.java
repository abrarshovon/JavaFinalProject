/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Abrar
 */



import cqu.assignment2phase1.Group;
import cqu.assignment2phase1.SummaryData;
import java.util.*;

public class ShopModel {
    private HashMap<Integer, Group> groupsInShop;
    private ArrayList<Group> allGroups;
    private int nextIdentifier;
    private int seatsAvailable;
    private int lostBusiness;
    private int numberServed;
    public static final int DEFAULT_GROUP_SIZE = 2;

    public ShopModel(int numberOfSeats) {
        this.groupsInShop = new HashMap<>();
        this.allGroups = new ArrayList<>();
        this.nextIdentifier = 1;
        this.seatsAvailable = numberOfSeats;
        this.lostBusiness = 0;
        this.numberServed = 0;
    }

    // PHASE 2: Ignore capacity, always let group enter
    public Group arrival(int time) {
        Group g = new Group(nextIdentifier, DEFAULT_GROUP_SIZE, time);
        nextIdentifier++;
        groupsInShop.put(g.id(), g);
        allGroups.add(g);
        System.out.printf("t = %4d: Group %d (%d people) arrived%n", time, g.id(), g.size());
        return g;
    }
    public SummaryData getSummaryData() {
        return new SummaryData(
                numberServed,
                lostBusiness,
                List.copyOf(allGroups),
                List.copyOf(groupsInShop.values())
        );
    }

}
    public void service(int time, Group group) {
        numberServed += group.size();
        System.out.printf("t = %4d: Order served for Group %d%n", time, group.id());
    }
    public void departure(int time, Group group) {
    System.out.printf("t = %4d: Group %d departed%n", time, group.id());
    groupsInShop.remove(group.id());
    // In phase 6, also increase seatsAvailable by group.size()
}




    // The following methods will be added in later phases:
    // public void service(int time, Group group) { ... }
    // public void departure(int time, Group group) { ... }
    // public SummaryData getSummaryData() { ... }
}
