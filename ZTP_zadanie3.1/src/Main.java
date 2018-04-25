import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Faculty f1 = new Faculty("Informatyka");
        Faculty f2 = new Faculty("Matematyka");

        Student s1 = new Student(f1,'M', 22, "Marek");
        Student s2 = new Student(f1,'M', 12, "Patryk");
        Student s3 = new Student(f1,'M', 18, "Andrzej");
        Student s4 = new Student(f1,'K', 17, "Marta");
        Student s5 = new Student(f2,'K', 18, "Ania");
        Student s6 = new Student(f2,'M', 32, "Michał");

        Course c1 = new Course("ZTP");
        Course c2 = new Course("HD");
        Course c3 = new Course("RSI");
        Course c4 = new Course("Analiza");
        Course c5 = new Course("Algebra");

        s1.addCourse(c2);
        s2.addCourse(c1, c2);
        s3.addCourse(c2, c4, c5);
        s3.addCourse(c1, c3);
        s4.addCourse(c2, c3, c5);
        s5.addCourse(c1, c4, c5);
        s6.addCourse(c1, c2, c3);

        List<Student> studentList= Arrays.asList(s1, s2, s3, s4, s5, s6);



        System.out.println("\nZadanie 1");
        /* 1. Wypisania obiektów wybranej klasy spełniających określone kryterium (filtrowanie)
         */
        // inicjalizacja predykatu
        Predicate<Student> predicate = student -> student.getAge() < 19;
        // filtrowanie predykatem i wypisanie
        studentList.stream().filter(predicate).forEach(student -> System.out.println(student));



        System.out.println("\nZadanie 2");
        /* 2. Wypisania atrybutu obiektu klasy A powiązanej z obiektem klasy
            B, np. wypisania nazwy wydziału dla każdego studenta (map)
        */
        studentList.stream().map(Student::getFaculty).forEach(faculty -> System.out.println(faculty.getName()));



        System.out.println("\nZadanie 3");
        /* 3. Wypisania obiektów klasy A, które mają najwyższą/najniższą
            wartość powiązanych obiektów klasy B, np. wypisz studentów o
            najwyższej liczbie powiązanych kursów (min/max)
        */
        Student stMax = studentList.stream().max(Comparator.comparing(Student::getNumberOfCourses)).get();
        Student stMin = studentList.stream().min(Comparator.comparing(Student::getNumberOfCourses)).get();
        System.out.println("Najwięcej kursów: " + stMax);
        System.out.println("Najmniej kursów: " + stMin);



        System.out.println("\nZadanie 4");
        /* 4. Grupowania obiektów klasy A wg pewnej cechy i policzenia
            pewnej statystyki dla grupy, np. pogrupowania studentów wg płci i
            policzenia średniej wieku (groupingBy)
        */
        Map<Character, Double> sexGroup = studentList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.averagingInt(Student::getAge)));
        System.out.println(sexGroup);
    }
}
