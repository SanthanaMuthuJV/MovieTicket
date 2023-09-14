package org.baseticket;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassCucu {

	public static WebDriver driver;

	public static void browserLanch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void urlLanch(String url) {
		driver.get(url);
	}

	public static void closeTap() {
		driver.close();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void refreshBase() {
		driver.navigate().refresh();

	}

	public static void sendKeys(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	public static void clickWebElement(WebElement btnElement) {
		btnElement.click();
	}

	public static void getTxt(WebElement ref) {
		String text = ref.getText();
		System.out.println(text);

	}

	public static void getInsertTxt(WebElement ref) {
		String insert = ref.getAttribute("value");
		System.out.println(insert);
	}

	public static void getCurrentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void getCurrentPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void maxWin() {
		driver.manage().window().maximize();

	}

	// Screenshot
	public static void getTheScreenshot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File desc = new File("C:\\Users\\USER\\Pictures\\Saved Pictures\\" + name + ".png");
		FileUtils.copyFile(src, desc);
	}

	// Actions
	public static void mouseOver(WebElement elementRef) {
		Actions a = new Actions(driver);
		a.moveToElement(elementRef).perform();
	}

	public static void rightClick(WebElement elementRef) {
		Actions a = new Actions(driver);
		a.contextClick(elementRef).perform();
	}

	public static void doubleClicks(WebElement elementRef) {
		Actions a = new Actions(driver);
		a.doubleClick(elementRef).perform();
	}

	public static void dragAndDrops(WebElement src, WebElement tar) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, tar).perform();
	}

	public static void wantAllCapital(WebElement refName, String text) {
		Actions a = new Actions(driver);
		a.keyDown(refName, Keys.SHIFT).sendKeys(refName, text).keyUp(refName, Keys.SHIFT).perform();

	}

	// Alert
	public static void simpleAlertOk() {
		Alert ale = driver.switchTo().alert();
		ale.accept();
	}

	public static void confirmAlertOk() {
		Alert ale = driver.switchTo().alert();
		ale.accept();
	}

	public static void confirmAlertCancel() {
		Alert ale = driver.switchTo().alert();
		ale.dismiss();
	}

	public static void promptAlertOk(String text) {
		Alert ale = driver.switchTo().alert();
		ale.sendKeys(text);
		ale.accept();
	}

	public static void promptAlertCancel() {
		Alert ale = driver.switchTo().alert();
		ale.dismiss();

	}

	// Robot
	public static void downKeyBttnRobot(int howmany) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < howmany; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void copyPasteRobot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

	public static void cutPasteRobot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}

	// frame
	public static void frameIndexClick(int index, WebElement refname) {
		driver.switchTo().frame(index);

		refname.click();

	}

	public static void frameIndexSendkeys(int index, WebElement refname, String text) {
		driver.switchTo().frame(index);

		refname.sendKeys(text);

	}

	public static void frameIdOrName(String idOrName, WebElement refname) {
		driver.switchTo().frame(idOrName);
		refname.click();
	}

	// javascript
	public static void scrollDownJS(WebElement refname) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true)", refname);
		String text = refname.getText();
		System.out.println(text);
	}

	public static void scrollUpJS(WebElement refname) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(false)", refname);
		String text = refname.getText();
		System.out.println(text);

	}

	
	public static void implicity() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

//
//	
//   public static void explicit() {
//	   
//	  WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
//}

	public static String excelRead(String pathname, String sheetname, int rownumber, int cellnumber)
			throws IOException {
		File f = new File(pathname);

		FileInputStream first = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(first);

		Sheet s = w.getSheet(sheetname);

		Row r = s.getRow(rownumber);

		Cell c = r.getCell(cellnumber);

		int cellType = c.getCellType();

		// by default cellType ==1 ---> String Cell
		// if cellType otherthan 1 ---> Date Cell / numeric Cell
		String value = "";
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
			value = simple.format(d);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);

		}
		return value;

	}

	public static void sendValueRowAndCell(Sheet refsheetname, int rownumber, int cellnumber, String stringvalue) {
		Row newrow = refsheetname.getRow(rownumber);
		Cell newcell = newrow.getCell(cellnumber);
		newcell.setCellValue(stringvalue);

	}

	public static void createNewRowAndCell(Sheet sheetref) {

		for (int i = 0; i < 20; i++) {
			Row newrow = sheetref.createRow(i);
			for (int k = 0; k < 20; k++) {
				Cell newcell = newrow.createCell(k);
			}
		}
	}

	public static void updateRowAndCellValue(String pathname, String sheetname, int rownumber, int cellnumber,
			String eqlvalue, String newvalue) throws IOException {
		File f = new File(pathname);
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rownumber);
		Cell cell = row.getCell(cellnumber);
		String value = cell.getStringCellValue();
		if (value.equals(eqlvalue)) {
			cell.setCellValue(newvalue);

		}
		FileOutputStream fileout = new FileOutputStream(f);
		w.write(fileout);

	}

	public static void windowHand(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);

	}

	public static String dbDatas() {

		Connection con = null;
		String nameclum = "";
		// 1.load the driver-oracle.jdbc.driver.OracleDriver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // throw - ClassNotFoundException

			// 2.connect to database=jdbc:orcle:thin:@localhost:1521:ex
			con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "hr", "tomjerry");

			// 3. write a SQL Query
			String que = "select first_name from employees where first_name='Amit'";

			// 4.prepare the statement

			PreparedStatement pr = con.prepareStatement(que);

			// 5.execute query

			ResultSet ex = pr.executeQuery();

			// 6.Iterate the row one by one from table
			// if row presented in a table it will return true otherwise it will return
			// false
			for (int i = 0; i < que.length(); i++) {

				if (ex.next()) {

					nameclum = ex.getString("first_name");
					System.out.println(nameclum);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				// 7.close the db connection
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return nameclum;

	}
}
