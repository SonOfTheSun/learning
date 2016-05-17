package com.lab.riv.five;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class FileDataProvider extends AbstractDataProvider{

	private String fileName;
	
	private final String type = "txt";
	
	private String inputPrefix = "$";
	private String outputPrefix = "output:\n";
	
	private BufferedReader fileReader;
	private BufferedWriter fileWriter;
	
	FileDataProvider(){
		this.fileName = "src\\com\\lab\\riv\\five\\test";
	}
	
	FileDataProvider(String fileName){
		this.fileName = fileName;
	}
	
	public void writeData(String data) throws Exception{
		getFileWtier().write("\n"+outputPrefix);
		getFileWtier().write(data);
		getFileWtier().flush();
		close();
		System.out.println("Операция успешно выполнения, результаты записаны в файл " + fileName+".txt");
	}
	
	private BufferedWriter getFileWtier() throws IOException{
		if(fileWriter == null)
			fileWriter = new BufferedWriter(
							new OutputStreamWriter(
								new FileOutputStream(fileName+"."+type, true),Charset.forName("UTF-8")
							)
						);
		return fileWriter;
	}
	
	private BufferedReader getFileReader() throws IOException{
		if(fileReader == null){
			fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName+"."+type), "UTF8"));	
		}
		return fileReader;
	}
	
	public void close() throws IOException{
		if(fileWriter != null)
			fileWriter.close();
		if(fileReader != null)
			fileReader.close();
	}

	@Override
	protected void readData() throws IOException {
		BufferedReader bufferredReader = getFileReader();
		String line;
		int count = 0;
		while((line = bufferredReader.readLine()) != null){
			if(line.startsWith(inputPrefix)){
				args[count++] = line.replace(inputPrefix, "");
				if(count>=args.length)
					break;
			}
		}
		 
	}
}
