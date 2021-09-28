import java.util.*;

class CalculatorRefactor {	 
    static List<String> listInputUser= new ArrayList<String>();
    static String valueInputUser = "";

    public static void main(String args[]) {
        Scanner inputConsole = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String inputUser = inputConsole.next();
            
            for (int indexInputUser = 0; indexInputUser < inputUser.length(); indexInputUser++) {
                addCharInputUserIntoArrayList(indexInputUser,inputUser);

                lastInputUser(indexInputUser,inputUser);
            }
            
            //perhitungan
            double result = 0;
            for (int indexListInputUser = 0; indexListInputUser < listInputUser.size(); indexListInputUser++) {
                switch (listInputUser.get(indexListInputUser)) {
                    case "+":
                        indexListInputUser++;
						result = additionOperation(result,Double.parseDouble(listInputUser.get(indexListInputUser)));
                        break;
                    case "-":
                        indexListInputUser++;
						result = substractionOperation(result,Double.parseDouble(listInputUser.get(indexListInputUser)));
                        break;
                    case "/":
                        indexListInputUser++;
                        result = divisionOperation(result,Double.parseDouble(listInputUser.get(indexListInputUser)));
                        break;
					case "*":
                        indexListInputUser++;
                        result = multiplicationOperation(result,Double.parseDouble(listInputUser.get(indexListInputUser)));
                        break;
                    default:
                        result = Double.parseDouble(listInputUser.get(indexListInputUser));
                }
            }

            System.out.println("** Result: "+result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void addCharInputUserIntoArrayList(int indexInputUser, String inputUser){ 
        if(inputUser.charAt(indexInputUser) == '+' || inputUser.charAt(indexInputUser) == '-' || inputUser.charAt(indexInputUser) == '/' || inputUser.charAt(indexInputUser) == '*') {
            listInputUser.add(valueInputUser);  
            listInputUser.add(String.valueOf(inputUser.charAt(indexInputUser)));

            valueInputUser = "";
        } else {
            valueInputUser = valueInputUser + String.valueOf(inputUser.charAt(indexInputUser));
        }
    }

    public static void lastInputUser(int indexInputUser,String inputUser){
		if (indexInputUser == inputUser.length() - 1) {
            listInputUser.add(valueInputUser);
            valueInputUser = "";
        }
	}
	
	public static double additionOperation (double valueInputUser1, double valueInputUser2){
		return valueInputUser1 + valueInputUser2;
	}
	
	public static double substractionOperation (double valueInputUser1, double valueInputUser2){
		return valueInputUser1 - valueInputUser2;
	}
	
	public static double divisionOperation (double valueInputUser1, double valueInputUser2){
		return valueInputUser1 / valueInputUser2;
	}
	
	public static double multiplicationOperation(double valueInputUser1, double valueInputUser2){
		return valueInputUser1 * valueInputUser2;
	}
}
