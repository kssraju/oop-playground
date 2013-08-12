package com.oopPlayground.solidPrinciples.SyntaxHighlighter;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SyntaxHighlighterSpec {
    String input = "If we write a program and compile it, then as we run the program, we will get output";

    SyntaxRuleAction colorWithBlue = new ColorWithSyntaxRuleAction("blue");
    SyntaxRuleAction colorWithRed = new ColorWithSyntaxRuleAction("red");
    SyntaxRuleAction colorWithGreen = new ColorWithSyntaxRuleAction("green");

    SyntaxRuleAction capitalizationAsCapital = new CapitalizeSyntaxRuleAction(true);
    SyntaxRuleAction capitalizationAsLower = new CapitalizeSyntaxRuleAction(false);

    SyntaxRuleAction styleAsNormal = new StylizeSyntaxRuleAction("normal");
    SyntaxRuleAction styleAsBold = new StylizeSyntaxRuleAction("bold");

    SyntaxRule colorWithBlueRule = new SyntaxRule(colorWithBlue);
    SyntaxRule colorWithRedRule = new SyntaxRule(colorWithRed);
    SyntaxRule colorWithGreenRule = new SyntaxRule(colorWithGreen);

    SyntaxRule capitalizationAsCapitalRule = new SyntaxRule(capitalizationAsCapital);
    SyntaxRule capitalizationAsLowerRule = new SyntaxRule(capitalizationAsLower);

    SyntaxRule styleAsNormalRule = new SyntaxRule(styleAsNormal);
    SyntaxRule styleAsBoldRule = new SyntaxRule(styleAsBold);

    @Test
    public void shouldHighlightIfToBlueRuleSetMocked() {
        SyntaxRuleSet ruleSet = mock(SyntaxRuleSet.class);
        given(ruleSet.apply("if")).willReturn("[blue]if[blue]");
        SyntaxHighlighter highlighter = new SyntaxHighlighter(ruleSet);
        String output = highlighter.process(input, "if");

        Assert.assertTrue(output.contains("[blue]if[blue]"));
    }

    @Test
    public void shouldHighlightIfToBlueCapsRulesMocked() {
        Map<String, List<SyntaxRule>> ruleMap = new HashMap<>();
        SyntaxRule colorBlueRule = mock(SyntaxRule.class);
        given(colorBlueRule.applyTo("if")).willReturn("[blue]if[blue]");
        SyntaxRule capitalRule = mock(SyntaxRule.class);
        given(capitalRule.applyTo("if")).willReturn("IF");
        ruleMap.put("if", Arrays.asList(colorBlueRule, capitalRule));
        SyntaxRuleSet ruleSet = new SyntaxRuleSet(ruleMap);
        SyntaxHighlighter highlighter = new SyntaxHighlighter(ruleSet);

        String output = highlighter.process(input, "if");

        Assert.assertTrue(output.contains("[blue]IF[blue]"));
    }

    @Test
    public void shouldHighlightIfToBlueCapsBold() {
        Map<String, List<SyntaxRule>> ruleMap = new HashMap<>();
        ruleMap.put("if", Arrays.asList(colorWithBlueRule, capitalizationAsCapitalRule, styleAsBoldRule));
        SyntaxRuleSet ruleSet = new SyntaxRuleSet(ruleMap);
        SyntaxHighlighter highlighter = new SyntaxHighlighter(ruleSet);

        String output = highlighter.process(input, "if");

        Assert.assertTrue(output.contains("[blue][bold]IF[bold][blue]"));
    }

    @Test
    public void shouldHighlightSampleTextWillAllRules() {
        Map<String, List<SyntaxRule>> ruleMap = new HashMap<>();
        ruleMap.put("as", Arrays.asList(colorWithBlueRule, capitalizationAsCapitalRule, styleAsNormalRule));
        ruleMap.put("if", Arrays.asList(colorWithRedRule, capitalizationAsLowerRule, styleAsBoldRule));
        ruleMap.put("and", Arrays.asList(colorWithRedRule, capitalizationAsCapitalRule, styleAsBoldRule));
        ruleMap.put("then", Arrays.asList(colorWithGreenRule, capitalizationAsLowerRule, styleAsNormalRule));
        ruleMap.put("when", Arrays.asList(colorWithBlueRule, capitalizationAsCapitalRule, styleAsNormalRule));

        SyntaxRuleSet ruleSet = new SyntaxRuleSet(ruleMap);

        SyntaxHighlighter highlighter = new SyntaxHighlighter(ruleSet);

        String output = highlighter.process(input, "as", "if", "and", "then", "when");
    }
}
