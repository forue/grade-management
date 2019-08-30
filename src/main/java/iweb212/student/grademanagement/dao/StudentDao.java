package iweb212.student.grademanagement.dao;

import com.github.pagehelper.Page;
import iweb212.student.grademanagement.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentDao {
    List<Student> findAll();

    Student findById(int sid);

    boolean insert(Student student);
}
