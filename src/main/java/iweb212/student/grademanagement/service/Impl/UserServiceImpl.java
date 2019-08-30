package iweb212.student.grademanagement.service.Impl;

import iweb212.student.grademanagement.dao.UserDao;
import iweb212.student.grademanagement.model.User;
import iweb212.student.grademanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return userDao.findUser(user);
    }
}
