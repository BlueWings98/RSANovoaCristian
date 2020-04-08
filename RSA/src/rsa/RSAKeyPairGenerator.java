
package rsa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;
public class RSAKeyPairGenerator {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private String privateString;
    private String publicString;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
        
        try{
            this.writeToFile("RSA/publicKey", this.getPublicKey().getEncoded());
            this.writeToFile("RSA/privateKey", this.getPrivateKey().getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.publicString = Base64.getEncoder().encodeToString(this.getPublicKey().getEncoded());
        this.privateString = Base64.getEncoder().encodeToString(this.getPrivateKey().getEncoded());
    }
    public String fileToString(){
        File file = new File("RSA/publicKey");
        try {
        Scanner scan = new Scanner(file);
        this.publicString = Base64.getEncoder().encodeToString(scan.nextLine().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.publicString;
        
    }
    public void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
    public String getPublicKeyString(){
        return publicString;
    }
    public String getPrivateKeyString(){
        return privateString;
    }
    
}
