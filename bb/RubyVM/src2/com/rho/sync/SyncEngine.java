/*
 *  rhodes
 *
 *  Copyright (C) 2008 Lars Burgess. All rights reserved.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rho.sync;

import com.xruby.runtime.lang.RubyBasic;
import com.xruby.runtime.lang.RubyBlock;
import com.xruby.runtime.lang.RubyClass;
import com.xruby.runtime.lang.RubyConstant;
import com.xruby.runtime.lang.RubyNoArgMethod;
import com.xruby.runtime.lang.RubyRuntime;
import com.xruby.runtime.lang.RubyValue;

/**
 * The Class SyncEngine.
 */
public class SyncEngine extends RubyBasic {

	/** The s thread. */
	private static SyncThread sThread = null;

	// @RubyAllocMethod
	/**
	 * Alloc.
	 * 
	 * @param receiver the receiver
	 * 
	 * @return the sync engine
	 */
	public static SyncEngine alloc(RubyValue receiver) {
		return new SyncEngine(RubyRuntime.SyncEngineClass);
	}

	// @RubyLevelMethod(name="dosync")
	/**
	 * Dosync.
	 * 
	 * @param receiver the receiver
	 * 
	 * @return the ruby value
	 */
	public static RubyValue dosync(RubyValue receiver) {
		return RubyConstant.QFALSE;
	}

	/**
	 * Inits the methods.
	 * 
	 * @param klass the klass
	 */
	public static void initMethods(RubyClass klass) {
		klass.defineMethod("initialize", new RubyNoArgMethod() {
			protected RubyValue run(RubyValue receiver, RubyBlock block) {
				return ((SyncEngine) receiver).initialize();
			}
		});
		klass.defineAllocMethod(new RubyNoArgMethod() {
			protected RubyValue run(RubyValue receiver, RubyBlock block) {
				return SyncEngine.alloc(receiver);
			}
		});
		klass.getSingletonClass().defineMethod("start", new RubyNoArgMethod() {
			protected RubyValue run(RubyValue receiver, RubyBlock block) {
				return SyncEngine.start(receiver);
			}
		});
		klass.getSingletonClass().defineMethod("stop", new RubyNoArgMethod() {
			protected RubyValue run(RubyValue receiver, RubyBlock block) {
				return SyncEngine.stop(receiver);
			}
		});
		klass.getSingletonClass().defineMethod("dosync", new RubyNoArgMethod() {
			protected RubyValue run(RubyValue receiver, RubyBlock block) {
				return SyncEngine.dosync(receiver);
			}
		});
		klass.getSingletonClass().defineMethod("lock_sync_mutex",
				new RubyNoArgMethod() {
					protected RubyValue run(RubyValue receiver, RubyBlock block) {
						return SyncEngine.lock_sync_mutex(receiver);
					}
				});
		klass.getSingletonClass().defineMethod("unlock_sync_mutex",
				new RubyNoArgMethod() {
					protected RubyValue run(RubyValue receiver, RubyBlock block) {
						return SyncEngine.unlock_sync_mutex(receiver);
					}
				});

	}

	// @RubyLevelMethod(name="lock_sync_mutex")
	/**
	 * Lock_sync_mutex.
	 * 
	 * @param receiver the receiver
	 * 
	 * @return the ruby value
	 */
	public static RubyValue lock_sync_mutex(RubyValue receiver) {
		return RubyConstant.QFALSE;
	}

	// @RubyLevelMethod(name="start")
	/**
	 * Start.
	 * 
	 * @param receiver the receiver
	 * 
	 * @return the ruby value
	 */
	public static RubyValue start(RubyValue receiver) {
		// Initialize only one thread
		if (sThread == null) {
			sThread = new SyncThread();
		}
		return RubyConstant.QFALSE;
	}

	// @RubyLevelMethod(name="stop")
	/**
	 * Stop.
	 * 
	 * @param receiver the receiver
	 * 
	 * @return the ruby value
	 */
	public static RubyValue stop(RubyValue receiver) {
		return RubyConstant.QFALSE;
	}

	// @RubyLevelMethod(name="unlock_sync_mutex")
	/**
	 * Unlock_sync_mutex.
	 * 
	 * @param receiver the receiver
	 * 
	 * @return the ruby value
	 */
	public static RubyValue unlock_sync_mutex(RubyValue receiver) {
		return RubyConstant.QFALSE;
	}

	/**
	 * Instantiates a new sync engine.
	 * 
	 * @param c the c
	 */
	SyncEngine(RubyClass c) {
		super(c);
	}

	// @RubyLevelMethod(name="initialize")
	/**
	 * Initialize.
	 * 
	 * @return the sync engine
	 */
	public SyncEngine initialize() {
		return this;
	}
}
