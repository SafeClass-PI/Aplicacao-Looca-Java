package school.sptech;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        boolean rodando = true;
        while (rodando) {
            System.out.println("""
                |____________________________|
                |    CONVERSOR DE MOEDAS     |
                |============================|
                | 1. Real(R$)                |
                | 2. Dolar($)                |
                | 3. Euro(€)                 |
                | 4. Iene Japones(¥)         |
                | 5. Yuan Chines(¥)          |
                |============================|
                |Insira a moeda que quer     |
                |converter:                  |
                |____________________________|""");
            int respostamenu1 = leitor.nextInt();
            String moeda_a_converter = switch (respostamenu1) {
                case 1 -> "Reais";
                case 2 -> "Dolares";
                case 3 -> "Euros";
                case 4 -> "Ienes Japoneses";
                case 5 -> "Yuans Chineses";
                default -> "";
            };
            if (moeda_a_converter == "") {
                System.out.println("Comando invalido");
                continue;
            }
            System.out.printf("""
                
                |____________________________|
                |    CONVERSOR DE MOEDAS     |
                |============================|
                | 1. Real(R$)                |
                | 2. Dolar($)                |
                | 3. Euro(€)                 |
                | 4. Iene Japones(¥)         |
                | 5. Yuan Chines(¥)          |
                |============================|
                | você quer converter %s     
                | para qual moeda:           |   
                |----------------------------|""", moeda_a_converter);

            int respostamenu2 = leitor.nextInt();
            if (respostamenu2 == respostamenu1) {
                System.out.println(" Insira moedas diferentes para convertê-las!");
                continue;
            }
            String converter_para = switch (respostamenu2) {
                case 1 -> "Reais";
                case 2 -> "Dolares";
                case 3 -> "Euros";
                case 4 -> "Ienes Japoneses";
                case 5 -> "Yuans Chineses";
                default -> "";
            };
            if (converter_para == "") {
                System.out.println("Comando invalido");
                continue;
            }
            Double[] converterreal = {0.19, 0.85, 27.13, 1.31};
            Double[] converterdolar = {5.40, 0.16, 147.40, 7.12};
            Double[] convertereuro = {6.33, 1.17, 172.46, 8.33};
            Double[] converteriene = {0.037, 0.0068, 0.0058, 0.048};
            Double[] converteryuan = {0.76, 0.14, 0.12, 20.69};

            boolean repetir = true;
            while (repetir) {
                System.out.println("Insira o valor que quer converter: ");
                double valor = leitor.nextDouble();
                double convertido = 0.0;

                switch (respostamenu1) {
                    case 1 -> { // Real
                        switch (respostamenu2) {
                            case 2 -> convertido = valor * converterreal[0];
                            case 3 -> convertido = valor * converterreal[1];
                            case 4 -> convertido = valor * converterreal[2];
                            case 5 -> convertido = valor * converterreal[3];
                        }
                    }
                    case 2 -> { // Dolar
                        switch (respostamenu2) {
                            case 1 -> convertido = valor * converterdolar[0];
                            case 3 -> convertido = valor * converterdolar[1];
                            case 4 -> convertido = valor * converterdolar[2];
                            case 5 -> convertido = valor * converterdolar[3];
                        }
                    }
                    case 3 -> { // Euro
                        switch (respostamenu2) {
                            case 1 -> convertido = valor * convertereuro[0];
                            case 2 -> convertido = valor * convertereuro[1];
                            case 4 -> convertido = valor * convertereuro[2];
                            case 5 -> convertido = valor * convertereuro[3];
                        }
                    }
                    case 4 -> { // Iene
                        switch (respostamenu2) {
                            case 1 -> convertido = valor * converteriene[0];
                            case 2 -> convertido = valor * converteriene[1];
                            case 3 -> convertido = valor * converteriene[2];
                            case 5 -> convertido = valor * converteriene[3];
                        }
                    }
                    case 5 -> { // Yuan
                        switch (respostamenu2) {
                            case 1 -> convertido = valor * converteryuan[0];
                            case 2 -> convertido = valor * converteryuan[1];
                            case 3 -> convertido = valor * converteryuan[2];
                            case 4 -> convertido = valor * converteryuan[3];
                        }
                    }
                }

                System.out.printf("%.2f %s valem %.2f %s%n", valor, moeda_a_converter, convertido, converter_para);
                System.out.println("""
            
            |-------------------------------|
            |  Opções:                      |
            |-------------------------------|
            | (1) Converter outro valor     | 
            | (2) Trocar moedas a converter |
            | (3) Encerrar programa         |
            |===============================|    
              Insira o comando: """);
                int respostamenu3 = leitor.nextInt();

                if (respostamenu3 == 1) {
                    repetir = true;
                } else if (respostamenu3 == 2) {
                    repetir = false;
                } else if (respostamenu3 == 3) {
                    repetir = false;
                    rodando = false;
                } else {
                    System.out.println(" Comando não encontrado.");
                }
            }
        }

        System.out.println("Bye");
    }
}