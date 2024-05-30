package samoy.stack.minstack;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked">最小栈</a>
 */
class MinStack {
    // 使用Deque（双端队列）来存储栈中的元素
    Deque<Integer> xStack;
    // 另一个Deque用于存储到目前为止遇到的最小值
    Deque<Integer> minStack;

    // 构造函数初始化两个栈
    public MinStack() {
        xStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        // 初始化minStack时放入一个极大值，以便首次push时能正确更新最小值
        minStack.push(Integer.MAX_VALUE);
    }

    // push方法将元素val推入栈中，并更新minStack
    public void push(int val) {
        xStack.push(val);
        // 比较当前值与minStack顶元素的最小值，将较小者压入minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // pop方法从xStack和minStack中同时弹出元素，保持它们同步
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    // top方法返回xStack顶部的元素，即最后加入的元素
    public int top() {
        // 检查xStack是否为空，避免空指针异常
        if (xStack.isEmpty()) {
            throw new NullPointerException("Stack is empty");
        }
        return xStack.peek();
    }

    // getMin方法返回minStack顶部的元素，即当前栈中的最小值
    public int getMin() {
        // 检查minStack是否为空，避免空指针异常
        if (minStack.isEmpty()) {
            throw new NullPointerException("Stack is empty");
        }
        return minStack.peek();
    }
}
