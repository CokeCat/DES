
package des;

import java.math.BigInteger;


public class secondStageInv {
        
    int E[]={32,1,2,3,4,5,4,5,
             6,7,8,9,8,9,10,11,
             12,13,12,13,14,15,16,17,
             16,17,18,19,20,21,20,21,
             22,23,24,25,24,25,26,27,
             28,29,28,29,30,31,32,1};
    
    int P[]={16,7,20,21,29,12,28,17,
             1,15,23,26,5,18,31,10,
             2,8,24,14,32,27,3,9,
             19,13,30,6,22,11,4,25};
    
    int sbox1[][] = {{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},{0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},{4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},{15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}};
    int sbox2[][] = {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},{0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
    int sbox3[][] = {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},{13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},{13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},{1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};
    int sbox4[][] = {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},{10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};
    int sbox5[][] = {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},{14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},{4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},{11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};
    int sbox6[][] = {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},{10,15,4,2,7,12,9,5,6,1,12,14,0,11,3,8},{9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},{4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};
    int sbox7[][] = {{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},{13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},{1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},{6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}};
    int sbox8[][] = {{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},{1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},{7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},{2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}};
    
    public long round16Inv(long fsmessage, long[] keys){
        
        String fsmessages = Long.toBinaryString(fsmessage);
        fsmessages = completeCeros(fsmessages,64);
        
        String r = fsmessages.substring(0, 32);
        String l = fsmessages.substring(32);        
        
        String tempr;        
        
        for(int i = 15; i>=0; i--){ 
            tempr = r;
            r = l;
            l = xortoString(ffunction(keys[i], l), tempr);            
        } 
        
        l = completeCeros(l,32);
        r = completeCeros(r,32);
        String ssmessage = l + r;
        
        long ssmessage1 = parseLong(ssmessage,2);
        
        return ssmessage1;
        
    }
    
    private static long parseLong(String s, int base) {
        return new BigInteger(s, base).longValue();
    } 
        
    private String xortoString(long res, String l){
        long resultado = res^Long.parseLong(l, 2);
        return Long.toBinaryString(resultado);
    }
    
    private long ffunction(long key, String r){
       
        long rn = Long.parseLong(r,2);
        long rne = expansion(rn);
        rn = key^rne;
        String rns = completeCeros(Long.toBinaryString(rn),48);
        String[] b = new String[8];
        String[] c = new String[8];
        String total = "";
 
        for(int i = 0; i<8 ; i++){
            b[i] = rns.substring(i*6, (i+1)*6);
        }       
            
        c[0]=sboxOperation(b[0], sbox1);
        c[1]=sboxOperation(b[1], sbox2);
        c[2]=sboxOperation(b[2], sbox3);
        c[3]=sboxOperation(b[3], sbox4);
        c[4]=sboxOperation(b[4], sbox5);
        c[5]=sboxOperation(b[5], sbox6);
        c[6]=sboxOperation(b[6], sbox7);
        c[7]=sboxOperation(b[7], sbox8);
        
        for(int i = 0; i<8 ; i++){
            total += c[i];
        }
        
        long pp = permP(Long.parseLong(total,2));
        return pp;
    }
    
    private String sboxOperation(String b, int[][] sbox){
        String rn = b.substring(0, 1) + b.substring(5, 6);        
        String cn = b.substring(1, 5);
        String res = Long.toBinaryString(sbox[Integer.parseInt(rn,2)][Integer.parseInt(cn,2)]);
        res = completeCeros(res,4);
        return res;
    }
   
    private long expansion(long r){
        
        long temp, temp1;
        long result = 0x0;
        int newpos;  
        
        for(int i = 47; i>=0; i--){
                        
            temp = 0;
            newpos = E[47-i];
            temp1 = (long)1 << 32-newpos;
            temp = r & temp1;
            if(temp != 0){
                result |= (long)1 << i;
            }
        }
        
        return result;
        
    }
    
    private long permP(long r){
        
        long temp, temp1;
        long result = 0x0;
        int newpos;  
        
        for(int i = 31; i>=0; i--){
                        
            temp = 0;
            newpos = P[31-i];
            temp1 = (long)1 << 32-newpos;
            temp = r & temp1;
            if(temp != 0){
                result |= (long)1 << i;
            }
        }
        
        return result;
        
    }
        
    private String completeCeros(String s, int l){
        
        while(s.length()<(l)){
            s = '0' + s;
        }
        return s;
    }
        
}    
  
