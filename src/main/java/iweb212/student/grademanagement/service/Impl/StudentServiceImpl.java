package iweb212.student.grademanagement.service.Impl;


import com.github.pagehelper.Page;
import iweb212.student.grademanagement.dao.StudentDao;
import iweb212.student.grademanagement.model.Student;
import iweb212.student.grademanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
