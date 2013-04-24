package com.lightspeedworks.events;

import java.util.List;

public class EventEmitterWorkMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventEmitter emitter = new EventEmitter();

		Listener1 listener1 = new Listener1();
		Listener2 listener2 = new Listener2();

		emitter.on("newListener", listener1);
		emitter.on("event1", listener2);
		emitter.once("event2", listener2);

		for (String event : emitter.events.keySet()) {
			System.out.print("event: " + event + ", ");
			System.out.print("listeners:");
			List<EventHandler> handlers = emitter.events.get(event);
			for (EventHandler handler : handlers)
				System.out.print(" " + handler.callback + "." + handler.once);
			System.out.println();
		}

		emitter.emit("event1", "event1 case 1.1");
		emitter.emit("event1", "event1 case 1.2");
		emitter.on("event1", listener2);
		emitter.emit("event1", "event1 case 2");
		emitter.removeListener("event1", listener2);
		emitter.emit("event1", "event1 case 3");
		emitter.removeListener("event1", listener2);
		emitter.emit("event1", "event1 case 4");

		emitter.on("event1", listener2);
		emitter.on("event1", listener2);
		emitter.emit("event1", "event1 case 5");
		emitter.removeAllListeners("event1");
		emitter.emit("event1", "event1 case 6");

		emitter.emit("event2", "event2 case 1.1");
		emitter.emit("event2", "event2 case 1.2");

		emitter.on("event1", listener2);
		emitter.once("event2", listener2);
		emitter.removeAllListeners();
		emitter.emit("event1", "event1 case 7");

		emitter.once("error", listener2);
		emitter.emit("error", "error case 1.1");
		// emitter.emit("error", "error case 1.2");

		for (String event : emitter.events.keySet()) {
			System.out.print("event: " + event + ", ");
			System.out.print("listeners:");
			List<EventHandler> handlers = emitter.events.get(event);
			for (EventHandler handler : handlers)
				System.out.print(" " + handler.callback + "." + handler.once);
			System.out.println();
		}
		System.out.println("end");
	}

	static class Listener1 implements Callback {
		public void callback(Object... args) {
			if (args.length < 1)
				throw new Error("Listener1 insufficient arguments");

			System.out.print("Listener1 callback:");
			for (Object arg : args)
				System.out.print(" " + arg);
			System.out.println();
		}
	}

	static class Listener2 implements Callback {
		public void callback(Object... args) {
			if (args.length < 1)
				throw new Error("Listener2 insufficient arguments");

			System.out.print("Listener2 callback:");
			for (Object arg : args)
				System.out.print(" " + arg);
			System.out.println();
		}
	}
}
