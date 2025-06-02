/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cqu.assignment2phase1;

/**
 *
 * @author Abrar
 */


import java.util.List;

public class Report {
    private SummaryData data;
    private String textReport;

    public Report(SummaryData sd) {
        this.data = sd;
    }

    public String exportAsText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Statistics\n==========\n");
        sb.append("The number of people served = ").append(data.served()).append("\n");
        sb.append("The lost business = ").append(data.lost()).append(" people\n\n");
        sb.append("The following groups are in the shop\n");
        sb.append("====================================\n");
        for (Group g : data.remaining()) sb.append(g).append("\n");
        sb.append("\nThe following groups arrived at the shop\n");
        sb.append("========================================\n");
        for (Group g : data.all()) sb.append(g).append("\n");
        textReport = sb.toString();
        return textReport;
    }

    public String getTextReport() { return textReport; }
    // saveAsText() will be implemented in Phase 7
}
