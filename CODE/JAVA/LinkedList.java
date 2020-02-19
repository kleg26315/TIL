/*
 참고 강의 : https://opentutorials.org/module/1335/8857
*/

package list.linkedList.implement;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	// 노드 이너클래스 생성
	private class Node{
		// 데이터가 저장될 필드
		private Object data;
		// 다음 노드를 가리키는 필드
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// 노드의 내용을 쉽게 출려개서 확인해볼 수 있는 기능
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	// 맨 앞에 추가
	public void addFirst(Object input) {
		// 노드를 생성
		Node newNode = new Node(input);
		// 새로운 노드의 다음 노드로 헤드를 지정
		newNode.next = head;
		// 헤드로 새로운 노드를 지정
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	// 맨 뒤에 추가
	public void addLast(Object input) {
		// 노드를 생성
		Node newNode = new Node(input);
		// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용
		if(size == 0) {
			addFirst(input);
		} else {
			// 마지막 노드의 다음 노드로 생성한 노드를 지정
			tail.next = newNode;
			// 마지막 노드를 갱신
			tail = newNode;
			// 엘리먼트의 개수를 1 증가
			size++;
		}
	}
	// 특정 위치의 노드를 찾아내는 기능
	public Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	// 중간에 추가
	public void add(int index, Object input) {
		if(index ==0) {
			addFirst(input);
		} else {
			Node previous = node(index - 1);
			// index번째 노드를 next로 지정
			Node next = previous.next;
			// 새로운 노드를 생성
			Node newNode = new Node(input);
			// previous의 다음 노드로 새로운 노드를 지정
			previous.next = newNode;
			// 새로운 노드의 다음 노드를 next로 지정
			newNode.next = next;
			size++;
			
			// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	// List에 저장된 데이터를 확인하기 위한 기능
	public String toString() {
		// 저장된 노드가 없다면 []를 리턴
		if(head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		// 다음 노드가 없을 때까지 반복문을 실행
		// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됨
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		// 마지막 노드를 출력결과에 포함
		str += temp.data;
		
		return str+"]";
	}
	// 처음 노드 삭제
	public Object removeFirst() {
		// 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경
		Node temp = head;
		head = temp.next;
		// 삭제한 노드의 값을 반환값으로 줘야하기 때문에
		// 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담음
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
	}
	// 중간의 데이터 삭제
	public Object remove(int index) {
		if(index ==0) {
			return removeFirst();
		}
		// index-1번째 노드를 previous의 값으로 지정
		Node previous = node(index -1);
		// 삭제 노드를 todoDeleted에 기록해 둠
		// 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없음
		Node todoDeleted = previous.next;
		// 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정
		previous.next = previous.next.next;
		// 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장
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
		// 탐색 대상이 되는 노드를 temp로 지정
		Node temp = head;
		// 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index 사용
		int index = 0;
		// 탐색 값과 탐색 대상의 값을 비교
		while(temp.data != data) {
			temp = temp.next;
			index++;
			// temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미
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
