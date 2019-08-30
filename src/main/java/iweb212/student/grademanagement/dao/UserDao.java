package iweb212.student.grademanagement.dao;

import iweb212.student.grademanagement.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User findUser(User user);
}
