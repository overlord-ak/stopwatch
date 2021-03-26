package stopwatch;

public class Timer implements Runnable {
    Stopwatch mysw;
    public Timer (Stopwatch sw) {
        mysw=sw;
    }
    @Override
    public void run() {
        int hr=0, min=0, sec=0;
        try {
            while(true) {
                Thread.sleep(1000);
                sec++;
                if(sec==60) {
                    min++;
                    sec=0;
                }
                if(min==60) {
                    hr++;
                    min=0;
                }
                mysw.setTimer(hr, min, sec);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
