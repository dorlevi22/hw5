
public class AVLNode<T> {

	
	public AVLNode<T> getLeftChild(){
		//TODO
		return null;
	}
	
	public AVLNode<T> getRightChild(){
		//TODO
		return null;
	}
	
	public AVLNode<T> getFather(){
		//TODO
		return null;
	}
	
	public int getKey(){
		//TODO
		return 0;
	}
	
	public T getData(){
		//TODO
		return null;
	}
	
	@Override
	public String toString() {
		
		String s = "";
		
		if (getLeftChild() != null){
			s+="(";
			s+=getLeftChild().toString();
			s+=")";
		}
		s+=getKey();
		
		if (getRightChild() != null){
			s+="(";
			s+=getRightChild().toString();
			s+=")";
		}
		
		return s;
	}
}

