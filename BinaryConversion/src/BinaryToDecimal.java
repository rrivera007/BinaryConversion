import java.io.*;
import java.util.*;
public class BinaryToDecimal {

	public static void main(String[] args) 
	{
		double base = 1.0;
		String Binary = Intro();
		char sign = Binary.charAt(0);
		String hold = Character.toString(sign);
		int Signed = Integer.parseInt(hold);
		int Sign = FirstBinary(Signed);
		int exponent = EightBitBinary(Binary);
		String deci = decimal(Binary);
		double convert = Double.parseDouble(deci);
		double last = base + convert;
		double test = moveDecimalPoint(last, exponent);
		int FinalBit = (int)test;
		String FB = Integer.toString(FinalBit);
		int Almost = Final(FB);
		System.out.println("Decimal Form: " + Almost*Sign);
		

	}
	
	public static int Final(String FinalBit)
	{
		int L = FinalBit.length();
		int place = L-1;
		char[] Hold = new char[L];
		
		try
		{
			for (int i = 0; 0<FinalBit.length(); i++)
			{
				Hold[i] = FinalBit.charAt(place);
				if (place==0)
				{
					place++;
				}
				place--;
			
			}
			
		}
		catch (ArrayIndexOutOfBoundsException exception) 
		{
			
		}
		
		int pos = 1;
		int bitTotal = 0;
		
		for (int i = 0; i<L;i++)
		{
			int bit = Character.getNumericValue(Hold[i]);
			if (bit==1)
			{
				bitTotal = bitTotal + pos;
				pos = pos*2;
			}
			else
			pos = pos*2;
				
		}
		
		int Finalbit = bitTotal;
		return Finalbit;
	}
	
	public static double moveDecimalPoint(double v, int amount) 
	{
			
	        v *= Math.pow(10, amount);
	        v = Math.ceil(v);
	        return v;
	   
	}
	
	
	public static String decimal(String Binary)
	{
		String placement = null;
		int HoldCount = 0;
		char[] Hold = new char[3];
		for (int i = 9; i<=23;i++)
		{
			
			int count = 0;
			for (int k = 1; k<=3; k++)
			{
				char checkNext = Binary.charAt(i+k);
				int convert = Character.getNumericValue(checkNext);
				if (convert==0)
				{
					count++;
				}
				
			}
			
			if (count==3)
			{
				StringBuilder stringBuilder = new StringBuilder();
				Hold[HoldCount] = Binary.charAt(i);
				stringBuilder.append(".");
				stringBuilder.append(Character.toString(Hold[0]));
				stringBuilder.append(Character.toString(Hold[1]));
				stringBuilder.append(Character.toString(Hold[2]));
				String deci = stringBuilder.toString();
				return deci;	
			}
			else
			{
				Hold[HoldCount] = Binary.charAt(i);
				HoldCount++;
			}
			
		}
		
		return placement;
			
	}
	
	
	public static int EightBitBinary(String Binary) 
	{
		char[] Hold = new char[8];
		Hold[0]=Binary.charAt(1);
		Hold[1]=Binary.charAt(2);
		Hold[2]=Binary.charAt(3);
		Hold[3]=Binary.charAt(4);
		Hold[4]=Binary.charAt(5);
		Hold[5]=Binary.charAt(6);
		Hold[6]=Binary.charAt(7);
		Hold[7]=Binary.charAt(8);
		
		int pos = 128;
		int bitTotal = 0;
		for (int i = 0; i<8;i++)
		{
			int bit = Character.getNumericValue(Hold[i]);
			if (bit==1)
			{
				bitTotal = bitTotal + pos;
				pos = pos/2;
			}
			else
			pos = pos/2;
				
		}
		
		int Finalbit = bitTotal - 127;
		return Finalbit;
		
	}
	
	public static int FirstBinary(int sign)
	{
		if (sign==0)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	public static String Intro ()
	{
		System.out.println("This program will calculate a given 32-bit FPN into it's Decimal equivalent\n");
		System.out.println("please enter a 32-bit FPN (no spaces): ");
		Scanner in = new Scanner(System.in);
		String Binary = in.nextLine();
		return Binary;
	}

}
