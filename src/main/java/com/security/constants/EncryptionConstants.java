package com.security.constants;

import lombok.Getter;

@Getter
public enum EncryptionConstants {

    ALGORITHM("AES/GCM/NoPadding"),
    KEY_LENGTH(256),
    GCM_IV_LENGTH(12),
    GCM_TAG_LENGTH(128),
    SALT_LENGTH(16),
    ITERATIONS(100000);

    private final Object value;

    EncryptionConstants(Object value) {
        this.value = value;
    }

    public String getStringValue() {
        return (String) value;
    }

    public int getIntValue() {
        return (Integer) value;
    }

}
