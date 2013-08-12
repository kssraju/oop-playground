package com.oopPlayground.solidPrinciples.SyntaxHighlighter;

public class CapitalizeSyntaxRuleAction extends SyntaxRuleAction {

    private boolean isCapital;

    public CapitalizeSyntaxRuleAction(boolean isCapital) {

        this.isCapital = isCapital;
    }

    @Override
    public String applyTo(String keyword) {
        return isCapital ? keyword.toUpperCase() : keyword.toLowerCase();
    }
}

