/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Wybierz opcję:");
      System.out.println("1. Dodaj studenta");
      System.out.println("2. Wyświetl listę studentów");
      int opcja = scanner.nextInt();
      scanner.nextLine(); 

      switch(opcja) {
        case 1:
          System.out.println("Podaj imię studenta:");
          String name = scanner.nextLine();
          System.out.println("Podaj nazwisko studenta:");
          String nazw = scanner.nextLine();
          System.out.println("Podaj wiek studenta:");
          int age = scanner.nextInt();
          scanner.nextLine(); 
          s.addStudent(new Student(name, nazw, age));
          System.out.println("Student dodany.");
          break;
          case 2:
          var students = s.getStudents();
          for(Student current : students) {
            System.out.println("Imię: " + current.GetName() +  ", Nazwisko: " + current.GetNazw() + ", Wiek: " + current.GetAge());
          }
          break;
        default:
          System.out.println("Niepoprawna opcja.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}