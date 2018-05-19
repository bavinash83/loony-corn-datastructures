package edu.polymath.loonycorn.ds021.stack;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesisMatcherTest {

  @Test
  public void hasMatchingParens() throws Exception {
    ParenthesisMatcher matcher = new ParenthesisMatcher();
    Assert.assertTrue(matcher.hasMatchingParens("(abcd)"));
    Assert.assertFalse(matcher.hasMatchingParens("{{{{}}"));
    Assert.assertFalse(matcher.hasMatchingParens("{{{{}}})"));
    Assert.assertTrue(matcher.hasMatchingParens("{{{}}}()"));
    Assert.assertFalse(matcher.hasMatchingParens("{{{}}]()"));
    Assert.assertTrue(matcher.hasMatchingParens("{{}}([]){}{}{}{}({[[[[]]]]})"));
    Assert.assertFalse(matcher.hasMatchingParens("}"));

  }

}