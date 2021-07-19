$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/CalculatePersonalLoan.feature");
formatter.feature({
  "name": "Calculate Personal Loan Repayment",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.scenario({
  "name": "User wants to be able to calculate repayment amount for personal loan",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.step({
  "name": "User has the Old Mutual Finance website open",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.userHasTheOldMutualFinanceWebsiteOpen()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to the Personal Loans page",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.userNavigatesToThePersonalLoansPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to Calculate",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.userNavigatesToCalculate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The results summary is displayed with repayment amount",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.theResultsSummaryIsDisplayedWithRepaymentAmount()"
});
formatter.result({
  "status": "passed"
});
});