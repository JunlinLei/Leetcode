class RandomizedSet {
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,val);  
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        List<Integer> values = new ArrayList<>(map.values());
        Random random = new Random();
        int randomIndex = random.nextInt(values.size());
        Integer randomValue = values.get(randomIndex);
        return randomValue;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */