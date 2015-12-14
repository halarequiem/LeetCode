package utilTest;

import java.util.*;

public class T1 {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();//存储键值对，key唯一
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();//按key排序
		Set<Integer> s = new HashSet<Integer>();//保证容器内元素唯一性,Set结构其实就是维护一个Map来存储数据的，利用Map结构key值唯一性
		Queue<Integer> q = new LinkedList<Integer>();
		Deque<Integer> d = new LinkedList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		
		m.put(1, 2);
		m.get(1);
		m.remove(1);
		m.keySet();
		m.remove(1, 2);
		m.containsKey(1);
		m.containsValue(2);
		
		tm.firstKey();
		tm.lastKey();
		tm.floorKey(1);//小于给定值的最大key
		tm.ceilingKey(1);//大于给定值的最小key
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.first();
		ts.last();
		ts.floor(1);
		ts.ceiling(1);
		
		s.iterator();
		s.add(1);
		s.remove(1);
		s.contains(1);
		
		q.add(1);
		q.remove();
		q.peek();
		
		d.push(1);
		d.pop();
		d.peek();
		d.add(2);
		
		st.pop();
		st.push(1);
		st.peek();
		
		
		Iterator<Integer> i = s.iterator();
		i.next();
		i.hasNext();
		i.remove();
	}

}
