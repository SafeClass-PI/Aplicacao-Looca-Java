package school.sptech;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inTxt = new Scanner(System.in);
        MetodosPizzaria pizzaria = new MetodosPizzaria();

        Integer respostaMenu = 1;
        Integer respostaMenuIngredientes = 1;
        Integer respostaMenuSabores = 1;
        Integer respostaMenuPedidos = 1;

        String nomeIngrediente;
        String nomeSabor;
        String continuar;

        pizzaria.dadosMockados();

        pizzaria.bemvindo();
        for (int i = 0; !respostaMenu.equals(0); i++) { // MENU INICIAL

            pizzaria.menuInicial();
            respostaMenu = in.nextInt();

            if (respostaMenu.equals(1)) { // GERENCIAR - INGREDIENTES

                for (int j = 0; !respostaMenuIngredientes.equals(0); j++) {
                    pizzaria.menuIngredientes();
                    respostaMenuIngredientes = in.nextInt();

                    if (respostaMenuIngredientes.equals(1)) { // Cadastrar Ingrediente
                        System.out.print("Digite o nome do ingrediente que deseja adicionar: ");
                        nomeIngrediente = inTxt.nextLine();
                        System.out.print("Digite a quantidade (porções): ");
                        Integer qtdIngrediente = in.nextInt();
                        pizzaria.cadastrarIngrediente(nomeIngrediente, qtdIngrediente);

                    } else if (respostaMenuIngredientes.equals(2)) { // Alterar Ingrediente
                        System.out.print("Digite o nome do ingrediente que deseja alterar: ");
                        nomeIngrediente = inTxt.nextLine();
                        System.out.print("Digite o novo nome do ingrediente: ");
                        String novoIngrediente = inTxt.nextLine();
                        pizzaria.alterarIngrediente(nomeIngrediente, novoIngrediente);

                    } else if (respostaMenuIngredientes.equals(3)) { // Remover Ingrediente
                        System.out.print("Digite o nome do ingrediente que deseja remover: ");
                        nomeIngrediente = inTxt.nextLine();
                        pizzaria.removerIngrediente(nomeIngrediente);

                    } else if (respostaMenuIngredientes.equals(4)) { // Reabastecer Ingredientes
                        System.out.print("Digite o ingrediente que deseja reabastecer: ");
                        nomeIngrediente = inTxt.nextLine();
                        System.out.print("Digite a quantidade para adicionar ao estoque (porções): ");
                        Integer qtdIngrediente = in.nextInt();
                        pizzaria.reabastecerIngrediente(nomeIngrediente, qtdIngrediente);

                    } else if (respostaMenuIngredientes.equals(5)) { // Relatório dos Ingredientes
                        pizzaria.relatorioIngredientes();

                    } else if (respostaMenuIngredientes.equals(7)) { // Voltar
                        break;

                    } else if (respostaMenuIngredientes.equals(0)) { // Sair
                        System.out.println("A pizzaria foi fechada. Até a próxima 👨‍🍳🍕👋");
                        pizzaria.artPizza();
                        respostaMenu = 0;

                    } else {
                        System.out.println("Ops! opção inválida. Tente novamente");
                    }

                    if (!respostaMenuIngredientes.equals(7) && !respostaMenuIngredientes.equals(0)) {
                        System.out.println("Digite qualquer tecla para continuar: ");
                        continuar = inTxt.nextLine();
                    }

                }

            } else if (respostaMenu.equals(2)) { // GERENCIAR - SABORES
                for (int j = 0; !respostaMenuSabores.equals(0); j++) {
                    pizzaria.menuSabores();
                    respostaMenuSabores = in.nextInt();

                    if (respostaMenuSabores.equals(1)) { // Cadastrar Sabor de Pizza
                        System.out.print("Digite o nome do sabor de pizza que deseja adicionar: ");
                        nomeSabor = inTxt.nextLine();
                        pizzaria.cadastrarSabor(nomeSabor);

                    } else if (respostaMenuSabores.equals(2)) { // Alterar Nome do Sabor de Pizza
                        System.out.print("Digite o nome do sabor de pizza que deseja alterar: ");
                        nomeSabor = inTxt.nextLine();
                        System.out.print("Digite o novo nome do sabor: ");
                        String novoSabor = inTxt.nextLine();
                        pizzaria.alterarSabor(nomeSabor, novoSabor);

                    } else if (respostaMenuSabores.equals(3)) { // Remover Sabor de Pizza
                        System.out.print("Digite o nome do sabor que deseja remover: ");
                        nomeSabor = inTxt.nextLine();
                        pizzaria.removerSabor(nomeSabor);

                    } else if (respostaMenuSabores.equals(4)) { // Relatório dos Sabores
                        pizzaria.relatorioSabores();

                    } else if (respostaMenuSabores.equals(7)) { // Voltar
                        break;

                    } else if (respostaMenuSabores.equals(0)) { // Sair
                        System.out.println("A pizzaria foi fechada. Até a próxima 👨‍🍳🍕👋");
                        pizzaria.artPizza();
                        respostaMenu = 0;

                    } else {
                        System.out.println("Ops! opção inválida. Tente novamente");
                    }

                    if (!respostaMenuSabores.equals(7) && !respostaMenuSabores.equals(0)) {
                        System.out.println("Digite qualquer tecla para continuar: ");
                        continuar = inTxt.nextLine();
                    }

                }
            } else if (respostaMenu.equals(3)) { // GERENCIAR - PEDIDOS

                for (int j = 0; !respostaMenuPedidos.equals(0); j++) {
                    pizzaria.menuPedidos();
                    respostaMenuPedidos = in.nextInt();

                    if (respostaMenuPedidos.equals(1)) { // Registrar Pedido
                        System.out.println("""
                                "𝑷𝒂𝒓𝒂 𝒔𝒂𝒃𝒐𝒓𝒆𝒂𝒓 𝒐 𝒎𝒂́𝒙𝒊𝒎𝒐 𝒅𝒆 𝒄𝒂𝒅𝒂 𝒑𝒊𝒛𝒛𝒂 𝒏𝒐𝒔𝒔𝒐𝒔 𝒄𝒍𝒊𝒆𝒏𝒕𝒆𝒔 𝒔𝒐́ 𝒑𝒐𝒅𝒆𝒎 𝒑𝒆𝒅𝒊𝒓 𝟏 𝒑𝒊𝒛𝒛𝒂 𝒑𝒐𝒓 𝒗𝒆𝒛."
                                """);
                        System.out.print("Digite o nome do sabor que foi pedido: ");
                        nomeSabor = inTxt.nextLine();
                        pizzaria.registrarPedido(nomeSabor);

                    } else if (respostaMenuPedidos.equals(7)) { // Voltar
                        break;

                    } else if (respostaMenuPedidos.equals(0)) { // Sair
                        System.out.println("A pizzaria foi fechada. Até a próxima 👨‍🍳🍕👋");
                        pizzaria.artPizza();
                        respostaMenu = 0;

                    } else {
                        System.out.println("Ops! opção inválida. Tente novamente");
                    }

                    if (!respostaMenuPedidos.equals(7) && !respostaMenuPedidos.equals(0)) {
                        System.out.println("Digite qualquer tecla para continuar: ");
                        continuar = inTxt.nextLine();
                    }

                }
            } else if (respostaMenu.equals(0)) {
                System.out.println("A pizzaria foi fechada. Até a próxima 👨‍🍳🍕👋");
                pizzaria.artPizza();
            } else {
                System.out.println("Ops! opção inválida. Tente novamente");
            }
        }

    }
}
