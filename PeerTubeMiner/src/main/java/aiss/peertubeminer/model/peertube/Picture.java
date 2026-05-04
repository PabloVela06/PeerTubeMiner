package aiss.peertubeminer.model.peertube;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Picture {

    @JsonProperty("fileUrl")
    private String pictureLink;
    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("fileUrl")
    public String getPictureLink() {
        return pictureLink;
    }

    @JsonProperty("fileUrl")
    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Picture withPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
        return this;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Picture withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Picture.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pictureLink");
        sb.append('=');
        sb.append(((this.pictureLink == null)?"<null>":this.pictureLink));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}