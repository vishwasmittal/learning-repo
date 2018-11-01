/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Q.1 write a java program to find multiplication of four numbers.Also find their geometric mean?
		double a,b,c,d,e,f;
		a=1;
		b=2;
		c=3;
		d=4;
		e=a*b*c*d;
		System.out.println("Multiplication of four numbers");
		System.out.println(e);
		System.out.println("Geometric mean of four numbers");
		f=Math.pow(e,0.25);
		System.out.println(f);
 
 
	}
}
