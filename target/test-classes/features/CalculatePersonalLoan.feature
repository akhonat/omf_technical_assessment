@Test
Feature: Calculate Personal Loan Repayment
  Scenario: User wants to be able to calculate repayment amount for personal loan
  Given User has the Old Mutual Finance website open
  When User navigates to the Personal Loans page
  And User navigates to Calculate
  Then The results summary is displayed with repayment amount