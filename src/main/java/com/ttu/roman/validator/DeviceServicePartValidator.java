package com.ttu.roman.validator;


import com.ttu.roman.form.deviceservice.DeviceServiceActionFormEdit;
import com.ttu.roman.form.deviceservice.ServicePartForm;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.ttu.roman.util.Util.isEmptyOrOnlyWhiteSpaces;
import static com.ttu.roman.util.Util.isPositiveInteger;

@Component
public class DeviceServicePartValidator {
    public Map<String, String> validate(ServicePartForm servicePartForm) {

        Map<String, String> errorMap = new HashMap<>();

        if(isEmptyOrOnlyWhiteSpaces(servicePartForm.getPartName())) {
            errorMap.put("partName", "Cannot be empty");
        }
        if(isEmptyOrOnlyWhiteSpaces(servicePartForm.getSerialNo())){
            errorMap.put("serialNo", "Cannot be empty");
        }
        if(!isPositiveInteger(servicePartForm.getPartPrice())) {
            errorMap.put("partPrice", "Should be a positive integer");
        }
        if(!isPositiveInteger(servicePartForm.getPartCount())) {
            errorMap.put("partCount", "Should be a positive integer");
        }

        return errorMap;
    }
}
