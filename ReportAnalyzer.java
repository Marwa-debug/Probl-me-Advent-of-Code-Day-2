package com.orange.aoc;

import java.util.List;

// I created this class in order to analyze the reports
public class ReportAnalyzer {
    
    // This function tells if a report is safe or not
    public boolean isSafeReport(List<Integer> levels) {
        if (levels == null || levels.size() < 2) {
            return false;
        }
        
        // I see if it goes up or down at the begining
        int premiere_diff = levels.get(1) - levels.get(0);
        
        if (premiere_diff == 0) {
            return false; 
        }
        
        boolean doit_monter = premiere_diff > 0;
        
        // I check all the levels one by one
        for (int i = 0; i < levels.size() - 1; i++) {
            int diff = levels.get(i + 1) - levels.get(i);
            
            // If it doesn't change it is not safe
            if (diff == 0) {
                return false;
            }
            
            // It should always stay on the same direction
            if ((diff > 0) != doit_monter) {
                return false;
            }
            
            // The difference should be between 1 and 3
            int diff_abs = Math.abs(diff);
            if (diff_abs < 1 || diff_abs > 3) {
                return false;
            }
        }
        
        return true;
    }
    
    // This function returns how many reports are safe
    public int countSafeReports(List<List<Integer>> reports) {
        int count = 0;
        
        for (List<Integer> report : reports) {
            if (isSafeReport(report)) {
                count++;
            }
        }
        
        return count;
    }
}
