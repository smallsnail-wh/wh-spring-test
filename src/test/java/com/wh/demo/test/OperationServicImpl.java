package com.wh.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * RPNCalculator运算类接口实现类
 * @author wanghuan
 *
 */
public class OperationServicImpl implements OperationService {

	/**
	 * 用于记录位置
	 */
	private int position;

	/**
	 * 用于记录当前的操作符
	 */
	private String currentOperator;

	/**
	 * 可用的运算符
	 */
	private static final String[] operators = { "+", "-", "*", "/", "sqrt", "undo", "clear" };

	@Override
	public void run() {
		/* 用LinkedList做堆栈 */
		LinkedList<Double> stack = new LinkedList<Double>();

		/* 用于undo操作的LinkedList */
		LinkedList<LinkedList<Double>> stacks = new LinkedList<LinkedList<Double>>();

		/* 用户输入的空格分隔的数字和运算符列表的字符串 */
		String inputString = null;

		operation(stack, stacks, inputString, operators);
	}

	/**
	 * 运算
	 * 
	 * @param stack
	 * @param stacks
	 * @param inputString
	 * @param operators
	 */
	@SuppressWarnings("unchecked")
	public void operation(LinkedList<Double> stack, LinkedList<LinkedList<Double>> stacks, String inputString,
			String[] operators) {
		try {
			/* 输入流 */
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			/* 将输入流赋值个inputString */
			inputString = bufferedReader.readLine();
			/* 以空格分割成字符串数组 */
			String[] datas = inputString.split(" ");

			for (String data : datas) {
				/* 判断是是否为可用的运算符 */
				if (Arrays.asList(operators).contains(data)) {
					/* 判断是哪种运算符 */
					if ("sqrt".equals(data)) {

						stacks.push( (LinkedList<Double>) stack.clone());

						position++;
						currentOperator = "sqrt";
						Double data1 = stack.pop();

						stack.push(sqrtOperation(data1));
						position++;
					} else if ("undo".equals(data)) {
						stack = stacks.pop();
						/* 清除算不算步骤数 */
						/* position++; */
					} else if ("clear".equals(data)) {
						stack.clear();
						/* 清除算不算步骤数 */
						/* position++; */
					} else {

						stacks.push((LinkedList<Double>) stack.clone());

						currentOperator = data;
						position++;
						Double data2 = stack.pop();
						position++;
						Double data1 = stack.pop();

						stack.push(generalOperation(data1, data2, data));
						position++;

					}

				} else {
					try {
						Double operand = Double.parseDouble(data);

						stacks.push((LinkedList<Double>) stack.clone());
						stack.push(operand);
						position++;

					} catch (NumberFormatException e) {
						System.out.println("请输入合法字符");
					} catch (NullPointerException e) {
						System.out.println("请输入。。。");
					}
				}

			}

			printStack(stack);

			operation(stack, stacks, inputString, operators);

		} catch (IOException e) {
			System.out.println(e.toString());
		} catch (NoSuchElementException e) {
			System.out.println("operator " + currentOperator + " (position: " + position + "): insucient parameters");
			printStack(stacks.pop());
		} catch (NumberFormatException e) {
			System.out.println("操作数的类型错误");
		}

	}

	/**
	 * 打印堆栈信息
	 * 
	 * @param stack
	 */
	public void printStack(LinkedList<Double> stack) {
		System.out.print("stack:");

		/* 颠倒stack顺序 */
		LinkedList<Double> stackTemp = new LinkedList<Double>();

		for (Double number : stack) {
			stackTemp.push(number);
		}

		for (Double number : stackTemp) {

			BigDecimal bd = new BigDecimal(number);
			/* 保存后10位 */
			number = bd.setScale(10, BigDecimal.ROUND_DOWN).doubleValue();

			if (number % 1.0 == 0) { // 判断改number有没有小数
				System.out.print(" " + number.intValue());
			} else {
				/* 打印小数点后10位 */
				System.out.print(" " + number);
			}

		}
		System.out.println("");
	}

	/**
	 * 通用的运算逻辑（+ - * /）
	 * 
	 * @param data1
	 * @param data2
	 * @param operator
	 * @return
	 */
	public Double generalOperation(Double data1, Double data2, String operator) {

		Double result = null;

		switch (operator) {
		case "+":
			result = data1 + data2;
			break;
		case "-":
			result = data1 - data2;
			break;
		case "*":
			result = data1 * data2;
			break;
		case "/":
			result = data1 / data2;
			break;
		default:
			break;
		}

		return result;
	}

	/**
	 * sqrt的运算逻辑
	 * 
	 * @param data1
	 * @return
	 */
	public Double sqrtOperation(Double data1) {

		if (data1 < 0) {
			throw new NumberFormatException();
		}

		Double result = null;

		result = Math.sqrt(data1);

		return result;
	}
	
}
