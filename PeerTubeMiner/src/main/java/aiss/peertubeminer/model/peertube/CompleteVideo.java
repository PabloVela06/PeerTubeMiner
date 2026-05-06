package aiss.peertubeminer.model.peertube;


import aiss.peertubeminer.model.videominer.VMCaption;
import aiss.peertubeminer.model.videominer.VMComment;
import aiss.peertubeminer.model.videominer.VMUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CompleteVideo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("publishedAt")
    private String releaseTime;
    @JsonProperty("account")
    private VMUser user;
    @JsonProperty("captions")
    private List<VMCaption> captions;
    @JsonProperty("comments")
    private List<VMComment> comments;



    @JsonProperty("captions")
    public List<VMCaption> getCaptions() {
        return captions;
    }
    @JsonProperty("captions")
    public void setCaptions(List<VMCaption> captions) {
        this.captions = captions;
    }

    @JsonProperty("comments")
    public List<VMComment> getComments() {
        return comments;
    }
    @JsonProperty("comments")
    public void setComments(List<VMComment> comments) {
        this.comments = comments;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public CompleteVideo withId(Integer id) {
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

    public CompleteVideo withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public CompleteVideo withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("publishedAt")
    public String getReleaseTime() {
        return releaseTime;
    }

    @JsonProperty("publishedAt")
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public CompleteVideo withReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
        return this;
    }

    @JsonProperty("account")
    public VMUser getUser() {
        return user;
    }

    @JsonProperty("account")
    public void setUser(VMUser user) {
        this.user = user;
    }

    public CompleteVideo withUser(VMUser user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Video.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("releaseTime");
        sb.append('=');
        sb.append(((this.releaseTime == null)?"<null>":this.releaseTime));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("captions");
        sb.append('=');
        sb.append(((this.captions == null)?"<null>":this.captions));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
