package SetImport;


import java.util.*;

public class SetImport {
    public static void main (String[] args){

        System.out.println("Criar um conjunto Set e adicione as notas: ");
        //Set de Notas
        Set<Double> notas = new HashSet<>(Arrays.asList(3.6, 7d, 0d, 8.5, 4.9, 9d, 7d, 5.8, 6.4));
        //Ordem aleatória dos elementos e elementos repetidos não aparecem
        System.out.println(notas.toString());

        //Não consigo trabalhar com posições utilizando o Set e nem Substituir Dados. Exemplo:

        //System.out.println("Exiba a posição da nota 4.9: ");
        //System.out.println("== NÃO TEM COMO UTILIZANDO SET ==");
        //System.out.println("Adicione a nota 8.9 na posição 4: ");
        //System.out.println("== NÃO TEM COMO UTILIZANDO SET ==");
        //System.out.println("Substitua a nota 4.9 por 5");
        //System.out.println("== NÃO TEM COMO UTILIZANDO SET ==");
        //System.out.println("Exiba a terceira nota adicionada");
        //System.out.println("== NÃO TEM COMO UTILIZANDO SET ==");

        //Consegue verificar se um dado existe no conjunto. true = tem / false = não tem
        System.out.println("Verifique se a nota 8.5 está no conjunto: " + notas.contains(8.5));

        System.out.println("Exiba a menor nota do conjunto: " + Collections.min(notas));

        System.out.println("Exiba a maior nota do conjunto: " + Collections.max(notas));

        //A soma é a mesma lógica usada para somar elementos de uma list
        Double soma= 0.0;
        Iterator<Double> iterator = notas.iterator();
        while (iterator.hasNext()){ // condição: enquanto iterator tiver próximo...
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a Soma das notas do conjunto: "+ soma);

        System.out.println("Exiba a Média das notas do conjunto: "+ (soma/ notas.size()));

        System.out.println("Remova a nota 4.9: ");
        notas.remove(4.9);
        System.out.println(notas);

        //Mesma lógica utilizada nas Lists
        System.out.println("Remova as notas menores que 7 e exiba: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7d){
                iterator1.remove();
            }
        }
        System.out.println(notas);

        //Criado o "TreeSet" passando como parametros nosso antigo Set, pois o TreeSet tem como função organizar o Set
        System.out.println("Exiba o conteúdo organizado de forma crescente: ");
        Set<Double> notas1 = new TreeSet<>(notas);
        System.out.println(notas1);

        System.out.println("Apague o Conjunto: ");
        notas.clear();

        System.out.println("O conjunto foi apagado?: "+ notas.isEmpty());
        System.out.println("O conjunto1 foi apagado?: "+ notas1.isEmpty());
    }
}
