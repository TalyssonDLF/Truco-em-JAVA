impot java.util.ArrayList;
import java.util.List;

public class jogador{
    private String nome;
    private int pontos;
    List<Carta> mao;

    jogador(String nome){
        this.nome = nome;
        this.pontos = 0;
        this.mao = new ArrayList<Carta>();
    }

    public void setPontos(int pontos){
        this.pontos = pontos;
    }

    public int getPontos(){
        return this.pontos;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public list<Carta> getMao(){
        return Mao;
    }

    public void verMao(){
        for(Carta c : this.mao){
            System.out.println(carta.getNome());
        }
    }

    public void getCarta(Carta c){
        this.mao.add(c);
    }

    public Carta jogarCarta(){
        return this.mao.remove(posicao-1);
    }

}