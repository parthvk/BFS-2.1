// Time Complexity : O(n) where n is the number of employees
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        //Putting all the employees in hasmap so that we can search in O(1)
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        //Calling recursive function
        helper(id, map);


        return result;
    }

    public void helper(int id, HashMap<Integer, Employee> map){
        List<Integer> l = map.get(id).subordinates;
        result = result + map.get(id).importance;
        for(Integer i: l){
            helper(i, map);
        }
    }
}