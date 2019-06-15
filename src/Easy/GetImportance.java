package Easy;

import java.util.*;

/*
690.员工的重要性
给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 */
public class GetImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Integer> emp_importance = new HashMap<Integer, Integer>();
        Map<Integer,List<Integer>> emp_sub = new HashMap<Integer,List<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int res = 0;
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee emp = iterator.next();
            emp_importance.put(emp.id, emp.importance);
            emp_sub.put(emp.id, emp.subordinates);
        }
        queue.offer(id);
        while(!queue.isEmpty()){
            int emp_id = queue.poll();
            res += emp_importance.get(emp_id);
            List<Integer> s = emp_sub.get(emp_id);
            for (int i=0; i<s.size(); i++){
                queue.offer(s.get(i));
            }
        }
        return res;
    }
}
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
