package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  @Test
  public void addStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.addStudent(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

  @Test
  public void testDeleteStudent() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);

    Student student = new Student(5L,"John", "Doe");

    when(repo.save(student)).thenReturn(student);
    when(repo.delete(student)).thenReturn(true);
    boolean isDeleted = studentServiceImpl.delete(student);

    assertEquals(true, isDeleted);
  }
  @Test
  public void testFindStudent(){
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);

    List<Student> students = new ArrayList<>();
    students.add(new Student(1L,"John", "Doe"));
    students.add(new Student(2L,"Jane", "Smith"));

    // Act
    when(repo.findAll()).thenReturn(students);
    List<Student> result = studentServiceImpl.findAll();

    // Assert
    assertEquals(students, result);
  }

}