package com.ttu.roman.validator;

import com.ttu.roman.form.deviceservice.DeviceServiceActionFormEdit;
import com.ttu.roman.util.Util;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static com.ttu.roman.util.Util.isEmptyOrOnlyWhiteSpaces;

@Component
public class DeviceServiceActionValidator {
    public Map<String, String> validate(DeviceServiceActionFormEdit deviceActionForm) {

        Map<String, String> errorMap = new HashMap<>();

        if(isEmptyOrOnlyWhiteSpaces(deviceActionForm.getActionDescription())) {
           errorMap.put("actionDescription", "Cannot be empty");
        }
        if(!isPositiveInteger(deviceActionForm.getPrice())) {
            errorMap.put("price", "Should be a positive integer");
        }
        if(!isPositiveInteger(deviceActionForm.getServiceAmount())) {
           errorMap.put("serviceAmount", "Should be a positive integer");
        }


        return errorMap;
    }

    private boolean isPositiveInteger(String val) {
        return val != null && val.matches("[1-9][0-9]*");
    }
}
