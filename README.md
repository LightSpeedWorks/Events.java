Events.java
==========================

LightSpeedWorks pages {光速工房}

events.EventEmitter class <br/>
Light event processing Library for Java (like Node.js)  <br/>
{軽量イベント処理ライブラリ(Java向け) - Node.js風}

LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)

[LightSpeedWorks/Events.java#readme] (https://github.com/LightSpeedWorks/Events.java#readme)

http://nodejs.org/api/events.html  <br/>
http://nodejs.jp/nodejs.org_ja/api/events.html (Japanese)

http://yand.info/?p=/docs/events.html#Events  <br/>
http://jp.yand.info/?p=/docs/events.html#Events (Japanese)

## usage: {使用方法:}

## Events

``` java
import com.lightspeedworks.events.EventEmitter;

  EventEmitter emitter = new EventEmitter();
  Listener listener = new Listener();

  emitter.on("event1", listener);
  emitter.emit("event1", "event1 case 1.1", "next arg"); // fire!
  emitter.emit("event1", "event1 case 1.2", "next arg"); // fire!
  emitter.removeListener("event1", listener);
  emitter.removeAllListener("event1");

  emitter.once("event2", listener);
  emitter.emit("event2", "event2 case 2.1", "next arg"); // fire!
  emitter.emit("event2", "event2 case 2.2", "next arg"); // listener removed
  emitter.removeAllListener();

  static class Listener implements Callback {
    public void callback(Object... args) {
      if (args.length < 1)
        throw new Error("insufficient arguments");

      System.out.print("callback:");
      for (Object arg : args)
        System.out.print(" " + arg);
      System.out.println();
    }
  }
```
