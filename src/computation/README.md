# Heavy Computation

Heavy computation refers to any operation that:
- CPU-heavy: it requires a lot of processing power (e.g. encryption, video rendering, large number crunching)
- Memory-heavy: it loads or allocates a lot of data into RAM.
- I/O-heavy: it depends on slow operations like:
  - Writing to disk (saving files, database writes)
  - Reading/writing over the network (HTTP requests, DB queries)
- Blocking/Latency-heavy: It waits for external systems, slowing down performance.


## CPU-heavy
- Sorting millions of records in memory.
- Performing image/audio/video processing.
- Machine learning model inference.
- Complex Algorithms (graph traversal, cryptography, compression).

## Memory-heavy
- Keeping large collections (e.g., List of 10M objects)
- Loading entire files into memory (instead of streaming)
- Memory leaks causing GC (Garbage Collection) thrashing

## I/O-heavy
- Writing large payloads to a DB (.save()).
- Reading/writing large files on disk.
- Sending/receiving data over the network (REST calls, Kafka, etc.).

## Concurrency-heavy
- Synchronizing many threads competing for locks.
- Deadlocks, thread starvation.
- Scaling workloads across CPUs/cores.