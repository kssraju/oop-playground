package com.oopPlayground.solidPrinciples.SyntaxHighlighter;

public class ColorWithSyntaxRuleAction extends SyntaxRuleAction {

    String colorWith;

    public ColorWithSyntaxRuleAction(String colorWith) {
        this.colorWith = colorWith;
    }

    @Override
    public String applyTo(String keyword) {
        return "[" + colorWith + "]" + keyword + "[" + colorWith + "]";
    }
}

