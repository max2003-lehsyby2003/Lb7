import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        IOFile ioFile = new IOFile();
        Logik logik = new Logik();

        List<Student> students;
        Scanner input = new Scanner(System.in);
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        String file, filename, fakul, group;
        int date;


        while (choice != 7) {
            System.out.println("Выберите один из пунктов меню:");
            System.out.println("1. Створення/перевірка на існування файла, виведення данних файлу");
            System.out.println("2. Запис данних до файлу");
            System.out.println("3. список студентів заданого факультету;");
            System.out.println("4. список студентів, які народились після заданого року;");
            System.out.println("5. список навчальної групи в порядку алфавіту;");
            System.out.println("6. список студентів упорядкований за алфавітом назви факультету, а для студентів одного" +
                    "факультету – за датою народження");
            System.out.println("7. Вихід з програми");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1.Створення/перевірка на існування файла, виведення данних файлу ");
                    System.out.println("Введіть назву файлу");
                    filename = sc.next();
                    ioFile.createFile(filename);


                    break;
                case 2:
                    System.out.println("2.Запис данних до файлу");
                    System.out.println("Введіть назву файлу");
                    file = sc.next();
                    students = logik.createList();
                    ioFile.writeListToFile(students, file);
                    break;
                case 3:

                    System.out.println("3. список студентів заданого факультету;");
                    System.out.println("введіть назву файлу");
                    file = sc.nextLine();

                    System.out.println("Введіть назву факультету(Програмна інженерія, Комп'ютерні технологіі)");
                    fakul = sc.nextLine();
                    System.out.println("------Студенти факультету Програмна інженерія----");
                    students = ioFile.readListFromFile(file);
                    logik.printStudent(logik.filterFakultStudent(students, fakul));

                    break;
                case 4:

                    System.out.println("4. список студентів, які народились після заданого року;");

                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);
                    System.out.println("Введіть дату год");
                    date = Integer.parseInt(sc.next());

                    logik.printStudent(logik.filterDataNarodg(students, date));
                    break;
                case 5:
                    System.out.println("5. список навчальної групи в порядку алфавіту;");

                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);

                    System.out.println("Введіть назву группи");
                    group = sc.next();

                    logik.printStudent(logik.printGroupStudent(students, group));

                    break;
                case 6:
                    System.out.println("6. список студентів упорядкований за алфавітом назви факультету, а для студентів одного факультету – за датою народження");
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readListFromFile(file);

                    logik.printStudent(logik.printListStudent(students));
                    break;
                case 7:
                    System.out.println("Выход из программы");
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

}

