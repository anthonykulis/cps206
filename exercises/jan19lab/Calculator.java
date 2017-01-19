package exercises.jan19lab;

public class Calculator {

	double add(double x, double y){ return x + y; }

	double subtract(double x, double y){ return x - y; }

	double multiply(double x, double y){ return x * y; }

	double divide(double x, double y) throws Exception {
		if(y == 0) throw new Exception("Cannot divide by 0");
		return x / y;
	}

	public static void main(String... args){
		if(args.length != 3) {
			System.err.println("Usage: java Calculator <operation> <operand> <operand>");
			System.exit(1);
		}

		Calculator calculator = new Calculator();

		String operation = args[0].toLowerCase();
		double leftOperand;
		double rightOperand;

		try {
			leftOperand = Double.valueOf(args[1]);
			rightOperand = Double.valueOf(args[2]);


			switch(operation){
				case "divide":
					System.out.println(calculator.divide(leftOperand, rightOperand));
					break;
				case "multiply":
					System.out.println(calculator.multiply(leftOperand, rightOperand));
					break;
				case "subtract":
					System.out.println(calculator.subtract(leftOperand, rightOperand));
					break;
				case "add":
					System.out.println(calculator.add(leftOperand, rightOperand));
					break;
				default:
					System.err.println("Unknown operation: " + operation);
					System.exit(1);
			}

		} catch (NumberFormatException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			System.exit(1);
		}
	}
}