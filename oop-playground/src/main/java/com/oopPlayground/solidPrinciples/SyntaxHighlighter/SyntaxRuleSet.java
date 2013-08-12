package com.oopPlayground.solidPrinciples.SyntaxHighlighter;

import sun.misc.Regexp;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxRuleSet {
    private Map<String, List<SyntaxRule>> rules;

    public SyntaxRuleSet(Map<String, List<SyntaxRule>> rules) {
        this.rules = rules;
    }

    public String apply(String keyword) {
        String highlightedKeyword = keyword;
        if (rules.containsKey(keyword)) {
            for (SyntaxRule syntaxRule : rules.get(keyword)) {
                Pattern matchingKeywordPattern = Pattern.compile("(?i)" + keyword);
                Matcher keywordMatcher = matchingKeywordPattern.matcher(highlightedKeyword);
                if (keywordMatcher.find()) {
                    highlightedKeyword = highlightedKeyword.replaceFirst("(?i)" + keyword, syntaxRule.applyTo(keywordMatcher.group(0)));
                }
            }
        }
        return highlightedKeyword;
    }
}
