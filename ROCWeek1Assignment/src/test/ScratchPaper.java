package test;

public class ScratchPaper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScratchPaper SP=new ScratchPaper();
		
		//System.out.println(SP.letterTwoNumber("Fred"));
		System.out.println(SP.setAccountNumber("John WatsonIC"));
	}
	
	public long letterTwoNumber(String string) {
		long result=0;
		for (int i=0; i<string.length(); i++) {
			char temp=string.charAt(i);
			System.out.println(temp);
			System.out.println((int)temp);
			System.out.println(Math.pow(10,(3*i)));
			result+=((int)temp)*Math.pow(10,(3*i));
			System.out.println(result);
		}
		return result;
	}
	
	public static long setAccountNumber(String name) {
		long result=0;
		for (int i=0; i<name.length(); i++) {
			char temp=name.charAt(i);

			System.out.println("val: "+((((int)temp)%26)*Math.pow(10,(2*i))));
			result+=((((int)temp)%26)*Math.pow(10,(2*i)));
			System.out.println("result: "+result);
		}
		return result;
	}

}
