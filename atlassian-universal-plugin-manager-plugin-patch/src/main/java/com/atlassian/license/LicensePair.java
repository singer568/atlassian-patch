package com.atlassian.license;

public class LicensePair {
    public static final byte[] NEW_LICENSE_PREFIX = { 13, 14, 12, 10, 15 };
    private final byte[] license;
    private final byte[] hash;
    private final String originalLicenseString;
    private final boolean isNG;

    public LicensePair(byte[] license, byte[] hash) throws LicenseException {
        this.license = license;
        this.hash = hash;
        this.isNG = true;
        this.originalLicenseString = new String(license);
    }

    public LicensePair(byte[] text, byte[] hash, String originalString) {
        this.license = text;
        this.hash = hash;
        this.isNG = true;
        this.originalLicenseString = originalString;
    }

    public LicensePair(String license, String hash) throws LicenseException {
        if ((license == null) || (hash == null)) {
            throw new LicenseException("License string or hash are null.");
        }
        try {
            this.license = license.getBytes();
            this.hash = hash == null ? new byte[0] : hash.getBytes();
            this.isNG = true;
            this.originalLicenseString = license;
        } catch (Exception e) {
            throw new LicenseException("Exception generating license: " + e);
        }
    }

    public LicensePair(String concatLicense) throws LicenseException {
        if (concatLicense == null) {
            throw new LicenseException("contactLicense was null");
        }
        this.originalLicenseString = concatLicense;
        this.hash = new byte[0];
        this.license = concatLicense.getBytes();
        this.isNG = true;
    }

    public boolean isNG() {
        return this.isNG;
    }

    public byte[] getLicense() {
        return this.license;
    }

    public String getLicenseString() {
        return LicenseUtils.getString(this.license);
    }

    public byte[] getHash() {
        return this.hash;
    }

    public String getHashString() {
        return LicenseUtils.getString(this.hash);
    }

    public String getOriginalLicenseString() {
        return this.originalLicenseString;
    }

    public String toString() {
        return this.originalLicenseString;
    }
}
