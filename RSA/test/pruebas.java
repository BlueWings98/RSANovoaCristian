/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rsa.RSA;
import rsa.RSAKeyPairGenerator;

/**
 *
 * @author sebas
 */
public class pruebas {
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void generadorClaves(){
        RSAKeyPairGenerator generador;
        String stringPublico = "";
        String stringPrivado = "";
        try{
        generador = new RSAKeyPairGenerator();
        stringPrivado = generador.getPrivateKeyString();
        stringPublico = generador.getPublicKeyString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void todo(){
        RSA entrada;
        String plano = "Novoa";
        String encriptado = "";
        String publica = "";
        String privada = "";
        
        try{
            entrada = new RSA();
            privada = entrada.getPrivateKeyString();
            publica = entrada.getPublicKeyString();
            encriptado = entrada.encriptar(plano, publica);
            System.out.println(entrada.desencriptar(encriptado, privada));
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
