package utilTest;

import java.util.*;

public class T1 {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();//�洢��ֵ�ԣ�keyΨһ
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();//��key����
		Set<Integer> s = new HashSet<Integer>();//��֤������Ԫ��Ψһ��,Set�ṹ��ʵ����ά��һ��Map���洢���ݵģ�����Map�ṹkeyֵΨһ��
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
		tm.floorKey(1);//С�ڸ���ֵ�����key
		tm.ceilingKey(1);//���ڸ���ֵ����Сkey
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
