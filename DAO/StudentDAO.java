package com.luv2code.cruddemo.DAO;
import com.luv2code.cruddemo.entity.Student;
import java.util.List;
public interface StudentDAO {
        void save(Student theStudent);
        List<Student> display(Student student);
         void update(Student student);
         Student findById(int sid);
         int delete(int sid);
}


