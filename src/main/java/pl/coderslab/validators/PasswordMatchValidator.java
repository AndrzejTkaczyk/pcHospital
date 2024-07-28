//package pl.coderslab.validators;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, String>{
//
//    @Override
//    public void initialize(PasswordMatch constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (value.equals(user.getPasswordRepetition())) {
//            return true;
//        }
//        return false;
//    }
//}
