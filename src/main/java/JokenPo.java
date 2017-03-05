import java.util.*;

public class JokenPo {
    final Map<Integer, Integer> resultados = new HashMap<Integer, Integer>();

    public JokenPo(final int jogadores) {
        if (jogadores < 2)
            throw new RuntimeException("E necessario pelo menos 2 jogadores");
        this.inicializarJogadores(jogadores);
    }

    private void inicializarJogadores(int jogadores) {
        for (int i = 1; i <= jogadores; i++) {
            resultados.put(i, 0);
        }
    }

    public void jogar(String stringJogada) {

        int jogadorVencedor = 0;
        final Map<Integer, Jogada> jogadas = new TreeMap<Integer, Jogada>();

        for (int i = 0; i < stringJogada.length(); i++) {
            final Jogada jogada = Jogada.getValue(stringJogada.charAt(i));
            if (jogada == null)
                throw new RuntimeException("Jogada Invalida, jogador " + (i + 1));
            jogadas.put(i, jogada);
        }


        while (jogadas.size() > 1) {
            Map.Entry<Integer, Jogada> jogador1 = null;
            Map.Entry<Integer, Jogada> jogador2 = null;
            int teste = 0;

            for (Map.Entry<Integer, Jogada> item : jogadas.entrySet()) {
                if (teste == 0) {
                    jogador1 = item;
                    teste++;
                } else {
                    jogador2 = item;
                    break;
                }
            }

            try {
                Jogada resultado = jogador1.getValue().desafiar(jogador2.getValue());
                if (resultado.equals(jogador1.getValue())) {
                    jogadorVencedor = jogador1.getKey();
                    jogadas.remove(jogador2.getKey());
                } else {
                    jogadorVencedor = jogador2.getKey();
                    jogadas.remove(jogador1.getKey());
                }

            } catch (Exception e) {
                return;
            }

        }

        resultados.put(jogadorVencedor + 1, resultados.get(jogadorVencedor + 1) + 1);

    }

    public void encerrar() {

    }

    public String getResultado() {
        String msgSaida = "";
        for (Map.Entry<Integer, Integer> item : resultados.entrySet()) {
            msgSaida += "Jogador " + item.getKey() + " -> " + item.getValue() + " pontos";
            msgSaida += "\n";
        }
        return msgSaida;
    }
}

