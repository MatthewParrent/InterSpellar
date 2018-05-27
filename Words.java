import java.util.ArrayList;

public class Words
{
	private ArrayList<String> list;
	public Words()
	{
		list = new ArrayList<String>();
		list.add("public");
		list.add("static");
		list.add("void");
		list.add("main");
		list.add("String");
		list.add("Integer");
		list.add("Double");
		list.add("Character");
		list.add("interface");
		list.add("abstract");
		list.add("extends");
		list.add("implements");
		list.add("private");
		list.add("protected");
		list.add("class");
		list.add("import");
		list.add("java");
		list.add("util");
		list.add("ArrayList");
		list.add("int");
		list.add("double");
		list.add("char");
		list.add("boolean");
		list.add("return");
		list.add("random");
		list.add("Math");
		list.add(".size()");
		list.add(".get()");
		list.add("break");
		list.add("throws");
		list.add(".add()");
		list.add(".remove()");
		list.add(".length");
		list.add(".length()");
		list.add("long");
		list.add("new");
		list.add("float");
		list.add("if");
		list.add("else");
		list.add("Arrays");
		list.add("Collections");
		list.add("int[]");
		list.add("double[]");
		list.add("String[]");
		list.add("int[][]");
		list.add("char[][]");
		list.add("double[][]");
		list.add("String[][]");
		list.add("char[]");
		list.add("while");
		list.add("for");
		list.add("null");
	}
	
	public String getWord()
	{
		return list.get((int)(Math.random()*(list.size())));
	}
}
