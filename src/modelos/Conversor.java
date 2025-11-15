package modelos;

public class Conversor implements Comparable<Conversor>{
    private String nome;
    private Double valor;


    public Conversor (String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }


    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public int compareTo(Conversor outroConversor) {
        return this.getNome().compareTo(outroConversor.getNome());
    }
}
