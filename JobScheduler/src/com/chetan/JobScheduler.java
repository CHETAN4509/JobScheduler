package com.chetan;

        
import java.util.*;

public class JobScheduler {

    static class Job {
        String id;
        int deadline;
        int profit;

        Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static class Result {
        List<String> scheduledJobs;
        int totalProfit;

        Result(List<String> scheduledJobs, int totalProfit) {
            this.scheduledJobs = scheduledJobs;
            this.totalProfit = totalProfit;
        }
    }

    public static Result scheduleJobs(List<Job> jobs) {
        // Sort jobs by deadline
        jobs.sort((a, b) -> a.deadline - b.deadline);

        // Max heap to pick most profitable job at each step
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        List<String> result = new ArrayList<>();
        int totalProfit = 0;

        // Iterate from last job to first
        for (int i = jobs.size() - 1; i >= 0; i--) {
            int availableSlots = (i == 0 ? jobs.get(i).deadline : jobs.get(i).deadline - jobs.get(i - 1).deadline);
            maxHeap.add(jobs.get(i));

            while (availableSlots > 0 && !maxHeap.isEmpty()) {
                Job selected = maxHeap.poll();
                result.add(selected.id);
                totalProfit += selected.profit;
                availableSlots--;
            }
        }

        return new Result(result, totalProfit);
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Job1", 6, 100),
                new Job("Job2", 1, 50),
                new Job("Job3", 2, 20),
                new Job("Job4", 1, 10),
                new Job("Job5", 5, 200)
        );

        Result res = scheduleJobs(jobs);
        System.out.println("Scheduled Jobs: " + res.scheduledJobs);
        System.out.println("Total Profit: ₹" + res.totalProfit);
    }
}

