package com.luv2code.cruddemo.DAO;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class StudentImpl implements StudentDAO {
    private EntityManager entity;
    public StudentImpl(EntityManager entity) {
        this.entity = entity;
    }
    @Override
    @Transactional
    public void save(Student thestudent) {
        entity.persist(thestudent);
    }
    @Override
    @Transactional
    public List<Student> display(Student student) {
        TypedQuery<Student> theQuery = entity.createQuery("FROM Student Order by last_name desc", Student.class);
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public  void update(Student student) {
        entity.merge(student);
    }
    @Override
    public Student findById(int sid) {
        return entity.find(Student.class, sid);
    }
    @Override
    @Transactional

    public int delete(int sid) {
        try {
            Student obj = entity.find(Student.class, sid);
            if (obj != null) {
                entity.remove(obj);
                return 1; // Indicate successful deletion
            } else {
                return 0; // Indicate that the entity was not found
            }
        } catch (Exception exception) {
            // Handle any exceptions that may occur during the delete operation
            // You can log the exception or perform other error-handling actions here
            return -1; // Indicate that an error occurred
        }
    }

}


