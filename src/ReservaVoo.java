import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReservaVoo {
    private final Map<Integer, Integer> voosReservados = new LinkedHashMap<>();

    private static final Map<Integer, Integer> listaVoos = new HashMap<>() {{
        put(1001, 100);
        put(1002, 100);
        put(1003, 100);
        put(1004, 100);
        put(1005, 100);
        put(1006, 100);
        put(1007, 100);
        put(1008, 100);
        put(1009, 100);
        put(1010, 100);
        put(1011, 100);
        put(1012, 100);
        put(1013, 100);
        put(1014, 100);
        put(1015, 100);
        put(1016, 100);
        put(1017, 100);
        put(1018, 10);
        put(1019, 100);
        put(1020, 100);
    }};

    /**
     * <h1>Método para reservar vôos</h1>
     * <p>Esse método recebe o número do vôo e a quantidade de assentos desejados como parâmetros, se o número do vôo recebido não existir, a exceção VooNaoEncontradoException será lançada</p>
     * <p>Se a quantidade de assentos desejada for maior que 8, a exceção LimiteReservaExcedidoException será lançada</p>
     * <p>Cada vôo tem 100 assentos e vai diminuindo de acordo com as reservas, se o passageiro escolher uma quantidade de assentos maior que a quantidade disponível, a exceção QuantidadeAssentosIndisponivelException será lançada.</p>
     * <p>Se o número do vôo existir, a quantidade de assentos desejados for menor ou igual a 8 e tiver assentos disponíveis, o vôo será reservado.</p>
     */
    public void reservarVoo(int numeroVoo, int quantidadeAssentos) {
        if (voosReservados.containsKey(numeroVoo)) {
            try {
                throw new VooJaCadastradoException("O vôo " + numeroVoo + " já foi cadastrado");
            } catch (VooJaCadastradoException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (!listaVoos.containsKey(numeroVoo)) {
                    throw new VooNaoEncontradoException();
                }
                if (quantidadeAssentos > 8) {
                    throw new LimiteReservaExcedidoException();
                }
                if (!(listaVoos.get(numeroVoo) >= quantidadeAssentos)) {
                    throw new QuantidadeAssentosIndisponivelException();
                }

                listaVoos.put(numeroVoo, listaVoos.get(numeroVoo) - quantidadeAssentos);

                voosReservados.put(numeroVoo, quantidadeAssentos);

            } catch (VooNaoEncontradoException | LimiteReservaExcedidoException |
                     QuantidadeAssentosIndisponivelException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <h1>Método para cancelar vôos</h1>
     * <p>Esse método recebe o número do vôo como parâmetro, se o número do vôo recebido existir na lista de vôos reservados do passageiro, o vôo será cancelado, se não existir, uma exceção será lançada.</p>
     */
    public void cancelarVoo(int numeroVoo) {
        try {
            if (!voosReservados.containsKey(numeroVoo)) {
                throw new VooNaoEncontradoException();
            }

            voosReservados.remove(numeroVoo);
            System.out.println("----- O vôo " + numeroVoo + " foi cancelado! -----");
        } catch (VooNaoEncontradoException e) {
            e.printStackTrace();
        }
    }

    public void imprime() {
        voosReservados.forEach((numeroVoo, quantidadeAssento) -> {
            System.out.println("Número do vôo: " + numeroVoo + "\nQuantidade de assentos: " + quantidadeAssento);
            System.out.println("--------------------------");
        });

    }
}
