package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DragAndDropPage extends TestPage {

	private static Logger logger = LogManager.getLogger(DragAndDropPage.class.getName());

	public DragAndDropPage(WebDriver driver) {
		super(driver);
		logger.info("Drag and Drop Page OPEN");
		Assert.assertTrue((driver.findElement(By.xpath("//h3")).getText().contains("Drag and Drop")));
	}

	private By squareA = By.xpath("//div[@id = 'column-a']/header[text() = 'A']");
	private By squareB = By.xpath("//div[@id = 'column-b']/header[text() = 'B']");

	public void dragAndDropA() {
		logger.info("Drag Square A and drop it on B");
		verifySquaresBeforeDrop();
		dragAndDrop(squareA, squareB);
		verifySquaresAfterDrop();
	}

	public void dragAndDropB() {
		logger.info("Drag Square B and drop it on A");
		verifySquaresBeforeDrop();
		dragAndDrop(squareB, squareA);
		verifySquaresAfterDrop();
	}

	private void verifySquaresAfterDrop() {
		logger.info("Validate the Drag and Drop worked");
		Assert.assertTrue(isElementPresent(By.xpath("//div[@id = 'column-a']/header[text() = 'B']")));
		Assert.assertTrue(isElementPresent(By.xpath("//div[@id = 'column-b']/header[text() = 'A']")));
	}

	private void verifySquaresBeforeDrop() {
		logger.info("Validate the Squares are in the original position");
		Assert.assertTrue(isElementPresent(squareA));
		Assert.assertTrue(isElementPresent(squareB));

	}
}
