public class ProxyLogger{


    private IPlayer player;

    public ProxyLogger(IPlayer player){
      this.player = player;
    }


    public  void login(){
      System.out.println("ProxyLogger ==> player is playing");
      player.login();
      System.out.println("ProxyLogger ==> player is stop Play");
    }



}
