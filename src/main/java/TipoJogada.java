public enum TipoJogada {

    PEDRA {
        @Override
        TipoJogada getVencedor() {
            return PAPEL;
        }
    },
    PAPEL {
        @Override
        TipoJogada getVencedor() {
            return TESOURA;
        }
    },
    TESOURA {
        @Override
        TipoJogada getVencedor() {
            return PEDRA;
        }
    };

    public TipoJogada desafiar(TipoJogada tipoJogada) throws Exception {
        if (equals(tipoJogada))
            throw new Exception("Empate");
        return (tipoJogada.equals(getVencedor()) ? tipoJogada : this);
    }

    abstract TipoJogada getVencedor();

    public static TipoJogada getValue(char value) {
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
