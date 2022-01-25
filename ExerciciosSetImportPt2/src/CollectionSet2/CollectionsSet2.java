package CollectionSet2;

import com.sun.source.tree.Tree;

import java.util.*;

public class CollectionsSet2 {
    public static void main (String[] args){

        System.out.println("Ordem Aleatória");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("Ozark", "Mistério", 60));
            add(new Serie("Supernatural", "Suspense", 26));
        }};
        //Apenas para imprimir bonitinho
        for (Serie serie: minhasSeries){
            System.out.println (serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println(" ");
        System.out.println("Ordem Inserção");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("Dark", "Ficção", 60));
            add(new Serie("Ozark", "Mistério", 60));
            add(new Serie("Supernatural", "Suspense", 26));
        }};
        //Apenas para imprimir bonitinho
        for (Serie serie: minhasSeries1){
            System.out.println (serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println(" ");
        System.out.println("Ordem Tempo Episódio");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        //Apenas para imprimir bonitinho
        for (Serie serie: minhasSeries2){
            System.out.println (serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println(" ");
        System.out.println("Ordem Nome/Gênero/TempoEpisódio");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3){
            System.out.println (serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return
                "{nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    //Inser Code.../Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    //Compare to para comparar e também para caso um atributo seja igual
    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), getTempoEpisodio());
        if (tempoEpisodio!=0){
            return tempoEpisodio;
        }
        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome =  s1.getNome().compareTo(s2.getNome());
        if (nome!=0){
            return nome;
        }
        int genero =  s1.getGenero().compareTo(s2.getGenero());
        if (genero!=0){
            return genero;
        }
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}
