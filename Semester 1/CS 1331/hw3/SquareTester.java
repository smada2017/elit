public class SquareTester {

public static void main(String[] args) {

		try {
            new Square("a1");
            System.out.println("good 1");
        } catch (InvalidSquareException e) {
            System.out.println("bad 1: " + e.getMessage());
        }
        try {
            String invalidSquare = "a9";
            new Square(invalidSquare);
            System.out.println("bad 2");
        } catch (InvalidSquareException e) {
            System.out.println("good 2: " + e.getMessage());
        }
        try {
	        Square s = new Square("d8");
	        System.out.println('d' == s.getFile());
	        System.out.println('8' == s.getRank());
	        System.out.println("getfile & rank work");
    	} catch (InvalidSquareException e) {
    		System.out.println("good 3: " + e.getMessage());
    	}
    	try {
    		Square s2 = new Square('a', 'h');
	        System.out.println("e4".equals(s2.toString()));
    	} catch (InvalidSquareException e) {
    		System.out.println("good 4: " + e.getMessage());
    	}
       }

}