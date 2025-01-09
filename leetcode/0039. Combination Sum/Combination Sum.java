class Solution {

    /**
    1. create a return list of list integer called output
    2.sort the candidates array
    3. backtrack method call
        parameter: candidates, target, cur_sum, combination, output,start_index
    4.backtrack:
        if cur_sum == target
            output.add(combination)
            return
        else if cur_sum > target
            return
        else
            for(int i = start_index;i<target;i++)
                combination.add(candidates[i]);
                backtrack(candidates,target,cur_sum+candidates[i],combination,output,i)
                combination.remove(combination.size()-1)
    5. return output
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), output,0);
        return output;
    }

    public void backtrack(int[] candidates, int target, int cur_sum, List<Integer> combination, List<List<Integer>> output,int start) {
        if (cur_sum == target) {
            output.add(new ArrayList<>(combination));
            return;
        } else if (cur_sum > target) {
            return;
        }
        else{
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target, cur_sum + candidates[i], combination, output,i);
            combination.remove(combination.size() - 1);
        }
        }
    }
}
