package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.ComputerDao;
import pl.coderslab.domain.Computer;

public class ComputerConverter implements Converter<String, Computer>{

    @Autowired
    private ComputerDao computerDao;

    @Override
    public Computer convert (String source) {
        return computerDao.findById(Long.parseLong(source));
    }

}
