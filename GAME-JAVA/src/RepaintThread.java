
public class RepaintThread extends Thread 
{
	public static int target_counter = 0;
	public static int counter = 0;
	private boolean pause;
	private ResultFrame rf;
	public void run() 
	{
		while (true)
		{
			pause = GameFrame.pause;
			if (!pause)
			{
				GameFrame.big.repaint();
				try 
				{
					Thread.sleep(10);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				
				rf = new ResultFrame();
				rf.setVisible(true);
				break;
			}
		}
		interrupt();
	}
}