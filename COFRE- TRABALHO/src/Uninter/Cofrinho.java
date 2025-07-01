package Uninter;

import java.util.ArrayList;

public class Cofrinho {

    // Lista para armazenar as moedas adicionadas
    private ArrayList<Moeda> listaMoedas;

    // Construtor que inicializa a lista de moedas
    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    /**
     * Método para adicionar uma moeda ao cofrinho.
     * @param moeda Objeto da classe Moeda (Real, Dólar ou Euro) que será adicionado à lista.
     */
    public void adicionar(Moeda moeda) {
        this.listaMoedas.add(moeda);
    }

    /**
     * Método para remover uma moeda do cofrinho.
     * @param moeda Objeto da classe Moeda que será removido da lista.
     */
    public void remover(Moeda moeda) {
        this.listaMoedas.remove(moeda);
    }

    /**
     * Método para listar todas as moedas armazenadas no cofrinho.
     * Se o cofrinho estiver vazio, informa ao usuário.
     */
    public void listagemMoedas() {
        // Verifica se o cofrinho está vazio
        if (this.listaMoedas.isEmpty()) {
            System.out.println("Não existe nenhuma moeda no cofrinho!");
            return;
        }

        // Percorre a lista e exibe as informações de cada moeda
        for (Moeda moeda : this.listaMoedas) {
            moeda.info(); // Chama o método info() de cada moeda para mostrar detalhes
        }
    }

    /**
     * Método para calcular o valor total das moedas convertidas para reais.
     * @return Valor total acumulado em reais.
     */
    public double totalConvertido() {
        // Se o cofrinho estiver vazio, retorna zero
        if (this.listaMoedas.isEmpty()) {
            return 0;
        }

        double valorAcumulado = 0;

        // Percorre a lista de moedas e soma os valores convertidos
        for (Moeda moeda : this.listaMoedas) {
            valorAcumulado += moeda.converter(); // Soma o valor convertido
        }

        return valorAcumulado;
    }
}