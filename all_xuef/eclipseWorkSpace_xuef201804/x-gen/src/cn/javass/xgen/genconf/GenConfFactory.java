package cn.javass.xgen.genconf;

public class GenConfFactory {
	private GenConfFactory(){}
	
	public static GenConfEbi newInstance(){
		return GenConfEbo.getInstance();
	}
}
