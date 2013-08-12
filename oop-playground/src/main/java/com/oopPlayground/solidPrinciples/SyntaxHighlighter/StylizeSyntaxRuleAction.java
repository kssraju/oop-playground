package com.oopPlayground.solidPrinciples.SyntaxHighlighter;

public class StylizeSyntaxRuleAction extends SyntaxRuleAction {

    String styleAs;

    public StylizeSyntaxRuleAction(String styleAs) {
        this.styleAs = styleAs;
    }

    @Override
    public String applyTo(String keyword) {
        if (styleAs.equalsIgnoreCase("normal")) {
            return keyword;
        }
        return "[" + styleAs + "]" + keyword + "[" + styleAs + "]";

    }
}
