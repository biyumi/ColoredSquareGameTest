import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ColoredSquareGameTest {
          @Test
          public void change_link_is_on_home_page() {

                   System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                   WebDriver driver = new ChromeDriver();
                   driver.get("http://localhost:4567/games/buggygames/the_coloured_square_game/colouredsquare.html#");
                   WebElement changeLink = driver.findElement(By.id("changeLink"));
                   assertTrue((changeLink.isDisplayed()));
                   driver.close();       
          }
          
          @Test
          public void click_change_link_changes_color() {

                   System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                   WebDriver driver = new ChromeDriver();
                   driver.get("http://localhost:4567/games/buggygames/the_coloured_square_game/colouredsquare.html#");
                   String colorBefore = driver.findElement(By.id("theSquare")).getCssValue("background-color");
                   driver.findElement(By.id("changeLink")).click();
                   String colorAfter = driver.findElement(By.id("theSquare")).getCssValue("background-color");
                   assertTrue(!colorBefore.equals(colorAfter));
                   driver.close();       
          }
          
          @Test
          public void change_link_displays_correct_color() {

                   System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                   WebDriver driver = new ChromeDriver();
                   driver.get("http://localhost:4567/games/buggygames/the_coloured_square_game/colouredsquare.html#");
                   driver.findElement(By.id("changeLink")).click();
                   String actualColor = driver.findElement(By.id("theSquare")).getAttribute("style").replace("background-color: ", "").replace(";","");
                   String changeLinkColor = driver.findElement(By.id("changeLink")).getText().replace("Change From ", "");
                   assertTrue(actualColor.contentEquals(changeLinkColor));
                   driver.close();       
          }
          
          @Test
          public void status_correct_for_non_red_square() {

                   System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                   WebDriver driver = new ChromeDriver();
                   driver.get("http://localhost:4567/games/buggygames/the_coloured_square_game/colouredsquare.html#");
                   String color = "red";
                   while(!color.equals("red")){
                	   driver.findElement(By.id("changeLink")).click();
                       color = driver.findElement(By.id("theSquare")).getAttribute("style").replace("background-color: ", "").replace(";","");
                   }
                   driver.findElement(By.id("theButton")).click();
                   String status = driver.findElement(By.id("status")).getText();
                   assertTrue(status.equals("Losing..."));
                   driver.close();       
          }
          
          @Test
          public void red_square_exists() {

                   System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                   WebDriver driver = new ChromeDriver();
                   driver.get("http://localhost:4567/games/buggygames/the_coloured_square_game/colouredsquare.html#");
                   int count = 0;
                   boolean notFound = true;
                   while(count < 100 && notFound){
                	   driver.findElement(By.id("changeLink")).click();
                       String color = driver.findElement(By.id("theSquare")).getAttribute("style").replace("background-color: ", "").replace(";","");
                       if(!color.equals("red")) {
                    	   count ++;
                       }else {
                    	   notFound = false;
                       }
                       
                   }
                   assertFalse(notFound);
                   driver.close();       
          }
}