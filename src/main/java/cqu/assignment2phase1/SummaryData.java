/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Abrar
 */
import java.util.List;

public record SummaryData(int served, int lost, List<Group> all, List<Group> remaining) { }
