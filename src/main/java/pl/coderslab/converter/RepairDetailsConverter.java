package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.RepairDetailsDao;
import pl.coderslab.domain.RepairDetails;

public class RepairDetailsConverter implements Converter<String, RepairDetails> {

    @Autowired
    private RepairDetailsDao repairDetailsDao;

    @Override
    public RepairDetails convert (String source) {
        return repairDetailsDao.findById(Long.parseLong(source));
    }
}
