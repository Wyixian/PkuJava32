public class Solution {
    public boolean canWinNim(int n) {
        //通过写出前20个数，每次自己走1或2或3步后，尽可能让对方赢，发现4、8、12、16时，对方均可赢
        //猜测：4的倍数对方赢。一次通过测试，说明猜测正确。
        if(n % 4 == 0){
            return false;
        }else{
            return true;
        }
    }
}