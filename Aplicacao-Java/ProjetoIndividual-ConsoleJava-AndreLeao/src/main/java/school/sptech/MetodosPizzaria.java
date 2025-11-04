package school.sptech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MetodosPizzaria {

    Scanner in = new Scanner(System.in);

    List<String> ingredientes = new ArrayList<>();
    List<String> saboresPizza = new ArrayList<>();
    List<Integer> estoque = new ArrayList<>();
    List<Double> preco = new ArrayList<>();

    List<List<Boolean>> ingredientesDeTodosSaboresBoolean = new ArrayList<>();
    List<List<String>> ingredientesDeTodosSaboresString = new ArrayList<>();

    // Dados mockados
    void dadosMockados() {
        ingredientes.addAll(List.of("MASSA", "MOLHO", "QUEIJO", "TOMATE", "MANJERICÃO", "CALABRESA", "BACON", "FRANGO"));
        estoque.addAll(List.of(3,4,5,1,9,20, 7, 0));
        saboresPizza.addAll(List.of("MARGUERITA", "CALABRESA", "BACON", "À MODA DA CASA"));
        preco.addAll(List.of(35.99, 39.98, 41.95, 50.00));
        ingredientesDeTodosSaboresBoolean.addAll(List.of(
                List.of(true, true, true, true, true, false, false, false),  // MARGUERITA
                List.of(true, true, true, false, false, true, false, false), // CALABRESA
                List.of(true, true, true, false, false, false, true, false),  // BACON
                List.of(true, true, true, true, true, true, true, false) // A LA CARTE
        ));
        ingredientesDeTodosSaboresString.addAll(List.of(
                List.of("MASSA", "MOLHO", "QUEIJO", "TOMATE", "MANJERICÃO"),  // MARGUERITA
                List.of("MASSA", "MOLHO", "QUEIJO", "CALABRESA"), // CALABRESA
                List.of("MASSA", "MOLHO", "QUEIJO", "BACON"),  // BACON
                List.of("MASSA", "MOLHO", "QUEIJO", "TOMATE", "MANJERICÃO", "CALABRESA", "BACON") // A LA CARTE
        ));

    }

    // Métodos - Ingredientes
    List<String> cadastrarIngrediente(String nomeIngrediente, Integer qtdIngrediente) {

        if (ingredientes.size() >= 1) {
            Boolean ingredienteExiste = false;
            for (int i = 0; i < ingredientes.size(); i++) {
                if (ingredientes.get(i).equalsIgnoreCase(nomeIngrediente)) {
                    System.out.println("Esse ingrediente já foi cadastrado! ❌");
                    ingredienteExiste = true;
                    break;
                }
            }
            if (!ingredienteExiste) {
                ingredientes.add(nomeIngrediente.toUpperCase());
                estoque.add(qtdIngrediente);
                System.out.println("Ingrediente (" + nomeIngrediente + "): cadastrado com sucesso! ✅");
            }
        } else {
            ingredientes.add(nomeIngrediente.toUpperCase());
            estoque.add(qtdIngrediente);
            System.out.println("Ingrediente (" + nomeIngrediente + "): cadastrado com sucesso! ✅");
        }

        return ingredientes;
    }

    List<String> alterarIngrediente(String nomeIngrediente, String novoNomeIngrediente) {
        Boolean ingredienteExiste = false;
        if (ingredientes.size() >= 1) {
            for (int i = 0; i < ingredientes.size(); i++) {
                if (ingredientes.get(i).equalsIgnoreCase(nomeIngrediente)) {
                    ingredienteExiste = true;
                    System.out.println("O nome do ingrediente ("+ nomeIngrediente + ") foi alterado para (" + novoNomeIngrediente + ") ✅");
                    ingredientes.set(i, novoNomeIngrediente.toUpperCase());
                    break;
                }
            }
            if (!ingredienteExiste) {
                System.out.println("Ingrediente não encontrado! ❌");
            }
        } else {
            System.out.println("Você ainda não possui ingredientes cadastrados! ❌");
        }
        return ingredientes;
    }

    void removerIngrediente(String nomeIngrediente) {
        Boolean ingredienteExiste = false;
        Integer indiceIngredienteEscolhido = 0;
        List<Integer> indiceSaboresQueUtilizam = new ArrayList<>();
        List<String> nomeSaboresQueUtilizam = new ArrayList<>();

        for (int i = 0; i < ingredientes.size(); i++) {
            if (ingredientes.get(i).equalsIgnoreCase(nomeIngrediente)){
                ingredienteExiste = true;
                indiceIngredienteEscolhido = i;
                break;
            }
        }

        if (!ingredienteExiste){
            System.out.println("Ingrediente não encontrado! ❌");
            return;
        }

        for (int j = 0; j < ingredientesDeTodosSaboresString.size(); j++) {
            for (int k = 0; k < ingredientesDeTodosSaboresString.get(j).size(); k++) {
                if (ingredientesDeTodosSaboresString.get(j).get(k).equalsIgnoreCase(nomeIngrediente)) {
                    indiceSaboresQueUtilizam.add(j);
                    nomeSaboresQueUtilizam.add(saboresPizza.get(j));
                    break;
                }
            }
        }

        if (!indiceSaboresQueUtilizam.isEmpty()) {
            System.out.println("Não é possível remover o ingrediente (" + nomeIngrediente + ") ❌");
            System.out.println("Porque ele é usado pelos seguintes sabores:");

            for (int l = 0; l < indiceSaboresQueUtilizam.size(); l++) {
                System.out.println("• " + nomeSaboresQueUtilizam.get(l));
            }

            System.out.println("Obs: Remova primeiro os sabores acima e depois tente novamente.");
            return;
        }

        ingredientes.remove(indiceIngredienteEscolhido.intValue());
        estoque.remove(indiceIngredienteEscolhido.intValue());
        System.out.println("Ingrediente (" + nomeIngrediente + "): removido com sucesso! ✅");
    }

    List<String> reabastecerIngrediente(String nomeIngrediente, Integer qtdIngrediente) {
        Boolean ingredienteExiste = false;
        for (int i = ingredientes.size() - 1; i >= 0; i--) {
            if (ingredientes.get(i).equalsIgnoreCase(nomeIngrediente)) {
                ingredienteExiste = true;
                estoque.set(i, estoque.get(i) + qtdIngrediente);
                System.out.println(qtdIngrediente + " porções de " + nomeIngrediente + " foram adicionadas ao estoque! ✅");
                break;
            }
        }
        if (!ingredienteExiste) {
            System.out.println("Ingrediente não encontrado! ❌");
        }

        return ingredientes;
    }

    List<String> relatorioIngredientes() {
        if (ingredientes.size() >= 1) {
            System.out.println("--------------------------------");
            System.out.println("   Relatório - Ingredientes:");
            System.out.println("--------------------------------");
            for (int i = 0; i < ingredientes.size(); i++) {
                System.out.println(ingredientes.get(i)+ ": " + estoque.get(i) + " porções");
            }
        } else {
            System.out.println("Obs: Você ainda não tem ingredientes cadastrados!");
        }
        return ingredientes;
    }


    // Métodos - Sabores
    void cadastrarSabor(String nomeSabor) {

        List<Boolean> ingredientesDoSaborAtual =  new ArrayList<>();
        List<String> nomeIngredientesEscolhidos = new ArrayList<>();

        if (ingredientes.size() >= 1) {
            if (saboresPizza.size() >= 1) {
                Boolean saborExiste = false;
                for (int i = 0; i < saboresPizza.size(); i++) {
                    if (saboresPizza.get(i).equalsIgnoreCase(nomeSabor)) {
                        System.out.println("Esse sabor já foi cadastrado! ❌");
                        saborExiste = true;
                        break;
                    }
                }

                if (!saborExiste) {
                    saboresPizza.add(nomeSabor.toUpperCase());
                    System.out.println("Para escolher os ingredientes da pizza digite:");
                    System.out.println("S: contém ✔");
                    System.out.println("N: não contém ✖");
                    for (int j = 0; j < ingredientes.size(); j++) {
                        System.out.print("O sabor " + nomeSabor + " contém " + ingredientes.get(j) + "?: ");
                        String resposta = in.nextLine();
                        if (resposta.equalsIgnoreCase("S")) {
                            ingredientesDoSaborAtual.add(true);
                            nomeIngredientesEscolhidos.add(ingredientes.get(j));
                        } else if (resposta.equalsIgnoreCase("N")) {
                            ingredientesDoSaborAtual.add(false);
                        } else {
                            System.out.println("Ops! Comando inválido, tente novamente. ❌");
                            j--;
                        }
                    }

                    System.out.print("Digite o valor deste sabor (Ex: 45.00): ");
                    Double respostaPreco = Double.parseDouble(in.nextLine());
                    preco.add(respostaPreco);
                    ingredientesDeTodosSaboresBoolean.add(new ArrayList<>(ingredientesDoSaborAtual)); //Guardando versão Boolean
                    ingredientesDeTodosSaboresString.add(new ArrayList<>(nomeIngredientesEscolhidos)); //Guardando versão String
                    System.out.println("Sabor (" + nomeSabor + "): cadastrado com sucesso! ✅");
                    System.out.println("Ingredientes: " + nomeIngredientesEscolhidos);
                    System.out.printf("Preço (R$): %.2f", respostaPreco);
                    System.out.println();
                }

            } else {
                saboresPizza.add(nomeSabor.toUpperCase());
                System.out.println("Para escolher os ingredientes da pizza digite:");
                System.out.println("S: contém ✔");
                System.out.println("N: não contém ✖");
                for (int i = 0; i < ingredientes.size(); i++) {
                    System.out.print("O sabor " + nomeSabor + " contém " + ingredientes.get(i) + "?: ");
                    String resposta = in.nextLine();
                    if (resposta.equalsIgnoreCase("S")) {
                        ingredientesDoSaborAtual.add(true);
                        nomeIngredientesEscolhidos.add(ingredientes.get(i));
                    } else if (resposta.equalsIgnoreCase("N")) {
                        ingredientesDoSaborAtual.add(false);
                    } else {
                        System.out.println("Ops! Comando inválido, tente novamente. ❌");
                        i--;
                    }
                }

                System.out.print("Digite o valor deste sabor (Ex: 45.00): ");
                Double respostaPreco = Double.parseDouble(in.nextLine());
                preco.add(respostaPreco);
                ingredientesDeTodosSaboresBoolean.add(new ArrayList<>(ingredientesDoSaborAtual)); //Guardando versão Boolean
                ingredientesDeTodosSaboresString.add(new ArrayList<>(nomeIngredientesEscolhidos)); //Guardando versão String
                System.out.println("Sabor (" + nomeSabor + "): cadastrado com sucesso! ✅");
                System.out.println("Ingredientes: " + nomeIngredientesEscolhidos);
                System.out.printf("Preço (R$): %.2f", respostaPreco);
                System.out.println();
            }
        } else {
            System.out.println("Você ainda não tem nenhum ingrediente cadastrado! ❌");
        }
    }

    List<String> removerSabor(String nomeSabor) {
        Boolean saborExistente = false;
        for (int i = saboresPizza.size() - 1; i >= 0; i--) {
            if (saboresPizza.get(i).equalsIgnoreCase(nomeSabor)) {
                saborExistente = true;
                saboresPizza.remove(i);
                preco.remove(i);
                ingredientesDeTodosSaboresBoolean.remove(i);
                ingredientesDeTodosSaboresString.remove(i);
                System.out.println("Sabor (" + nomeSabor + "): removido com sucesso! ✅");
            }
        }
        if (!saborExistente) {
            System.out.println("Sabor não encontrado! ❌");
        }
        return saboresPizza;
    }

    void alterarSabor(String nomeSabor, String novoNomeSabor) {
        Boolean saborExiste = false;
        if (saboresPizza.size() >= 1) {
            for (int i = 0; i < saboresPizza.size(); i++) {
                if (saboresPizza.get(i).equalsIgnoreCase(nomeSabor)) {
                    saborExiste = true;
                    System.out.println("O nome do sabor ("+ nomeSabor + ") foi alterado para (" + novoNomeSabor + ") ✅");
                    saboresPizza.set(i, novoNomeSabor.toUpperCase());
                    break;
                }
            }
            if (!saborExiste) {
                System.out.println("Sabor não encontrado! ❌");
                return;
            }
        } else {
            System.out.println("Você ainda não possui sabores cadastrados! ❌");
        }
    }

    void relatorioSabores() {
        if (saboresPizza.size() >= 1) {

            System.out.println("-----------------------------------");
            System.out.println("   Relatório - Sabores de Pizza:");
            System.out.println("-----------------------------------");
            for (int i = 0; i < saboresPizza.size(); i++) {
                System.out.print(saboresPizza.get(i) + " (R$ ");
                System.out.printf("%.2f", preco.get(i));
                System.out.println("): " + ingredientesDeTodosSaboresString.get(i));
            }
        } else {
            System.out.println("Obs: Você ainda não tem sabores cadastrados!");
        }
    }

    // Método - Pedidos
    void registrarPedido(String nomeSabor) {
        Boolean saborExiste = false;
        Integer indiceSabor = 0;

        if (saboresPizza.size() >= 1) {

            for (int i = 0; i < saboresPizza.size(); i++) {
                if (saboresPizza.get(i).equalsIgnoreCase(nomeSabor)) {
                    saborExiste = true;
                    indiceSabor = i;
                    break;
                }
            }
            if (!saborExiste) {
                System.out.println("Sabor não encontrado! ❌");
                return;
            }

            Boolean temTodosIngredientes = true;
            List<String> ingredientesQueFaltam = new ArrayList<>();

            for (int j = 0; j < ingredientesDeTodosSaboresBoolean.get(indiceSabor).size(); j++) {
                if (ingredientesDeTodosSaboresBoolean.get(indiceSabor).get(j).equals(true)) {
                    if (estoque.get(j) <= 0) {
                        temTodosIngredientes = false;
                        ingredientesQueFaltam.add(ingredientes.get(j));
                    }
                }
            }
            if (!temTodosIngredientes) {
                System.out.println("Não foi possível registrar o pedido ❌");
                System.out.println("Ingredientes em falta: " + ingredientesQueFaltam);
                return;
            }

            for (int k = 0; k < ingredientesDeTodosSaboresBoolean.get(indiceSabor).size(); k++) {
                if (ingredientesDeTodosSaboresBoolean.get(indiceSabor).get(k).equals(true)) {
                    estoque.set(k, estoque.get(k) - 1);
                }
            }

            System.out.println("------------------------------------------");
            System.out.println("    Pedido Registrado com Sucesso! ✅");
            System.out.println("------------------------------------------");
            System.out.println("🍕 Sabor: " + saboresPizza.get(indiceSabor));
            System.out.println("🥩 Ingredientes utilizados: " + ingredientesDeTodosSaboresString.get(indiceSabor));
            System.out.printf("💵 Valor: R$ %.2f\n", preco.get(indiceSabor));
            System.out.println("""
                    "𝑶́𝒕𝒊𝒎𝒂 𝒆𝒔𝒄𝒐𝒍𝒉𝒂, 𝒎𝒖𝒊𝒕𝒐 𝒐𝒃𝒓𝒊𝒈𝒂𝒅𝒐 𝒆 𝒃𝒐𝒎 𝒂𝒑𝒆𝒕𝒊𝒕𝒆! ❤"
                    """);

        } else {
            System.out.println("Você ainda não possui sabores cadastrados! ❌");
        }
    }

    // Métodos - Apresentação
    void bemvindo() {
        System.out.print(
                """
                ┌──────────────────────────────────────────┐
                         Bem-vindo à PizzaTech 👨‍🍳🍕   
                └──────────────────────────────────────────┘
                ────────────────────────────────────────────
                """);
    }
    void menuInicial() {
        System.out.print(
                """
                ┌──────────────────────────────────────────┐
                │               MENU INICIAL               │
                └──────────────────────────────────────────┘
                O que deseja gerenciar?
                
                1- 🥩 Ingredientes
                2- 🍕 Sabores de Pizza
                3- 🔔 Pedidos
                
                🔴 0- Fechar Pizzaria
                ────────────────────────────────────────────
                """);
        System.out.print("Escolha uma opção: ");
    }

    void menuIngredientes() {
        System.out.print(
                """
                ┌──────────────────────────────────────────┐
                │           MENU - INGREDIENTES            │
                └──────────────────────────────────────────┘
                🥩 Ingredientes
                 1- Cadastrar Ingrediente      
                 2- Alterar nome do Ingrediente     
                 3- Remover Ingrediente         
                 4- Reabastecer Ingrediente   
                 5- Relatório de Ingredientes
                 
                🔙 7- Voltar                  
                🔴 0- Fechar Pizzaria
                ────────────────────────────────────────────
                """);
        System.out.print("Escolha uma opção: ");

    }

    void menuSabores() {
        System.out.print(
                """
                ┌──────────────────────────────────────────┐
                │              MENU - SABORES              │
                └──────────────────────────────────────────┘
                🍕 Sabores de Pizza
                 1- Cadastrar sabor de Pizza
                 2- Alterar nome do sabor de Pizza
                 3- Remover sabor de Pizza
                 4- Relatório de Sabores
                 
                🔙 7- Voltar                  
                🔴 0- Fechar Pizzaria
                ────────────────────────────────────────────
                """);
        System.out.print("Escolha uma opção: ");

    }

    void menuPedidos() {
        System.out.print(
                """
                ┌──────────────────────────────────────────┐
                │              MENU - PEDIDOS              │
                └──────────────────────────────────────────┘
                🔔 Pedidos
                 1- Registrar Pedido
                 
                🔙 7- Voltar                  
                🔴 0- Fechar Pizzaria
                ────────────────────────────────────────────
                """);
        System.out.print("Escolha uma opção: ");

    }

    void artPizza() {
        System.out.println("""
                              
                              ⣠⣤⣶⣶⣦⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣷⣤⠀⠈⠙⢿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀           _____ _                  __         _     _         _
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⠆⠰⠶⠀⠘⢿⣿⣿⣿⣿⣿⣆⠀⠀⠀          |  __ (_)                /_/        (_)   | |       | |
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⠏⠀⢀⣠⣤⣤⣀⠙⣿⣿⣿⣿⣿⣷⡀⠀         | |__) | __________ _    ___  __   ___  __| | __ _  | |
                ⠀⠀⠀⠀⠀⠀⠀⠀⢠⠋⢈⣉⠉⣡⣤⢰⣿⣿⣿⣿⣿⣷⡈⢿⣿⣿⣿⣿⣷⡀        |  ___/ |_  /_  / _` |  / _ \\ \\ \\ / / |/ _` |/ _` | | |
                ⠀⠀⠀⠀⠀⠀⠀⡴⢡⣾⣿⣿⣷⠋⠁⣿⣿⣿⣿⣿⣿⣿⠃⠀⡻⣿⣿⣿⣿⡇        | |   | |/ / / / (_| | |  __/  \\ V /| | (_| | (_| | |_|
                ⠀⠀⠀⠀⠀⢀⠜⠁⠸⣿⣿⣿⠟⠀⠀⠘⠿⣿⣿⣿⡿⠋⠰⠖⠱⣽⠟⠋⠉⡇        |_|   |_/___/___\\__,_|  \\___|   \\_/ |_|\\__,_|\\__,_| (_)
                ⠀⠀⠀⠀⡰⠉⠖⣀⠀⠀⢁⣀⠀⣴⣶⣦⠀⢴⡆⠀⠀⢀⣀⣀⣉⡽⠷⠶⠋⠀
                ⠀⠀⠀⡰⢡⣾⣿⣿⣿⡄⠛⠋⠘⣿⣿⡿⠀⠀⣐⣲⣤⣯⠞⠉⠁⠀⠀⠀⠀⠀                 Atenciosamente, André Augusto Corado Leão
                ⠀⢀⠔⠁⣿⣿⣿⣿⣿⡟⠀⠀⠀⢀⣄⣀⡞⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀                              (Desenvolvedor)
                ⠀⡜⠀⠀⠻⣿⣿⠿⣻⣥⣀⡀⢠⡟⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⢰⠁⠀⡤⠖⠺⢶⡾⠃⠀⠈⠙⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠈⠓⠾⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                """);
    }

}
