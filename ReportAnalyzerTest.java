package com.orange.aoc;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// This is a test in order to test my code
public class ReportAnalyzerTest {
    
    @Test
    public void testExemple1Safe() {
        // 7 6 4 2 1 : Safe (decreases by 1 or 2)
        ReportAnalyzer analyzer = new ReportAnalyzer();
        List<Integer> niveaux = Arrays.asList(7, 6, 4, 2, 1);
        assertTrue(analyzer.isSafeReport(niveaux));
    }
    
    @Test
    public void testExemple2Unsafe() {
        // 1 2 7 8 9 : Unsafe (2 -> 7 = +5, too big)
        ReportAnalyzer analyzer = new ReportAnalyzer();
        List<Integer> niveaux = Arrays.asList(1, 2, 7, 8, 9);
        assertFalse(analyzer.isSafeReport(niveaux));
    }
    
    @Test
    public void testExemple3Unsafe() {
        // 9 7 6 2 1 : Unsafe (6 -> 2 = -4, too big)
        ReportAnalyzer analyzer = new ReportAnalyzer();
        List<Integer> niveaux = Arrays.asList(9, 7, 6, 2, 1);
        assertFalse(analyzer.isSafeReport(niveaux));
    }
    
    @Test
    public void testExemple4Unsafe() {
        // 1 3 2 4 5 : Unsafe (it changes the direction)
        ReportAnalyzer analyzer = new ReportAnalyzer();
        List<Integer> niveaux = Arrays.asList(1, 3, 2, 4, 5);
        assertFalse(analyzer.isSafeReport(niveaux));
    }
    
    @Test
    public void testExemple5Unsafe() {
        // 8 6 4 4 1 : Unsafe (4 -> 4 = 0)
        ReportAnalyzer analyzer = new ReportAnalyzer();
        List<Integer> niveaux = Arrays.asList(8, 6, 4, 4, 1);
        assertFalse(analyzer.isSafeReport(niveaux));
    }
    
    @Test
    public void testExemple6Safe() {
        // 1 3 6 7 9 : Safe (increases by 1, 2 or 3)
        ReportAnalyzer analyzer = new ReportAnalyzer();
        List<Integer> niveaux = Arrays.asList(1, 3, 6, 7, 9);
        assertTrue(analyzer.isSafeReport(niveaux));
    }
    
    @Test
    public void testComptageTotal() {
        // Test with all the examples -> must give 2
        ReportAnalyzer analyzer = new ReportAnalyzer();
        List<List<Integer>> rapports = Arrays.asList(
            Arrays.asList(7, 6, 4, 2, 1),
            Arrays.asList(1, 2, 7, 8, 9),
            Arrays.asList(9, 7, 6, 2, 1),
            Arrays.asList(1, 3, 2, 4, 5),
            Arrays.asList(8, 6, 4, 4, 1),
            Arrays.asList(1, 3, 6, 7, 9)
        );
        
        assertEquals(2, analyzer.countSafeReports(rapports));
    }
}
