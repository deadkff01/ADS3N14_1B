package Estrutura;



	public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

		private Nodo<T> findBefore(Nodo<T> novo) {
			Nodo<T> atual = getHead();
			Nodo<T> anterior = null;

			while (atual != null) {
				int comp = atual.compareTo(novo);
				if (comp < 0) {
					anterior = atual;
					atual = atual.getNext();
				}
				if (comp == 0)
					return atual;
				if (comp > 0)
					return anterior;
			}

			return anterior;
		}

	
		
		@Override
		public void insert(Nodo<T> novo)
		{
			Nodo<T> anterior = findBefore(novo);
			if (anterior == null) {
				super.insert(novo);
			} else {
				super.insert(novo, anterior);
			}
		}


		@Override
		public void insert(Nodo<T> novo, Nodo<T> anterior)
		{
			insert(novo);
		}

		@Override
		public void append(Nodo<T> novo)
		{
			insert(novo);
		}


		public static void main(String[] args) {
			ListaOrdenada<String> lista = new ListaOrdenada<String>();

			lista.insert(new Nodo<String>("Rafael"));
			lista.insert(new Nodo<String>("Dennis"), lista.getHead());
			lista.append(new Nodo<String>("Mauro"));
			lista.insert(new Nodo<String>("Carlos"));
			
			//lista.insert(new Nodo<String>("Rafael"));
			//lista.insert(new Nodo<String>("Raphael"));

			lista.print();
			System.out.println("--------");
			
		}

	}

