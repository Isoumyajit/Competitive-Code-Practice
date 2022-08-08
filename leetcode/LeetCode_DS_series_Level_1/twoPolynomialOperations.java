
/* Signature of four required functions is given in the code. You can create other functions as well if you need.
*  Also you should submit your code even if you are not done with all the functions. 
*/

// Main used internally is shown here just for your reference.
/*public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int degree1[] = new int[n];
		for(int i = 0; i < n; i++){
			degree1[i] = s.nextInt();
		}
		int coeff1[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff1[i] = s.nextInt();
		}
		Polynomial first = new Polynomial();
		for(int i = 0; i < n; i++){
			first.setCoefficient(degree1[i],coeff1[i]);
		}
		n = s.nextInt();
		int degree2[] = new int[n];
		for(int i = 0; i < n; i++){
			degree2[i] = s.nextInt();
		}
		 int coeff2[] = new int[n];
		for(int i = 0; i < n; i++){
			coeff2[i] = s.nextInt();
		}
		Polynomial second = new Polynomial();
		for(int i = 0; i < n; i++){
			second.setCoefficient(degree2[i],coeff2[i]);
		}
		int choice = s.nextInt();
		Polynomial result;
		switch(choice){
		// Add
		case 1: 
			 result = first.add(second);
			result.print();
			break;
		// Subtract	
		case 2 :
			 result = first.subtract(second);
			result.print();
			break;
		// Multiply
		case 3 :
			 result = first.multiply(second);
			result.print();
			break;
		}

	}
  */

import java.util.*;

public class twoPolynomialOperations {

    /*
     * This function sets coefficient for a particular degree value, if degree is
     * not there in the polynomial
     * then corresponding term with specified degree and value is added int the
     * polynomial. If the degree
     * is already present in the polynomial then previous coefficient is replaced by
     * new coefficient value passed as function argument
     */
    private Map<Integer, Integer> helper = null;

    twoPolynomialOperations() {
        helper = new TreeMap<>();
    }

    public void setCoefficient(int degree, int coeff) {

        this.helper.put(degree, coeff);
    }

    // Prints all the terms(only terms with non zero coefficients are to be printed)
    // in increasing order of degree.
    public void print() {
        String answer = "";
        for (Map.Entry<Integer, Integer> temp : this.helper.entrySet()) {
            answer += temp.getValue() + "x" + temp.getKey() + " ";
        }
        System.out.println(answer);
    }

    // Adds two polynomials and returns a new polynomial which has result
    public twoPolynomialOperations add(twoPolynomialOperations p) {

        Map<Integer, Integer> h1 = p.getmap();
        for (Map.Entry<Integer, Integer> temp : h1.entrySet()) {
            if (this.helper.containsKey(temp.getKey())) {
                this.helper.put(temp.getKey(), temp.getValue() + this.helper.get(temp.getKey()));
            } else {
                this.helper.put(temp.getKey(), temp.getValue());
            }
        }
        return this;
    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public twoPolynomialOperations subtract(twoPolynomialOperations p) {
        Map<Integer, Integer> h1 = p.getmap();
        for (Map.Entry<Integer, Integer> temp : h1.entrySet()) {
            if (this.helper.containsKey(temp.getKey())) {
                this.helper.put(temp.getKey(), this.helper.get(temp.getKey()) - temp.getValue());
            } else {
                this.helper.put(temp.getKey(), -1 * temp.getValue());
            }
        }
        return this;
    }

    // Multiply two polynomials and returns a new polynomial which has result
    public twoPolynomialOperations multiply(twoPolynomialOperations p) {
        Map<Integer, Integer> h1 = p.getmap();
        Map<Integer, Integer> dummy = new TreeMap<>();
        // ArrayList<Integer> ex = new ArrayList<>();
        for (Map.Entry<Integer, Integer> temp : h1.entrySet()) {
            int val = temp.getValue();
            for (Map.Entry<Integer, Integer> temp1 : this.helper.entrySet()) {
                if (val == 0) {
                    if (dummy.containsKey(val))
                        dummy.put(temp1.getKey(), dummy.get(val) + temp1.getValue() * temp.getValue());
                    else
                        dummy.put(temp1.getKey(), temp1.getValue() * temp.getValue());
                } else {
                    int sum = temp.getKey() + temp1.getKey();
                    // ex.add(sum);
                    if (dummy.containsKey(sum))
                        dummy.put(sum, dummy.get(sum) + temp1.getValue() * temp.getValue());
                    else
                        dummy.put(sum, temp1.getValue() * val);
                }
            }
        }

        this.helper = dummy;
        return this;
    }

    void add(TreeMap<Integer, ArrayList<Integer>> h1) {

    }

    Map<Integer, Integer> getmap() {
        return this.helper;
    }

}