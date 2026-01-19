package tyukann_B253377_宮廻陽向;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * 劇的に高速な素数判定サーバー
 * Java標準ライブラリのみを使用（外部ライブラリ不要）
 * 
 * 実行方法：
 * 1. このファイルをコンパイル・実行してください。
 * 2. ブラウザで http://localhost:8000 にアクセスしてください。
 */
public class FastPrimeServer {

    private static final int PORT = 8000;
    // ミラー・ラビン素数判定法の確からしさパラメータ
    // 100の場合、誤判定の確率は 1 / 2^100 未満（実用的にはほぼゼロ）
    private static final int CERTAINTY = 100;

    public static void main(String[] args) throws IOException {
        // 簡単なHTTPサーバーを作成
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // コンテキストの設定
        // 1. ルートパス ("/")：Web UI (HTML) を返す
        server.createContext("/", new StaticFileHandler());
        
        // 2. APIパス ("/api/check")：素数判定ロジックを実行してJSONを返す
        server.createContext("/api/check", new PrimeCheckHandler());

        server.setExecutor(null); // デフォルトのエグゼキュータ
        System.out.println("==================================================");
        System.out.println("  FastPrimeServer Started");
        System.out.println("  Port: " + PORT);
        System.out.println("  URL:  http://localhost:" + PORT);
        System.out.println("==================================================");
        server.start();
    }

    /**
     * 静的ファイル (index.html) を配信するハンドラ
     */
    static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            // "web/index.html" を読み込む
            // 実行場所のカレントディレクトリからの相対パス
            Path path = Paths.get("web", "index.html").toAbsolutePath();
            
            if (!Files.exists(path)) {
                String response = "Error: web/index.html not found at " + path;
                t.sendResponseHeaders(404, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
                return;
            }

            byte[] content = Files.readAllBytes(path);
            t.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            t.sendResponseHeaders(200, content.length);
            OutputStream os = t.getResponseBody();
            os.write(content);
            os.close();
        }
    }

    /**
     * 素数判定APIハンドラ
     */
    static class PrimeCheckHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            // CORSヘッダー（開発用）
            t.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            t.getResponseHeaders().set("Content-Type", "application/json");

            // クエリパラメータの解析 (?number=123)
            String query = t.getRequestURI().getQuery();
            Map<String, String> params =  queryToMap(query);
            
            String numberStr = params.get("number");
            String jsonResponse;

            if (numberStr == null || !numberStr.matches("\\d+")) {
                jsonResponse = "{\"error\": true, \"message\": \"Invalid number format\"}";
            } else {
                try {
                    BigInteger bigInt = new BigInteger(numberStr);
                    
                    // 計測開始
                    long startTime = System.nanoTime();
                    
                    // 高速判定（ミラー・ラビン法などを使用）
                    boolean isPrime = bigInt.isProbablePrime(CERTAINTY);
                    
                    // 計測終了
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;

                    jsonResponse = String.format(
                        "{\"isPrime\": %b, \"timeNs\": %d, \"error\": false}",
                        isPrime, duration
                    );

                } catch (Exception e) {
                    jsonResponse = "{\"error\": true, \"message\": \"Calculation error\"}";
                }
            }

            // レスポンス送信
            byte[] responseBytes = jsonResponse.getBytes(StandardCharsets.UTF_8);
            t.sendResponseHeaders(200, responseBytes.length);
            OutputStream os = t.getResponseBody();
            os.write(responseBytes);
            os.close();
        }

        // 簡易クエリパーサ
        private Map<String, String> queryToMap(String query) {
            Map<String, String> result = new HashMap<>();
            if (query == null) return result;
            
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) {
                    result.put(entry[0], entry[1]);
                } else {
                    result.put(entry[0], "");
                }
            }
            return result;
        }
    }
}
