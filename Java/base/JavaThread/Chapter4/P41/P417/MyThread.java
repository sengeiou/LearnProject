public class MyThread extends Thread {

	private MyService myService;
	private boolean isSet;

	public MyThread(MyService myService , boolean isSet ) {
		this.myService = myService;
		this.isSet = isSet;
	}

	public void run() {
		for (int i = 0 ; i < 5; i++ ) {

			try {
				Thread.sleep(1000);
			}catch (Exception e) {

			}

			if (isSet) {
				myService.set();
			} else {
				myService.get();
			}
		}
	}

}