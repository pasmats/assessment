package com.example.assessment.enumType;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sport {
    Basketball, Football;

    @JsonValue
    public int toValue() {
        return ordinal();
    }

}
