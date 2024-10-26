Feature:Scenario1

  @SdetUnicorns
  Scenario Outline: Sign Up For New User
    Given Home Page for SDET Unicorns Page is Opened
    And Click on UserProfile button
    And Click on Register button
    And Enter Username with"<username>"
    And Enter Email with"<email>"
    And Enter Password with"<password>"
    And Select Gender with"<gender>"
    And Click on Register button for submitting
    Then Validate UserProfile contains logout button

    Examples:
      | username | email | password | gender |
      | username | email | password | Female |



