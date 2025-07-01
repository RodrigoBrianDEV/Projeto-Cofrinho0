package Uninter;

public class Euro extends Moeda {

    public Euro(double valorInicial) {
        this.valor = valorInicial;
    }

    @Override
    public void info() {
        // Exibe o valor com o símbolo de Euro (€)
        System.out.println("Euro - € " + String.format("%.2f", valor).replace(".", ","));
    }

    @Override
    public double converter() {
        // A taxa de câmbio do Euro do dia 12/03/2025 é 6,30 Reais
        return this.valor * 6.3;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        Euro objetoDeEuro = (Euro) objeto;

        if (this.valor != objetoDeEuro.valor) {
            return false;
        }

        return true;
    }
}
