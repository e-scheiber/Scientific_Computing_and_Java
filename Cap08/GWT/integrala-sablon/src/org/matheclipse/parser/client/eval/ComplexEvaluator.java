/*
 * Copyright 2005-2008 Axel Kramer (axellclk@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matheclipse.parser.client.eval;

import java.util.HashMap;
import java.util.Map;

import org.matheclipse.parser.client.Parser;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.ast.ASTNode;
import org.matheclipse.parser.client.ast.FunctionNode;
import org.matheclipse.parser.client.ast.NumberNode;
import org.matheclipse.parser.client.ast.SymbolNode;
import org.matheclipse.parser.client.math.Complex;
import org.matheclipse.parser.client.math.MathException;

/**
 * Evaluate math expressions to {@code Complex} numbers.
 * 
 */
public class ComplexEvaluator {
	private static Map<String, Complex> SYMBOL_MAP;

	private static Map<String, Object> FUNCTION_MAP;

	static class ArcTanFunction implements IComplex1Function {
		public Complex evaluate(Complex arg1) {
			return arg1.atan();// ComplexUtils.atan(arg1);
		}

	}

	static class LogFunction implements IComplex1Function, IComplex2Function {
		public Complex evaluate(Complex arg1) {
			return arg1.log();// ComplexUtils.log(arg1);
		}

		public Complex evaluate(Complex base, Complex z) {
			return z.log().divide(base.log());// ComplexUtils.log(z).divide(ComplexUtils.log(base));
		}
	}

	static class PlusFunction implements IComplexFunction, IComplex2Function {
		public Complex evaluate(Complex arg1, Complex arg2) {
			return arg1.add(arg2);
		}

		public Complex evaluate(ComplexEvaluator engine, FunctionNode function) {
			Complex result = new Complex(0.0, 0.0);
			for (int i = 1; i < function.size(); i++) {
				result = result.add(engine.evaluateNode((ASTNode) function.getNode(i)));
			}
			return result;
		}
	}

	static class TimesFunction implements IComplexFunction, IComplex2Function {
		public Complex evaluate(Complex arg1, Complex arg2) {
			return arg1.multiply(arg2);
		}

		public Complex evaluate(ComplexEvaluator engine, FunctionNode function) {
			Complex result = new Complex(1.0, 0.0);
			for (int i = 1; i < function.size(); i++) {
				result = result.multiply(engine.evaluateNode((ASTNode) function.getNode(i)));
			}
			return result;
		}
	}

	static {
		SYMBOL_MAP = new HashMap<String, Complex>();
		SYMBOL_MAP.put("Degree", new Complex(Math.PI / 180, 0.0));
		SYMBOL_MAP.put("E", new Complex(Math.E, 0.0));
		SYMBOL_MAP.put("I", new Complex(0.0, 1.0));
		SYMBOL_MAP.put("Pi", new Complex(Math.PI, 0.0));

		FUNCTION_MAP = new HashMap<String, Object>();
		FUNCTION_MAP.put("ArcTan", new ArcTanFunction());
		FUNCTION_MAP.put("Log", new LogFunction());
		FUNCTION_MAP.put("Plus", new PlusFunction());
		FUNCTION_MAP.put("Times", new TimesFunction());
		//
		// Functions with 0 argument
		//
		FUNCTION_MAP.put("Random", new IComplex0Function() {
			public Complex evaluate() {
				return new Complex(Math.random(), Math.random());
			}
		});
		//
		// Functions with 1 argument
		//
		FUNCTION_MAP.put("ArcCos", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.acos();// acos(arg1);
			}
		});
		FUNCTION_MAP.put("ArcSin", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.asin();// asin(arg1);
			}
		});

		FUNCTION_MAP.put("Cos", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.cos();// cos(arg1);
			}
		});
		FUNCTION_MAP.put("Cosh", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.cosh();// cosh(arg1);
			}
		});
		FUNCTION_MAP.put("Exp", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.exp();// exp(arg1);
			}
		});
		FUNCTION_MAP.put("Sin", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.sin();// sin(arg1);
			}
		});
		FUNCTION_MAP.put("Sinh", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.sinh();// sinh(arg1);
			}
		});
		FUNCTION_MAP.put("Sqrt", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.sqrt();// sqrt(arg1);
			}
		});
		FUNCTION_MAP.put("Tan", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.tan();// tan(arg1);
			}
		});
		FUNCTION_MAP.put("Tanh", new IComplex1Function() {
			public Complex evaluate(Complex arg1) {
				return arg1.tanh();// tanh(arg1);
			}
		});

		//
		// Functions with 2 arguments
		//
		FUNCTION_MAP.put("Power", new IComplex2Function() {
			public Complex evaluate(Complex arg1, Complex arg2) {
				return arg1.pow(arg2);// pow(arg1, arg2);
			}
		});
	}

	Map<String, ComplexVariable> fVariableMap;

	public ComplexEvaluator() {
		fVariableMap = new HashMap<String, ComplexVariable>();
	}

	/**
	 * Evaluate an already parsed in abstract syntax tree node into a
	 * <code>Complex</code> number value.
	 * 
	 * @param node
	 *          abstract syntax tree node
	 * 
	 * @return the evaluated Complex number
	 * 
	 * @throws MathException
	 *           if the <code>node</code> cannot be evaluated.
	 */
	public Complex evaluateNode(final ASTNode node) {

		if (node instanceof ComplexNode) {
			return ((ComplexNode) node).complexValue();
		}
		if (node instanceof FunctionNode) {
			return evaluateFunction((FunctionNode) node);
		}
		if (node instanceof SymbolNode) {
			ComplexVariable v = (ComplexVariable) fVariableMap.get(node.toString());
			if (v != null) {
				return v.getValue();
			}
			Complex c = (Complex) SYMBOL_MAP.get(node.toString());
			if (c != null) {
				return c;
			}
		} else if (node instanceof NumberNode) {
			return new Complex(((NumberNode) node).doubleValue(), 0.0);
		}

		throw new MathException("EvalDouble#evaluate(ASTNode) not possible for: " + node.toString());
	}

	/**
	 * Evaluate an already parsed in <code>FunctionNode</code> into a
	 * <code>Complex</code> number value.
	 * 
	 * @param functionNode
	 * @return
	 * 
	 * @throws MathException
	 *           if the <code>functionNode</code> cannot be evaluated.
	 */
	public Complex evaluateFunction(final FunctionNode functionNode) {
		if (functionNode.size() > 0 && functionNode.getNode(0) instanceof SymbolNode) {
			String symbol = functionNode.getNode(0).toString();
			if (functionNode.size() == 1) {
				Object obj = FUNCTION_MAP.get(symbol);
				if (obj instanceof IComplex0Function) {
					return ((IComplex0Function) obj).evaluate();
				}
			} else if (functionNode.size() == 2) {
				Object obj = FUNCTION_MAP.get(symbol);
				if (obj instanceof IComplex1Function) {
					return ((IComplex1Function) obj).evaluate(evaluateNode((ASTNode) functionNode.getNode(1)));
				}
			} else if (functionNode.size() == 3) {
				Object obj = FUNCTION_MAP.get(symbol);
				if (obj instanceof IComplex2Function) {
					return ((IComplex2Function) obj).evaluate(evaluateNode((ASTNode) functionNode.getNode(1)),
							evaluateNode((ASTNode) functionNode.getNode(2)));
				}
			} else {
				Object obj = FUNCTION_MAP.get(symbol);
				if (obj instanceof IComplexFunction) {
					return ((IComplexFunction) obj).evaluate(this, functionNode);
				}
			}
		}
		throw new MathException("EvalDouble#evaluateFunction(FunctionNode) not possible for: " + functionNode.toString());
	}

	/**
	 * Optimize an already parsed in <code>functionNode</code> into an
	 * <code>ASTNode</code>.
	 * 
	 * @param functionNode
	 * @return
	 * 
	 */
	public ASTNode optimizeFunction(final FunctionNode functionNode) {
		if (functionNode.size() > 0) {
			boolean complexOnly = true;
			ASTNode node;
			for (int i = 1; i < functionNode.size(); i++) {
				node = functionNode.getNode(i);
				if (node instanceof NumberNode) {
					functionNode.set(i, new ComplexNode(((NumberNode) functionNode.getNode(i)).doubleValue()));
				} else if (functionNode.getNode(i) instanceof FunctionNode) {
					ASTNode optNode = optimizeFunction((FunctionNode) functionNode.getNode(i));
					if (!(optNode instanceof ComplexNode)) {
						complexOnly = false;
					}
					functionNode.set(i, optNode);
				} else if (node instanceof SymbolNode) {
					Complex c = (Complex) SYMBOL_MAP.get(node.toString());
					if (c != null) {
						functionNode.set(i, new ComplexNode(c));
					} else {
						complexOnly = false;
					}
				} else {
					complexOnly = false;
				}
			}
			if (complexOnly) {
				try {
					return new ComplexNode(evaluateFunction(functionNode));
				} catch (Exception e) {

				}
			}
		}
		return functionNode;
	}

	/**
	 * Returns a <code>String</code> representation of the given
	 * <code>Complex</code> number.
	 * 
	 * @param c
	 * @return
	 * 
	 */
	public static String toString(Complex c) {
		double real = c.getReal();
		double imag = c.getImaginary();
		if (imag == 0.0) {
			return Double.valueOf(real).toString();
		} else {
			if (imag >= 0.0) {
				return Double.valueOf(real).toString() + "+I*" + Double.valueOf(imag).toString();
			} else {
				return Double.valueOf(real).toString() + "+I*(" + Double.valueOf(imag).toString() + ")";
			}
		}
	}

	/**
	 * Define a value for a given variable name.
	 * 
	 * @param variableName
	 * @param value
	 */
	public void defineVariable(String variableName, ComplexVariable value) {
		fVariableMap.put(variableName, value);
	}

	/**
	 * Clear all defined variables for this evaluator.
	 */
	public void clearVariables() {
		fVariableMap.clear();
	}

	/**
	 * Parse the given expression <code>String</code> and evaluate it to a
	 * <code>Complex</code> value.
	 * 
	 * @param expression
	 * @return
	 * @throws SyntaxError
	 */
	public Complex evaluate(String expression) {
		Parser p = new Parser();
		ASTNode obj = p.parse(expression);
		if (obj instanceof FunctionNode) {
			obj = optimizeFunction((FunctionNode) obj);
		}
		return evaluateNode(obj);
	}
}
