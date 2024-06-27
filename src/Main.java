public class Main {
    public static void main(String[] args) {
        java.util.Arrays.asList(
                        "teste10",
                        "teste20",
                        "teste50",
                        "teste100",
                        "teste200",
                        "teste300",
                        "teste500",
                        "teste1000",
                        "teste2000"
                )
                .stream().map(str -> "./src/files/" + str + ".txt")
                .forEach(file -> System.out.println(new Reader(file)));
    }
}