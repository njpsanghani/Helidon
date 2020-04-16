package njscommunity;

import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
	// write your code here
        WebServer webServer = WebServer
                .create(Routing.builder()
                        .any((req, res) -> res.send("It works!"))
                        .build())
                .start()
                .toCompletableFuture()
                .get(10, TimeUnit.SECONDS);

        System.out.println("Server started at: http://localhost:" + webServer.port());
    }
}
