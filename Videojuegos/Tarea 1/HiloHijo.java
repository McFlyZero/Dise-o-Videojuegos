public class HiloHijo implements Runnable{

    private String name;
    private int time;
    int currenttime;

    public void run(){
        for(int i = 1; i <= 10; i++){
            try {
                System.out.println("Hilo [" + name + "]" + i);
                currenttime = i;
                Thread.sleep(time);
            } catch (Exception e) {
                System.out.println("Error"+ e);
            }        
        }
    }
    public void setNombre(String name){
        this.name = name;
    }

    public void setTime(int time){
        this.time = time; 
    }

    public void setCurrentTime(int currenttime){
        this.currenttime = currenttime;
    }

    public int getCurrentTime(){
        return currenttime;
    }
}