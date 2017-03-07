public class Jogador {

    private final String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        pontuacao = pontuacao < 0 ? 0 : pontuacao;

        this.pontuacao = pontuacao;
    }
}
