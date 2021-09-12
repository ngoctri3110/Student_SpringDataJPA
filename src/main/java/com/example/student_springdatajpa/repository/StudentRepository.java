package com.example.student_springdatajpa.repository;

import com.example.student_springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    //JPQL findStudentByStudentId
    @Query("select s from Student s where s.studentId = ?1")
    public Student findStudentByStudentID(Long id);

    //Native
    @Query(value = "select * from tbl_student where email = ?1", nativeQuery = true)
    public Student findStudentByEmail(String email);

    //JPQL Update firstName
    @Transactional
    @Modifying
    @Query("update Student s set s.firstName = ?2 where s.studentId = ?1")
    void updateFirstNameById(Long id, String newFirstName);

    //Native Update LastName
    @Transactional
    @Modifying
    @Query(value = "update tbl_student set last_name = ?2 where student_id = ?1", nativeQuery = true)
    void updateLastNameById(Long Id, String newLastName);

    //delete JPQL
    @Transactional
    @Modifying
    @Query("delete from Student s where s.email = ?1")
    void deleteByEmailStudent(String email);

    //delete JPQL by ID
    @Transactional
    @Modifying
    @Query("delete from Student s where s.studentId = ?1")
    void deleteByIDStudentJPQL(Long id);

    //delete Native
    @Transactional
    @Modifying
    @Query(value = "delete from tbl_student where email = ?1", nativeQuery = true)
    void deleteByStudentNative(String email);

    //delete Native by ID
    @Transactional
    @Modifying
    @Query(value = "delete from tbl_student where student_id  = ?1", nativeQuery = true)
    void deleteStudentByIDNative(Long id);
}
