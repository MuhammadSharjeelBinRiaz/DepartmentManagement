package departmentmanagement;

public class Course {

    private String courseName, courseCode, departmentId;
Course next;
    public Course(String courseName, String courseCode, String departmentId) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.departmentId = departmentId;
        this.next = null;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
