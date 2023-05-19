package criptografia;
import java.security.*;

import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import java.security.PrivateKey;
import java.security.PublicKey;

import java.security.Key;
import java.security.KeyFactory;

public class GeradorDeChaves {

	private GerenciadorDeArquivos gerenciadorDeArquivos = new GerenciadorDeArquivos();
	
	public GeradorDeChaves()
	{}
	
	KeyPairGenerator GeradorDeParDeChaves ;
	KeyPair ParDeChaves;
	public void GerarParDeChaves(String ArquivoChavePublica, String ArquivoChavePrivada)
	{
		try {
			
			GeradorDeParDeChaves = KeyPairGenerator.getInstance("RSA");
			GeradorDeParDeChaves.initialize(2048);
		    ParDeChaves = GeradorDeParDeChaves.generateKeyPair();
		    		    
		    gerenciadorDeArquivos.GravarDadosParaArquivo(ParDeChaves.getPublic().getEncoded(),
					ArquivoChavePublica);

			gerenciadorDeArquivos.GravarDadosParaArquivo(ParDeChaves.getPrivate().getEncoded(),
					ArquivoChavePrivada);

			System.out.println("Chaves geradas com sucesso.");
			
		} catch (NoSuchAlgorithmException e) {
			
			System.out.print("Erro: Não foi possivel gerar chaves");
			e.printStackTrace();
			
		}
		
	}
	
	
	
	public PublicKey GetChavePublica(String CaminhoDoArquivo)
	{				
		 try
		 {
		 		byte[] bytesChave = gerenciadorDeArquivos.LerArquivo(CaminhoDoArquivo);
		 
	             
		 		X509EncodedKeySpec keyTipo = new X509EncodedKeySpec(bytesChave);
	            KeyFactory gerador = KeyFactory.getInstance("RSA");
	            
	            return gerador.generatePublic(keyTipo);
	            
	        } catch (Exception e) {
	        
	        	System.err.println(e.getMessage());
	        	
	            return null;
	            
	        }
	}
		
	
	 public PrivateKey GetChavePrivada(String CaminhoDoArquivo) {

		 try
		 {
		 		byte[] bytesChave = gerenciadorDeArquivos.LerArquivo(CaminhoDoArquivo);
		 
	             
	            PKCS8EncodedKeySpec keyTipo = new PKCS8EncodedKeySpec(bytesChave);
	            KeyFactory gerador = KeyFactory.getInstance("RSA");
	            
	            return gerador.generatePrivate(keyTipo);
	            
	        } catch (Exception e) {
	        
	        	System.err.println(e.getMessage());
	        	
	            return null;
	            
	        }
	    }
	
	
	
	
	
	
	
}

