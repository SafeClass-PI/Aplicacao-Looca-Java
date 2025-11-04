package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Function {
    Scanner leitor = new Scanner(System.in);
    Scanner leitor_texto = new Scanner(System.in);
    void chamarMenu(){
        limparTela();
        System.out.printf
                ("""
                _______________________________________________________
                |               Seja Bem-vindo ao console             |
                |                   Feito por Arthur                  |
                |--------------------------|--------------------------|
                |  1º - Calculadora        |   2º - Aulas             |
                |--------------------------|--------------------------|
                |  3º - Criador de Select  |   4º - Sorteio           |
                |--------------------------|--------------------------|
                |  5º - Sobre a SafeClass  |   6º - Sobre o Autor     |
                |--------------------------|--------------------------|
                |  7º - Sair do console    |##########################|
                |__________________________|__________________________|
                Digite o número da sua ação: 
                """);
        Integer acao = leitor.nextInt();
        while (acao < 1 || acao > 7){
            System.out.println("Operação Invalída. Tente Novamente:");
            acao = leitor.nextInt();
        }
        if (acao == 1){
            chamarMenuCalculadora();
        } else if (acao == 2) {
            ChamarMenuAulas();
        } else if (acao == 3) {
            CriadordeSelect();
        } else if (acao == 4) {
            CriarSorteio();
        } else if (acao == 5) {
            sobreSafeclass();
        } else if (acao == 6) {
            sobreAutor();
        } else if (acao == 7) {
            limparTela();
            EncerrarConsole();
            System.exit(0);
        }
    }
    void limparTela(){
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
    void chamarMenuCalculadora(){
        limparTela();
        System.out.printf("""
                _______________________________________________________
                |                      Calculadora                    |
                |--------------------------|--------------------------|
                |  1º - Soma               |   2º - Subtração         |
                |--------------------------|--------------------------|
                |  3º - Multiplicação      |   4º - Divisão           |
                |--------------------------|--------------------------|
                |  5º - Exponenciação      |   6º - Radiciação        |
                |--------------------------|--------------------------|
                |  7º - Voltar ao Menu     |##########################|
                |__________________________|__________________________|
                Digite o número da sua operação: 
                """);
        Integer acao = leitor.nextInt();
        while (acao < 1 || acao > 7){
            System.out.println("Operação Invalída. Tente Novamente:");
            acao = leitor.nextInt();
        }
        if (acao == 1){
            Somarnumeros();
        } else if (acao == 2) {
            Subtrairnumeros();
        } else if (acao == 3) {
            Multiplicarnumeros();
        } else if (acao == 4) {
            Dividirnumeros();
        } else if (acao == 5) {
            Elevandonumeros();
        } else if (acao == 6) {
            Raiznumeros();
        } else if (acao == 7) {
            chamarMenu();
        }
    }
    void Somarnumeros(){
        System.out.println("Quantos números você irá somar:");
        Integer numeros_total = leitor.nextInt();
        Double[] numeros = new Double[numeros_total];
        Double soma = 0.0;
        for (int i = 0; i < numeros_total; i++) {
            System.out.println("Digite o " + (i+1) + "º a ser somado:");
            numeros[i] = leitor.nextDouble();
        }
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        String mensagem = "";
        for (int i = 0; i < numeros.length; i++) {
            if (i == numeros.length-1){
                mensagem += numeros[i];
            } else {
                mensagem += numeros[i] + " + ";
            }
        }
        mensagem += " = " + soma;
        System.out.println(mensagem);
        System.out.println("Quer fazer uma outra conta (S/N):");
        String acao = leitor_texto.nextLine().toLowerCase();
        while (!acao.equals("s") && !acao.equals("n")){
            System.out.println("Quer fazer uma outra conta (S/N):");
            acao = leitor_texto.nextLine().toLowerCase();
        }
        if (acao.equals("s")){
            Somarnumeros();
        } else {
            chamarMenuCalculadora();
        }
    }
    void Subtrairnumeros(){
        System.out.println("Digite o minuendo(Número no qual irá subtrair):");
        Double minuendo = leitor.nextDouble();
        System.out.println("Digite o subtraendo(Número que irá subtrair o de cima):");
        Double subtraendo = leitor.nextDouble();
        Double resultado = minuendo - subtraendo;
        System.out.println(minuendo + " - " + subtraendo + " = " + resultado);
        System.out.println("Quer fazer uma outra conta (S/N):");
        String acao = leitor_texto.nextLine().toLowerCase();
        while (!acao.equals("s") && !acao.equals("n")){
            System.out.println("Quer fazer uma outra conta (S/N):");
            acao = leitor_texto.nextLine().toLowerCase();
        }
        if (acao.equals("s")){
            Subtrairnumeros();
        } else {
            chamarMenuCalculadora();
        }
    }
    void Multiplicarnumeros(){
        System.out.println("Digite o multiplicando(Número no qual irá multiplicar):");
        Double multiplicando = leitor.nextDouble();
        System.out.println("Digite o multiplicador:");
        Double multiplicador = leitor.nextDouble();
        Double produto = multiplicando * multiplicador;
        System.out.println(multiplicando + " X " + multiplicador + " = " + produto);
        System.out.println("Quer fazer uma outra conta (S/N):");
        String acao = leitor_texto.nextLine().toLowerCase();
        while (!acao.equals("s") && !acao.equals("n")){
            System.out.println("Quer fazer uma outra conta (S/N):");
            acao = leitor_texto.nextLine().toLowerCase();
        }
        if (acao.equals("s")){
            Multiplicarnumeros();
        } else {
            chamarMenuCalculadora();
        }
    }
    void Dividirnumeros(){
        System.out.println("Digite o divedendo(Número no qual irá dividir):");
        Double divedendo = leitor.nextDouble();
        System.out.println("Digite o divisor:");
        Double divisor = leitor.nextDouble();
        Double Quociente = divedendo / divisor;
        System.out.println(divedendo + " / " + divisor + " = " + Quociente);
        System.out.println("Quer fazer uma outra conta (S/N):");
        String acao = leitor_texto.nextLine().toLowerCase();
        while (!acao.equals("s") && !acao.equals("n")){
            System.out.println("Quer fazer uma outra conta (S/N):");
            acao = leitor_texto.nextLine().toLowerCase();
        }
        if (acao.equals("s")){
            Dividirnumeros();
        } else {
            chamarMenuCalculadora();
        }
    }
    void Elevandonumeros(){
        System.out.println("Digite a base:");
        Double base = leitor.nextDouble();
        System.out.println("Digite o expoente:");
        Double expoente = leitor.nextDouble();
        Double potencia = Math.pow(base,expoente);
        System.out.println(base + " ^ " + expoente + " = " + potencia);
        System.out.println("Quer fazer uma outra conta (S/N):");
        String acao = leitor_texto.nextLine().toLowerCase();
        while (!acao.equals("s") && !acao.equals("n")){
            System.out.println("Quer fazer uma outra conta (S/N):");
            acao = leitor_texto.nextLine().toLowerCase();
        }
        if (acao.equals("s")){
            Elevandonumeros();
        } else {
            chamarMenuCalculadora();
        }
    }
    void Raiznumeros(){
        System.out.println("Digite a radicando:");
        Double radicando = leitor.nextDouble();
        System.out.println("Digite o índice:");
        Double indice = leitor.nextDouble();
        Double raiz = Math.pow(radicando,(1/indice));
        System.out.println(indice + "√" + radicando + " = " + raiz);
        System.out.println("Quer fazer uma outra conta (S/N):");
        String acao = leitor_texto.nextLine().toLowerCase();
        while (!acao.equals("s") && !acao.equals("n")){
            System.out.println("Quer fazer uma outra conta (S/N):");
            acao = leitor_texto.nextLine().toLowerCase();
        }
        if (acao.equals("s")){
            Raiznumeros();
        } else {
            chamarMenuCalculadora();
        }
    }
    void EncerrarConsole(){
        System.out.printf("""
                      ____  _          _                 _                            _    _               \s
                     / __ \\| |        (_)               | |                          | |  | |              \s
                    | |  | | |__  _ __ _  __ _  __ _  __| | ___    _ __   ___  _ __  | |  | |___  __ _ _ __\s
                    | |  | | '_ \\| '__| |/ _` |/ _` |/ _` |/ _ \\  | '_ \\ / _ \\| '__| | |  | / __|/ _` | '__|
                    | |__| | |_) | |  | | (_| | (_| | (_| | (_) | | |_) | (_) | |    | |__| \\__ \\ (_| | |  \s
                     \\____/|_.__/|_|  |_|\\__, |\\__,_|\\__,_|\\___/  | .__/ \\___/|_|     \\____/|___/\\__,_|_|  \s
                                          __/ |                   | |                                      \s
                                         |___/                    |_|                                      \s
                """);
    }
    void ChamarMenuAulas(){
        limparTela();
        System.out.printf("""
                _______________________________________________________
                |                         Aulas                       |
                |--------------------------|--------------------------|
                |  1º - Váriaveis          |   2º - If / Else         |
                |--------------------------|--------------------------|
                |  3º - While / For        |   4º - Vetor[]           |
                |--------------------------|--------------------------|
                |  5º - Listas             |   6º - Operações Math    |
                |--------------------------|--------------------------|
                |  7º - Números Aletórios  |   8º - Voltar para Menu  |
                |__________________________|__________________________|
                Digite o número da sua operação: 
                """);
        Integer acao = leitor.nextInt();
        while (acao < 1 || acao > 8){
            System.out.println("Operação Invalída. Tente Novamente:");
            acao = leitor.nextInt();
        }
        limparTela();
        if (acao == 1){
            AulaVariavel();
        } else if (acao == 2) {
            AulaifElse();
        } else if (acao == 3) {
            AulaWhilefor();
        } else if (acao == 4) {
            AulaVetor();
        } else if (acao == 5) {
            AulaListas();
        } else if (acao == 6) {
            aulaOperacaoMath();
        } else if (acao == 7) {
            aulaRandomNumber();
        } else {
        chamarMenu();
        }
    }
    void AulaVariavel(){
        int int_primitivo = 30;
        Integer int_wrapper = 50;
        String string_wrapper = "Hello World";
        double double_primitivo = 5.55;
        Double double_wrapper = 6.61;
        float float_primitvo = 40.502f;
        Float float_wrapper = 41.2f;
        boolean bollean_primitivo = false;
        Boolean bollean_wrapper = true;
        char char_primitivo = 'A';
        Character char_wrapper = 'B';

        System.out.println("Bem vindo a Aula sobre Varíavel");
        System.out.printf("""
                O que é uma Variavél: É um espaço nomeado na memória de um computador que armazena dados 
                que podem ser alterados durante a execução de um programa.
                Difêrencia das variavéis em Js para Java: No javascript para criar uma variavél é só ulti
                zar o var e pelo o valor inserido a varíavel virava uma tipagem de dado específica(Ex: St
                ring,Boolean,Int,Float) no Java você faz esse processo antes de você declarar uma váriavel
                você precisa passar a tipagem dela(Ex: int Minha_primeira_Variavel = 0)
                Tipos de Varíaveis no Java:
                    int -> Número inteiros de -2147483648 a 2147483647
                    String -> Texto "Hello World"
                    double -> Números Racionais Ex: 0.25 (64 bits)
                    float -> Números Racionais Ex: 0.5 (32 bits)
                    boolean -> True ou False
                    char -> Uma Letra Ex: "A"
                Nós também temos outro tipo de váriavel chamada Wrappers no qual só ultilizadas para criar
                objetos:
                    Integer   -> Wrapper do int
                    String    ->
                    Double    -> Wrapper do double
                    Float     -> Wrapper do float
                    Boolean   -> Wrapper do Boolean
                    Character -> Wrapper do char
                Vamos mostrar alguns exemplos:
                int int_primitivo = 30;
                Resultado no Print: %d
                Integer int_wrapper = 50;
                Resultado no Print: %d
                String string_wrapper = "Hello World";
                Resultado no Print: %s
                double double_primitivo = 5.55;
                Resultado no Print: %f
                Double double_wrapper = 6.61;
                Resultado no Print: %f
                float float_primitvo = 40.502f;
                Resultado no Print: %f
                Float float_wrapper = 41.2f;
                Resultado no Print: %f
                boolean bollean_primitivo = false;
                Resultado no Print: %b
                Boolean bollean_wrapper = true;
                Resultado no Print: %b
                char char_primitivo = 'A';
                Resultado no Print: %c
                Character char_wrapper = 'B';
                Resultado no Print: %c
                Lembrando que todas as variavéis Wrappers pode ser nulas
                """,int_primitivo,int_wrapper,string_wrapper,double_primitivo,double_wrapper,float_primitvo,float_wrapper,bollean_primitivo,bollean_wrapper,char_primitivo,char_wrapper);
        System.out.println("Para voltar para o menu das aulas, Digite 1:");
        String volta = leitor_texto.nextLine();
        while (!volta.equals("1")){
            System.out.println("Não entendi o comando");
            System.out.println("Para voltar para o menu das aulas, Digite 1:");
            volta = leitor_texto.nextLine();
        }
        ChamarMenuAulas();
    }
    void AulaifElse(){
        System.out.printf("""
                O if é comando de estrutura de decisão no qual ele,
                no qual ele funciona por meio de uma pergunta no q
                ual ele irá retornar verdadeiro ou falso Ex:
                if(100 > 50){
                Executa essa parte de a afirmação for verdadeira
                } else {
                Executa essa parte se a afirmação for falsa
                }
                Para fazer essa perguntas usamos alguns operadores
                no quais são:
                == -> Igual
                != -> Diferente
                >  -> Maior que
                >= -> Maior ou igual
                <  -> Menor que 
                <= -> Menor ou igual
                Se você deseja encadear vários ifs você pode usar
                else como no exemplo a seguir:
                Sem Else if
                if (acao == 1){
                
                } else {
                        if(acao == 2) {
                            if(acao == 3){
                            
                            }
                            else{
                            
                            }
                        }
                    }
                Com Else if
                if(acao == 1){
                
                } else if(acao == 2) {
                
                } else if(acao == 3) {
                
                } else {
                
                }
                Você ainda pode usar as portas lógicas ou e and
                no seu if utilizando os seguintes caracteres:
                && -> And
                || -> Or
                Como usar isso:
                if(condição 1 && condição 2){
                Executa se as duas condições foram verdadeiras
                }
                if(condição 1 || condição 2){
                Executa se alguma opção for verdadeira ou ambas
                }
                Tome cuidado no java quando você vai comparar v
                ariavéis Wrappers pois você não está comparado
                um valor primitivo mais sim um objeto, para res
                olver isso utilize .equals()
                Integer n1 = 1;
                Integer n2 = 2;
                if(n1 == n2){
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
                Saída do código: False
                if(n1.equals(n2)){
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
                Saída do código: True
                """);
        System.out.println("Para voltar para o menu das aulas, Digite 1:");
        String volta = leitor_texto.nextLine();
        while (!volta.equals("1")){
            System.out.println("Não entendi o comando");
            System.out.println("Para voltar para o menu das aulas, Digite 1:");
            volta = leitor_texto.nextLine();
        }
        ChamarMenuAulas();
    }
    void CriadordeSelect(){
        limparTela();
        System.out.println("Vamos criar um select");
        System.out.println("Digite 1 - Para continuar o Criador de Select\n" +
                "Digite 2 - Para voltar para o menu");
        String volta = leitor_texto.nextLine();
        while (!volta.equals("1") && !volta.equals("2")){
            System.out.println("Não entedi a operação Digite novamente");
            System.out.println("Digite 1 - Para continuar o Criador de Select\n" +
                    "Digite 2 - Para voltar para o menu");
            volta = leitor_texto.nextLine();
        }
        if (volta.equals("2")){
            chamarMenu();
        }
        limparTela();
        Boolean habilita_join = false;
        String select = "SELECT ";
        System.out.println("Bem vindo ao Criador de Select");
        System.out.println("Deseja criar um select com Join ( S / N ):");
        String join = leitor_texto.nextLine().toLowerCase();
        while (!join.equals("s") && !join.equals("n")){
            System.out.println("Desculpa não entedi o comando");
            System.out.println("Deseja criar um select com Join ( S / N ):");
            join = leitor_texto.nextLine().toLowerCase();
        }
        if (join.equals("s")){
            habilita_join = true;
        }
        if (habilita_join){
            System.out.println("Qual é nome da tabela ou apelido da sua coluna(atributo):");
            select += leitor_texto.nextLine();
            select += ".";
        }
        System.out.println("Digite o nome da coluna(atributo) quer irá consultar:");
        select += leitor_texto.nextLine();
        System.out.println("Deseja apelidar essa coluna ( S / N ):");
        String apelido = leitor_texto.nextLine().toLowerCase();
        while (!apelido.equals("s") && !apelido.equals("n")){
            System.out.println("Desculpa não entendi");
            System.out.println("Deseja apelidar essa coluna ( S / N ):");
            apelido = leitor_texto.nextLine().toLowerCase();
        }
        if (apelido.equals("s")){
            System.out.println("Digite o Apelido da coluna(atributo):");
            select += " as `";
            select += leitor_texto.nextLine();
            select += "` ";
        }
        System.out.println("Deseja adicionar mais uma coluna ( S / N ):");
        String Nova_coluna = leitor_texto.nextLine().toLowerCase();
        while (!Nova_coluna.equals("s") && !Nova_coluna.equals("n")){
            System.out.println("Desculpa não entendi o seu comando");
            System.out.println("Deseja adicionar mais uma coluna ( S / N ):");
            Nova_coluna = leitor_texto.nextLine().toLowerCase();
        }
        while (Nova_coluna.equals("s")){
            select += ", ";
            if (habilita_join){
                System.out.println("Qual é nome da tabela ou apelido da sua coluna(atributo):");
                select += leitor_texto.nextLine();
                select += ".";
            }
            System.out.println("Digite o nome da coluna(atributo) quer irá consultar:");
            select += leitor_texto.nextLine();
            System.out.println("Deseja apelidar essa coluna ( S / N ):");
            apelido = leitor_texto.nextLine().toLowerCase();
            while (!apelido.equals("s") && !apelido.equals("n")){
                System.out.println("Desculpa não entendi");
                System.out.println("Deseja apelidar essa coluna ( S / N ):");
                apelido = leitor_texto.nextLine().toLowerCase();
            }
            if (apelido.equals("s")){
                System.out.println("Digite o Apelido da coluna(atributo):");
                select += " as `";
                select += leitor_texto.nextLine();
                select += "` ";
            }
            System.out.println("Deseja adicionar mais uma coluna ( S / N ):");
            Nova_coluna = leitor_texto.nextLine().toLowerCase();
            while (!Nova_coluna.equals("s") && !Nova_coluna.equals("n")){
                System.out.println("Desculpa não entendi o seu comando");
                System.out.println("Deseja adicionar mais uma coluna ( S / N ):");
                Nova_coluna = leitor_texto.nextLine().toLowerCase();
            }
        }
        select += " FROM ";
        if (habilita_join){
            System.out.println("Digite o nome da tabela no qual você puxou os dados:");
            select += leitor_texto.nextLine();
            System.out.printf("""
                    Você colocou algum apelido nas colunas desse tabela
                    Seu select para conferir: %s
                    Caso tenha apelidado Digite 1 
                    Caso não tenha Digite  2\n""", select);
            String apelidar_join = leitor_texto.nextLine();
            while (!apelidar_join.equals("1") && !apelidar_join.equals("2")){
                System.out.println("Desculpa não entendi o Comando");
                System.out.printf("""
                    Você colocou algum apelido nas colunas desse tabela
                    Seu select para conferir: %s
                    Caso tenha apelidado Digite 1 
                    Caso não tenha Digite 2\n""", select);
                apelidar_join = leitor_texto.nextLine();
            }
            if (apelidar_join.equals("1")){
                System.out.printf("""
                        Apelide a tabela como no Select
                        Seu select como base: %s\n""",select);
                select += leitor_texto.nextLine();
            }
            System.out.printf("""
                    Qual join você quer fazer
                    Digite 1 - Join
                    Digite 2 - Left Join
                    Digite 3 - Right Join \n""");
            String escolhe_join = leitor_texto.nextLine();
            while (!escolhe_join.equals("1") && !escolhe_join.equals("2") && !escolhe_join.equals("3")){
                System.out.println("Desculpa não Entendi");
                System.out.printf("""
                    Qual join você quer fazer
                    Digite 1 - Join
                    Digite 2 - Left Join
                    Digite 3 - Right Join \n""");
                escolhe_join = leitor_texto.nextLine();
            }
            if (escolhe_join.equals("1")){
                select += " JOIN ";
            } else if(escolhe_join.equals("2")){
                select += " LEFT JOIN ";
            } else if(escolhe_join.equals("3")){
                select += " RIGHT JOIN ";
            }
            System.out.println("Digite o nome da tabela no qual você vai fazer o join:");
            select += leitor_texto.nextLine();
            System.out.printf("""
                    Você colocou algum apelido nas colunas desse tabela
                    Seu select para conferir: %s
                    Caso tenha apelidado Digite 1 
                    Caso não tenha Digite 2 \n""", select);
            apelidar_join = leitor_texto.nextLine();
            while (!apelidar_join.equals("1") && !apelidar_join.equals("2")){
                System.out.println("Desculpa não entendi o Comando");
                System.out.printf("""
                    Você colocou algum apelido nas colunas desse tabela
                    Seu select para conferir: %s
                    Caso tenha apelidado Digite 1 
                    Caso não tenha Digite 2 \n""", select);
                apelidar_join = leitor_texto.nextLine();
            }
            if (apelidar_join.equals("1")){
                System.out.printf("""
                        Apelide a tabela como no Select
                        Seu select como base: %s \n""",select);
                select += leitor_texto.nextLine();
            }
            select += " on ";
            System.out.println("Digite o nome da tabela ou apelido no qual fica a fk do join:");
            select += leitor_texto.nextLine();
            select += ".";
            System.out.println("Digite o nome da Fk");
            select += leitor_texto.nextLine();
            select += " = ";
            System.out.println("Digite o nome da tabela ou apelido no qual fica o id do join:");
            select += leitor_texto.nextLine();
            select += ".";
            System.out.println("Digite o nome da id");
            select += leitor_texto.nextLine();
            System.out.println("Deseja fazer mais um Join ( S / N ):");
            String repetir_join = leitor_texto.nextLine().toLowerCase();
            while (!repetir_join.equals("s") && !repetir_join.equals("n")){
                System.out.println("Desculpa não entendi");
                System.out.println("Deseja fazer mais um Join ( S / N ):");
                repetir_join = leitor_texto.nextLine().toLowerCase();
            }
            while (repetir_join.equals("s")){
                System.out.printf("""
                    Qual join você quer fazer
                    Digite 1 - Join
                    Digite 2 - Left Join
                    Digite 3 - Right Join \n
                    """);
                escolhe_join = leitor_texto.nextLine();
                while (!escolhe_join.equals("1") && !escolhe_join.equals("2") && !escolhe_join.equals("3")){
                    System.out.println("Desculpa não Entendi");
                    System.out.printf("""
                    Qual join você quer fazer
                    Digite 1 - Join
                    Digite 2 - Left Join
                    Digite 3 - Right Join \n
                    """);
                    escolhe_join = leitor_texto.nextLine();
                }
                if (escolhe_join.equals("1")){
                    select += " JOIN ";
                } else if(escolhe_join.equals("2")){
                    select += " LEFT JOIN ";
                } else if(escolhe_join.equals("3")){
                    select += " RIGHT JOIN ";
                }
                System.out.println("Digite o nome da tabela no qual você vai fazer o join:");
                select += leitor_texto.nextLine();
                System.out.printf("""
                    Você colocou algum apelido nas colunas desse tabela
                    Seu select para conferir: %s
                    Caso tenha apelidado Digite 1 
                    Caso não tenha Digite 2 \n
                    """, select);
                apelidar_join = leitor_texto.nextLine();
                while (!apelidar_join.equals("1") && !apelidar_join.equals("2")){
                    System.out.println("Desculpa não entendi o Comando");
                    System.out.printf("""
                    Você colocou algum apelido nas colunas desse tabela
                    Seu select para conferir: %s
                    Caso tenha apelidado Digite 1 
                    Caso não tenha Digite 2 \n
                    """, select);
                    apelidar_join = leitor_texto.nextLine();
                }
                if (apelidar_join.equals("1")){
                    System.out.printf("""
                        Apelide a tabela como no Select
                        Seu select como base: %s \n
                        """,select);
                    select += leitor_texto.nextLine();
                }
                select += " on ";
                System.out.println("Digite o nome da tabela ou apelido no qual fica a fk do join:");
                select += leitor_texto.nextLine();
                select += ".";
                System.out.println("Digite o nome da Fk");
                select += leitor_texto.nextLine();
                select += " = ";
                System.out.println("Digite o nome da tabela ou apelido no qual fica o id do join:");
                select += leitor_texto.nextLine();
                select += ".";
                System.out.println("Digite o nome da id");
                select += leitor_texto.nextLine();
                System.out.println("Deseja fazer mais um Join ( S / N ):");
                repetir_join = leitor_texto.nextLine().toLowerCase();
                while (!repetir_join.equals("s") && !repetir_join.equals("n")){
                    System.out.println("Desculpa não entendi");
                    System.out.println("Deseja fazer mais um Join ( S / N ):");
                    repetir_join = leitor_texto.nextLine().toLowerCase();
                }
            }
        } else {
            System.out.println("Digite o nome da tabela que você puxou os dados:");
            select += leitor_texto.nextLine();
        }
        select += ";";
        System.out.println("Seu select:");
        System.out.println(select);
        System.out.println("Digite 1 - Para fazer outro select\n" +
                "Digite 2 - Para voltar para o menu");
        String backtomenu = leitor_texto.nextLine();
        while (!backtomenu.equals("1") && !backtomenu.equals("2")){
            System.out.println("Não entendi o comando");
            System.out.println("Digite 1 - Para fazer outro select\n" +
                    "Digite 2 - Para voltar para o menu");
            backtomenu = leitor_texto.nextLine();
        }
        if (backtomenu.equals("1")){
            CriadordeSelect();
        }
        if (backtomenu.equals("2")){
            chamarMenu();
        }
    }
    List<String> sorteio = new ArrayList<>();
    void CriarSorteio(){
        limparTela();
        System.out.println("Bem vindo ao Sorteio\n" +
                "Digite 1 - Para configurar o sorteio\n" +
                "Digite 2 - Para voltar para o menu");
        String operacao = leitor_texto.nextLine();
        while (!operacao.equals("1") && !operacao.equals("2")){
            limparTela();
            System.out.println("Não entendi o comando");
            System.out.println("Bem vindo ao Sorteio\n" +
                    "Digite 1 - Para configurar o sorteio\n" +
                    "Digite 2 - Para voltar para o menu");
            operacao = leitor_texto.nextLine();
        }
        if(operacao.equals("1")){
            Boolean sair_sorteio = configSorteio();
            while (sair_sorteio){
                sair_sorteio = configSorteio();
            }
        }
        if (operacao.equals("2")){
            chamarMenu();
        }
        limparTela();
        chamarMenu();
    }
    Boolean configSorteio(){
        limparTela();
        System.out.println("Configure o seu sorteio\n" +
                "Digite 1 - Para inserir uma entrada no sorteio\n" +
                "Digite 2 - Para editar uma entrada\n" +
                "Digite 3 - Para remover uma entrada\n" +
                "Digite 4 - Para começar o sorteio");
        System.out.println("Entradas registradas:");
        for (int i = 0; i < sorteio.size(); i++) {
            System.out.println(i+1 + "º - " + sorteio.get(i));
        }
        System.out.println("Digite a operação: ");
        String acao = leitor_texto.nextLine();
        while (!acao.equals("1") && !acao.equals("2") && !acao.equals("3") && !acao.equals("4")){
            System.out.println("Operação Invalída");
            System.out.println("Digite a operação: ");
            acao = leitor_texto.nextLine();
        }
        if (acao.equals("1")){
            limparTela();
            System.out.println("Digite o nome da Entrada: ");
            String valor_cadastrado = leitor_texto.nextLine();
            sorteio.add(valor_cadastrado);
        } else if (acao.equals("2")){
            limparTela();
            System.out.println("Editar a Entrada");
            for (int i = 0; i < sorteio.size(); i++) {
                System.out.println(i+1 + "º - " + sorteio.get(i));
            }
            System.out.println("Digite o número da entrada a ser editada: ");
            Integer num_entrada_edit = leitor.nextInt();
            while (num_entrada_edit < 1 && num_entrada_edit > sorteio.size()){
                System.out.println("Entrada invalída");
                System.out.println("Digite o número da entrada a ser editada: ");
                num_entrada_edit = leitor.nextInt();
            }
            System.out.println("Valor antigo: " + sorteio.get(num_entrada_edit-1));
            System.out.println("Valor Novo: ");
            String new_value_edit = leitor_texto.nextLine();
            sorteio.set(num_entrada_edit - 1 , new_value_edit);
        } else if (acao.equals("3")) {
            limparTela();
            System.out.println("Remover a Entrada");
            for (int i = 0; i < sorteio.size(); i++) {
                System.out.println(i+1 + "º - " + sorteio.get(i));
            }
            System.out.println("Digite o número da entrada a ser removida: ");
            Integer num_entrada_remove = leitor.nextInt();
            while (num_entrada_remove < 1 && num_entrada_remove > sorteio.size()){
                System.out.println("Entrada invalída");
                System.out.println("Digite o número da entrada a ser removida: ");
                num_entrada_remove = leitor.nextInt();
            }
            sorteio.remove(num_entrada_remove - 1);
        } else if (acao.equals("4") && sorteio.size() > 0) {
            limparTela();
            Integer num_sorteio = ThreadLocalRandom.current().nextInt(0,sorteio.size());
            System.out.println("Resultado: " + sorteio.get(num_sorteio));
            System.out.println("Digite 1 - Para configurar outro sorteio\n" +
                    "Digite 2 - Para configurar outro sorteio com as mesmas entradas\n" +
                    "Digite 3 - Para voltar para o menu");
            System.out.println("Digite sua operação: ");
            String finish_sorteio = leitor_texto.nextLine();
            while (!finish_sorteio.equals("1") && !finish_sorteio.equals("2") && !finish_sorteio.equals("3")){
                System.out.println("Operação Invalída");
                System.out.println("Digite sua operação:");
                finish_sorteio = leitor_texto.nextLine();
            }
            if (finish_sorteio.equals("1")){
                for (int i = sorteio.size() - 1; i >= 0; i--) {
                    sorteio.remove(i);
                }
            }
            if (finish_sorteio.equals("3")){
                return false;
            }
        } else if (acao.equals("4") && sorteio.size() == 0){
            System.out.println("Adicione uma Entrada");
        }
        return true;
    }
    void sobreSafeclass(){
        limparTela();
        System.out.println("""
                A SafeClass é uma empresa que presta serviço de monitoramento
                para dispositivos escolares, com o nosso monitoramento é poss
                ível indetificar o uso dos componentes em tempo real, como 
                CPU,RAM e disco além de montar um ranking dos sites mais ace
                ssados.""");
        System.out.println("Digite algo para voltar para o menu:");
        String back_menu = leitor_texto.nextLine();
        chamarMenu();
    }
    void sobreAutor(){
        limparTela();
        System.out.println("""
                Olá me chamo Arthur, tenho 19 anos e estou cursando Sistemas da
                Informação, atualmente estou no 2º Semestre, eu entrei nessa ár
                ea de tecnologia por uma vivência que eu tive no SENAI no curso
                de mecatrônica no qual tive muito interesse em lógica de progra
                mação que eu usava para programação de CLP's e comandos eletri
                cos, porém não me indetificava tanto com a parte física dessas
                aplicações e me voltei mais para a parte do código, por recome
                ndação de um amigo conheci a falcudade que eu estudo e vi o cu
                rso Sistemas da Informação com um proposíto mais voltado a neg
                ocíos no qual eu tinha um grande interesse""");
        System.out.println("Digite algo para voltar para o menu:");
        String back_menu = leitor_texto.nextLine();
        chamarMenu();
    }
    void AulaWhilefor(){
        limparTela();
        System.out.println("""
                Bem-Vindo a aula de While/For
                O while e o for são estruturas de repetição, essas estruturas
                de repetição servem para otimizar processos repetitivos.
                A sintaxe do for e o while continuam a mesma:
                while(condicao){
                // Código que irá repetir
                }
                for(criacao da variavel; condicao; incremento da variavel){
                // Código que irá repetir
                }
                Lembrando que o for não precisa ser preenchido:
                for(;;) -> irá se comportar igual um while(True)
                Uma otimização que você pode usar enquanto estiver no
                IntelliJ é escrever um nome de um vetor ou lista e utilizar
                o . você pode escolher algumas funções para estrutura de re
                petição:
                sorteio.fori
                for(int i = 0; i < sorteio.length();i++){
                }
                sorteio.forr
                for(int = sorteio.length() - 1; i >= 0; i--){
                }
                Caso você utiliza uma lista o for irá utilizar o .size()""");
        System.out.println("Digite algo para voltar para o menu:");
        String back_to_menu = leitor_texto.nextLine();
        ChamarMenuAulas();
    }
    void AulaVetor(){
        limparTela();
        String[] vetorTexto = new String[10];
        System.out.println("""
                O vetor no java é um pouco diferente do que conhecemos no JavaScript
                o vetor no java tem um tamanho imutável no qual você define assim qu
                e cria o vetor. Para nós criarmos um vetor em java usamos a seguinte
                sintaxe:
                String[] nomeDaVariavel = new String[tamanho do vetor];
                Assim que você cria o vetor ele vem da seguinte forma:
                [null,null,null,null,null,null] - Caso você utilize uma váriavel wrapper
                Se você utilizar um varíavel primitiva você pode obter os seguintes resu
                ltados:
                [0,0,0,0,0] - int
                [0.0,0.0,0.0,0.0] - double
                [ ,  ,  ,  ,  ,  ,  ,  ,  ,  ] - char
                Se você quiser mostrar o seu vetor inteiro ultilize o comando:
                System.out.Println(Arrays.toString(nomeDoVetor))
                Colocar um elemento em uma posição:
                nomeDoVetor[posição] = valor;
                Consultar um número em uma posição do vetor
                nomeDoVetor[posição]
                Caso queira consultar o tamanho do vetor
                nomeDoVetor.length""");
        System.out.println("Digite algo para voltar para o menu:");
        String back_to_menu = leitor_texto.nextLine();
        ChamarMenuAulas();
    }
    void AulaListas(){
        limparTela();
        System.out.println("""
                =======================================================
                |                   Aula 5 - Listas                   |
                =======================================================
                
                Bem-vindo à aula sobre Listas! A Lista é uma das estruturas de dados
                mais úteis e flexíveis em Java.
                
                Pense nela como um "vetor superpoderoso". Enquanto um vetor (array)
                tem um tamanho fixo que você define na criação, uma Lista pode
                crescer e encolher dinamicamente.
                
                A implementação mais comum da Lista é o `ArrayList`.
                
                -------------------------------------------------------
                1. CRIANDO UMA LISTA
                -------------------------------------------------------
                
                Criando uma lista de Strings vazia.
                Por padrão, ela reserva um espaço inicial (geralmente para 10 itens).
                List<String> frutas = new ArrayList<>();
                
                Criando uma lista já com valores iniciais.
                List<String> frutasComValores = new ArrayList<>(List.of("Abacate","Abacaxi","Melão"));
                
                -------------------------------------------------------
                2. ADICIONANDO ELEMENTOS
                -------------------------------------------------------
                
                frutas.add(elemento) -> Adiciona o elemento no final da lista.
                frutas.add("Morango");
                frutas.add("Goiaba");
                Lista 'frutas' agora é: [Morango, Goiaba]
                
                Se a capacidade interna da lista for atingida, o Java automaticamente
                dobra o tamanho dela para você. Você não precisa se preocupar!
                
                frutas.add(indice, elemento) -> Adiciona em uma posição específica.
                frutas.add(1, "Kiwi"); // Adiciona "Kiwi" na posição 1
                Lista 'frutas' agora é: [Morango, Kiwi, Goiaba]
                
                frutas.addAll(outraLista) -> Adiciona todos os itens de outra lista.
                frutas.addAll(frutasComValores);
                Lista 'frutas' agora é: [Morango, Kiwi, Goiaba, Abacate, Abacaxi, Melão]
                
                frutas.addFirst(elemento) -> Adiciona um elemento na primeira posição (índice 0).
                frutas.addFirst("Jabuticaba");
                
                -------------------------------------------------------
                3. ACESSANDO E MODIFICANDO ELEMENTOS
                -------------------------------------------------------

                frutas.get(indice) -> Pega o valor de uma posição (similar ao vetor[indice]).
                System.out.println("A fruta na posição 2 é: " + frutas.get(2)); // Saída: Goiaba
                
                frutas.set(indice, novoElemento) -> Substitui o valor em uma posição.
                frutas.set(2, "Cupuaçu"); // Troca "Goiaba" por "Cupuaçu"
                Lista 'frutas' agora contém "Cupuaçu" na posição 2.
                
                frutas.size() -> Retorna o número de elementos na lista (similar ao vetor.length).
                System.out.println("A lista tem " + frutas.size() + " elementos.");

                -------------------------------------------------------
                4. REMOVENDO ELEMENTOS
                -------------------------------------------------------
                
                frutas.remove(indice) -> Remove o elemento de uma posição específica.
                frutas.remove(0); // Remove "Jabuticaba"
                
                frutas.remove(objeto) -> Remove a primeira ocorrência do valor especificado.
                frutas.remove("Kiwi"); // Procura e remove o texto "Kiwi"
                
                frutas.removeAll(outraLista) -> Remove todos os elementos que também estão na outra lista.
                
                frutas.removeFirst() / .removeLast() -> Remove o primeiro ou o último elemento.
                
                frutas.clear() -> Remove TODOS os elementos da lista, deixando-a vazia.
                frutas.clear();
                Lista 'frutas' agora é: []
                -------------------------------------------------------
                """);
        System.out.println("Digite algo para voltar para o menu:");
        String back_to_menu = leitor_texto.nextLine();
        ChamarMenuAulas();
    }
    void aulaOperacaoMath(){
        limparTela();
        System.out.println("""
                =======================================================
                |                Aula 6 - Operações Math              |
                =======================================================
                Bem-vindo a aula de operações Math, no java existem algumas limitações
                quando nós falamos de operações matemáticas, no java não temos as 
                operações de potênciação e nem de radiciação, para conseguir fazer
                essas contas podemos utilizar a biblioteca Math no qual habilita
                algumas funções matématícas como:
                - Math.pow(base,expoente) -> Exponenciação
                - Math.sqrt(radicando)    -> Raiz Quadrado
                -------------------------------------------------------
                1. Desmistificando o Math.pow()
                -------------------------------------------------------
                O .pow() ou exponeciação consiste em uma repetição da propria multiplicação
                como esse caso a seguir:
                Double calcularPonteciacao(Double base, Integer expoente){
                    Double resultado = 1.0;
                    if(exponte == 0){
                        resultado = 1.0;
                    }
                    for(int i = 0; i < expoente; i++){
                        resultado *= base;
                    }
                    return resultado;
                }
                -------------------------------------------------------
                2. Desmistificando o Math.sqrt()
                -------------------------------------------------------
                Para o Math.sqrt() iremos fazer uma potenciação, pórem nosso expoente
                será uma fração:
                Raiz quadrada -> Expoente = 1/2
                Raiz Cúbica   -> Expoente = 1/3
                Raiz 4        -> Expoente = 1/4
                Raiz qualquer -> Expoente = 1/índice
                -------------------------------------------------------
                """);
        System.out.println("Digite algo para voltar para o menu:");
        String back_to_menu = leitor_texto.nextLine();
        ChamarMenuAulas();
    }
    void aulaRandomNumber(){
        limparTela();
        System.out.println("""
                =======================================================
                |                Aula 7 - Números Aleatórios          |
                =======================================================
                Bem-vindo à aula de Números Aleatórios, nessa aula você vai aprender
                a como gerar um número aleatório usando a classe Math e também o ThreadLocalRandom.
                -------------------------------------------------------
                1. Gerando um número aleátorios pelo Math.random()
                -------------------------------------------------------
                O Math.random() funciona da seguinte forma ele gera um número
                entre 0 a 0.99(Não gera 1). Caso você queira que ele sorteie entre
                o 0 ao 5 você pode utilizar a operação de multiplicação para aumentar
                esse range Ex:
                Math.random()*100 -> Valor mínimo: 0 Valor máximo: 99.9...
                Caso queira aumentar o índice você pode utilizar a soma:
                Situação Sorteio de 10 a 20:
                Math.random()*10+10 -> Valor mínimo: 10 Valor máximo: 19.9...
                Lembrando que o Math.random volta muitas casas decimais, caso você queira
                apenas casas inteiras utilize uma função de arredodamento.
                -------------------------------------------------------
                2. Gerando um número aleátorios pelo ThreadLocalRandom
                -------------------------------------------------------
                O ThreadLocalRandom é uma classe que facilita gerar números
                aleatórios, uma das vantagens de usar o ThreadLocalRandom é que você
                pode escolher diretamente no comando o range do número a ser gerado
                como também definir o tipo dele com int,double.Para utilizar o 
                ThreadLocalRandom iremos usar a seguinte sintaxe:
                ThreadLocalRandom.current().nextInt(origem,limite)
                ThreadLocalRandom.current().nextDouble(origem,limite)
                Um ponto importante que quando você escolher um final do range ele só não sorterá
                esse número exemplo:
                ThreadLocalRandom.current().nextInt(0,10)
                // O número 10 não será sorteado
                -------------------------------------------------------
                """);
        System.out.println("Digite algo para voltar para o menu:");
        String back_to_menu = leitor_texto.nextLine();
        ChamarMenuAulas();
    }
}
