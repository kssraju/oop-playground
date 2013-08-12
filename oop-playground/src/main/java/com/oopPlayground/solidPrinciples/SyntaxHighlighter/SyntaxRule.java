package com.oopPlayground.solidPrinciples.SyntaxHighlighter;

public class SyntaxRule {

    private SyntaxRuleAction syntaxRuleAction;

    public SyntaxRule(SyntaxRuleAction action){

        syntaxRuleAction = action;
    }

    public String applyTo(String keyword) {
        return syntaxRuleAction.applyTo(keyword);
    }
}
