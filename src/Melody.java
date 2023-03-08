import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
	
	Queue<Note> notes;
	
	//works
	public Melody(Queue<Note> song)
	{
		notes = new LinkedList<>();
		while(song.isEmpty()==false)
		{
			Note n = new Note(song.peek().getDuration(), song.peek().getPitch(), song.peek().getOctave(), song.peek().getAccidental(), song.peek().isRepeat());
			notes.offer(n);
			song.poll();
		}
		
		
	}
	
	//works
	public double getTotalDuration()
	{
		double total = 0.0;
		int tracker = 0;
		Queue<Note> copy = new LinkedList<>();
		Queue<Note> repeat = new LinkedList<>();
		while(notes.isEmpty()==false)
		{
			if(notes.peek().isRepeat()==false || tracker == 2)
			{
				copy.offer(notes.peek());
			}
			if(notes.peek().isRepeat()==true)
			{
				copy.offer(notes.peek());
				repeat.offer(notes.peek());
				tracker++;
			}
			else if(tracker==1)
			{
				repeat.offer(notes.peek());
			}
			notes.poll();
		}
		while(copy.isEmpty()==false)
		{
			notes.offer(copy.peek());
			total += copy.poll().getDuration();
		}
		while(repeat.isEmpty()==false)
		{
			total += repeat.poll().getDuration();
		}
		return total;
	}
	
	//works
	public String toString()
	{
		String s = "";
		Note n;
		Queue<Note> copy = new LinkedList<>();
		while(notes.isEmpty()==false)
		{
			copy.offer(notes.poll());
		}
		while(copy.isEmpty()==false)
		{
			notes.offer(copy.peek());
			n = copy.poll();
			s += n.getDuration() + " " + n.getPitch() + " " + n.getOctave() + " " + n.getAccidental() + " " + n.isRepeat();
			s+= "\n";
		}
		return s;
	}
	
	//works
	public void changeTempo(double tempo)
	{
		Queue<Note> temp = new LinkedList<>();
		while(notes.isEmpty()==false)
		{
			temp.offer(notes.peek());
			notes.peek().setDuration((notes.poll().getDuration())/tempo);
		}
		while(temp.isEmpty()==false)
		{
			notes.offer(temp.poll());
		}
	}
	
	//works
	public void reverse()
	{
		Stack<Note> n = new Stack<>();
		while(notes.isEmpty()==false)
		{
			n.add(notes.poll());
		}
		while(n.isEmpty()==false)
		{
			notes.offer(n.pop());
		}
	}
	
	//works
	public void append(Melody other)
	{
		Queue<Note> copy = other.notes;
		while(copy.isEmpty()==false)
		{
			notes.offer(copy.poll());
		}
	}
	
	//works
	public void play()
	{
		Queue<Note> temp = new LinkedList<>();
		while(notes.isEmpty()==false)
		{
			temp.offer(notes.peek());
			notes.peek().play();
			if(notes.peek().isRepeat()==true)
			{
				notes.peek().play();
			}
			notes.poll();
		}
		while(temp.isEmpty()==false)
		{
			notes.offer(temp.poll());
		}
	}
	
	//should work
	public Queue<Note> getNotes()
	{
		return notes;
	}
	

}
