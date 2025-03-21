class Cartas {
    private String naipe;
    private String valor;

    public Cartas(String naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
    }
}

class Baralho {
    private final List<Cartas> carta;

    public Baralho() {
        carta = new ArrayList<>();
        String[] naipes = {"Ouros", "Espadas", "Copas", "Paus"};
        String[] valores = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};
        int i = 0;
        for (String naipe : naipes) {
            for (String valor : valores) {
                carta.add(new Cartas(valor, naipe));
            }
        }
    }
}

public void Embaralhar(){
    Collections.shuffle(carta);
}

public Cartas darCarta(){
    if (cartas.size() > 0){
        return cartas.remove(0);
    }
    return null;
}