
  package training.taylor.time-tracker.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class CheckapiTest {

      @Test
      void testAll() {
          String apiHostServer = System.getenv().getOrDefault("alias_URL_BASE", "http://localhost:4010");
String apiHostServer = System.getenv().getOrDefault("alias_URL_BASE", "http://localhost:4010");
String apiHostServer = System.getenv().getOrDefault("alias_URL_BASE", "http://localhost:4010");
String apiHostServer = System.getenv().getOrDefault("alias_URL_BASE", "http://localhost:4010");
String apiHostServer = System.getenv().getOrDefault("alias_URL_BASE", "http://localhost:4010");
String apiHostServer = System.getenv().getOrDefault("alias_URL_BASE", "http://localhost:4010");
String apiHostServer = System.getenv().getOrDefault("alias_URL_BASE", "http://localhost:4010");
          Results results = Runner.path("src/test/java/training/taylor/time-tracker/api_tests/Checkapi")
                  .systemProperty("alias_URL_BASE", apiHostServer)
.systemProperty("alias_URL_BASE", apiHostServer)
.systemProperty("alias_URL_BASE", apiHostServer)
.systemProperty("alias_URL_BASE", apiHostServer)
.systemProperty("alias_URL_BASE", apiHostServer)
.systemProperty("alias_URL_BASE", apiHostServer)
.systemProperty("alias_URL_BASE", apiHostServer)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
