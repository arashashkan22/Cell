package hello.hellospring.project;

import java.util.Set;

public class LessonDomain {

    private Set<Long> videoId;
    private Set<Long> courseLevelId;
    private Set<Long> sectionId;

    public Set<Long> getVideoId() {
        return videoId;
    }

    public void setVideoId(Set<Long> videoId) {
        this.videoId = videoId;
    }

    public Set<Long> getCourseLevelId() {
        return courseLevelId;
    }

    public void setCourseLevelId(Set<Long> courseLevelId) {
        this.courseLevelId = courseLevelId;
    }

    public Set<Long> getSectionId() {
        return sectionId;
    }

    public void setSectionId(Set<Long> sectionId) {
        this.sectionId = sectionId;
    }
}
