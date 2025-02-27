package com.hannam.rental.hannam_rental.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum College {
    ENGINEERING("공과대학"),
    SMART_CONVERGENCE("스마트융합대학");

    private final String collegeName;

    College(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    //String을 ENUM으로 변환
    @JsonCreator
    public static College fromString(String collegeName) {
        for (College college : College.values()) {
            if (college.collegeName.equals(collegeName)) {
                return college;
            }
        }
        throw new IllegalArgumentException("해당하는 단과대학이 없습니다: " + collegeName);
    }
}
