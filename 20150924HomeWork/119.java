public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for(int i=0; i<rowIndex; i++) {
            for(int j=i-1; j>=0; j--)
                list.set(j+1, list.get(j) + list.get(j+1));
            list.add(1);
        }
        return list;
    }
}