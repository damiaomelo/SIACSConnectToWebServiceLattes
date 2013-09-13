package model.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/** 
 * ##### 
 *
 *      By Filipe Brito (filipesabrito@gmail.com)
 *
 * ##### 
 * */
public class CreateDirectoryAndInputFiles {
	
	public CreateDirectoryAndInputFiles(){}
	
	String desktopPath = System.getProperty("user.home") + "/Desktop";
	
	// Attention: creates path in Windows
	File file = new File(desktopPath+"\\SIACS\\CurriculosCompactados");

	public void inputFileInDirectory(String fileName, byte[] retornoByte){
		if(!file.exists()){
			file.mkdirs();
		}
		try{
			FileOutputStream OutFile = new FileOutputStream(desktopPath +"/SIACS/CurriculosCompactados/"+fileName+".zip");
			OutFile.write(retornoByte);
			OutFile.close();
			Mensagem.setErroAtual(Mensagem.CURRICULO_RECUPERADO_COM_SUCESSO);
		}catch(IOException iOE){
			Mensagem.setErroAtual(Mensagem.ERRO_INTERNO);
		}
	}
	
}
