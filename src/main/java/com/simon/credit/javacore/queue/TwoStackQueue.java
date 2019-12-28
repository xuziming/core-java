package com.simon.credit.javacore.queue;

import java.util.Stack;

/**
 * 题目：如何用两个栈模拟实现一个队列?
 * <pre>
 * 若这两个堆栈的容量分别是m和n（m>n)，你的方法能保证队列的最大容量是多少？（这里讨论的是顺序栈，如果是链式栈的话完全没有必要考虑空间）
 * 分析：栈的特点是“后进先出(LIFO)”，而队列的特点是“先进先出(FIFO)”。
 * 
 * 实现思路：用一个栈作为存储空间，另一个栈作为输出缓冲区，入队时把元素按顺序压入两栈模拟的队列，出队时按入队的顺序出栈即可。
 * 
 * 如下图，用容量为m（较大的）的栈作为存储空间，容量为n的栈作为输出缓冲区，先将入队的前n个元素push进存储空间栈
 * 随后对存储空间栈中的每个元素进行出栈(pop)操作，继而压入(push)输出缓冲区栈，如下图所示
 * 对于剩余入队的前n+1个元素，将他们压入存储空间栈，两个栈的状态如下图：
 * 此时已经入队了2n+1个元素，<B>若此时进行出队操作</B>，先将输出缓冲区栈中的元素出栈(pop),
 * 并输出：Q1,Q2,......,Qn，再对存储空间栈中的n个元素进行出栈(pop)并压入输入缓冲区栈，状态图如下：
 * 然后对存储空间栈进行一次出栈(pop)操作并输出：Qn+1，最后再对输出缓冲区栈中的所有元素进行出栈(pop)操作并输出Qn+2,Qn+3,......,Q2n,Q2n+1。
 * 这样两个栈总的输出序列为：Q1,Q2,......,Qn,Qn+1,Qn+2,Qn+3,......,Q2n,Q2n+1，符合队列“先进先出”的特性，模拟成功。
 * 
 * <B>但是如果前面蓝字的假设不成立，即在已经入队了2n+1个元素的情况下，还要继续向队列中添加更多的元素，将无法满足按入队的顺序出队</B>
 * 综上所述，两个栈所模拟的队列的最大容量为2n+1。
 * </pre>
 */
public class TwoStackQueue<T> {

	private Stack<T> stackFrom = new Stack<T>();
	private Stack<T> stackTo = new Stack<T>();
	private volatile int size = 0;// 队列长度

	/**
	 * 入队
	 * <pre>
	 * add方法在添加元素的时候，若超出了度列的长度会直接抛出异常：java.lang.IllegalStateException: Queue full.
	 * offer方法在添加元素时，若发现队列已满无法添加的话，会直接返回false.
	 * put方法在向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素.
	 * </pre>
	 */
	public void offer(T t) {
		size++;
		stackFrom.add(t);
	}

	/**
	 * 出队
	 * <pre>
	 * 从队列中取出并移除头元素的方法有：poll，remove，take.
	 * poll  :若队列为空，返回null.
	 * remove:若队列为空，抛出NoSuchElementException异常.
	 * take  :若队列为空，发生阻塞，等待有元素。
	 * </pre>
	 */
	public T poll() {
		if (stackTo.isEmpty()) {
			if (stackFrom.isEmpty()) {
				return null;
			} else {
				transfer();
			}
		}

		size--;
		return stackTo.pop();
	}

	/**
	 * 栈From元素转移到栈To
	 */
	private void transfer() {
		while (!stackFrom.isEmpty()) {
			stackTo.push(stackFrom.pop());
		}
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		TwoStackQueue<String> queue = new TwoStackQueue<String>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		queue.offer("f");
		queue.offer("g");
		queue.offer("h");
		queue.offer("i");

		int size = queue.size();
		for (int i = 0; i < size; i++) {
			System.out.println(queue.poll());
			System.out.println(queue.size());
		}
	}

}