package com.example.student_springdatajpa;

import com.example.student_springdatajpa.entity.Student;
import com.example.student_springdatajpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class StudentSpringDataJpaApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void insertStudent() {
        Student student = Student.builder()
                .firstName("Nguyen")
                .lastName("Ngoc Tri")
                .email("NgocTri@gmail.com")
                .build();
        studentRepository.save(student);
    }
    // Read REPO
    @Test
    public void findAllStudents() {
        List<Student> students = (List<Student>) studentRepository.findAll();
        System.out.println(students);
    }
    //Read Repo
    @Test
    public void findById() {
        Optional<Student> student = studentRepository.findById(Long.valueOf(2));
        System.out.println(student);
    }
    //JPQL Read
    @Test
    public void findByStudentIdJPQL(){
        System.out.println(studentRepository.findStudentByStudentID(Long.valueOf(5)));
    }
    //Native Read
    @Test
    public void findStudentByEmail() {
        System.out.println(studentRepository.findStudentByEmail("NgocTri@gmail.com"));
    }
    //Update email by REPO
    @Test
    public void updateStudentEmail() {
        Student student = studentRepository.findById(3L).get();
        student.setEmail("NgocTri@gmail.com");
        studentRepository.save(student);
    }
    //Update Employee by REPO
    @Test
    public void updateStudentREPO() {
        Student student = studentRepository.findById(3L).get();
        student.setFirstName("Nguyen");
        student.setLastName("Ngoc Tri");
        student.setEmail("NgocTri@gmail.com");
        studentRepository.save(student);
    }
    //Update FirstName by JPQL
    @Test
    public void updateFirstNameById() {
        studentRepository.updateFirstNameById(2L, "Dao");
    }
    //Update LastName by Native
    @Test
    public void UpdateLastNameById() {
        studentRepository.updateLastNameById(Long.valueOf(2), "Van An");
    }
    //Delete by REPO
    @Test
    public void delete(){
        studentRepository.deleteById(Long.valueOf(4));
        System.out.println("Thanh cong");
    }
    //Delete By JPQL
    @Test
    public void deleteByEmail(){
        studentRepository.deleteByEmailStudent("fdjfksdf@gmail.com");
        System.out.println("Thanh cong");
    }
    //Delete By JPQL ID
    @Test
    public void deleteById(){
        studentRepository.deleteByIDStudentJPQL(2L);
        System.out.println("Thanh cong");
    }
    //Delete By Native
    @Test
    public void deleteByEmailNative(){
        studentRepository.deleteByStudentNative("VanBau@gmail.com");
        System.out.println("Thanh cong");
    }
    //Delete By Native ID
    @Test
    public void deleteStudentByIDNative(){
        studentRepository.deleteStudentByIDNative(3L);
        System.out.println("Thanh cong");
    }
}
