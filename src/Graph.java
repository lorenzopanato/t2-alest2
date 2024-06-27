import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private List<Box> boxes;
    private List<List<Integer>> adj;

    // Construtor da classe Grafo, inicializa a lista de caixas e adjacencias
    public Graph(List<Box> bxs) {
        this.boxes = bxs;
        this.adj = new ArrayList<>();

        // adiciona <10> arraylists (em cada um será guardado o n de adjacencias)
        for (int i = 0; i < boxes.size(); i++) {
            adj.add(new ArrayList<>());
        }

        buildGraph();
    }

    // Constrói o grafo, adicionando arestas entre caixas que podem conter outras caixas
    private void buildGraph() {
        for (int i = 0; i < boxes.size(); i++) {
            for (int j = 0; j < boxes.size(); j++) {
                if (i != j && boxes.get(i).canContain(boxes.get(j))) {
                    adj.get(i).add(j);
                }
            }
        }
    }

    // Encontra o caminho mais longo no grafo utilizando DFS e memoization
    public int findLongestSequence() {
        int n = boxes.size();
        int[] dp = new int[n];  // armazena o tamanho do maior caminho a partir do vertice
        Arrays.fill(dp, -1);  // Inicializa o array longestSequence com -1 (ainda nao foi calculado)
        int maxLength = 0;

        // Calcula o caminho mais longo a partir de cada vértice
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dfs(i, dp));
        }
        return maxLength;
    }

    // Realiza uma busca em profundidade (DFS) a partir do vértice u
    private int dfs(int u, int[] dp) {
        if (dp[u] != -1) {
            return dp[u];
        }

        int maxLength = 1;
        for (int v : adj.get(u)) {
            maxLength = Math.max(maxLength, 1 + dfs(v, dp));
        }
        dp[u] = maxLength;
        return maxLength;
    }
}
