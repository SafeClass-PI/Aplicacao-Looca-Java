package school.sptech;
import java.util.Scanner;

public class ConsoleGiovanna {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String[] campanhas = new String[5];
            Integer[] resultados = new Integer[5];
            Integer contador = 0;

            System.out.println("🌟✨ Bem-vindo ao Simulador de Estratégias de Marketing ✨🌟");
            System.out.println(" \uD83C\uDF84 Crie campanhas, escolha estratégias e veja seus resultados divertidos! \uD83C\uDF84 \n");

            Integer opcao;
            do {
                System.out.println("\n📌 Menu Principal");
                System.out.println("1️ 🎁 Criar nova campanha");
                System.out.println("2️ \uD83D\uDC51 Ver ranking de campanhas");
                System.out.println("3️ 👋 Sair");
                System.out.print("👉 Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        if (contador < campanhas.length) {
                            System.out.print("\n📝 Nome da campanha: ");
                            String nomeCampanha = sc.nextLine();

                            System.out.print("💰 Defina o orçamento (em R$): ");
                            Double orcamento = sc.nextDouble();

                            System.out.println("\n🎯 Escolha uma estratégia de marketing:");
                            System.out.println("1️ Redes Sociais 📱 (Custo baixo, retorno médio)");
                            System.out.println("2️ Panfletos 📰 (Custo médio, retorno baixo)");
                            System.out.println("3️ Anúncios Online 💻 (Custo alto, retorno alto)");
                            System.out.println("4️ Influenciadores 🤳⭐ (Custo médio, retorno variável)");
                            System.out.print("💡 Sua escolha: ");
                            Integer estrategia = sc.nextInt();

                            Integer engajamento = 0;

                            switch (estrategia) {
                                case 1:
                                    engajamento = (int)(orcamento * 1.5);
                                    break;
                                case 2:
                                    engajamento = (int)(orcamento * 0.8);
                                    break;
                                case 3:
                                    engajamento = (int)(orcamento * 2.0);
                                    break;
                                case 4:
                                    // retorno aleatório para influenciadores
                                    engajamento = (int)(orcamento * (Math.random() * 2 + 0.5));
                                    break;
                                default:
                                    System.out.println("⚠️ Opção de estratégia inválida!");
                            }

                            campanhas[contador] = nomeCampanha;
                            resultados[contador] = engajamento;
                            contador++;

                            System.out.println("\n📢 Resultado da campanha '" + nomeCampanha + "':");
                            System.out.println("✨ Engajamento gerado: R$" + engajamento + " 🎯");
                            if (engajamento > 1000) {
                                System.out.println("🏆 Sucesso absoluto! 🚀🔥🔥");
                            } else if (engajamento > 500) {
                                System.out.println("💡💡 Campanha sólida, mas ainda pode melhorar 💡💡");
                            } else {
                                System.out.println("💤 Quase ninguém viu... tente algo diferente na próxima vez 😢");
                            }

                        } else {
                            System.out.println("🚫 Você já atingiu o limite máximo de campanhas (5)!");
                        }
                        break;

                    case 2:
                        System.out.println("\n🏆 Ranking de Campanhas Criadas:");
                        if (contador == 0) {
                            System.out.println("📭 Nenhuma campanha criada ainda!");
                        } else {
                            for (int i = 0; i < contador; i++) {
                                Integer auxOrdenacaoMaiorNumero = resultados[i];
                                Integer auxOrdenacaoMaiorNumeroposicao = i;
                                for (int j = i + 1; j < contador; j++) {
                                    if (resultados[j] > auxOrdenacaoMaiorNumero){
                                        auxOrdenacaoMaiorNumeroposicao = j;
                                        auxOrdenacaoMaiorNumero = resultados[j];
                                    }
                                }
                                Integer tempResultado = resultados[i];
                                resultados[i] = resultados[auxOrdenacaoMaiorNumeroposicao];
                                resultados[auxOrdenacaoMaiorNumeroposicao] = tempResultado;
                                String tempCampanha = campanhas[i];
                                campanhas[i] = campanhas[auxOrdenacaoMaiorNumeroposicao];
                                campanhas[auxOrdenacaoMaiorNumeroposicao] = tempCampanha;
                            }

                            for (int i = 0; i < contador; i++) {
                                System.out.println((i+1) + "️⃣ " + campanhas[i] + " 🔹 Engajamento: R$" + resultados[i] + " possível retorno financeiro ✨");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n👋 Obrigado por jogar o Simulador de Marketing! Até logo! 🌍✨");
                        break;

                    default:
                        System.out.println("❌ Opção inválida! Tente novamente ");
                }

            } while (opcao != 3);

            sc.close();
        }
    }


