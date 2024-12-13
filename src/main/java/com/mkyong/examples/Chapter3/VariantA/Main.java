package com.mkyong.examples.Chapter3.VariantA;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[]{
                new Student(1, "Иванов", "Иван", "Иванович", "1998-03-08", "ул. Ленина, д. 1", "+7 (900) 123-45-67", "ПИИИ", 2, 3),
                new Student(2, "Петров", "Петр", "Петрович", "1999-04-12", "ул. Мира, д. 2", "+7 (901) 234-56-78", "ФКНТ", 1, 1),
                new Student(3, "Сидоров", "Сидор", "Сидорович", "2000-05-15", "ул. Октябрьская, д. 3", "+7 (902) 345-67-89", "ФКНТ", 3, 2),
                new Student(4, "Кузнецов", "Кузьма", "Кузьмич", "2001-06-18", "ул. Советская, д. 4", "+7 (903) 456-78-90", "ПИИИ", 1, 3),
                new Student(5, "Соколов", "Сокол", "Соколович", "2002-07-21", "ул. Победы, д. 5", "+7 (904) 567-89-01", "ФИИТ", 3, 1),
        };

        System.out.println("Введите название факультета:");
        String faculty = scanner.nextLine();
        System.out.println("Список студентов факультета " + faculty + ":");
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }

        System.out.println("Списки студентов для каждого факультета и курса:");
        for (String uniqueFaculty : getUniqueFaculties(students)) {
            System.out.println("Факультет: " + uniqueFaculty);
            for (Student student : students) {
                if (student.getFaculty().equals(uniqueFaculty)) {
                    System.out.println("\tКурс " + student.getCourse() + ": " + student);
                }
            }
        }

        System.out.println("Введите год рождения:");
        int birthYear = scanner.nextInt();
        System.out.println("Список студентов, родившихся после " + birthYear + " года:");
        for (Student student : students) {
            if (student.getBirthDate().substring(0, 4).compareTo(String.valueOf(birthYear)) > 0) {
                System.out.println(student);
            }
        }

        System.out.println("Введите номер учебной группы:");
        int groupNumber = scanner.nextInt();
        System.out.println("Список студентов учебной группы " + groupNumber + ":");
        for (Student student : students) {
            if (student.getGroup() == groupNumber) {
                System.out.println(student);
            }
        }
    }

    private static String[] getUniqueFaculties(Student[] students) {
        String[] uniqueFaculties = new String[students.length];
        int uniqueFacultyCount = 0;
        for (Student student : students) {
            if (!Arrays.asList(uniqueFaculties).contains(student.getFaculty())) {
                uniqueFaculties[uniqueFacultyCount++] = student.getFaculty();
            }
        }
        return Arrays.copyOf(uniqueFaculties, uniqueFacultyCount);
    }
}


class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private int group;

    public Student(int id, String lastName, String firstName, String middleName, String birthDate, String address, String phone, String faculty, int course, int group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group=" + group +
                '}';
    }
}
