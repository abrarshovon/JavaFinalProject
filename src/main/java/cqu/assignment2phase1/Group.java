/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Abrar
 */
public record Group(int id, int size, int arrivalTime) {
    @Override
    public String toString() {
        return String.format("Group[id=%d, size=%d, arrival=%d]", id, size, arrivalTime);
    }
}
