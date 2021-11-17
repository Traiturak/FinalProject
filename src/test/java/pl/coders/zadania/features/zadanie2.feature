@Test2
Scenario Outline: Adding product on My Store and pay for it.

Given user login in my-store-testlab.coderslab.pl/
When user click in SignIn Button to login
When user login on my-store-testlab.coderslab.pl with email:lawfrankgroup@gmail.com and password: 5555555555
When user go back to main page
When user search the product: Hummingbird Printed Sweater
When  user choose my product from results
When user choose the size: M and quantity which is equal 5 of product and I add to cart
When user proceed to checkout
And user make doublecheck in order and click proceed to checkout.
When user Confirm address
When user choose pick up method as PrestaShop "pick up in store"
When user choose payment method: Pay by check
Then user make screen shot

#    Examples:
#      | name OF Product             |size|quantity|
#      | Hummingbird Printed Sweater |M   |5       |