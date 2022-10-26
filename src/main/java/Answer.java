import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    final private String copyright;
    final private String date;
    final private String explanation;
    final private String hdurl;
    final private String media_type;
    final private String service_version;
    final private String title;
    final private String url;

    public Answer(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMediaType() {
        return media_type;
    }

    public String getTitle() {
        return title;
    }
}