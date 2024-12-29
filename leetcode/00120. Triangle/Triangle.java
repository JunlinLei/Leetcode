class Solution {
    /**
        for i = triangle.size() -1 to 0
            for j = 0 to triangle.get(i).size()
                s = triangle.get(i).get(j)
                triangle.get(i).set(j, Math.min(s+triangle.get(i+1).get(j),s+triangle.get(i+1).get(j+1)))

        return the top element
        set the list of list[i][j] = minimum of 
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int s = 0; 
        for(int i = triangle.size()-2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                s = triangle.get(i).get(j);
                triangle.get(i).set(j,Math.min(s+triangle.get(i+1).get(j),s+triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}