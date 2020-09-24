package org.academiadecodigo.bootcamp54.notstring;

public class NotString
{
	public void removeString(String str) {
    	// print result here
		if (str.length() >= 3 && str.substring(0, 3).equals("not"))
		{
			System.out.println(str);
		}
		else
		{
			System.out.println("not " + str);
		}
	}
}
