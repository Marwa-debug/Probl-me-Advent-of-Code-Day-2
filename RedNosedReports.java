package com.orange.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// This is the main program to solve the problem in question
public class RedNosedReports {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Utilisation: java RedNosedReports <fichier_input>");
            return;
        }
        
        try {
            // I start by reading the file
            List<String> lignes = Files.readAllLines(Paths.get(args[0]));
            
            // I parse all the lines
            List<List<Integer>> rapports = new ArrayList<>();
            for (String ligne : lignes) {
                if (ligne.trim().isEmpty()) {
                    continue; // I skip the empty lines
                }
                
                List<Integer> niveaux = new ArrayList<>();
                String[] parties = ligne.trim().split("\\s+");
                
                for (String partie : parties) {
                    niveaux.add(Integer.parseInt(partie));
                }
                
                rapports.add(niveaux);
            }
            
            System.out.println("Fichier chargé: " + rapports.size() + " rapports");
            
            // I analyze my class
            ReportAnalyzer analyzer = new ReportAnalyzer();
            int safe_count = analyzer.countSafeReports(rapports);
            
            System.out.println("\n=== RESULTAT ===");
            System.out.println("Rapports safe: " + safe_count);
            System.out.println("Rapports unsafe: " + (rapports.size() - safe_count));
            System.out.println("Total: " + rapports.size());
            
        } catch (IOException e) {
            System.out.println("Erreur lecture fichier: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur format nombre: " + e.getMessage());
        }
    }
}
