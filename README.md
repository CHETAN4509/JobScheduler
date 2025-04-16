# 🛠️ Job Scheduler

Welcome to the **Job Scheduler** project — a Java-based solution that schedules jobs to **maximize total profit** while respecting job deadlines. It's a slick combo of **priority queues (max-heaps)** and greedy strategy, handcrafted for performance optimization.

## 💡 Problem Statement

You're given a set of jobs. Each job has:
- A unique **ID**
- A **deadline** by which it must be completed
- A **profit** associated with it

Each job takes **1 unit of time** to complete, and the goal is to **schedule the jobs** such that:
- Maximum profit is earned
- No two jobs are scheduled at the same time
- A job must be completed **on or before its deadline**

---

## 🚀 Features

- 📌 Sorts jobs by deadline
- ⚙️ Uses a max heap to always pick the most profitable job
- 🧠 Schedules jobs backwards to simulate greedy decisions
- 🧾 Prints out the sequence of scheduled jobs

---

## 📦 Sample Input

```java
List<Job> jobs = Arrays.asList(
    new Job("Job1", 2, 100),
    new Job("Job2", 1, 50),
    new Job("Job3", 2, 20),
    new Job("Job4", 1, 70),
    new Job("Job5", 3, 0),
    new Job("Job6", 5, 400),
    new Job("Job7", 6, 300),
    new Job("Job8", 3, 2),
    new Job("Job9", 4, 2000)
);

OUTPUT: 
Scheduled Jobs: [Job7, Job6, Job9, Job8, Job1, Job4]

