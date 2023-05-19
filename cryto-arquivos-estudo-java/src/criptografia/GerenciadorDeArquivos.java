package criptografia;
import java.io.*;

public class GerenciadorDeArquivos {
	
	public GerenciadorDeArquivos()
	{
		
	}
	
	public byte[] LerArquivo(String CaminhoDoArquivo) throws IOException
	{
		File arquivoDeEntrada = null;
		FileInputStream streamDeEntrada = null;
		try {
			
			arquivoDeEntrada = new File(CaminhoDoArquivo);
			streamDeEntrada = new FileInputStream(arquivoDeEntrada);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int TamanhoBuffer = (int)arquivoDeEntrada.length();
		byte[] bytesLidos = new byte[TamanhoBuffer];
        streamDeEntrada.read(bytesLidos);
		return bytesLidos;
	
		
	}
	
	public void GravarDadosParaArquivo(byte[] dadosParaGravar, String CaminhoDoArquivo){
	
        File arquivoParaGravar = null;
        FileOutputStream streamParaGravar = null;
        try {
        
        	arquivoParaGravar = new File(CaminhoDoArquivo);
            streamParaGravar = new FileOutputStream(arquivoParaGravar);         
			streamParaGravar.write(dadosParaGravar);
			streamParaGravar.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
        
	}
	

}
/*


 
  // Read the input file
        File inputFile = new File("input.txt");
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);

*/