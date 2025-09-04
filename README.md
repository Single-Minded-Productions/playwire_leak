**Steps to Reproduce:**

1) Replace all values of "PLACEHOLDER-REPLACE" with appropriate values
2) Run project on the emulator
3) Rotate screen so the Activity is destroyed and recreated
4) Open the profiler (View > Tool Windows > Profiler)
5) Run Analyze Memory Usage (Heap Dump)

**Actual behavior:**

The report indicates that MainActivity, and all objects contained within, have leaked.

**Expected behavior:**

No leaks recorded.

**Reference:** https://developer.android.com/guide/topics/resources/runtime-changes

"Furthermore, the old Activity is no longer visible or valid, so any remaining references to it or its contained objects are stale. They can cause bugs, memory leaks, and crashes."
