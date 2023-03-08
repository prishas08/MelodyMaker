import java.util.LinkedList;
import java.util.Queue;

public class Runner {
	
	public static void main(String args[])
	{
		QueueProbs q  = new QueueProbs();
		Queue<Integer> A = new LinkedList<>();
		A.offer(2);
		A.offer(5);
		A.offer(3);
		A.offer(21);
		A.offer(4);
		System.out.println(q.evenFirst(A));
		System.out.println(q.primeNums(30));

	}

}
