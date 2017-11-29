package com.atlassian.extras.decoder.v2;

import java.io.IOException;
import java.io.StringReader;
import java.util.Base64;
import java.util.Properties;

import com.atlassian.extras.decoder.api.AbstractLicenseDecoder;

public class Version2LicenseDecoder extends AbstractLicenseDecoder {

    public boolean canDecode(String licenseString) {
        return true;
    }

    protected Properties doDecode(String licenseString) {
        Properties localProps = new MitlabProperties();
        StringReader reader = new StringReader(new String(Base64.getDecoder().decode(licenseString)));
        try {
            localProps.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(new StringBuilder("Invalid license:[").append(licenseString).append("]").toString(), e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                throw new RuntimeException(new StringBuilder("Close stream error for license:[").append(licenseString).append("]").toString(), e);
            }
        }
        return localProps;        
    }

    protected int getLicenseVersion() {
        return 2;
    }
    
}
