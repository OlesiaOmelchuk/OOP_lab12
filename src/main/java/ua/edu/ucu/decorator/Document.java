package ua.edu.ucu.decorator;

import lombok.Getter;
import lombok.Setter;

public abstract class Document {
    @Getter @Setter
    protected String gcsPath;
    public abstract String parse();
}
