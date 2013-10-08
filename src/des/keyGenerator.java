
package des;

public class keyGenerator {
    
    int PC1[]={57,49,41,33,25,17,9,1,
               58,50,42,34,26,18,10,2,
               59,51,43,35,27,19,11,3,
               60,52,44,36,63,55,47,39,
               31,23,15,7,62,54,46,38,
               30,22,14,6,61,53,45,37,
               29,21,13,5,28,20,12,4};
    
     int PC2[]={14,17,11,24,1,5,3,28,
                15,6,21,10,23,19,12,4,
                26,8,16,7,27,20,13,2,
                41,52,31,37,47,55,30,40,
                51,45,33,48,44,49,39,56,
                34,53,46,42,50,36,29,32}; 
    
    public long[] generatekeys(long key){
        
        long[] keys = new long[16];
        long pc1key = permutatioChoise1(key);
        
        String pc1keys = Long.toBinaryString(pc1key);
        
        String cs = pc1keys.substring(0, 28);
        String ds = pc1keys.substring(28);
        String ckey;
                
        int c = Integer.parseInt(cs,2);
        int d = Integer.parseInt(ds,2);        
        
        for(int i = 0; i<16; i++){     
            
            c = leftShift(c,i);
            d = leftShift(d,i); 
            ckey = ckey(c,d);
            keys[i] = permutatioChoise2(Long.parseLong(ckey,2));
        }        
        
        return keys;        
    }   
    
    public String ckey(int c, int d){
        
        String tempc, tempd, ckey;
        tempc = Long.toBinaryString(c);
        tempd = Long.toBinaryString(d);
        
        for(int i = 0; i<28; i++){
            if(tempc.length() != 28){
                tempc = '0' + tempc;
            }
            
            if(tempd.length() != 28){
                tempd = '0' + tempd;
            }
        }
        ckey = tempc + tempd;
        return ckey;
        
    }
    
    public int leftShift(int c, int i){
        
        if(i==0 || i==1 || i==8 || i==15){
            c = (((int)c >> 27) | ((int)c << 1)) & ~((int)1 << 28);
        }
        else{
            c = (((int)c >> 27) | ((int)c << 1)) & ~((int)1 << 28);
            c = (((int)c >> 27) | ((int)c << 1)) & ~((int)1 << 28);
        }
        
        return c;  
        
    }
    
    public long permutatioChoise1(long key){
        
        long temp, temp1;
        long result = 0x0;
        int newpos;  
        
        for(int i = 55; i>=0; i--){
            
            temp = 0;
            newpos = PC1[55-i];
            temp1 = (long)1 << 64-newpos;
            temp = key & temp1;
            if(temp != 0){
                result |= (long)1 << i;
            }
        }
        
        return result;
        
    }
    
    public long permutatioChoise2(long key){
        
        long temp, temp1;
        long result = 0x0;
        int newpos;  
        
        for(int i = 47; i>=0; i--){
            
            temp = 0;
            newpos = PC2[47-i];
            temp1 = (long)1 << 56-newpos;
            temp = key & temp1;
            if(temp != 0){
                result |= (long)1 << i;
            }
        }
        
        return result;
        
    }
    
    
    
}
