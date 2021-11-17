@Test1
Scenario Outline: User add new addresses
Given user logged on My store
When user click Addresses
And user click Create new address
And user create new address with alias:<Alias>, address:<address>, city:<City>, zip code:<Zip Code>, phone number:<Phone Number>
And user click Save
Then User sees "Information successfully updated"
And close the browser

Examples
  |alias|address|city|zip/postal code|country|phone|
  |1 |Long street|London|78001|England|574658741|