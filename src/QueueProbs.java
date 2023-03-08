import java.util.LinkedList;
import java.util.Queue;

public class QueueProbs {
	
	//works
	public Queue<Integer> evenFirst(Queue<Integer> nums)
	{
		Queue<Integer> EvenNumbers = new LinkedList<>();
		while(nums.isEmpty()!=true)
		{
			if(nums.peek()%2 == 0)
			{
				EvenNumbers.offer(nums.poll());
			}
			else
			{
				nums.poll();
			}
		}
		return EvenNumbers;
	}
	
	//#4 - yesterday, today, tomorrow
	
	//works
	public Queue<Integer> primeNums(int n)
	{
		Queue<Integer> temp = new LinkedList<>();
		for(int i = 2; i <= n; i++)
		{
			temp.offer(i);
		}
		Queue<Integer> prime = new LinkedList<>();
		boolean isNotPrime;
		int size = temp.size();
		while(temp.isEmpty()!=true)
		{
			isNotPrime = false;
			int x = temp.peek();
			for(int i = 2; i< Math.sqrt(size); i++)
			{
				if(x % i==0 && x != i) 
				{
					isNotPrime = true;
				}
				
			}
			if(isNotPrime==false) 
			{
				prime.offer(temp.poll());
			}
			else
			{
				temp.poll();
			}
		}
		return prime;
		
	}
	
	
	

}
