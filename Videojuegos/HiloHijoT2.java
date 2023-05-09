public class HiloHijoT2 implements Runnable{

    private String name;
    private int time;

    public void run(){
        for(int i = 1; i <= 10; i++){
            try {
                System.out.println("Hilo [" + name + "]" + i);
                Thread.sleep(time);
            } catch (Exception e) {
                // TODO: handle exception
            }        
        }
    }
    public void setNombre(String name){
        this.name = name;
    }

    public void setTime(int time){
        this.time = time;
    }
}
