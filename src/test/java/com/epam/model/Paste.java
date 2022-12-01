package com.epam.model;

import java.util.Objects;

public class Paste {
    private String name;
    private String paste;
    private String highlighting;
    private String expirationTime;

    public Paste(String paste) {
        this.paste = paste;
    }

    public Paste(String name, String paste, String highlighting, String expirationTime) {
        this.name = name;
        this.paste = paste;
        this.highlighting = highlighting;
        this.expirationTime = expirationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaste() {
        return paste;
    }

    public void setPaste(String paste) {
        this.paste = paste;
    }

    public String getHighlighting() {
        return highlighting;
    }

    public void setHighlighting(String highlighting) {
        this.highlighting = highlighting;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paste that = (Paste) o;
        return expirationTime.equals(that.expirationTime) && name.equals(that.name) && paste.equals(that.paste) && highlighting.equals(that.highlighting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, paste, highlighting, expirationTime);
    }

    @Override
    public String toString() {
        return "PasteWithParameters{" +
                "name='" + name + '\'' +
                ", paste='" + paste + '\'' +
                ", highlighting='" + highlighting + '\'' +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
