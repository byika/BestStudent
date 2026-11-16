
//Создайте класс «Студент»: у него есть имя и массив оценок.
//У студента должен быть метод, который возвращает его средний балл.
//В main создайте трёх студентов с разными оценками и выведите,
//у кого средний балл самый высокий.

import java.util.ArrayList;

class Student{
    String name;
    int[] grades;
    public Student (String name, int[] grades){
        this.name = name;
        this.grades = grades;
    }
    public double avgGrade (){
        if(grades.length == 0){
            return -1;
        }
        double avg = 0.0;
        int i = 0;
        for (int g : grades){
            avg += g;
            i++;
        }
        return avg/i;
    }

    public void printAvgGrade (){
        if(this.avgGrade() != -1) {
            System.out.println("Средний бал студента " + this.name + ": " + this.avgGrade());
        }else{
            System.out.println("У студента " + this.name + " пока нет оценок.");
        }
    }

}


public class Main {
    static void bestStudent(Student[] students){
        ArrayList<Student> bestStudents = new ArrayList<Student>();
        double max = students[0].avgGrade();
        for (Student i : students){
            if(max < i.avgGrade()){
                max = i.avgGrade();
            }
        }
        for(Student i : students){
            if(max == i.avgGrade()){
                bestStudents.add(i);
            }
        }
        if (max == -1){
            System.out.print("Студенты не набрали ни одной оценки за семестр. Список на исключение: ");
            for (Student i : bestStudents){
                System.out.print(i.name + " ");
            }
        } else if(bestStudents.size() > 1){
            System.out.print("Лучшие студенты ");
            for (Student i : bestStudents){
                System.out.print(i.name + " ");
            }
            System.out.print("со средним баллом " + max);
        }else{
            System.out.print("Лучший студент " + bestStudents.get(0).name + " со средним баллом " + max);
        }
    }

    public static void main(String[] args) {
        int[] grades1 = {3, 4, 4, 4, 4};
        int[] grades2 = {};
        int[] grades3 = {};
        int[] grades4 = {5, 5, 5, 2, 2};

        Student mike = new Student("Mike", grades1);
        Student tom = new Student("Tom", grades2);
        Student sam = new Student("Sam", grades3);
        Student maria = new Student("Maria", grades4);
        Student[] students = {mike, tom, sam, maria};
        mike.printAvgGrade();
        tom.printAvgGrade();
        sam.printAvgGrade();
        maria.printAvgGrade();
        bestStudent(students);
    }
}