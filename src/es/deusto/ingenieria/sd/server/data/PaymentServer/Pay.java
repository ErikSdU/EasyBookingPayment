package es.deusto.ingenieria.sd.server.data.PaymentServer;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Pay extends UnicastRemoteObject implements IPay {
	private static final long serialVersionUID = 1L;
	private String cardNumberTest = "53234576802";
	private String cardHolderTest = "1111";
	private int money = 10000;

	
	protected Pay() throws RemoteException {
		super();
	}
	
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]"); 
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IPay objServer = new Pay();
			Naming.rebind(name, objServer);//To include in RMIregistry
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public boolean makePaymentVisa(String cardNumber, String cardHolder, int price) throws RemoteException {
			if(cardNumber.equals(cardNumberTest)){
				if(cardHolder.equals(cardHolderTest)){
					if(price<= money){
						money = money - price;
						return true;
					}
				}
			}
		return false;
	} 

	
}
