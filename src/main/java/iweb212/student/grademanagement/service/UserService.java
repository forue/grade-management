package iweb212.student.grademanagement.service;

import iweb212.student.grademanagement.model.User;

public interface UserService {
    User findUser(String username,String password);
}
