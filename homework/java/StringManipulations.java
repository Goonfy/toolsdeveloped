public class StringManipulations
{
    public static void main(String[] args)
    {
	String str = "http://www.academiadecodigo.org";

	String domain = ""; // www.academiadecodigo.org
	String name = "";   // < Academia de Codigo_ >

	// print the following message at the end
	// I am a Code Cadet at < Academia de Codigo_ >, www.academiadecodigo.org
	domain = str.substring(7);
	name = "< " + domain.substring(4, 12).replaceFirst("a", "A") + " " + domain.substring(12, 14) + " " + domain.substring(14, 20).replaceFirst("c", "C") + "_ >";

	System.out.println("I am a Code Cadet at " + name + ", " + domain);
    }
}
