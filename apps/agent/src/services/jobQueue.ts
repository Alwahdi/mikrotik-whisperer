export class TaskQueue {
  private readonly concurrency: number;
  private active = 0;
  private queue: Array<() => void> = [];

  constructor(concurrency = 2) {
    this.concurrency = Math.max(1, concurrency);
  }

  async run<T>(task: () => Promise<T>): Promise<T> {
    if (this.active >= this.concurrency) {
      await new Promise<void>((resolve) => {
        this.queue.push(resolve);
      });
    }

    this.active += 1;
    try {
      return await task();
    } finally {
      this.active -= 1;
      const next = this.queue.shift();
      if (next) next();
    }
  }
}
