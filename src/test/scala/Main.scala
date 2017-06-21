/**
  * Created by primko on 6/17/17.
  */
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide._
import org.scalatest.FlatSpec

class Main extends FlatSpec {

  System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver")
  System.setProperty("phantomjs.binary.path", "src/drivers/phantomjs")
  Configuration.browser = "phantomjs"
  Configuration.reportsFolder = "target/screenshots"
  Configuration.fastSetValue = true

  it should "open site" in {
    open("https://retailedge.intel.com/50/landing")
  }

  it should "be login" in {
    $(".external-login-textbox").setValue(System.getProperty("name", ""))
    $(".userlogin-password>input").setValue(System.getProperty("password", ""))
    $(".external-login-button").submit()
    println(title())
  }

  it should "be open shop" in {
    open("https://retailedge.intel.com/50/emea/store/index")
    val count = $$(".resource-module-details").size()
    for (i <- 0 until count) markup($$(".resource-module").get(i).toString)
    for (i <- 0 until count) {
      assert ($$(".resource-module-details").get(i).text() contains "Продано", "Доступно!")
    }
  }
}
