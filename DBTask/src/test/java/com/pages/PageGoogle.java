package com.pages;


import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;


public class PageGoogle extends Form {

    public PageGoogle() {
        super(By.xpath("//img[@alt='Google']"), "Google");
    }

    private final ITextBox googleSearchBox = getElementFactory().getTextBox
            (By.name("q"), "google Search Box");

    public void inputText(String Text) {
        googleSearchBox.state().waitForDisplayed();
        googleSearchBox.type(Text);
    }

    public void selectText() {
        googleSearchBox.submit();
    }


    private final ILabel getTitle = getElementFactory().getLabel
            (By.xpath("//div[@class='SPZz6b']//h2"), "Text 'Беларусь'");


    public String checkText1() {
        getTitle.state().waitForDisplayed();
        return getTitle.getText();

    }

}
