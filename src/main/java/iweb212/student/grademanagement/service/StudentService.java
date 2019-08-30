package iweb212.student.grademanagement.service;

import com.github.pagehelper.Page;
import iweb212.student.grademanagement.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
}
