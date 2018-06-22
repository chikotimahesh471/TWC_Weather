package Android.Practice;

import org.openqa.selenium.WebElement;

import bsh.This;

public class overLoading {
	int e1;
	int e2;
	int e3;
	public void m1(int e1)
	{
	this.e1=e1;
	System.out.println("m1 of e1"+"="+e1);
	}
public void m1( int e2, int e3)
{
	this.e2=e2;
	this.e3=e3;
	System.out.println("m1 of e2 and e3"+"="+e2+"and"+e3);
}

	public static void main(String[] args) {
		
		
		overLoading b=new overLoading();
		b.m1(2);
		b.m1(3,4);
		
		

	}

}
