package utility;

/**
 * a classe Queue che modella una struttura coda che e' poi 
 * usata come contenitore a modalita' FIFO per i pattern frequenti 
 * scoperti a livello k da usare per generare i pattern candidati a livello k+1
 * @author Ferdo
 *
 * @param <T>
 */
public class Queue<T> {

	private Record begin = null;
	private Record end = null;

	private class Record {

		T elem;
		Record next;

		Record(T e) {
			this.elem = e;
			this.next = null;
		}
	}
	/**
	 * controlla se la coda e' vuota
	 * @return boolean
	 */
	public boolean isEmpty() {

		return this.begin == null;
	}
	/**
	 * inserisce un elemento dalla coda
	 * @param e
	 */
	public void enqueue(T e) {

		if (this.isEmpty()) {

			this.begin = this.end = new Record(e);
		} else {

			this.end.next = new Record(e);
			this.end = this.end.next;
		}
	}
	/**
	 * ritorna il primo elemento della coda, se e' vuoto si genere un eccezzione
	 * @return Record
	 * @throws EmptyQueueException
	 */
	public T first() throws EmptyQueueException {

		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return this.begin.elem;
	}
	/**
	 * toglie un elemento dalla coda, se e' vuota si genera un eccezzione
	 * @throws EmptyQueueException
	 */
	public void dequeue() throws EmptyQueueException {

		if (isEmpty()) {

			throw new EmptyQueueException();
		}
		if (this.begin == this.end) {

			if (this.begin == null) {

				System.out.println("The queue is empty!");
			} else {

				this.begin = this.end = null;
			}
		} else {
			begin = begin.next;
		}
	}
}