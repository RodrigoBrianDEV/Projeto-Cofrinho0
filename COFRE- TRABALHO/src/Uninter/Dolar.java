package Uninter;

public class Dolar extends Moeda {

    public Dolar(double valorInicial) {
        this.valor = valorInicial;
    }

    @Override
    public void info() {
        // Exibe o valor com o símbolo de Dólar ($)
        System.out.println("Dólar - $ " + String.format("%.2f", valor).replace(".", ","));
    }

    @Override
    public double converter() {
        // A taxa de câmbio do dólar do dia 12/03/2025 é 5,80 Reais
        return this.valor * 5.8;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        Dolar objetoDeDolar = (Dolar) objeto;

        if (this.valor != objetoDeDolar.valor) {
            return false;
        }

        return true;
    }
}