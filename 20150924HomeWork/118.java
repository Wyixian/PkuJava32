public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> rs = new ArrayList<List<Integer>>();
        if(numRows == 0) return rs;
        ArrayList<Integer> elem = new ArrayList<Integer>();
        elem.add(1);
        rs.add(elem);
        int tmp = 0;
        for(int i = 0; i < numRows-1; i++) {
            ArrayList<Integer> elem2 = new ArrayList<Integer>();
            elem2.add(1);
            for(int j = 0; j <= i - 1; j++) {
                tmp = elem.get(j) + elem.get(j+1);
                elem2.add(tmp);
            }
            elem2.add(1);
            rs.add(elem2);
            elem = elem2;
        }
        return rs;
    }
}