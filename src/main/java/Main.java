import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.URL;


public class Main {

    public static final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=Qyt2h7woGVy2M88KCkde3fSQABrYHW4y6EgtlqzK";
    public static ObjectMapper mapper = new ObjectMapper();
    public static File file = null;

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(new HttpGet(NASA_URL))) {
            Answer answer = mapper.readValue(response.getEntity().getContent(),
                    Answer.class);
            saveFile(answer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void saveFile(Answer answer) {

//        String title = null;
//        if ("video".equals(answer.getMediaType())) {
            String link = answer.getUrl();
            String preview = link.substring(link.lastIndexOf('/'),
                    link.indexOf('?'));
            String title = "https://img.youtube.com/vi" + preview + "/maxresdefault.jpg";
//        }

        file = new File("1.jpg");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse contentResponse = httpClient.execute(new HttpGet(title)) //title
        ) {

            byte[] content = contentResponse.getEntity().getContent().readAllBytes();
            FileOutputStream output = new FileOutputStream(file);
            output.write(content);
            output.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
