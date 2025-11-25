package school.sptech.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackService {

    private final String token;

    public SlackService(String token) {
        this.token = token;
    }

    public void enviarAlerta(String canal, String mensagem) {
        try {
            URL url = new URL("https://slack.com/api/chat.postMessage");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            String json = String.format(
                    "{\"channel\":\"%s\", \"text\":\"%s\"}",
                    canal, mensagem.replace("\"", "\\\"")
            );

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes("utf-8"));
            }

            int responseCode = conn.getResponseCode();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            responseCode >= 200 && responseCode < 300
                                    ? conn.getInputStream()
                                    : conn.getErrorStream()
                    )
            )) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                String jsonResponse = response.toString();

                if (jsonResponse.contains("\"ok\":true")) {
                    System.out.println("✅ Alerta enviado para o Slack!");
                } else {
                    System.out.println("❌ Falha ao enviar alerta. Resposta: " + jsonResponse);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
