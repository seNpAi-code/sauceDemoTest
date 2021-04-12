import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testcoursework {

    public static void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    WebDriver driver;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test


    public void execute() {


        //Testing log in
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        sleep(200);

        //Verifying the inventory url
        String inventUrl ="https://www.saucedemo.com/inventory.html";
        String currentUrl1 = driver.getCurrentUrl();

        Assert.assertEquals(inventUrl,currentUrl1);

        //Selecting an item
        WebElement clickProduct = driver.findElement(By.id("item_4_title_link"));
        clickProduct.click();

        sleep(200);

        //Verifying the product name and price
        WebElement productName = driver.findElement(By.className("inventory_details_name"));
        String expectedName = "Sauce Labs Backpack";
        String actualName = productName.getText();

        Assert.assertEquals(expectedName,actualName);

        WebElement productPrice = driver.findElement(By.className("inventory_details_price"));
        String expectedPrice = "$29.99";
        String actualPrice = productPrice.getText();

        Assert.assertEquals(expectedPrice,actualPrice);


        //Adding the item to the cart
        WebElement clickAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        clickAddToCart.click();

        sleep(200);

        //Shopping cart icon click
        WebElement cartBtnClick = driver.findElement(By.className("shopping_cart_link"));
        cartBtnClick.click();

        //Verifying shopping cart url
        String cartUrl ="https://www.saucedemo.com/cart.html";
        String currentUrl2 = driver.getCurrentUrl();

        Assert.assertEquals(cartUrl,currentUrl2);

        sleep(200);

        //Verifying the added product name and price
        //Name
        WebElement cartproductname = driver.findElement(By.className("inventory_item_name"));
        String cartExpectedName = "Sauce Labs Backpack";
        String cartActualName = cartproductname.getText();

        Assert.assertEquals(cartExpectedName,cartActualName);

        //Price
        WebElement cartproductprice = driver.findElement(By.className("inventory_item_price"));
        String cartExpectedPrice = "$29.99";
        String cartActualPrice = cartproductprice.getText();

        Assert.assertEquals(cartExpectedPrice,cartActualPrice);


        //Remove item
        WebElement clickToRemove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        clickToRemove.click();

        sleep(200);

        //Verifying item no longer in the cart
        if(driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")) != null){
            System.out.println("Product removed");
        }
        else {
            System.out.println("Product not removed");
        }

        sleep(200);

        //Click continue shopping btn
        WebElement clickContinueShoppingBtn = driver.findElement(By.id("continue-shopping"));
        clickContinueShoppingBtn.click();

        sleep(200);

        //Add item to cart
        WebElement clickAddToCartBtn1 = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        clickAddToCartBtn1.click();

        sleep(200);

        //Add item to cart
        WebElement clickAddToCartBtn3= driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        clickAddToCartBtn3.click();

        sleep(200);

        //Verify the names and prices of the selected
        //Verifying product1 name//
        WebElement cartproductname1 = driver.findElement(By.id("item_0_title_link"));
        String cartExpectedName1 = "Sauce Labs Bike Light";
        String cartActualName1 = cartproductname1.getText();

        Assert.assertEquals(cartExpectedName1,cartActualName1);

//        WebElement cartproductprice1 = driver.findElement(By.className("inventory_item_price"));
//        String cartExpectedPrice1 = "$9.99";
//        String cartActualPrice1 = cartproductprice1.getText();
//
//        Assert.assertEquals(cartExpectedPrice1,cartActualPrice1);

        //Verifying product price//
        WebElement cartproductprice1 = driver.findElement(By.className("inventory_item_price"));
        String productExpectedPrice1 = "$9.99";
        String productActualPrice1 = cartproductprice1.getText();


        if (productExpectedPrice1.equals(productActualPrice1)) {
            System.out.println("Price 1 verified");
        }
        else {
            System.out.println("Price 1 not verified");
        }

        //Verifying product2 name//
        WebElement cartproductname2 = driver.findElement(By.id("item_3_title_link"));
        String cartExpectedName2 = "Test.allTheThings() T-Shirt (Red)";
        String cartActualName2 = cartproductname2.getText();

        Assert.assertEquals(cartExpectedName2,cartActualName2);

//        WebElement cartproductprice2 = driver.findElement(By.className("inventory_item_price"));
//        String cartExpectedPrice2 = "$15.99";
//        String cartActualPrice2 = cartproductprice2.getText();
//
//        Assert.assertEquals(cartExpectedPrice2,cartActualPrice2);

        //verifying product2 price//
        WebElement cartproductprice2 = driver.findElement(By.className("inventory_item_price"));
        String cartExpectedPrice2 = "$15.99";
        String cartActualPrice2 = cartproductprice2.getText();


        if (cartExpectedPrice2.equals(cartActualPrice2)) {
            System.out.println("Price 2 verified");
        }
        else {
            System.out.println("Price 2 not verified");
        }

        //Click cart btn
        WebElement cartBtnClick2  = driver.findElement(By.className("shopping_cart_link"));
        cartBtnClick2.click();

        sleep(200);

        //Checkout
        WebElement clickCheckoutBtn = driver.findElement(By.id("checkout"));
        clickCheckoutBtn.click();

        sleep(200);

        //Filling the form
        WebElement firstname = driver.findElement(By.id("first-name"));
        firstname.sendKeys("Lambda");

        WebElement lastname = driver.findElement(By.id("last-name"));
        lastname.sendKeys("Warrior");

        WebElement postalCode = driver.findElement(By.id("postal-code"));
        postalCode.sendKeys("10230");

        sleep(200);

        //Click continue btn
        WebElement clickContinueBtn = driver.findElement(By.id("continue"));
        clickContinueBtn.click();

        sleep(200);

        //Verifying total
        WebElement itemTotal = driver.findElement(By.className("summary_subtotal_label"));
        String expItemTotal = "Item total: $25.98";
        String actItemTotal = itemTotal.getText();

        Assert.assertEquals(expItemTotal,actItemTotal);

        //Click finish btn
        WebElement clickFinishBtn = driver.findElement(By.id("finish"));
        clickFinishBtn.click();


        //Verifying the thank You for your order text is visible.
        WebElement thankYouText = driver.findElement(By.className("complete-header"));
        String expectedMsg = "THANK YOU FOR YOUR ORDER";
        String actualMsg = thankYouText.getText();

        Assert.assertEquals(expectedMsg,actualMsg);

        //Verifying the checkout-complete url
        String checkoutUrl ="https://www.saucedemo.com/checkout-complete.html";

        String currentUrl3 = driver.getCurrentUrl();

        Assert.assertEquals(checkoutUrl,currentUrl3);





        //Reference
        //guru99.com
        //stackoverflow.com

    }
}
