package servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileItem{
	private String name;
	private String string;
	public FileItem(String name, String string) {
		super();
		this.name = name;
		this.string = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	@Override
	public String toString() {
		return "FileItem [name=" + name + ", string=" + string + "]";
	}
	
}
public class Test {
	
	public static String getString(List<FileItem> list, String name) {
		for(FileItem li: list) {
			if(li.getName().equals("name")) {
				return li.getString();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		List<FileItem> list = new ArrayList<FileItem>();
		list.add(new FileItem("name", "홍길동"));
		list.add(new FileItem("age", "33"));
		list.add(new FileItem("address", "서울"));
		
		Map<String,String> map = new HashMap<String,String>();
		for(FileItem fi:list) {
			map.put(fi.getName(), fi.getString());
		}
		System.out.println(getString(list, "name"));
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("address"));
	}
}
