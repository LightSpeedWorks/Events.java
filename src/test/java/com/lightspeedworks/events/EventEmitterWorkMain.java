package com.lightspeedworks.events;

public class EventEmitterWorkMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventEmitter emitter = new EventEmitter();

		CB1 cb1 = new CB1();
		CB2 cb2 = new CB2();

		emitter.on("newListener", cb1);
		emitter.on("test", cb2);
		emitter.once("once", cb2);

		for (String event : emitter.events.keySet() ) {
			System.out.print("event: " + event + ", ");
			System.out.println("listeners: " + emitter.events.get(event));
		}

		emitter.emit("test", "test case 1.1");
		emitter.emit("test", "test case 1.2");
		emitter.on("test", cb2);
		emitter.emit("test", "test case 2");
		emitter.removeListener("test", cb2);
		emitter.emit("test", "test case 3");
		emitter.removeListener("test", cb2);
		emitter.emit("test", "test case 4");

		emitter.on("test", cb2);
		emitter.on("test", cb2);
		emitter.emit("test", "test case 5");
		emitter.removeAllListeners("test");
		emitter.emit("test", "test case 6");

		emitter.emit("once", "once case 1.1");
		emitter.emit("once", "once case 1.2");

		emitter.on("test", cb2);
		emitter.once("once", cb2);
		emitter.removeAllListeners();
		emitter.emit("test", "test case 7");

		emitter.once("error", cb2);
		emitter.emit("error", "error case 1.1");
		emitter.emit("error", "error case 1.2");

		for (String event : emitter.events.keySet() ) {
			System.out.print("event: " + event + ", ");
			System.out.println("listeners: " + emitter.events.get(event));
		}
		System.out.println("end");
	}

	static class CB1 implements Callback {
		public void callback(Object... args) {
			if (args.length < 1)
				throw new Error("CB1 insufficient arguments");

			String arg0 = (String) args[0];
			System.out.println("CB1 callback: " + arg0);
		}
	}

	static class CB2 implements Callback {
		public void callback(Object... args) {
			if (args.length < 1)
				throw new Error("CB2 insufficient arguments");

			String arg0 = (String) args[0];
			System.out.println("CB2 callback: " + arg0);
		}
	}
}
