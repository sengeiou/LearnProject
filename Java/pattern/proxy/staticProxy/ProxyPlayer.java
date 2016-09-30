public class ProxyPlayer implements IPlayer{

      public IPlayer player;

      public ProxyPlayer(IPlayer player){
        this.player = player;
      }

      public void login(){
        System.out.println("ProxyPlayer is handle play");
        player.login();
      }



}
