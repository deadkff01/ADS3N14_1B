/**Trabalho da arvore binaria..
 * 
 * @author Dennis Kaffer

 * @version 1.0

 */


public interface BSTInterface <T extends Comparable<T>> {
	
	public void add(Node<T> data);
	
	public boolean remove(String data) throws EmptyBSTException;
	
	public String containsDFS(String data);
	
	public String containsBFS(String data);
	
	public int getTreeHeight();
	
	public int getSize();
	
	public int getComparisonsDFS();
	
	public int getComparisonsBFS();
	
	public boolean isEmpty();
	
	public String infixa();
	
	public String prefixa();
	
	public String posfixa();
	
}
