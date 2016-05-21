package nyft.diploma.report.model;

/**
 * Created by Vlad on 22.05.2016.
 */
public class FreeApparmentReport {
    private Long appartmentCode;
    private String adress;
    private Long price;
    private Long appartmentNumber;
    private Long area;
    private Long developerCode;

    public FreeApparmentReport(Long appartmentCode, String adress, Long price, Long appartmentNumber, Long area, Long developerCode) {
        this.appartmentCode = appartmentCode;
        this.adress = adress;
        this.price = price;
        this.appartmentNumber = appartmentNumber;
        this.area = area;
        this.developerCode = developerCode;
    }

    public Long getAppartmentCode() {
        return appartmentCode;
    }

    public void setAppartmentCode(Long appartmentCode) {
        this.appartmentCode = appartmentCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(Long appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getDeveloperCode() {
        return developerCode;
    }

    public void setDeveloperCode(Long developerCode) {
        this.developerCode = developerCode;
    }
}
