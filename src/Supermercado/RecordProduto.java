package Supermercado;

public record RecordProduto(String nomeDoProduto, Double precoNormalDoProduto, EnumTiposDeProdutos qualOtipoDeProduto) implements InterfaceItem {

    @Override

    public Double getPrecoFinal() {
        return switch (qualOtipoDeProduto){

            case ALIMENTOS -> precoNormalDoProduto * 0.95;

            case LIMPEZA -> precoNormalDoProduto * 1.10;

            default -> precoNormalDoProduto;

        };

    }

}
