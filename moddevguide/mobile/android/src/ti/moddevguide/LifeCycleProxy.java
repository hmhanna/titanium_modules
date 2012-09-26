/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */

package ti.moddevguide;

import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.kroll.common.Log;

import android.app.Activity;

// The proxy is declared with the @Kroll.proxy annotation

@Kroll.proxy(creatableInModule = ModdevguideModule.class)
public class LifeCycleProxy extends KrollProxy 
	implements OnLifecycleEvent
{
	// Standard Debugging variables
	private static final String LCAT = "ModdevguideModule";
	
	public LifeCycleProxy() 
	{
		super();
		
		// A proxy can receive lifecycle events for the current context.
		// Note that these events are for the context and not the proxy itself.
		// You do not need to register for these events; your proxy will receive them
		// if overridden.
		
		// Each KrollProxy object has a unique proxy id
		Log.i(LCAT, "[PROXY LIFECYCLE EVENT] init with proxy id of " + getProxyId());
	}
	
	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) 
	{
		// This method is called from handleCreationArgs if there is at least one
		// argument specified for the proxy creation call and the first argument
		// is a KrollDict object.
		
		Log.d(LCAT, "PROXY LIFECYCLE EVENT] handleCreationDict " + options);

		// Calling the superclass method ensures that the properties specified
		// in the dictionary are properly set on the proxy object.
		super.handleCreationDict(options);
	}

	public void handleCreationArgs(KrollModule createdInModule, Object[] args) 
	{
		// This method is one of the initializers for the proxy class. The arguments
		// for the create call are passed as an array of objects. If your proxy 
		// simply needs to handle a single KrollDict argument, use handleCreationDict.
		// The superclass method calls the handleCreationDict if the first argument
		// to the create method is a dictionary object.

		Log.d(LCAT, "PROXY LIFECYCLE EVENT] handleCreationArgs ");
	
		for (int i = 0; i < args.length; i++) {
			Log.d(LCAT, "PROXY LIFECYCLE EVENT] args[" + i + "] " + args[i]);
		}

		// Calling the superclass method is required
		super.handleCreationArgs(createdInModule, args);
	}

	// Context Lifecycle events

	@Override
	public void onStart(Activity activity) 
	{
		// This method is called when the module is loaded and the root context is started

		Log.d(LCAT, "[PROXY CONTEXT LIFECYCLE EVENT] start proxy with id " + getProxyId());
	}
	
	@Override
	public void onStop(Activity activity) 
	{
		// This method is called when the root context is stopped 

		Log.d(LCAT, "[PROXY CONTEXT LIFECYCLE EVENT] stop proxy with id " + getProxyId());
	}
	
	@Override
	public void onPause(Activity activity) 
	{
		// This method is called when the root context is being suspended

		Log.d(LCAT, "[PROXY CONTEXT LIFECYCLE EVENT] pause proxy with id " + getProxyId());
	}

	@Override
	public void onResume(Activity activity) 
	{		
		// This method is called when the root context is being resumed

		Log.d(LCAT, "[PROXY CONTEXT LIFECYCLE EVENT] resume proxy with id " + getProxyId());	
	}

	
	@Override
	public void onDestroy(Activity activity) 
	{
		// This method is called when the root context is being destroyed

		Log.d(LCAT, "[PROXY CONTEXT LIFECYCLE EVENT] destroy proxy with id " + getProxyId());
	}

	// Public APIs (available in javascript)
	
	// The methods are exposed to javascript because of the @Kroll.method annotation

	@Kroll.method
	public void close() 
	{
		Log.d(LCAT, "[PROXY CONTEXT LIFECYCLE EVENT] close called");
	}
	
}
