import java.util.*;

public class HanFeiZi implements IHanFeiZi , Observable{

	public LiSi mLiSi = new LiSi();


	public void haveFun(){
		
		System.out.println(" hanfeizi is haveFun");

		notifyObserver(" hanfeizi is haveFun");

	}

	public void haveBreakfast(){

		System.out.println(" hanfeizi is haveBreakfast");

		notifyObserver(" hanfeizi is haveBreakfast");
	}


	public List<Observer> observerList = new ArrayList<Observer>();

	public void addObserver(Observer observer){
		this.observerList.add(observer);
	}

	public void deleteObserver(Observer observer){
		this.observerList.remove(observer);
	}

	public void notifyObserver(String context){
			for(Observer o  : observerList){
				o.update(context);
			}
	}

} 
