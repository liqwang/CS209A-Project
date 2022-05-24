package edu.sustech.backend.service;

import org.springframework.stereotype.Service;

public interface UpdateService {

    public enum UpdateStatus {
        PROGRESS("In Progress"), SUCCESS("Success"), FAILED("Failed"), NOT_INITIATED("Not initiated");

        String s;

        UpdateStatus(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }
}
