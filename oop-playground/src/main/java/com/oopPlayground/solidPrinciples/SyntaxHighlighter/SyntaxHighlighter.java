package com.oopPlayground.solidPrinciples.SyntaxHighlighter;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxHighlighter {

    SyntaxRuleSet syntaxRuleSet;

    public SyntaxHighlighter(SyntaxRuleSet syntaxRuleSet) {
        this.syntaxRuleSet = syntaxRuleSet;
    }

    public String process(String input, String... keywords) {
        String output = input;
        for (String keyword : keywords) {
            String highlightedKeyword = syntaxRuleSet.apply(keyword);
            Pattern matchingKeywordPattern = Pattern.compile("(?i)" + keyword);
            Matcher keywordMatcher = matchingKeywordPattern.matcher(input);
            if (keywordMatcher.find()) {
                output = output.replaceAll("(?i)" + keyword, highlightedKeyword);
            }
        }
        return output;
    }
}
