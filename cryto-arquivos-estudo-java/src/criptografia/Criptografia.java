package criptografia;

import javax.crypto.*;
import java.security.*;

public class Criptografia {


	public Criptografia()
	{
		
	}

	
	public  byte[] Criptografar(byte[] dadosParaCriptografar, PublicKey chavePublic)
	{
	
		
		Cipher cifrador=null;
		byte[] byteCifrado= null;
		
		try {
		
			cifrador = Cipher.getInstance("RSA");
		
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			
			e.printStackTrace();
		}
		
        try {
		
        	cifrador.init(Cipher.ENCRYPT_MODE, chavePublic);
		
        } catch (InvalidKeyException e) {
			
			e.printStackTrace();
		}
        
        try {
		
        	byteCifrado = cifrador.doFinal(dadosParaCriptografar);
		
        	
        } catch (IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
		}
        return byteCifrado;

		
	}

	
	public  byte[] DeCriptografar(byte[] dadosParaDeCriptografar, PrivateKey chavePrivada)
	{
	
		
		Cipher decifrador=null;
		byte[] bytedeCifrado= null;
		
		try {
		
			decifrador = Cipher.getInstance("RSA");
		
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			
			e.printStackTrace();
		}
		
        try {
		
        	decifrador.init(Cipher.ENCRYPT_MODE, chavePrivada);
		
        } catch (InvalidKeyException e) {
			
			e.printStackTrace();
		}
        
        try {
		
        	bytedeCifrado = decifrador.doFinal(dadosParaDeCriptografar);
		
        	
        } catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
        return bytedeCifrado;

		
	}

}


