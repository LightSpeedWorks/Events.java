/**
 * events.EventEmitter test
 *
 * @see http://nodejs.org/api/events.html
 * @see http://nodejs.jp/nodejs.org_ja/api/events.html (Japanese)
 *
 * @see http://yand.info/?p=/docs/events.html#Events
 * @see http://jp.yand.info/?p=/docs/events.html#Events (Japanese)
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */

EventEmitter = require('events').EventEmitter;

emitter = new EventEmitter();

emitter.on('newListener', function newListenerCB(x, y) { console.log('NL ', x, y); });
emitter.on('test', function testCB(x, y) { console.log('CB1', x, y); });
emitter.on('test', function testCB(x, y) { console.log('CB2', x, y); });

emitter.emit('test', 'test case 1.1', '');
emitter.emit('test', 'test case 1.2', '');

function testCB(x, y) { console.log('CB ', x, y); }

emitter.on('test', testCB);
emitter.on('test', testCB);
emitter.emit('test', 'test case 2.1', '');
emitter.removeListener('test', testCB);
emitter.emit('test', 'test case 2.2', '');
emitter.removeListener('test', testCB);
emitter.emit('test', 'test case 2.3', '');
emitter.removeListener('test', testCB);
emitter.emit('test', 'test case 2.4', '');
emitter.removeAllListeners('test');
emitter.emit('test', 'test case 2.5', '');

emitter.once('test', testCB);
emitter.emit('test', 'test case 3.1', '');
emitter.emit('test', 'test case 3.2', '');

emitter.once('error', testCB);
emitter.emit('error', 'error case 3.1', '');
emitter.emit('error', 'error case 3.2', '');
console.log('end');
