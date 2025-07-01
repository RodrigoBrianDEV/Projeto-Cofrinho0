package Uninter;

public class Real extends Moeda {

    public Real(double valorInicial) {
        this.valor = valorInicial;
    }

    @Override
    public void info() {
        // Exibe o valor com o símbolo de Real (R$)
        System.out.println("Real - R$ " + String.format("%.2f", valor).replace(".", ","));
    }

    @Override
    public double converter() {
        return this.valor;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        Real objetoDeReal = (Real) objeto;

        if (this.valor != objetoDeReal.valor) {
            return false;
        }

        return true;
    }
}
