package school.sptech;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> Lviagem = new ArrayList<>();
        ArrayList<Double> Lkm = new ArrayList<>();
        ArrayList<Double> Lkml = new ArrayList<>();
        ArrayList<String> Ldata = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Insira um nome que voce deseja dar a viagem: ");
            String viagem = scanner.nextLine();
            if (viagem.trim().isEmpty()) {
                System.out.println("Insira um nome válido");
                continue;
            } else {
                Lviagem.add(viagem);
            }

            System.out.println("Insira a quantidade de Km's desta viagem: ");
            String kmStr = scanner.nextLine();
            if (kmStr.trim().isEmpty()) {
                System.out.println("Insira um valor válido");
                continue;
            } else {
                Double km = Double.parseDouble(kmStr);
                Lkm.add(km);
            }

            System.out.println("Insira quantos quilomêtros o carro faz por litro: ");
            String kmLStr = scanner.nextLine();
            if (kmLStr.trim().isEmpty()) {
                System.out.println("Insira um valor válido");
                continue;
            } else {
                Double kmL = Double.parseDouble(kmLStr);
                Lkml.add(kmL);
            }

            System.out.println("Insira a data desta viagem: ");
            String dataV = scanner.nextLine();
            if (dataV.trim().isEmpty()) {
                System.out.println("Insira uma data válida");
                continue;
            } else {
                Ldata.add(dataV);
            }

            System.out.println("Deseja inserir outra viagem? S/N");
            String outra = scanner.nextLine();
            if (outra.equalsIgnoreCase("S")) {
                continue;
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Escolha uma das opções: ");
            System.out.println("" +
                    "[1] - Ver todas as viagens cadastradas\n" +
                    "[2] - Ver quanto de combustivel foi gasto até agora\n" +
                    "[3] - Ver quanto de combustivel foi gasto em determinada viagem\n" +
                    "[4] - Ver o total de quilomêtros já percorridos\n" +
                    "[5] - Ver total de quilomêtros em determinada viagem\n"+
                    "[0] - Sair"
            );
            Integer opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("\n=== Viagens Cadastradas ===");
                for (int i = 0; i < Lviagem.size(); i++) {
                    System.out.println("Viagem: " + Lviagem.get(i));
                    System.out.println("Km: " + Lkm.get(i));
                    System.out.println("Km/L: " + Lkml.get(i));
                    System.out.println("Data: " + Ldata.get(i));
                    System.out.println("---------------------------");
                }
            } else if (opcao == 2) {
                Double total = 0.0;
                for (int i = 0; i < Lviagem.size(); i++) {
                   Double totalKM = Lkm.get(i);
                   Double totalGa = Lkml.get(i);
                   total += totalKM / totalGa;
                }
                System.out.println(String.format("Total de combustível gasto até agora: %.2f litro(s)\n", total ));
            } else if (opcao == 3) {
                System.out.println("Coloque o numero da viagem");
                Integer nmrViagem = scanner.nextInt();
                Double Ga = Lkml.get(nmrViagem - 1);
                Double km = Lkm.get(nmrViagem - 1);
                Double total = km / Ga;
                System.out.println(String.format("Total de combustível gasto nesta viagem %.2f litro(s)\n", total));


            } else if (opcao == 4) {

                Double km = 0.0;
                for (int i = 0; i < Lkm.size(); i++) {
                    km += Lkm.get(i);
                }
                System.out.println(String.format("Total de quilomêtros percorridos: %.2f Km\n", km));
            } else if (opcao == 5) {
                System.out.println("Coloque o numero da viagem");
                Integer nmrViagem = scanner.nextInt();
                Double km = Lkm.get(nmrViagem - 1);
                System.out.println(String.format("Total de quilomêtros percorridos na viagem %d: %.2f Km\n", nmrViagem,km));
            } else if (opcao == 0) {
                System.out.println("Obrigado e até mais :)");
                break;
            }
            else {
                System.out.println("Insira alguma das opções");
                continue;
            }
        }
    }
}