package nyft.diploma.report.model;

/**
 * Created by Vlad on 21.05.2016.
 */
public class ManagerReport {
    private Long managerCode;
    private String initials;
    private Long successfulDeals;
    private String experience;

    public ManagerReport(Long managerCode, String initials, Long successfulDeals, String experience) {
        this.managerCode = managerCode;
        this.initials = initials;
        this.successfulDeals = successfulDeals;
        this.experience = experience;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Long getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(Long managerCode) {
        this.managerCode = managerCode;
    }

    public Long getSuccessfulDeals() {
        return successfulDeals;
    }

    public void setSuccessfulDeals(Long successfulDeals) {
        this.successfulDeals = successfulDeals;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
