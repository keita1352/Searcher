package searcher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Searcher{
	@SuppressWarnings("resource")
	public static void main(String []args){
		System.out.println("Welcome to Searcher-A!");
		System.out.println("What do you want to search?");
		boolean out = true;
		while (out) {
			switch (new Scanner(System.in).next()){
				case "programer":
				case "Programer":
				case "program":
				case "Program":
					switch(new Scanner(System.in).next()){
						case "java-base":
						case "Java-base":
						case "java-Base":
						case "Java-Base":
						case "javabase":
						case "Javabase":
						case "javaBase":
						case "JavaBase":
						case "java":
						case "Java":
							base("java","basic");
							break;
						case "javafx":
						case "JavaFx":
						case "javaFx":
							base("java","javafx");
							break;
						default:
							System.out.println("Oh! You made mistakes!");
					}
					break;
				case "bot":
				case "Bot":
					System.out.println("Welcome to Bot World!\r\nYou can use english.");
					while(out) {
						switch (new Scanner(System.in).next()) {
							case "english":
							case "English":
								while(out) {
									String japanese = new Scanner(System.in).next();
									if (japanese.equals("exit")||japanese.equals("Exit")) {
										System.out.println("Searcher//bot//english -> Searcher//bot");
										out = false;
									}else {
										english(japanese);
									}
								}
								out = true;
								break;
							case "exit":
							case "Exit":
								System.out.println("Searcher//bot -> Searcher");
								out = false;
								break;
							default:
								System.out.println("Oh! You made mistakes!");
						}
					}
					out = true;
					break;
				case "help":
				case "Help":
					System.out.println("You are Searcher now.\r\nYou can do these:\r\n    program,bot,help,exit");
					break;
				case "exit":
				case "Exit":
					System.out.println("Good bye!");
					out = false;
					break;
				default:
					System.out.println("Oh! You made mistakes!");
			}
		}
	}
	public static void english(String japanese) {
		switch(japanese){
			case "こんにちは":
				System.out.println("Hello");
				break;
			case "1つの":
			case "一つの":
			case "ひとつの":
				System.out.println("a");
				break;
			case "できる":
			case "出来る":
			case "有能な":
			case "ゆうのうな":
				System.out.println("able");
				break;
			case "午後":
			case "ごご":
				System.out.println("afternoon");
				break;
			default:
				System.out.println("Sorry,I don't know.");
		}
	}
	@SuppressWarnings("resource")
	public static void base(String language,String type){
		System.out.println("Where will you work?");
		String workarea = new Scanner(System.in).next();
		if(workarea.equals("here")||workarea.equals("Here"))workarea = "";
		File file = new File(workarea);
		if(file.exists()||workarea.equals("")){
			System.out.println("What do you want to name?");
			String fileName = new Scanner(System.in).next();
			String fileNameR = "";
			if(workarea.equals("")){
				fileNameR = fileName + ".txt";
			}else{
				fileNameR = workarea + "\\" + fileName + ".txt";
			}
			File file2 = new File(fileNameR);
			try{
				if(file2.createNewFile()){
					try{
						if(file2.isFile() && file2.canWrite()){
							FileWriter filewriter = new FileWriter(file2);
							switch(language){
								case "java":
									switch (type){
										case "javafx":
											filewriter.write("import javafx.application.Application;\r\nimport javafx.stage.Stage;\r\n\r\nclass " + fileName + " extends Application{\r\n    public static void main(String []args){\r\n        launch(args);\r\n    }\r\n\r\n    @Override\r\n    public void start(Stage stage) throws Exception{\r\n        stage.show();\r\n    }\r\n}");
											break;
										case "basic":
											filewriter.write("class " + fileName + "{\r\n    public static void main(String []args){\r\n        \r\n    }\r\n}");
											break;
									}
									break;
							}
							filewriter.close();
						}else{
							System.out.println("You couldn't write java");
						}
					}catch(IOException a){
						System.out.println(a);
					}
				}else{
					System.out.println("You couldn't name.");
				}
			}catch(IOException e){
				System.out.println(e);
			}
		}else{
			System.out.println("File wasn't founded...");
		}
	}
}
