import java.util.*;

public class Main {
    private static List<Student> students=new ArrayList<>();
    private static List<Faculty> faculties = new ArrayList<>();
     private static List<Course> courses = new ArrayList<>();
         private static Scanner sc = new Scanner(System.in);



        public static void main(String[] args){
            while (true){
                      System.out.println("\n==== UNIVERSITY MANAGEMENT SYSTEM ====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student to Course");
            System.out.println("5. Assign Faculty to Course");
            System.out.println("6. View Details");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

               int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addFaculty();
                case 3 -> addCourse();
                case 4 -> enrollStudent();
                case 5 -> assignFaculty();
                case 6 -> viewAll();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");

            }
        }
    }

    private static void addStudent(){
          System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        students.add(new Student( name, email,id));
        System.out.println(" Student added successfully!");

    }
    
        private static void addFaculty() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        faculties.add(new Faculty(name,  email,id, dept));
        System.out.println(" Faculty added successfully!");
    }

private static void addCourse() {
        System.out.print("Enter Course ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();
        courses.add(new Course(id, name));
        System.out.println("Course added successfully!");
    }
      private static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();
        System.out.print("Enter Course ID: ");
        String cid = sc.nextLine();

        
        Student s = students.stream().filter(st -> st.getId().equals(sid)).findFirst().orElse(null);
        Course c = courses.stream().filter(co -> co.getCourseId().equals(cid)).findFirst().orElse(null);

           if (s != null && c != null) {
            c.enrollStudent(s);
            System.out.println("Student enrolled in course!");
        } else System.out.println(" Invalid Student or Course ID");
    }

    private static void assignFaculty() {
        System.out.print("Enter Faculty ID: ");
        String fid = sc.nextLine();
        System.out.print("Enter Course ID: ");
        String cid = sc.nextLine();

        Faculty f = faculties.stream().filter(fc -> fc.getId().equals(fid)).findFirst().orElse(null);
        Course c = courses.stream().filter(co -> co.getCourseId().equals(cid)).findFirst().orElse(null);

        if (f != null && c != null) {
            c.setFaculty(f);
            System.out.println(" Faculty assigned to course!");
        } else System.out.println(" Invalid Faculty or Course ID");
    }

  private static void viewAll() {
        System.out.println("\n--- STUDENTS ---");
        students.forEach(System.out::println);
        System.out.println("\n--- FACULTY ---");
        faculties.forEach(System.out::println);
        System.out.println("\n--- COURSES ---");
        courses.forEach(c -> System.out.println(c.getCourseId() + " | " + c.getCourseName()));
    }
}