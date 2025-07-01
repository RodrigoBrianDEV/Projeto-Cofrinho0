package Uninter;

import java.util.Scanner;

public class Menu {

    private Scanner sc;
    private Cofrinho cofrinho;

    // Construtor para inicializar o Scanner e o Cofrinho
    public Menu() {
        sc = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    // Exibe o menu principal e trata as opções
    public void exibirMenuPrincipal() {
        System.out.println("Cofrinho:");
        System.out.println("1 + Adicionar (Moeda)");
        System.out.println("2 + Remover   (Moeda)");
        System.out.println("3 + Listar    (Moedas)");
        System.out.println("4 + Calcular valor total convertido para real()");
        System.out.println("0 - Encerrar:");

        String opcaoSelecionada = sc.next();

        switch (opcaoSelecionada) {

            case "0": // Encerra o sistema
                System.out.println("Sistema concluído!");
                break;

            case "1": // Adicionar Moeda
                exibirSubMenuAdicionarMoedas();
                break;

            case "2": // Remover Moeda
                exibirSubMenuRemoverMoedas();
                break;

            case "3": // Listar Moedas
                cofrinho.listagemMoedas(); // Chama o método para listar moedas
                exibirMenuPrincipal();
                break;

            case "4": // Calcular valor total convertido para real
                double valorTotal = cofrinho.totalConvertido();
                
                // Formata o valor usando vírgula como separador decimal
                String valorFormatado = String.format("%.2f", valorTotal).replace(".", ",");
                
                System.out.println("Valor total convertido para real: R$ " + valorFormatado);
                
                exibirMenuPrincipal(); // Retorna ao menu após mostrar o valor total
                break;

            default:
                System.out.println("Erro! Opção inválida.");
                exibirMenuPrincipal(); // Retorna ao menu em caso de erro
                break;
        }
    }

    // Método para adicionar moedas
    private void exibirSubMenuAdicionarMoedas() {
        Moeda moeda = null;

        while (moeda == null) {
            System.out.println("Escolha Moeda");
            System.out.println("1 - Real (R$):");
            System.out.println("2 - Dólar ($):");
            System.out.println("3 - Euro (€):");
            System.out.println("4 - Voltar ao menu principal");

            int opcaoMoeda = sc.nextInt();

            if (opcaoMoeda == 4) { // Se o usuário escolher voltar
                System.out.println("Voltando ao menu principal...");
                exibirMenuPrincipal();
                return;
            }

            if (opcaoMoeda < 1 || opcaoMoeda > 3) {
                System.out.println("Não existe essa moeda! Tente novamente.");
                continue;
            }

            // Solicita o valor da moeda
            System.out.println("Digite o valor:");
            String valorTextualMoeda = sc.next();
            valorTextualMoeda = valorTextualMoeda.replace(",", "."); // Substitui vírgula por ponto para conversão
            double valorMoeda = Double.valueOf(valorTextualMoeda);

            // Cria o objeto correspondente à moeda escolhida
            if (opcaoMoeda == 1) {
                moeda = new Real(valorMoeda);
                System.out.println("Adicionando: R$ " + valorMoeda);
            } else if (opcaoMoeda == 2) {
                moeda = new Dolar(valorMoeda);
                System.out.println("Adicionando: $ " + valorMoeda);
            } else if (opcaoMoeda == 3) {
                moeda = new Euro(valorMoeda);
                System.out.println("Adicionando: € " + valorMoeda);
            }
        }

        cofrinho.adicionar(moeda); // Adiciona a moeda ao cofrinho
        System.out.println("Excelente! Moeda adicionada com sucesso.");

        exibirMenuPrincipal(); // Retorna ao menu principal após adicionar
    }

    // Método para remover moedas
    private void exibirSubMenuRemoverMoedas() {
        Moeda moeda = null;

        while (moeda == null) {
            System.out.println("Escolha Moeda");
            System.out.println("1 - Real (R$):");
            System.out.println("2 - Dólar ($):");
            System.out.println("3 - Euro (€):");
            System.out.println("4 - Voltar ao menu principal");

            int opcaoMoeda = sc.nextInt();

            if (opcaoMoeda == 4) { // Se o usuário escolher voltar
                System.out.println("Voltando ao menu principal...");
                exibirMenuPrincipal();
                return;
            }

            if (opcaoMoeda < 1 || opcaoMoeda > 3) {
                System.out.println("Não existe essa moeda! Tente novamente.");
                continue;
            }

            // Solicita o valor da moeda para remoção
            System.out.println("Digite o valor:");
            String valorTextualMoeda = sc.next();
            valorTextualMoeda = valorTextualMoeda.replace(",", ".");
            double valorMoeda = Double.valueOf(valorTextualMoeda);

            // Cria o objeto correspondente à moeda escolhida
            if (opcaoMoeda == 1) {
                moeda = new Real(valorMoeda);
                System.out.println("Removendo: R$ " + valorMoeda);
            } else if (opcaoMoeda == 2) {
                moeda = new Dolar(valorMoeda);
                System.out.println("Removendo: $ " + valorMoeda);
            } else if (opcaoMoeda == 3) {
                moeda = new Euro(valorMoeda);
                System.out.println("Removendo: € " + valorMoeda);
            }
        }

        cofrinho.remover(moeda); // Remove a moeda do cofrinho
        System.out.println("Excelente! Moeda removida com sucesso.");

        exibirMenuPrincipal(); // Retorna ao menu após remover
    }
}