package leetcode.priorityqueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSchedular {
	
	public static void main(String args[]) {
		char[] tasks = new char[] {'A','A','B'};
		leastInterval(tasks,1);
	}
	
	 public static class Task{
         int task_count;
         int cooling_time;
        public Task(int task_count,int cooling_time){
            this.cooling_time = cooling_time;
            this.task_count = task_count;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] tasks_count = new int[26];
        int curr_time = 0;
        PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        Queue<Task> queue = new LinkedList<>();
        for(char task:tasks){
            tasks_count[task - 'A']++;
        }
        for(int task_count : tasks_count){
            if(task_count>0)
                max_heap.offer(task_count);
        }
        while(!queue.isEmpty() || !max_heap.isEmpty()){
            curr_time ++;
            if(!queue.isEmpty() && queue.peek().cooling_time<=curr_time){
                max_heap.offer(queue.poll().task_count);
            }
            if(!max_heap.isEmpty()){
                int task_count = max_heap.poll();
                if(task_count>1)
                {
                    Task task_obj = new Task(task_count-1, n + curr_time+1);
                    queue.offer(task_obj);
                }
            }
        }
        

        return curr_time;
    }
}
