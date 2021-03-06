package org.starrier.dreamwar.utils.annotation;

import org.springframework.util.StringUtils;
import org.starrier.common.utils.ValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Starrier
 * @date 2019/1/7.
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile isMobile) {
        required = isMobile.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        return required ? ValidatorUtil.isMobile(value) : (StringUtils.isEmpty(value) || ValidatorUtil.isMobile(value));
    }
}
