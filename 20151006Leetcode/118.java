public class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return result;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        result.add(first);
        
        for(int n = 2; n <= numRows; n++)
        {
            ArrayList<Integer> thisRow = new ArrayList<Integer>();
            thisRow.add(1);

            //A(n+1)[i] = A(n)[i - 1] + A(n)[i]
            List<Integer> previousRow = result.get(n- 2);
            for(int i = 1; i < n - 1; i++)
            {
                thisRow.add(previousRow.get(i - 1) + previousRow.get(i));
            }
            thisRow.add(1);
            result.add(thisRow);
        }
        
        return result;
    }
}