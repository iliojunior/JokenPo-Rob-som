import java.util.*;

public class JokenPo {
    final ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

    public JokenPo(final int quantidadeJogadores) {
        if (quantidadeJogadores < 2)
            throw new RuntimeException("E necessario pelo menos 2 jogadores");

        this.inicializarJogadores(quantidadeJogadores);
    }

    private void inicializarJogadores(int quantidadeJogadores) {
        for (int i = 0; i < quantidadeJogadores; i++) {
            final Jogador jogador = new Jogador("Jogador " + (i + 1));
            jogadores.add(jogador);
        }
    }

    private Jogador getJogadorByNome(String nome) {

        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(nome))
                return jogador;
        }

        return null;
    }

    private List<Jogada> converterStringEmJogadas(String entradaJogadas) {
        final List<Jogada> jogadas = new ArrayList<>();

        for (int i = 0; i < entradaJogadas.length(); i++) {

            final TipoJogada tipoJogada = TipoJogada.getValue(entradaJogadas.charAt(i));

            if (tipoJogada == null)
                throw new RuntimeException("TipoJogada Invalida, jogador " + (i + 1));

            final Jogador jogador = getJogadorByNome("Jogador " + (i + 1));
            final Jogada jogada = new Jogada(jogador, tipoJogada);

            jogadas.add(jogada);
        }

        return jogadas;
    }

    public void jogar(String stringJogada) {

        Jogador jogadorVencedor = null;
        final List<Jogada> jogadasParaProcessar = converterStringEmJogadas(stringJogada);

        while (jogadasParaProcessar.size() > 1) {
            final Jogada jogadorDesafiante = jogadasParaProcessar.get(0);
            final Jogada jogadorDesafiado = jogadasParaProcessar.get(1);
            Boolean desafianteGanhou = false;
            TipoJogada jogadaVencedora = null;

            try {
                jogadaVencedora = jogadorDesafiante.getJogada().desafiar(jogadorDesafiado.getJogada());
            } catch (Exception e) {
                return;
            }

            desafianteGanhou = jogadaVencedora.equals(jogadorDesafiante.getJogada());

            jogadorVencedor = (desafianteGanhou ? jogadorDesafiante.getJogador() : jogadorDesafiado.getJogador());

            jogadasParaProcessar.remove(desafianteGanhou ? 1 : 0);

        }

        jogadorVencedor.setPontuacao(jogadorVencedor.getPontuacao() + 1);

    }

    public String getResultado() {
        String msgSaida = "";

        for (Jogador jogador : jogadores)
            msgSaida += jogador.getNome() + " -> " + jogador.getPontuacao() + " pontos\n";

        return msgSaida;
    }

    public String getVencedor() {

        Jogador jogadorVencedor = jogadores.get(0);

        for (Jogador jogador : jogadores) {
            if (jogador.getPontuacao() > jogadorVencedor.getPontuacao())
                jogadorVencedor = jogador;
        }

        return jogadorVencedor.getNome() + " -> " + jogadorVencedor.getPontuacao() + " pontos";
    }
}

