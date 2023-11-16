package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alex","Nikitin",25));
        people.add(new Person("John", "Doe", 30));
        people.add(new Person("Jane", "Smith", 22));
        people.add(new Person("Mike", "Johnson", 28));
        people.add(new Person("Emily", "Davis", 35));
        people.add(new Person("Chris", "Anderson", 27));
        people.add(new Person("Sarah", "Brown", 29));
        people.add(new Person("David", "Williams", 33));
        people.add(new Person("Emma", "Taylor", 26));
        people.add(new Person("Daniel", "Miller", 31));


        //prompt user to search for a name first or last
        System.out.print("Please enter a name to search for (first or last): ");
        String userInput = keyboard.nextLine();
        //display the names that match
//        ArrayList<Person> matches = new ArrayList<>();
//        for(Person person: people){
//            if(userInput.equalsIgnoreCase(person.firstName) || userInput.equalsIgnoreCase(person.lastName)){
//                matches.add(person);
//            }
//        }
//
//        System.out.println("Matches found:");
//        for(Person person: matches){
//            System.out.println("Name: " + person.firstName + " " + person.lastName + " Age: " + person.age);
//
//        }

        //stream version with lambdas
        List<Person> matches = people.stream()
                .filter(person -> person.firstName.equalsIgnoreCase(userInput) || person.lastName.equalsIgnoreCase(userInput))
                .collect(Collectors.toList());

                matches.stream()
                .forEach(person -> System.out.println(person.firstName + " " + person.lastName));



        //find average age

        int[] totalAge = {0};
        int average = 0;
//        for(Person person: people){
//            totalAge += person.age;
//        }
//        average = totalAge / people.size();
//
//        System.out.println("The average age is: "+average);

        //find average age stream lambda version
        people.stream()
                .forEach(person -> totalAge[0] += person.age);
        average = totalAge[0] / people.size();
        System.out.println("The average age is: "+ average);
        //display age of the oldest person in the list
//
//        int oldest = people.get(0).getAge();
//
//        for(int i = 0;i<people.size();i++){
//            if(oldest<people.get(i).getAge()){
//                oldest = people.get(i).getAge();
//            }
//        }
//
//        System.out.println("The oldest age is:"+ oldest);

        //find oldest age stream lambda version
        int oldest = people.stream()

                .mapToInt(person -> person.getAge())
                .reduce(0,Integer::max);
        people.stream()
                .filter(person -> person.getAge() == oldest)
                .forEach(person -> System.out.println("The oldest age is: " + oldest));
        //display the age of the youngest person in the list

//        int youngest = people.get(0).getAge();
//        for(int i = 0;i<people.size();i++){
//            if(youngest > people.get(i).getAge()){
//                youngest = people.get(i).getAge();
//            }
//        }
//        System.out.println("The youngest age is:" + youngest);

        //get youngest age stream lambda version
        int youngest = people.stream()
                .mapToInt(person -> person.getAge())
                .reduce(100,Integer::min);
        people.stream()
                .filter(person -> person.getAge() == youngest)
                .forEach(person -> System.out.println("The youngest age is: " + youngest));


    }




}
