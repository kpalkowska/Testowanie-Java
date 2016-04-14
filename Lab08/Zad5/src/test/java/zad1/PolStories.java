package zad1;

import java.util.Locale;
public class PolStories extends LocalizedStories {
    
    @Override
    protected Locale locale() {
        return new Locale("pol");
    }

    @Override
    protected String storyPattern() {
        return "**/*.historia";
    }

    @Override
    protected Object localizedSteps() {
        return new PolSteps();
    }
 
}