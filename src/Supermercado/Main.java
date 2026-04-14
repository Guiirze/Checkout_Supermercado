import Supermercado.Cupom_Natal;
import Supermercado.EnumTiposDeProdutos;
import Supermercado.RecordProduto;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Double totalGeral = 0.0;
    NumberFormat moedaBrazil = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    while (true) {
        try {
            System.out.print("Digite o nome do produto (ou SAIR para finalizar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("SAIR")) {
                break;
            }
            System.out.print("Preço base do produto: ");
            Double precoNormalDoProduto = Double.valueOf(scanner.nextLine());
            System.out.println();
            System.out.println("--- Qual é o tipo do produto? ---");
            System.out.println("ALIMENTOS | LIMPEZA | HIGIENE_PESSOAL | UTENSILIOS_DOMÉSTICOS | PET_SHOP | PAPELARIA | ELETRONICOS | AUTOMOTIVOS");
            System.out.print("Ele é.: ");
            String tipoDeProdutoEscolhido = scanner.nextLine().toUpperCase();

            EnumTiposDeProdutos tipoDeProdutosEscolhidoPeloUsuario = EnumTiposDeProdutos.valueOf(tipoDeProdutoEscolhido);
            RecordProduto produto = new RecordProduto(nome, precoNormalDoProduto, tipoDeProdutosEscolhidoPeloUsuario);
            Double precoFinal = produto.getPrecoFinal();
            totalGeral += precoFinal;

            System.out.printf("Item adicionado: %s - Valor Final: %s%n", nome, moedaBrazil.format(precoFinal));
            System.out.println();



        } catch (RuntimeException e) {
            System.err.println("Erro: Esse tipo de produto não existe em nosso catálogo.");
        }

    }

    System.out.println("--- FINALIZANDO COMPRA... ---");
    System.out.println("Total parcial: " + moedaBrazil.format(totalGeral));
    System.out.print("Digite o cupom de desconto (ou aperte ENTER para pular): ");
    String cupomDigitado = scanner.nextLine();

    if (cupomDigitado.equalsIgnoreCase("NATAL")) {
        Cupom_Natal cupom = new Cupom_Natal();
        totalGeral = cupom.aplicadorDeDesconto(totalGeral);
        System.out.println("Cupom NATAL aplicado! Desconto de 20%.");
    }
    System.out.println("----------------------------------");
    System.out.println("TOTAL FINAL A PAGAR: " + moedaBrazil.format(totalGeral));
    System.out.println("Obrigado pela preferência!");
}
















