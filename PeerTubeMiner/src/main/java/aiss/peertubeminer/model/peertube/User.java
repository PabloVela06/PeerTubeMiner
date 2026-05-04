package aiss.peertubeminer.model.peertube;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String userLink;
    @JsonProperty("avatars")
    private List<Picture> pictureList;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public User withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("url")
    public String getUserLink() {
        return userLink;
    }

    @JsonProperty("url")
    public void setUserLink(String userLink) {
        this.userLink = userLink;
    }

    public User withUserLink(String userLink) {
        this.userLink = userLink;
        return this;
    }

    @JsonProperty("avatars")
    public List<Picture> getPictureList() {
        return pictureList;
    }

    @JsonProperty("avatars")
    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public User withPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("userLink");
        sb.append('=');
        sb.append(((this.userLink == null)?"<null>":this.userLink));
        sb.append(',');
        sb.append("pictureList");
        sb.append('=');
        sb.append(((this.pictureList == null)?"<null>":this.pictureList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
