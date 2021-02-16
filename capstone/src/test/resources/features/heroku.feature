Feature: Heroku Applications and Webpages
    This is a basic demonstration of utilizing Cucumber and TestNG
    to highlight the useage of these technologies and a tutorial
    for someone to follow along

    Scenario: Verify the functinality of the Checkbox Page
        Given I am on the Checkbox Page
        When I click on all checkboxes
        Then all the checkboxes will be active
    
    Scenario: Verify the behavior of the Modal Pagetitle
        Given I am on the Modal Page
        When I open the modal on the webpage
        Then I can close it with the close button
    
    Scenario Outline: Verify that the Date Picker can choose several dates
        Given I am on the Datepicker Page
        When I click on the text field
        Then I can select a date with <day>, <month>, and <year>
        And the full date should display on the text field

     Examples:
        | day | month | year |
        |  16 |    10 | 2010 |
        |  03 |     8 | 2015 |
        |  24 |     5 | 2000 |