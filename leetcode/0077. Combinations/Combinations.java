class Solution {
    /**
    1.create a return list of integer list call output
    2.backtrack
        parameters:n,k,output,index,combination
        
    3. backtrack
        if combination.length == k
            add combination to output
            return
        
        for i = index to k
            add i to combination
            backtrack n,k,output,index+1,combination
            remove i from combination
    4.return output*/
            
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(n,k,output,1,new ArrayList<>());
        return output;
    }

    public void backtrack(int n, int k, List<List<Integer>> output, int index, List<Integer> combination){
        if(combination.size() == k){
            output.add(new ArrayList<>(combination));
            return;
        }

        for(int i = index;i<=n;i++){
            combination.add(i);
            backtrack(n,k,output,i+1,combination);
            combination.remove(combination.size()-1);
        }
    }
}