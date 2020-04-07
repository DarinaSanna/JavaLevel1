import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class SmartBride {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/candidates.csv"));

            reader.readLine();
            Candidate[] allCandidates = new Candidate[10];
            int candidatesCount = 0;

            candidatesCount = getCandidates(reader, allCandidates, candidatesCount);

            sortCandidates(allCandidates, candidatesCount);

            for (Candidate candidate : allCandidates) {

                System.out.println(candidate);


            }

        }



        private static void sortCandidates(Candidate[] allCandidates, int candidatesCount) {
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                Candidate smartest = allCandidates[0];
                Candidate candidate = allCandidates[1];
                for (int i = 0; i < candidatesCount - 1; i++) {
                    if (candidate.iq > smartest.iq) {
                        Candidate x = allCandidates[i];
                        allCandidates[i] = allCandidates[i + 1];
                        allCandidates[i + 1] = x;
                        sorted = false;
                        candidatesCount = candidatesCount -1;
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

        static class Candidate {
            String name;
            int iq;

            @Override
            public String toString() {
                return "Candidate{" +
                        "name='" + name + '\'' +
                        ", iq=" + iq +
                        '}';
            }
        }
    }
