import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class JokenPoTest {
    @Test
    public void TestUmJogador() {

        try {
            final JokenPo jokenPo = new JokenPo(1);
            fail("Nao podia chegar aqui");
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(),
                    "E necessario pelo menos 2 jogadores");
        }
    }

    @Test
    public void TestDoisJogadores() {
        final JokenPo jokenPo = new JokenPo(2);

    }

    @Test
    public void TestEnumeradorPapelContraPedra() {
        final TipoJogada tipoJogada1 = TipoJogada.PAPEL;
        final TipoJogada tipoJogada2 = TipoJogada.PEDRA;

        try {
            final TipoJogada resultado = tipoJogada1.desafiar(tipoJogada2);
            assertEquals(resultado, TipoJogada.PAPEL);
        } catch (Exception e) {
            fail("Nao era pra cair aqui");
        }
    }

    @Test
    public void TestEnumeradorPapelContraTesoura() {
        final TipoJogada tipoJogada1 = TipoJogada.PAPEL;
        final TipoJogada tipoJogada2 = TipoJogada.TESOURA;

        try {
            final TipoJogada resultado = tipoJogada1.desafiar(tipoJogada2);
            assertEquals(resultado, TipoJogada.TESOURA);
        } catch (Exception e) {
            fail("Nao era pra cair aqui");
        }
    }

    @Test
    public void TestJogadaInvalida() {
        final JokenPo jokenPo = new JokenPo(2);
        try {
            jokenPo.jogar("pT");
            fail("Nao pode chegar aqui");
        } catch (RuntimeException ex) {
            assertEquals(ex.getMessage(), "TipoJogada Invalida, jogador 2");
        }

    }

    @Test
    public void TestUmaJogada() {
        final JokenPo jokenPo = new JokenPo(2);
        jokenPo.jogar("pP");

        assertEquals(jokenPo.getResultado(),
                "Jogador 1 -> 1 pontos\n" +
                        "Jogador 2 -> 0 pontos\n");
    }

    @Test
    public void TestDuasJogadas() {
        final JokenPo jokenPo = new JokenPo(2);
        jokenPo.jogar("pP");
        jokenPo.jogar("pP");

        assertEquals(jokenPo.getResultado(),
                "Jogador 1 -> 2 pontos\n" +
                        "Jogador 2 -> 0 pontos\n");
    }

    @Test
    public void TestDuasJogadas2() {
        final JokenPo jokenPo = new JokenPo(2);
        jokenPo.jogar("pP");
        jokenPo.jogar("pt");

        assertEquals(jokenPo.getResultado(),
                "Jogador 1 -> 1 pontos\n" +
                        "Jogador 2 -> 1 pontos\n");
    }

    @Test
    public void TestTresJogadores() {
        final JokenPo jokenPo = new JokenPo(3);
        jokenPo.jogar("pPt");

        assertEquals(jokenPo.getResultado(),
                "Jogador 1 -> 0 pontos\n" +
                        "Jogador 2 -> 0 pontos\n" +
                        "Jogador 3 -> 1 pontos\n");
    }

    @Test
    public void TestTresJogadoresDuasJogadas() {
        final JokenPo jokenPo = new JokenPo(3);
        jokenPo.jogar("pPt");
        jokenPo.jogar("ppt");

        assertEquals(jokenPo.getResultado(),
                "Jogador 1 -> 0 pontos\n" +
                        "Jogador 2 -> 0 pontos\n" +
                        "Jogador 3 -> 1 pontos\n");
    }

    @Test
    public void TestQuatroJogadores() {
        final JokenPo jokenPo = new JokenPo(4);
        jokenPo.jogar("pPtp");

        assertEquals(jokenPo.getResultado(),
                "Jogador 1 -> 0 pontos\n" +
                        "Jogador 2 -> 0 pontos\n" +
                        "Jogador 3 -> 1 pontos\n" +
                        "Jogador 4 -> 0 pontos\n");
    }

    @Test
    public void TestVencedor() {
        final JokenPo jokenPo = new JokenPo(4);
        jokenPo.jogar("pPtp");
        jokenPo.jogar("pPtp");
        jokenPo.jogar("pPtp");

        assertEquals(jokenPo.getVencedor(), "Jogador 3 -> 3 pontos");
    }
}
