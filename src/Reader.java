import java.io.*;
import java.util.*;

public class Reader {
    private String filePath;
    private int maxNestingLength;
    private double executionTime;

    public Reader(String path) {
        long start = System.currentTimeMillis();

        this.filePath = path;
        List<Box> boxes = readFile();
        Graph graph = new Graph(boxes);
        this.maxNestingLength = graph.findLongestSequence();

        long end = System.currentTimeMillis();

        executionTime = (end - start) / 1000.0;
    }

    private List<Box> readFile() {
        List<Box> boxes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int d1 = Integer.parseInt(parts[0]);
                int d2 = Integer.parseInt(parts[1]);
                int d3 = Integer.parseInt(parts[2]);
                boxes.add(new Box(d1, d2, d3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boxes;
    }

    private int getNumberOfBoxes(String path) {
        String fileName = new File(path).getName();
        String numStr = fileName.replaceAll("[^0-9]", "");
        return Integer.parseInt(numStr);
    }

//    @Override
//    public String toString() {
//        return "O tempo de execução para o teste de " + getNumberOfBoxes(filePath) + " caixas foi aproximadamente: " + executionTime + " segundos";
//    }


    @Override
    public String toString() {
        return "O comprimento da sequência mais longa para o teste de " + getNumberOfBoxes(filePath) + " caixas foi: " + maxNestingLength;
    }
}
