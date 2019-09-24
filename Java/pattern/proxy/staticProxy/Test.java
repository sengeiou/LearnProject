public class Test{
  public static void main(String[] args){


      Human shenjun = new Human();
      ProxyPlayer didi = new ProxyPlayer(shenjun);
      ProxyLogger logger = new ProxyLogger(didi);


      logger.login();




  }
}
