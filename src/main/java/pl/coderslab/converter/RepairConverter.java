package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.RepairDao;
import pl.coderslab.domain.Repair;

public class RepairConverter implements Converter<String, Repair> {

    @Autowired
    private RepairDao repairDao;

    @Override
    public Repair convert(String source) {
        return repairDao.findById(Long.parseLong(source));
    }
}
