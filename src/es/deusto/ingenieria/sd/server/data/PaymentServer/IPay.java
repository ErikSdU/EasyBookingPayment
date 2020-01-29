package es.deusto.ingenieria.sd.server.data.PaymentServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPay extends Remote{

	public boolean makePaymentVisa(String cardNumber, String password, int price) throws RemoteException;
}
