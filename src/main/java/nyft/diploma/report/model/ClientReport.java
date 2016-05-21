package nyft.diploma.report.model;

/**
 * Created by Vlad on 21.05.2016.
 */
public class ClientReport {
    private Long clientCode;
    private String initials;
    private String mobilePhone;
    private String adress;
    private String passportSerial;
    private Long appartmentCode;


    public ClientReport(Long clientCode, String initials, String mobilePhone, String adress, String passportSerial, Long appartmentCode) {
        this.clientCode = clientCode;
        this.initials = initials;
        this.mobilePhone = mobilePhone;
        this.adress = adress;
        this.passportSerial = passportSerial;
        this.appartmentCode = appartmentCode;
    }

    public Long getClientCode() {
        return clientCode;
    }

    public void setClientCode(Long clientCode) {
        this.clientCode = clientCode;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public Long getAppartmentCode() {
        return appartmentCode;
    }

    public void setAppartmentCode(Long appartmentCode) {
        this.appartmentCode = appartmentCode;
    }
}
