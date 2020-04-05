import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SmartBride {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("candidates.csv"));

        reader.readLine();
        Candidate[] allCandidates = new Candidate[10];
        int candidatesCount = 0;

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] cells = line.split(",");
            if (cells.length == 2) {
                String name = cells[0];
                int iq = Integer.parseInt(cells[1]);

                Candidate candidate = new Candidate();
                candidate.name = name;
                candidate.iq = iq;

                allCandidates[candidatesCount] = candidate;
                candidatesCount++;
            }

        }

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (Candidate i = 0; i < candidatesCount-1; i++) {
                Candidate smartest = Candidate[i];
                Candidate candidate = Candidate[i+1];

                if (candidate.iq > smartest.iq){
                      int x = allCandidates[i];
                    allCandidates[i] = allCandidates[i+1];
                    allCandidates[i+1] = x;
                    sorted = false;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("How much results do you want to see?");
        int n = sc.nextInt();
        for (int i = 0; i < candidatesCount; i++) {
            System.out.println("Candidates with highest IQ are:" + allCandidates[n]);

     }

}

static class Candidate {
    String name;
    int iq;
}
