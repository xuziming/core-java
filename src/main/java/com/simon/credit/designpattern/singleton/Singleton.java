package com.simon.credit.designpattern.singleton;

public class Singleton {

	static enum SingletonEnum {
		INST;

		private Singleton enumSingleton;

		private SingletonEnum() {
			enumSingleton = new Singleton();
		}

		public Singleton getInstance() {
			return enumSingleton;
		}

	}

}
