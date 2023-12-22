import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class GUI {
	
	JFrame frame;
	JLabel equation;
	double result;
	ArrayList<String> operand;
	String operation;
	JButton zero;
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eigth;
	JButton nine;
	JButton plus;
	JButton minus;
	JButton times;
	JButton divide;
	JButton dot;
	JButton equals;
	JButton clear;
	
	public GUI(String name) {
		this.operand = new ArrayList<String>();
		this.operation = "";
		
		this.frame = new JFrame(name);
		this.equation = new JLabel("0");
		equation.setFont(equation.getFont().deriveFont(32.0f));
		equation.setBounds(10, 5, 280, 50);
		
		this.seven = new JButton("7");
		seven.setBounds(25, 60, 55, 55);
		seven.addActionListener(number);
		this.eigth = new JButton("8");
		eigth.setBounds(90, 60, 55, 55);
		eigth.addActionListener(number);
		this.nine = new JButton("9");
		nine.setBounds(155, 60, 55, 55);
		nine.addActionListener(number);
		this.plus = new JButton("+");
		plus.setBounds(220, 60, 55, 55);
		plus.addActionListener(mainAction);
		
		this.four = new JButton("4");
		four.setBounds(25, 125, 55, 55);
		four.addActionListener(number);
		this.five = new JButton("5");
		five.setBounds(90, 125, 55, 55);
		five.addActionListener(number);
		this.six = new JButton("6");
		six.setBounds(155, 125, 55, 55);
		six.addActionListener(number);
		this.minus = new JButton("-");
		minus.setBounds(220, 125, 55, 55);
		minus.addActionListener(mainAction);
		
		
		this.one = new JButton("1");
		one.setBounds(25, 190, 55, 55);
		one.addActionListener(number);
		this.two = new JButton("2");
		two.setBounds(90, 190, 55, 55);
		two.addActionListener(number);
		this.three = new JButton("3");
		three.setBounds(155, 190, 55, 55);
		three.addActionListener(number);
		this.times = new JButton("X");
		times.setBounds(220, 190, 55, 55);
		times.addActionListener(mainAction);
		
		
		this.clear = new JButton("AC");
		clear.setBounds(25, 255, 55, 55);
		clear.addActionListener(mainAction);
		this.zero = new JButton("0");
		zero.setBounds(90, 255, 55, 55);
		zero.addActionListener(number);
		this.dot = new JButton(".");
		dot.setBounds(155, 255, 55, 55);
		dot.addActionListener(number);
		this.divide = new JButton("/");
		divide.setBounds(220, 255, 55, 55);
		divide.addActionListener(mainAction);
		
		
		this.equals = new JButton("=");
		equals.setBounds(90, 320, 120, 55);
		equals.addActionListener(mainAction);
		
		
	}
	
	private void add() {
		this.frame.add(zero);
		this.frame.add(one);
		this.frame.add(two);
		this.frame.add(three);
		this.frame.add(four);
		this.frame.add(five);
		this.frame.add(six);
		this.frame.add(seven);
		this.frame.add(eigth);
		this.frame.add(nine);
		this.frame.add(plus);
		this.frame.add(minus);
		this.frame.add(times);
		this.frame.add(divide);
		this.frame.add(equals);
		this.frame.add(clear);
		this.frame.add(dot);
		this.frame.add(equation);
	}
	
	public void show() {
		this.add();
		
		this.frame.setSize(300,410);
		this.frame.setLayout(null);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private ActionListener mainAction = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("AC")) equation.setText("0");
			else if (operand.size() < 1 && !cmd.equals("=")){
				operand.add(equation.getText());
				equation.setForeground(Color.blue);
				operation = cmd;
			}
			else if (cmd.equals("=")) {
				if (operand.size() == 1) {
					double numLeft = Double.parseDouble(operand.get(0));
					double numRight = Double.parseDouble(equation.getText());
					double res = calculate(numLeft, numRight, operation);
					operand.clear();
					equation.setText(res + "");
				}
			}
			else {
				double numLeft = Double.parseDouble(operand.get(0));
				double numRight = Double.parseDouble(equation.getText());
				double res = calculate(numLeft, numRight, operation);
				operand.clear();
				operand.add(res + "");
				equation.setText(res + "");
				equation.setForeground(Color.blue);
				operation = cmd;
			}
		}
	};
	
	private double calculate(double left, double right, String cmd) {
		
		if (cmd.equals("+")) return left + right;
		else if (cmd.equals("-")) return left - right;
		else if (cmd.equals("X")) return left * right;
		else {
			return left / right;
		}
	}
	
	private ActionListener number = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String num = e.getActionCommand();
			String curr = equation.getText();
			if (curr.equals("0") && !num.equals(".")) {
				curr = "";
				
			}
			else if (equation.getForeground().equals(Color.blue)) {
				equation.setForeground(Color.black);
				curr = "";
				
			}
			if (!(num.equals(".") && curr.contains(num))) equation.setText(curr + num);
			
		}
	};
	

}
