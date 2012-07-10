package com.fourthskyinteractive.dxengine.resources;

import java.nio.ByteBuffer;

public abstract class Resource {

	public abstract ByteBuffer map();
	
	public abstract void unmap();
}
