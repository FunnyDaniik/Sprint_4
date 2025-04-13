package ru.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    //Создали драйвер
    private WebDriver driver;

    // Локаторы на всей страницы сайта
    // локатор кнопки заказать в шапке страницы
    private final By headerOrderButton = By.cssSelector("button[class='Button_Button__ra12g']");
    // локатор кнопки куки
    private final By cookieButton = By.className("App_CookieButton__3cvqF");
    // локатор кнопки заказать в теле страницы
    private final By orderButtonDown = By.className("Button_Middle__1CSJM");
    // локатор раскрывающего блока с вопросами
    private final By accordionHeader = By.className("accordion__button");
    // локатор раскрывающего блока
    private final By accordionItem = By.xpath(".//div[@class='accordion__panel']/p");


    //Конструктор класса MainPage
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод для использования локаторов
    // Метод принятие cookie
    public void clickOnCookieButton() {
        driver.findElement(cookieButton).click();
    }
    //Метод ожидания загрузки панели с ответом на вопросы
    public void waitLoadAccordionItem(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElements(accordionItem).get(index)));
    }
    //Метод для получения текста из заголовка блока с вопросами
    public String getTextHeaderAccordion(int index) {
        return driver.findElements(accordionHeader).get(index).getText();
    }
    //Метод для нажатия на блок с вопросом
    public void clickHeaderAccordion(int index) {
        driver.findElements(accordionHeader).get(index).click();
    }
    //Метод для получения текста из панели блока вопросов
    public String getTextItemAccordion(int index) {
        return driver.findElements(accordionItem).get(index).getText();
    }

    //Метод для проверки раскрытия блока с вопросом
    public boolean isAccordionItemOpen(int index) {
        return driver.findElements(accordionItem).get(index).isDisplayed();
    }

    //Метод для нажатия на кнопку заказать в шапке страницы
    public void clickOrderButtonHeader(){
        driver.findElement(headerOrderButton).click();
    }

    //Метод для нажатия на кнопку заказать в теле страницы
    public void clickOrderButtonBody(){
        driver.findElement(orderButtonDown).click();
    }

}
