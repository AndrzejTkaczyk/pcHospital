package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.UserDao;
import pl.coderslab.domain.User;

public class UserConverter implements Converter<String, User> {
    @Autowired
    private UserDao userDao;
    @Override
    public User convert (String source) {
        return userDao.findById(Long.parseLong(source));
    }
}
