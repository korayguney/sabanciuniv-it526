package edu.sabanciuniv.test;

import edu.sabanciuniv.model.*;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;


import java.time.LocalDate;
import java.time.Month;

public class TestInsuranceApp {
    public static void main(String[] args){
        saveTestData();

    }

    private static void saveTestData() {

        Student student1 = new Student("Betul Gulcam", LocalDate.of(1992, Month.SEPTEMBER,27),"Istanbul","Female");
        Student student2 = new Student("Zeynep Basarı", LocalDate.of(2021, Month.DECEMBER,01), "Istanbul","Female");
        Student student3 = new Student("Deniz Dora", LocalDate.of(2022, Month.MAY,15), "Istanbul","Male");

        Course course1=new Course("English",101,3.00);
        Course course2=new Course("Math",102,3.00);
        Course course3=new Course("Enterprise Java",201,3.00);
        Course course4=new Course("Software Testing",202,3.00);


        Instructor permanentInstructor1=new PermanentInstructor("Tarık Sengül","Ankara","32456677",35000.00);
        Instructor permanentInstructor2=new PermanentInstructor("Necmi Erdoğan","Ankara","98888865",35000.00);
        Instructor visitingResearcher1=new VisitingResearcher("Basak Alpan","Ankara","555555678",25000.00);
        Instructor visitingResearcher2=new VisitingResearcher("Barıs Cakmur","Ankara","32111111",25000.00);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher2);
        course4.setInstructor(visitingResearcher1);

        course1.getStudentList().add(student1);
        course2.getStudentList().add(student2);
        course3.getStudentList().add(student3);
        course4.getStudentList().add(student1);

        /*student1.getCourseList().add(course1);
        student2.getCourseList().add(course2);
        student3.getCourseList().add(course3);
        student1.getCourseList().add(course4);*/

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);
            entityManager.persist(course4);
            entityManager.persist(student1);
            entityManager.persist(student2);
            entityManager.persist(student3);
            entityManager.persist(permanentInstructor1);
            entityManager.persist(permanentInstructor2);
            entityManager.persist(visitingResearcher1);
            entityManager.persist(visitingResearcher2);
            entityManager.getTransaction().commit();
            System.out.println("All data persisted.");
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }finally{
            EntityManagerUtils.closeEntityManager(entityManager);

        }



    }
}
