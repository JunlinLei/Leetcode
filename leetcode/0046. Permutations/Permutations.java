class Solution {
    /**
    1.create a List of Integer List called output for returning the answer 
    2.call the the method backtrack
        parameter: nums, index, combination,putted,output
    
    3.backtrack:
        1.if the combination length == nums.length
            add the combination to the output list
        2.for int i=0 to putted.length
            add int_bag[i] to combination
            remove int_bag[i]
            backtrack nums, combination, int_bag, output
            add int_bag[i] back to position i
    4.return output
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack(nums,new ArrayList<>(),numbers,output);
        return output;
    }

    public void backtrack(int[] nums, List<Integer> combination, List<Integer> int_bag, List<List<Integer>> output){
        if(combination.size()==nums.length){
            output.add(new ArrayList<>(combination));
            return;
        }

        for(int i = 0;i<int_bag.size();i++){
            int temp = int_bag.get(i);
            combination.add(temp);
            int_bag.remove(i);
            backtrack(nums,combination,int_bag,output);
            combination.remove(combination.size() - 1);
            int_bag.add(i,temp);
        }
    }
}