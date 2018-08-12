package tnk.gesture.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestErrorInfo {

    public final String detail;
    public final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }

}
