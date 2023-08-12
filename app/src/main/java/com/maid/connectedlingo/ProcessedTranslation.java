package com.maid.connectedlingo;

public class ProcessedTranslation {


    private String sourceLangauge;
    private String input;
    private String targetLanguage;
    private String output;

    public ProcessedTranslation(String sourceLanguage, String input, String targetLanguage, String output)
    {
        this.sourceLangauge = sourceLanguage;
        this.input = input;
        this.targetLanguage = targetLanguage;
        this.output = output;
    }

    public String getSourceLangauge() {
        return sourceLangauge;
    }

    public void setSourceLangauge(String sourceLangauge) {
        this.sourceLangauge = sourceLangauge;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String toString(){
        return "\nSource Language: " + sourceLangauge +
                "\nInput: " + input +
                "\nTarget Language: " + targetLanguage +
                "\nOutput: " + output +"\n\n";
    }
}
