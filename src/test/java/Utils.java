import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Utils {

    String myjson_1 = "{\n" +
            " \"key0_0\": \"value_key0_0\",\n" +
            " \"/key0_1\": \"/value_key0_1\",\n" +
            " \"node1\": {\n" +
            "    \"key1_1\": \"value_key1_1\",\n" +
            "    \"key1_2\": \"/value_key1_2\",\n" +
            "    \"/key1_3\": \"value_key1_3\",\n" +
            "    \"key1_4/moreText\": \"value_key1_4\"\n" +
            "  }\n" +
            "}";

    public Properties readConfig() {
        String pathConfig = "src/test/config/config.properties";
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(pathConfig);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public String getEnvironment() {
        String env_system = System.getenv("env_name");
        if (env_system != null && !env_system.trim().isEmpty()) {
            return env_system;
        }
        return readConfig().getProperty("env.name");
    }
    public String getMicroserviceName() {
        String microserviceName = System.getenv("microservice_name ");
        if (microserviceName != null && !microserviceName.trim().isEmpty()) {
            return microserviceName;
        }
        return readConfig().getProperty("microservice.name");
    }

    public String getMicroservicePath() {
        String microservicePath = System.getenv("microservice_path ");
        if (microservicePath != null && !microservicePath.trim().isEmpty()) {
            return microservicePath;
        }
        return readConfig().getProperty("microservice.path");
    }
    public String getDemoSwagger() {
        return readConfig().getProperty("demo.swagger");
    }



}
