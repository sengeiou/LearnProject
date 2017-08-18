import java.util.Observable;

public class HanFeiZi extends Observable implements IHanFeiZi{

	public void haveFun(){		
		System.out.println(" hanfeizi is haveFun");
		setChanged();
		notifyObservers(" hanfeizi is haveFun");

	}

	public void haveBreakfast(){
		System.out.println(" hanfeizi is haveBreakfast");
		setChanged();
		notifyObservers(" hanfeizi is haveBreakfast");
	}

} 
