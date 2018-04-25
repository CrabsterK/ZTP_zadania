import java.util.HashSet;
import java.util.Set;

public class Student {
    private char sex;
    private int age;
    private String name;
    private Faculty faculty;
    private Set<Course> courseList;

    public Student(Faculty faculty, char sex, int age, String name) {
        this.faculty = faculty;
        this.sex = sex;
        this.age = age;
        this.name = name;
        courseList = new HashSet<>();
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    public void addCourse(Course course, Course course2){
        courseList.add(course);
        courseList.add(course2);
    }

    public void addCourse(Course course, Course course2, Course course3){
        courseList.add(course);
        courseList.add(course2);
        courseList.add(course3);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfCourses() {
        return courseList.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "sex=" + sex +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", kursy='" + getNumberOfCourses() + '\'' +
                '}';
    }
}
