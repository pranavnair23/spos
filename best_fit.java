import java.util.Scanner;

public class best_fit {
	public static void swap(int [] a, int s1, int s2) {
		int temp = a[s1];
		a[s1] = a[s2];
		a[s2] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no of Jobs: ");
		int jobs = sc.nextInt();
		System.out.println("enter no of Blocks: ");
		int blocks = sc.nextInt();
		int jobId[] = new int[jobs];
		int memory[] = new int[blocks];
		int vis[] = new int[blocks];
		float mem_used=0;
		float tot_mem=0;
		
		for(int i = 0; i < jobs; i++)
		{
			System.out.println("Enter JobId " + (i+1) + " required memory ");
			jobId[i] = sc.nextInt();
		}
		for(int i = 0; i < jobs; i++)
		{
			System.out.println("Enter Block Size for jobId" + (i+1) + " ");
			memory[i] = sc.nextInt();
			tot_mem += memory[i];
		}
		
		for(int i=0;i<jobs;i++) {

			int diff = Integer.MAX_VALUE;
			int bk=0;
			
			for(int j=0;j<blocks;j++) {
				
				if(vis[j] == 0 && jobId[i] <= memory[j]) {
					int temp = memory[j] - jobId[i];
					
					if(temp<diff) {
						diff = temp;
						bk = j;
					}
				}
			}
			
			vis[bk] = 1;
			System.out.println("JobId " + (i+1) + " Allocated to Block No "+ (bk+1));
			mem_used += jobId[i];
			
		}
		
		float utilization = mem_used / tot_mem;
		
		System.out.println("Memory Utilization is "+utilization+ " out of "+tot_mem);
		
	}

}
