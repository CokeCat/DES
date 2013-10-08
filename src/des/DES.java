
package des;

public class DES {    
    
    public static void main(String[] args) {
        
        firstStage fs = new firstStage();
        secondStage ss = new secondStage();
        secondStageInv ssi = new secondStageInv();
        thirdStage ts = new thirdStage();
        keyGenerator kg = new keyGenerator();
        
        
        String message = "0123456789abcdef";
        String key = "133457799BBCDFF1";
        
        long[] keys;
        long nemessage = Long.parseLong(message,16);
        long key1 = Long.parseLong(key,16);
        long fsmessage;
        long ssmessage;
        long tsmessage;
        long fsimessage;
        long ssimessage;
        long tsimessage;
        
        System.out.println("message:   " + message);
        
        keys = kg.generatekeys(key1);
        fsmessage = fs.initialPermutation(nemessage);
        //System.out.println("fsmessage: " + Long.toBinaryString(fsmessage));
        ssmessage = ss.round16(fsmessage, keys);
        //System.out.println("ssmessage: " + Long.toBinaryString(ssmessage));
        tsmessage = ts.finalPermutation(ssmessage);
        //System.out.println("tsmessage: " + Long.toBinaryString(tsmessage));
               
        System.out.println("Encrypted message: " + Long.toHexString(tsmessage));
        
        fsimessage = fs.initialPermutation(tsmessage);
        //System.out.println("fsimessage:" + Long.toBinaryString(fsimessage));
        ssimessage = ssi.round16Inv(fsimessage, keys);
        //System.out.println("ssimessage:" + Long.toBinaryString(ssimessage));
        tsimessage = ts.finalPermutation(ssimessage);
        //System.out.println("tsimessage:" + Long.toBinaryString(tsimessage));
        
        System.out.println("Desencrypted Message: " + Long.toHexString(tsimessage));
        
    }
}
