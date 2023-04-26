import java.time.LocalDate;
import java.util.*;

public class Logik {

    //вносим данные в список
public List<Student> createList() {
    List<Student> students = new ArrayList<>();

    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Введите количество записей: ");
        int count = scanner.nextInt();

        scanner.nextLine(); // считываем символ перевода строки

        for (int i = 0; i < count; i++) {
            System.out.println("Введите данные для записи " + (i + 1) + ":");
            System.out.print("Имя: ");
            String imy = scanner.nextLine();
            System.out.print("Фамилия: ");
            String famil = scanner.nextLine();
            System.out.print("Отчество: ");
            String batkiv = scanner.nextLine();
            System.out.print("Дата рождения (гггг-мм-дд): ");
            String dataNarodgString = scanner.nextLine();
            LocalDate dataNarodg = LocalDate.parse(dataNarodgString);
            System.out.print("Адрес: ");
            String adress = scanner.nextLine();
            System.out.print("Факультет: ");
            String fakul = scanner.nextLine();
            System.out.print("Группа: ");
            String grupa = scanner.nextLine();
            System.out.print("Телефон: ");
            String telefon = scanner.nextLine();
            System.out.print("Курс: ");
            int kurs = scanner.nextInt();
            scanner.nextLine(); // считываем символ перевода строки

            students.add(new Student(imy, famil, batkiv, dataNarodg, adress, fakul, grupa, telefon, kurs));
        }
    }

    return students;
}
    //вывод данных списка
    public void printStudent(List<Student> students) {
        for (Student value : students) {
            System.out.println(value);
        }

    }
//список студентів заданого факультету;
public  List<Student> filterFakultStudent(List<Student>  students, String fakul) {
    List<Student> temp = new ArrayList<>();

    for (Student student : students) {
        if (student.getFakul().equals(fakul)) {
            temp.add(student);
        }
    } return temp;
}

//список студентів, які народились після заданого року;
    public  List<Student> filterDataNarodg(List<Student> students, int dataNarodg) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getDataNarodg().getYear() > dataNarodg) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    //список навчальної групи в порядку алфавіту;
    public List<Student> printGroupStudent(List<Student> students, String group) {
        List<Student> temp = new ArrayList<>();

        for (Student student : students) {
            if (student.getGrupa().equals(group)) {
                temp.add(student);
            }
        }
        temp.sort(Comparator.comparing(Student::getFamil).thenComparing(Student::getImy));
        return temp;
    }
    public List<Student> printListStudent(List<Student> students){

    students.sort(Comparator.comparing(Student:: getFakul).thenComparing(Student::getDataNarodg));
return students;
}
}

