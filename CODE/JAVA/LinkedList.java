/*
 ���� ���� : https://opentutorials.org/module/1335/8857
*/

package list.linkedList.implement;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	// ��� �̳�Ŭ���� ����
	private class Node{
		// �����Ͱ� ����� �ʵ�
		private Object data;
		// ���� ��带 ����Ű�� �ʵ�
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// ����� ������ ���� ������� Ȯ���غ� �� �ִ� ���
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	// �� �տ� �߰�
	public void addFirst(Object input) {
		// ��带 ����
		Node newNode = new Node(input);
		// ���ο� ����� ���� ���� ��带 ����
		newNode.next = head;
		// ���� ���ο� ��带 ����
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	// �� �ڿ� �߰�
	public void addLast(Object input) {
		// ��带 ����
		Node newNode = new Node(input);
		// ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ���
		if(size == 0) {
			addFirst(input);
		} else {
			// ������ ����� ���� ���� ������ ��带 ����
			tail.next = newNode;
			// ������ ��带 ����
			tail = newNode;
			// ������Ʈ�� ������ 1 ����
			size++;
		}
	}
	// Ư�� ��ġ�� ��带 ã�Ƴ��� ���
	public Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	// �߰��� �߰�
	public void add(int index, Object input) {
		if(index ==0) {
			addFirst(input);
		} else {
			Node previous = node(index - 1);
			// index��° ��带 next�� ����
			Node next = previous.next;
			// ���ο� ��带 ����
			Node newNode = new Node(input);
			// previous�� ���� ���� ���ο� ��带 ����
			previous.next = newNode;
			// ���ο� ����� ���� ��带 next�� ����
			newNode.next = next;
			size++;
			
			// ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	// List�� ����� �����͸� Ȯ���ϱ� ���� ���
	public String toString() {
		// ����� ��尡 ���ٸ� []�� ����
		if(head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		// ���� ��尡 ���� ������ �ݺ����� ����
		// ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ�
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		// ������ ��带 ��°���� ����
		str += temp.data;
		
		return str+"]";
	}
	// ó�� ��� ����
	public Object removeFirst() {
		// ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� ����
		Node temp = head;
		head = temp.next;
		// ������ ����� ���� ��ȯ������ ����ϱ� ������
		// �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
	}
	// �߰��� ������ ����
	public Object remove(int index) {
		if(index ==0) {
			return removeFirst();
		}
		// index-1��° ��带 previous�� ������ ����
		Node previous = node(index -1);
		// ���� ��带 todoDeleted�� ����� ��
		// ���� ��带 ���� �����ϸ� ���� �� ���� ���� �� ��带 ������ �� ����
		Node todoDeleted = previous.next;
		// ���� �� ����� ���� ���� ���� �� ��带 ����
		previous.next = previous.next.next;
		// ������ �����͸� �����ϱ� ���ؼ� returnData�� �����͸� ����
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {
			tail = previous;
		}
		todoDeleted = null;
		size--;
		return returnData;
	}
	public Object removeLast() {
		return remove(size-1); 
	}
	public int size() {
		return size;
	}
	public Object get(int index) {
		Node temp = node(index);
		return temp.data;
	}
	public int indexOf(Object data) {
		// Ž�� ����� �Ǵ� ��带 temp�� ����
		Node temp = head;
		// Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index ���
		int index = 0;
		// Ž�� ���� Ž�� ����� ���� ��
		while(temp.data != data) {
			temp = temp.next;
			index++;
			// temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ�
			if(temp == null) {
				return -1;
			}
		}
		return index;
	}
	public ListIterator listIterator() {
		return new ListIterator();
	}
	class ListIterator{
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator(){
			next = head;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public void add(Object input) {
			Node newNode = new Node(input);
			
			if(lastReturned == null) {
				head = newNode;
				newNode.next = next;	
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		public void remove() {
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}
