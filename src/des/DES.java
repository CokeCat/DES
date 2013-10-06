
package des;

public class DES {    
    
    public static void main(String[] args) {
        
        firstStage fs = new firstStage();
        secondStage ss = new secondStage();
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
        
        keys = kg.generatekeys(key1);
        fsmessage = fs.initialPermutation(nemessage);
        ssmessage = ss.secondStage(fsmessage, keys);
        tsmessage = ts.finalPermutation(ssmessage);
        
        System.out.println("Encrypted message: " + Long.toHexString(tsmessage));
        
    }
}
