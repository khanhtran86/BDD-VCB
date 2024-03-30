package vn.vcb.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import vn.vcb.UI.LoginPage;

public class ErrorMessageFromLogin implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LoginPage.ERROR.resolveFor(actor).getText();
    }
}
