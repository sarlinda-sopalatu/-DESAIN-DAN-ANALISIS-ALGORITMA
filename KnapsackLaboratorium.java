import java.util.ArrayList;
import java.util.List;

public class KnapsackLaboratorium {

    public static void main(String[] args) {
        
        String[] names = {
            "Mikroskop", "Tabung reaksi", "Centrifuge", "Pipet", 
            "Spectrophotometer", "Hot plate", "Gelas ukur", 
            "Incubator", "pH meter", "Autoclave"
        };
        int[] w = {15, 2, 8, 1, 12, 6, 3, 20, 4, 25}; 
        int[] p = {120, 15, 85, 10, 150, 65, 25, 180, 55, 200}; 
        int M = 20; 
        int n = names.length;

        
        int[][] dp = new int[n + 1][M + 1];

      
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                if (w[i - 1] <= j) {
                   
                    dp[i][j] = Math.max(p[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

     
        int res = dp[n][M];
        int tempW = M;
        List<String> itemsSelected = new ArrayList<>();
        int actualWeight = 0;

        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][tempW]) {
                itemsSelected.add(names[i - 1]);
                actualWeight += w[i - 1];
                res -= p[i - 1];
                tempW -= w[i - 1];
            }
        }

       
        System.out.println("========== IMPLEMENTASI KNAPSACK DP ==========");
        System.out.println("Kapasitas Rak Maksimal : " + M + " cm3");
        System.out.println("Nilai Maksimum (Profit): " + dp[n][M]);
        System.out.println("Total Berat Terpakai   : " + actualWeight + " cm3");
        System.out.println("----------------------------------------------");
        System.out.println("Daftar Alat Laboratorium yang Terpilih:");
        for (String item : itemsSelected) {
            System.out.println("- " + item);
        }
        System.out.println("==============================================");
    }
}