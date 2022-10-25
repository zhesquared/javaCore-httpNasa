import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private String copyright;
    private String date;
    private String explanation;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public Answer(
        @JsonProperty("copyright") String copyright,
        @JsonProperty("date") String date,
        @JsonProperty("explanation") String explanation,
        @JsonProperty("media_type") String media_type,
        @JsonProperty("service_version") String service_version,
        @JsonProperty("title") String title,
        @JsonProperty("url") String url
        ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getMediaType() {
        return media_type;
    }

    public String getTitle() {
        return title;
    }
}

//{
// "copyright":"Makrem Larnaout",
//        "date":"2022-10-25",
//        "explanation":"Jupiter and its moons move like our Sun and its planets. Similarly, Jupiter spins while its moons circle around. Jupiter\u2019s rotation can be observed by tracking circulating dark belts and light zones. The Great Red Spot, the largest storm known, rotates to become visible after about 15 seconds in the 48-second time lapse video. The video is a compilation of shorts taken over several nights last month and combined into a digital recreation of how 24-continuous hours would appear. Jupiter's brightest moons always orbit in the plane of the planet's rotation, even as Earth\u2019s spin makes the whole system appear to tilt.  The moons Europa, Ganymede, and Io are all visible, with Europa's shadow appearing as the icy Galilean moon crosses Jupiter's disk.  Jupiter remains near opposition this month, meaning that it is unusually bright, near to its closest to the Earth, and visible nearly all night long.   Almost Hyperspace: Random APOD Generator",
//        "media_type":"video",
//        "service_version":"v1",
//        "title":"Jupiter Rotates as Moons Orbit",
//        "url":"https://www.youtube.com/embed/juloL5WeLrc?rel=0"
//        }