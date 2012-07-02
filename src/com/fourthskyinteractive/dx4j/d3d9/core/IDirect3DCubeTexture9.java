package com.fourthskyinteractive.dx4j.d3d9.core;

import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.ann.Virtual;
import org.bridj.cpp.com.COMRuntime;
import org.bridj.cpp.com.IID;
import org.bridj.cpp.com.RECT;

import com.fourthskyinteractive.dx4j.d3d9.D3D9.D3DCUBEMAP_FACES;
import com.fourthskyinteractive.dx4j.d3d9.resources.D3DLOCKED_RECT;
import com.fourthskyinteractive.dx4j.d3d9.resources.D3DSURFACE_DESC;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DBaseTexture9;
import com.fourthskyinteractive.dx4j.d3d9.resources.IDirect3DSurface9;

@IID("FFF32F81-D953-473a-9223-93D652ABA93F")
@Library("d3d9")
@Runtime(COMRuntime.class)
public class IDirect3DCubeTexture9 extends IDirect3DBaseTexture9 {

	public IDirect3DCubeTexture9() {
		// TODO Auto-generated constructor stub
	}
	
	@Virtual(0)
	public native final int GetLevelDesc(int Level, Pointer<D3DSURFACE_DESC> pDesc);
	
	@Virtual(1)
	public native final int GetCubeMapSurface(D3DCUBEMAP_FACES FaceType, int Level, Pointer<Pointer<IDirect3DSurface9>> ppCubeMapSurface);
	
	@Virtual(2)
	public native final int LockRect(D3DCUBEMAP_FACES FaceType, int Level, Pointer<D3DLOCKED_RECT> pLockedRect, Pointer<RECT> pRect, int Flags);
	
	@Virtual(3)
	public native final int UnlockRect(D3DCUBEMAP_FACES FaceType, int Level);
	
	@Virtual(4)
	public native final int AddDirtyRect(D3DCUBEMAP_FACES FaceType,Pointer<RECT> pDirtyRect);
}
