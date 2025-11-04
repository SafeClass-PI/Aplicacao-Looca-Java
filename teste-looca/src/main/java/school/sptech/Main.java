package school.sptech;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Looca looca = new Looca();

        System.out.println("Monitorando tráfego de rede (MB) a cada 5 segundos...");
        System.out.println("Pressione CTRL+C para parar.\n");

        // Pega a primeira interface de rede ativa
        RedeInterface rede = looca.getRede().getGrupoDeInterfaces()
                .getInterfaces()
                .stream()
                .findFirst()
                .orElse(null);

        if (rede == null) {
            System.out.println("Nenhuma interface de rede ativa encontrada.");
            return;
        }

        long bytesEnviadosAnterior = rede.getBytesEnviados();
        long bytesRecebidosAnterior = rede.getBytesRecebidos();

        while (true) {
            Thread.sleep(5000);

            long bytesEnviadosAtual = rede.getBytesEnviados();
            long bytesRecebidosAtual = rede.getBytesRecebidos();

            long bytesEnviadosDelta = bytesEnviadosAtual - bytesEnviadosAnterior;
            long bytesRecebidosDelta = bytesRecebidosAtual - bytesRecebidosAnterior;

            double mbEnviados = bytesEnviadosDelta / 1_000_000.0;
            double mbRecebidos = bytesRecebidosDelta / 1_000_000.0;

            System.out.printf("Enviados: %.2f MB | Recebidos: %.2f MB%n", mbEnviados, mbRecebidos);

            bytesEnviadosAnterior = bytesEnviadosAtual;
            bytesRecebidosAnterior = bytesRecebidosAtual;
        }
    }
}
