package com.simon.credit.designpattern.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class RealStarProxy3 extends Proxy implements Star {
	private static final long serialVersionUID = 2222829841920221435L;

	private static Method m1;
	private static Method m6;
	private static Method m3;
	private static Method m5;
	private static Method m7;
	private static Method m0;
	private static Method m4;
	private static Method m2;

	public RealStarProxy3(InvocationHandler paramInvocationHandler) throws Exception {
		super(paramInvocationHandler);
	}

	public final boolean equals(Object paramObject) {
		try {
			return ((Boolean) this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void sing() {
		try {
			this.h.invoke(this, m6, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void confer() {
		try {
			this.h.invoke(this, m3, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void collectMoney() {
		try {
			this.h.invoke(this, m5, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void signContract() {
		try {
			this.h.invoke(this, m7, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final int hashCode() {
		try {
			return ((Integer) this.h.invoke(this, m0, null)).intValue();
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void bookTicket() {
		try {
			this.h.invoke(this, m4, null);
			return;
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final String toString() {
		try {
			return (String) this.h.invoke(this, m2, null);
		} catch (Error | RuntimeException localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	static {
		try {
			m1 = Class.forName("java.lang.Object").getMethod("equals",
					new Class[] { Class.forName("java.lang.Object") });
			m6 = Class.forName("com.simon.credit.designpattern.proxy.dynamicproxy.jdk.Star").getMethod("sing",
					new Class[0]);
			m3 = Class.forName("com.simon.credit.designpattern.proxy.dynamicproxy.jdk.Star").getMethod("confer",
					new Class[0]);
			m5 = Class.forName("com.simon.credit.designpattern.proxy.dynamicproxy.jdk.Star").getMethod("collectMoney",
					new Class[0]);
			m7 = Class.forName("com.simon.credit.designpattern.proxy.dynamicproxy.jdk.Star").getMethod("signContract",
					new Class[0]);
			m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
			m4 = Class.forName("com.simon.credit.designpattern.proxy.dynamicproxy.jdk.Star").getMethod("bookTicket",
					new Class[0]);
			m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
		} catch (NoSuchMethodException localNoSuchMethodException) {
			throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
		} catch (ClassNotFoundException localClassNotFoundException) {
			throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
		}
	}

}