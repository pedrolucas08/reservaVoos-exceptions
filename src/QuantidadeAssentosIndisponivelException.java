public class QuantidadeAssentosIndisponivelException extends Exception{
    public QuantidadeAssentosIndisponivelException() {
        super("Esse vôo não tem o número de assento que foi solicitado");
    }
}
