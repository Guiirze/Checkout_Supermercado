package Supermercado;

public class Cupom_Natal extends AbstractClassCupomDeDesconto {

    @Override
    public Double aplicadorDeDesconto(Double valor) {
        return valor * 0.80;
    }
}
