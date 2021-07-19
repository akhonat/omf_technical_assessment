package pages;

public class PersonalLoan_Page {

    //Personal Loans page elements
    private String btnCalculate = "//*[@id=\"gatsby-focus-wrapper\"]/om-wc-config/div/om-page/div/div/header/om-header-with-breadcrumbs/div/om-hero-banner/div/div[3]/div[2]/om-hero-banner-content/span/om-button[1]/a";
    private String ddlHowMuchYouNeed = "//*[@id=\"loanAmount\"]/div/div/div/om-form-dropdown-field";
    private String ddlAmountNeeded = "//*[@id=\"R50000\"]";
    private String btnNext = "//*[@id=\"undefined\"]/button";
    private String ddlHowLongToRepay = "//*[@id=\"repaymentDuration\"]/div/div/div/om-form-dropdown-field";
    private String ddlRepayTerm = "//*[@id=\"60 Months\"]";
    private String btnCalc = "/html/body/div/div[1]/om-wc-config/div/om-page/div/div/main/om-application-container/div/om-1-col-layout/div/om-section/div/div[2]/div[2]/div/om-personal-loans-calculator/div/div[2]/div[1]/div[1]/div/om-button/button";
    private String resultSummary = "//*[@id=\"blta0166b1bd8387d20\"]/div/div[2]/div[2]/om-calculator-result";
    private String summaryAmounts = "//*[@id=\"blta0166b1bd8387d20\"]/div/div[2]/div[2]/om-calculator-result/div[2]";
    private String calculatedAmounts = "//*[@id=\"blta0166b1bd8387d20\"]/div/div[2]/div[2]/om-calculator-result/div[2]";

    public String getBtnCalculate() { return btnCalculate; }
    public String getDdlHowMuchYouNeed() { return ddlHowMuchYouNeed; }
    public String getDdlAmountNeeded() { return ddlAmountNeeded; }
    public String getBtnNext() { return btnNext; }
    public String getDdlHowLongToRepay() { return ddlHowLongToRepay; }
    public String getDdlRepayTerm() { return ddlRepayTerm; }
    public String getBtnCalc() { return btnCalc; }
    public String getResultSummary() { return resultSummary; }
    public String getSummaryAmounts() { return summaryAmounts; }
    public String getCalculatedAmounts(){return calculatedAmounts; }

}
