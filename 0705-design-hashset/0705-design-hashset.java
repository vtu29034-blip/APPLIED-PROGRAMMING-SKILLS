
class MyHashSet {

    // key can be from 0 to 1,000,000
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    // Inserts key into the HashSet
    public void add(int key) {
        set[key] = true;
    }

    // Returns true if key exists
    public boolean contains(int key) {
        return set[key];
    }

    // Removes key from the HashSet
    public void remove(int key) {
        set[key] = false;
    }
}






    

        

    

        

    

        




 




