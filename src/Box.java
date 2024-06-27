import java.util.Arrays;

public class Box {

    int[] dimensions;

    public Box(int d1, int d2, int d3) {
        dimensions = new int[]{d1, d2, d3};
        Arrays.sort(dimensions); // ordena as dimensoes da menor para a maior
    }

    // verifica se uma caixa cabe dentro da outra
    public boolean canContain(Box b) {
        return this.dimensions[0] > b.dimensions[0] &&
                this.dimensions[1] > b.dimensions[1] &&
                this.dimensions[2] > b.dimensions[2];
    }
}
