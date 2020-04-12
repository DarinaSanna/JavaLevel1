import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SmartBride {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/candidates.csv"));
            Scanner sc = new Scanner(System.in);

            reader.readLine();
            Candidate[] allCandidates = new Candidate[10];
            int candidatesCount = 0;

            candidatesCount = getCandidates(reader, allCandidates, candidatesCount);

            sortCandidates(allCandidates, candidatesCount);

            System.out.print("How much candidates do you want to see?");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++)
                System.out.println("Candidate{" +
                        "name='" + allCandidates[i].name + '\'' +
                        ", iq=" + allCandidates[i].iq +
                        '}');
        }


    private static void sortCandidates(Candidate[] allCandidates, int candidatesCount) {
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                //int i = 0;
                for (int i=0; i < candidatesCount - 1; i++) {
                    if (allCandidates[i].iq > allCandidates[i+1].iq) {
                        Candidate x = allCandidates[i];
                        allCandidates[i] = allCandidates[i + 1];
                        allCandidates[i + 1] = x;
                        sorted = false;
                    }
                }
            }
        }

        private static int getCandidates(BufferedReader reader, Candidate[] allCandidates, int candidatesCount) throws IOException {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] cells = line.split(",");
                if (cells.length == 2) {
                    String name = cells[0];
                    int iq = Integer.parseInt(cells[1].trim());

                    Candidate candidate = new Candidate();
                    candidate.name = name;
                    candidate.iq = iq;

                    allCandidates[candidatesCount] = candidate;
                    candidatesCount++;
                }

            }
            return candidatesCount;
        }


    }
class Candidate {
    String name;
    int iq;
}
