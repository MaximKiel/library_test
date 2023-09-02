package com.macon_library_test.validator;

import com.macon_library_test.dao.MaconProjectDAO;
import com.macon_library_test.model.MaconProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MaconProjectValidator implements Validator {

    private final MaconProjectDAO maconProjectDAO;

    @Autowired
    public MaconProjectValidator(MaconProjectDAO maconProjectDAO) {
        this.maconProjectDAO = maconProjectDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return MaconProject.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MaconProject project = (MaconProject) o;
        if (maconProjectDAO.show(project.getId()) != null) {
            errors.rejectValue("id", "", "This id has already taken");
        }
    }
}
