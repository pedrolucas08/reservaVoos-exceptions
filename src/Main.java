public class Main {
    public static void main(String[] args) {
        ReservaVoo pedro = new ReservaVoo();

        pedro.reservarVoo(1001, 5);
        pedro.reservarVoo(1004, 4);
        pedro.reservarVoo(1018, 3);
        pedro.reservarVoo(1018, 2);

        pedro.imprime();

        pedro.cancelarVoo(1004);

        pedro.imprime();

    }
}