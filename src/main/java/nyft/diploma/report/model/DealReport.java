package nyft.diploma.report.model;

/**
 * Created by Vlad on 21.05.2016.
 */
public class DealReport {
    private Long dealCode;
    private String dealDate;
    private String adress;
    private String price;
    private Long clientCode;
    private Long appartmentCode;


    public DealReport(Long dealCode, String dealDate, String adress, String price, Long clientCode, Long appartmentCode) {
        this.dealCode = dealCode;
        this.dealDate = dealDate;
        this.adress = adress;
        this.price = price;
        this.clientCode = clientCode;
        this.appartmentCode = appartmentCode;
    }

    public Long getDealCode() {
        return dealCode;
    }

    public void setDealCode(Long dealCode) {
        this.dealCode = dealCode;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getClientCode() {
        return clientCode;
    }

    public void setClientCode(Long clientCode) {
        this.clientCode = clientCode;
    }

    public Long getAppartmentCode() {
        return appartmentCode;
    }

    public void setAppartmentCode(Long appartmentCode) {
        this.appartmentCode = appartmentCode;
    }
}
