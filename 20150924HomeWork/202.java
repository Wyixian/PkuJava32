bool isHappy(int n) {
    int a[1024] = {0};
    int val = 0;
    int num = n;
    while(1) {
        while(num) {
            val += (num%10) * (num%10);
            num /= 10;
        }
        num = val;
        if(a[num] > 0) break;
        a[num]++;
        val = 0;
    }
    if(num == 1) return true;
    return false;
}