package pages;

public class Home_Page {

    //Web page elements
    private String mnuPersonal = "//*[@id=\"gatsby-focus-wrapper\"]/om-wc-config/div/om-page/div/div/header/om-segment-landing-header/div/om-main-navigation/div[1]/nav/div[1]/div[2]/om-main-navigation-menu/ul/li[1]/a";
    private String mnuOurSolutions = "/html/body/om-wc-config/div/om-solutions-detail-page/om-page/div/div/div/div/header/div/om-header-with-breadcrumbs/div/om-main-navigation/div[1]/nav/div[1]/div[2]/om-main-navigation-menu/ul/li[1]/ul/li[3]/a";
    private String lnkPersonalLoans = "//*[@id=\"app\"]/div/om-solutions-detail-page/om-page/div/div/div/div/header/div/om-header-with-breadcrumbs/div/om-main-navigation/div[1]/nav/div[1]/div[2]/om-main-navigation-menu/ul/li[1]/ul/li[3]/ul/li[1]/ul/li[2]/a/span";

    public String getMnuPersonal() { return mnuPersonal; }
    public String getMnuOurSolutions() { return mnuOurSolutions; }
    public String getLnkPersonalLoans() { return lnkPersonalLoans; }
}
