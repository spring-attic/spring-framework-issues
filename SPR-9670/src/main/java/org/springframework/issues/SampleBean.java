package org.springframework.issues;

import java.util.List;

public class SampleBean {

    private String title;

    private String id;

    private String loc;

    private String trackerId;

    private boolean visible;

    private List<SampleBean> children;

    public List<SampleBean> getChildren() {
        return children;
    }

    public void setChildren(List<SampleBean> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
