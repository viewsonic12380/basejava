package model;

import java.util.Objects;

public class TextSection extends Section {
    private final String content;

    public TextSection(String content) {
        Objects.requireNonNull(content,"content must not be null");
        this.content = content;
    }

    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
//        return Objects.equals(content, that.content);
        return content != null ? content.equals(that.content) : that.content == null;
    }

    @Override
    public int hashCode() {
//        return Objects.hash(content);
        return content != null ? content.hashCode() : 0;
    }
}
