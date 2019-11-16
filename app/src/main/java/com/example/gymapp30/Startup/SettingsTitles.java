package com.example.gymapp30.Startup;

public class SettingsTitles {

    private String Title,
            Hint;

    public SettingsTitles(String title, String hint) {
        Title = title;
        Hint = hint;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getHint() {
        return Hint;
    }

    public void setHint(String hint) {
        Hint = hint;
    }
}
