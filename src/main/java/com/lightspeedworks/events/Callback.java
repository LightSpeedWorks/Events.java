package com.lightspeedworks.events;

/**
 * Callback interface. (like Node.js)
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public interface Callback {
	/**
	 * Callback.
	 *
	 * @param args
	 *            Object...
	 */
	void callback(Object... args);
}
