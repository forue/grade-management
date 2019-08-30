package iweb212.student.grademanagement.model;

public class Navigation {
    private String title;
    private String mapper;

    public Navigation(String title, String mapper) {
        this.title = title;
        this.mapper = mapper;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMapper() {
        return mapper;
    }

    public void setMapper(String mapper) {
        this.mapper = mapper;
    }
}
