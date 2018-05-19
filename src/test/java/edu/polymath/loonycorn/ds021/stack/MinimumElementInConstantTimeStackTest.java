package edu.polymath.loonycorn.ds021.stack;

import org.junit.Assert;
import org.junit.Test;

public class MinimumElementInConstantTimeStackTest {

  @Test(expected = StackUnderflowException.class)
  public void scenario1() {
    MinimumElementInConstantTimeStack<Integer> stack =
        new MinimumElementInConstantTimeStack<Integer>();

    stack.push(2);
    Assert.assertEquals(2, stack.peekMinimum().intValue());

    stack.push(3);
    Assert.assertEquals(2, stack.peekMinimum().intValue());

    stack.push(-1);
    Assert.assertEquals(-1, stack.peekMinimum().intValue());

    stack.push(4);
    Assert.assertEquals(-1, stack.peekMinimum().intValue());

    Assert.assertEquals(4, stack.pop().intValue());
    Assert.assertEquals(-1, stack.peekMinimum().intValue());

    Assert.assertEquals(-1, stack.pop().intValue());
    Assert.assertEquals(2, stack.peekMinimum().intValue());

    Assert.assertEquals(3, stack.pop().intValue());
    Assert.assertEquals(2, stack.peekMinimum().intValue());

    Assert.assertEquals(2, stack.pop().intValue());
    stack.peekMinimum().intValue();
  }

  @Test
  public void scenario2() {
    MinimumElementInConstantTimeStack<Integer> stack =
        new MinimumElementInConstantTimeStack<Integer>();
    for (int i = 0; i > -100; i--) {
      stack.push(i);
      Assert.assertEquals(i, stack.peekMinimum().intValue());
    }
    for (int i = 0; i > -99; i--) {
      int data = stack.pop();
      Assert.assertEquals(data + 1, stack.peekMinimum().intValue());
    }

    Assert.assertEquals(0, stack.peekMinimum().intValue());
    Assert.assertEquals(0, stack.peek().intValue());
  }


  @Test(expected = StackOverflowException.class)
  public void scenario3() {
    MinimumElementInConstantTimeStack<Integer> stack =
        new MinimumElementInConstantTimeStack<Integer>();
    for (int i = 0; i > -101; i--) {
      stack.push(i);
      Assert.assertEquals(i, stack.peekMinimum().intValue());
    }
  }

  @Test
  public void scenario4() {
    MinimumElementInConstantTimeStack<Integer> minimumStack = new MinimumElementInConstantTimeStack();
    minimumStack.push(2);
    minimumStack.push(4);
    minimumStack.push(10);

    Assert.assertEquals(2, minimumStack.peekMinimum().intValue());
    minimumStack.push(1);
    Assert.assertEquals(1, minimumStack.peekMinimum().intValue());
    minimumStack.push(0);
    Assert.assertEquals(0, minimumStack.peekMinimum().intValue());

    minimumStack.pop();
    Assert.assertEquals(1, minimumStack.peekMinimum().intValue());
    minimumStack.pop();
    Assert.assertEquals(2, minimumStack.peekMinimum().intValue());
    minimumStack.pop();
    Assert.assertEquals(2, minimumStack.peekMinimum().intValue());
  }
}