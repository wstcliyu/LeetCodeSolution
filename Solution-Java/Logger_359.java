// My solution
class Logger {
    
    private HashMap<String, Integer> timer;

    public Logger() {
        timer = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp >= timer.getOrDefault(message, 0)) {
            timer.put(message, timestamp + 10);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */