public enum Jogada {

    PEDRA {
        @Override
        Jogada getVencedor() {
            return PAPEL;
        }
    },
    PAPEL {
        @Override
        Jogada getVencedor() {
            return TESOURA;
        }
    },
    TESOURA {
        @Override
        Jogada getVencedor() {
            return PEDRA;
        }
    };

    public Jogada desafiar(Jogada jogada) throws Exception {
        if (equals(jogada))
            throw new Exception("Empate");
        return (jogada.equals(getVencedor()) ? jogada : this);
    }

    abstract Jogada getVencedor();

    public static Jogada getValue(char value) {
        switch (value) {
            case 'P':
                return PEDRA;
            case 'p':
                return PAPEL;
            case 't':
                return TESOURA;
            default:
                break;
        }
        return null;
    }
}
