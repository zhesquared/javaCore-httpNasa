import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

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
        String link;
        String title;

        if ("video".equals(answer.getMediaType())) {
            String url = answer.getUrl();
            String preview = url.substring(url.lastIndexOf('/'),
                    url.indexOf('?'));
            link = "https://img.youtube.com/vi" + preview + "/maxresdefault.jpg";
            title = answer.getTitle() + ".jpg";
        } else {
            link = answer.getHdurl();
            String[] path = answer.getHdurl().split("/");
            title = path[path.length - 1];
        }

        file = new File(title);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse contentResponse = httpClient.execute(new HttpGet(link))
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
