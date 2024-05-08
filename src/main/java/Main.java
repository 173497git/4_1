/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            Service s = new Service();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean addingStudents = true;

            while (addingStudents) {
                System.out.println("Co chcesz zrobić?");
                System.out.println("1. Dodaj nowego studenta");
                System.out.println("2. Zakończ dodawanie studentów");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        System.out.println("Podaj imię nowego studenta:");
                        String name = reader.readLine();
                        System.out.println("Podaj wiek nowego studenta:");
                        int age = Integer.parseInt(reader.readLine());
                        s.addStudent(new Student(name, age));
                        System.out.println("Dodano nowego studenta.");
                        break;
                    case "2":
                        addingStudents = false;
                        break;
                    default:
                        System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                        break;
                }
            }

            System.out.println("Lista studentów w bazie:");
            for (Student student : s.getStudents()) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd wejścia/wyjścia: " + e.getMessage());
        }
    }
}

