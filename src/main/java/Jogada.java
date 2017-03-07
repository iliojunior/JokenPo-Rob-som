public class Jogada {

    private final Jogador jogador;
    private final TipoJogada jogada;

    public Jogada(Jogador jogador, TipoJogada jogada) {
        this.jogador = jogador;
        this.jogada = jogada;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public TipoJogada getJogada() {
        return jogada;
    }
}
